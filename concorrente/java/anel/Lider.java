import java.util.*;
import java.util.concurrent.*;

public class Lider extends Seguidor {
    public Lider(int pid) {
        super(pid, 0);
    }

    public void run() {
    }

    public void sendReceiveSynchronous(Object msg) {
        try {
            proxSeguidor.enviaMsg(msg);
            msg = fila.take();
        } catch (InterruptedException e) {
              Thread.currentThread().interrupted();
        }
    }
}