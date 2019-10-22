package anel;

import java.util.LinkedList;
import java.util.Queue;

public class Seguidor extends Thread {
    final Queue<String> fila = new LinkedList<String>();
    Seguidor proxSeguidor;
    int pid;
    int numeroMensagens;

    public Seguidor(int pid, int numeroMensagens) {
        this.pid = pid;
        this.numeroMensagens = numeroMensagens;
    }

    public void setProxSeguidor(Seguidor proxSeguidor) {
        this.proxSeguidor = proxSeguidor;
    }

    public void enviaMsg(String msg) {
        fila.add(msg);
    }

    @Override
    public void run() {
        for (int i = 0; i < numeroMensagens; i++) {
            try {
                String msg = fila.remove();
                proxSeguidor.enviaMsg(msg);
            } catch (java.util.NoSuchElementException e) {
                Thread.interrupted();
            }
        }
    }
}