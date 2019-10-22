package anel;

import java.util.*;
import java.util.concurrent.*;
import "./Seguidor";
import Lider;

public class Anel {

    public void executaAnel(int numeroThreads, int numeroMensagens) {
        Lider lider = new Lider(-1);
        Seguidor[] seguidores = constroiSeguidores(numeroThreads-1, numeroMensagens, lider);
        iniciaSeguidores(seguidores);
        for (int i = 0; i < numeroMensagens; i++) {
            lider.sendReceiveSynchronous(Boolean.TRUE);
        }
    }

    public void benchmark(int numeroThreads, int numeroMensagens) {
        System.out.println("Iniciando anel com " + numeroThreads + " threads e " + numeroMensagens + " mensagens.");
        long inicio = System.currentTimeMillis();
        executaAnel(numeroThreads, numeroMensagens);
        long tempo = System.currentTimeMillis() - inicio;
        System.out.println("O anel para " + numeroThreads + " threads e " + numeroMensagens + " mensagens levou " + tempo + " milisegundos.");
    }

    private void iniciaSeguidores(Seguidor[] seguidores) {
        for (int i = 0; i < seguidores.length; i++) {
            seguidores[i].setDaemon(true);
            seguidores[i].start();
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
		for (int i = 100; i < 10000; i += 100) {
		    for (int j=100; j<10000; j+=1000) {
		        new Anel().benchmark(i, j);
		    }
		}
	}
}
