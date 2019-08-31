/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author eduardoj.paiva
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class comb {
    public static void main(String args[]){
        
        int n = Integer.parseInt(args[0]);
        int k = Integer.parseInt(args[1]);
        int lCount = 0;
        String nomeArq = args[2];

        int[] vet = new int[n];

        try{
            FileReader arq = new FileReader(nomeArq);
            BufferedReader lerArq = new BufferedReader(arq);
            String linha = lerArq.readLine();
            while (linha != null){
                int num = Integer.parseInt(linha);
                vet[lCount++] = num;
                linha = lerArq.readLine();
            }
            arq.close();
        } catch (IOException e){
            System.out.println("Erro na abertura do arquivo: "+e.getMessage() + ".\n");
        }

        if (lCount == n){
            combGenerico(vet, k);
        } else {
            System.out.println("Entrada inválida.");
        }
    }

    static void combGenerico(int vet[], int step){
        
        ArrayList list = new ArrayList();
        for(int i : vet){
            list.add(i);
        }
        
        if(step == 1){
            System.out.println(list);
        }else if (step > 1){
            for (int i = 0; i < list.size(); i++) {
                if(step + i > list.size()) break;
                ArrayList aux = new ArrayList();
                aux.add(list.get(i));
                
                combGenerico(new ArrayList(list.subList(i+1, list.size())), step - 1, aux);
            }
        }
        
    }

    private static void combGenerico(ArrayList list, int step, ArrayList listToPrint) {
        
        //System.out.println(listToPrint);
        
        if(step == 1){
            for (int i = 0; i < list.size(); i++) {
                if (listToPrint.contains(list.get(i))) {
                    continue;
                }
                ArrayList aux = new ArrayList(listToPrint);
                aux.add(list.get(i));
                System.out.println(aux);
                
            }
        }else if (step > 1){
            for (int i = 0; i < list.size(); i++) {
                if(step + i > list.size()) break;
                ArrayList aux = new ArrayList(listToPrint);
                aux.add(list.get(i));
                combGenerico(new ArrayList(list.subList(i+1, list.size())), step - 1, aux);
            }
        }
    }

}

