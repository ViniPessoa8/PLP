
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
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class perm {
    public static void main(String args[]){
        
        int n = Integer.parseInt(args[0]);
        String nomeArq = args[1];
        int lCount = 0;
        
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
        
        for(int i[] : perm(vet)){
            for(int q : i) System.out.print( "\t"+ q );
            System.out.println();
        }
        
    }
    
    static ArrayList<int[]> perm(int[] vet){
        if (vet.length == 0) return new ArrayList();
        if (vet.length == 1){
            ArrayList list = new ArrayList();
            list.add(vet);
            return list;
        }
            
        ArrayList aux = new ArrayList();
        
        for (int i = 0; i < vet.length; i++) {
            int valor[] = new int[1];
            valor[0] = vet[i];
            int param[] = new int[vet.length - 1];
            
            for (int j = 0, k = 0; j < vet.length; j++) {
                if(i == j)continue;
                param[k] = vet[j];
                k++;
            }            
            
            for (int j[] : perm(param)) {
                int vetPermutado[] = new int[j.length + 1];
                vetPermutado[0] = valor[0];
                
                for (int k = 0, x = 1; k < j.length; k++, x++) {
                    vetPermutado[x] = j[k];
                }
                aux.add(vetPermutado);   
            }    
        }
        
        return aux;
    }
}