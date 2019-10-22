package anel;

import java.util.*;
import java.util.concurrent.*;

public class Seguidor extends Thread {
    final BlockingQueue fila = new LinkedBlockingQueue();
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

    public void enviaMsg(Object msg) {
        fila.add(msg);
    }

    public void run() {
        for (int i = 0; i < numeroMensagens; i++) {
            try {
                Object msg = fila.take();
                proxSeguidor.enviaMsg(msg);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupted();
            }
        }
    }
}