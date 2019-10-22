package anel;

public class Anel {
    
    String msg;
    
    public Anel(String msg){
        this.msg = msg;
    }

    public void executaAnel(int numeroThreads, int numeroMensagens) {
        Lider lider = new Lider(-1);
        Seguidor[] seguidores = constroiSeguidores(numeroThreads-1, numeroMensagens, lider);
        iniciaSeguidores(seguidores);
        for (int i = 0; i < numeroMensagens; i++) {
            lider.enviaMsg(msg);
        }
    }

    public void benchmark(int numeroThreads, int numeroMensagens) {
        executaAnel(numeroThreads, numeroMensagens);
    }

    private void iniciaSeguidores(Seguidor[] seguidores) {
        for (Seguidor seguidor : seguidores) {
            seguidor.setDaemon(true);
            seguidor.start();
        }
    }

    private Seguidor[] constroiSeguidores(int numeroSeguidores, int numeroMensagens, Lider lider) {
        Seguidor[] seguidores = new Seguidor[numeroSeguidores];

        for (int i=0; i<seguidores.length; i++) {
            seguidores[i] = new Seguidor(i, numeroMensagens);
        }

        lider.setProxSeguidor(seguidores[0]);
        for (int i = 0; i < seguidores.length; i++) {
            if (i == seguidores.length - 1) {
                seguidores[i].setProxSeguidor(lider);
            } else {
                seguidores[i].setProxSeguidor(seguidores[i+1]);
            }
        }

        return seguidores;
    }

    public static void main(String[] args) {
        
        int nThreads = Integer.parseInt(args[0]);
        int nMsgs = Integer.parseInt(args[1]);
        String msg = args[2];        
        
        Anel anel = new Anel(msg);
        
        anel.benchmark(nThreads, nMsgs);

    }
}
