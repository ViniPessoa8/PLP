package anel;

public class Lider extends Seguidor {
    public Lider(int pid) {
        super(pid, 0);
    }

    @Override
    public void run() {
    }

    @Override
    public void enviaMsg(String msg) {
        proxSeguidor.enviaMsg(msg);
        try {
            msg = fila.remove();
            
        } catch (java.util.NoSuchElementException e){
            
        }
    }
}