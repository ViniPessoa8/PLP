import java.util.logging.Level;
import java.util.logging.Logger;

public class main {

    public static void main(String[] args) {
        int n_Tiros = 10;
        int n_Corredores = 5;
        int menorTempo = 10000;
        int[] tempos = new int[n_Corredores];
        Corredor[] corredores = new Corredor[n_Corredores];
        
        
        for (int i = 0; i < n_Tiros; i++){
            // Instancia corredores
            Corredor joao = new Corredor("João   ");
            Corredor maria = new Corredor("Maria  ");
            Corredor felipe = new Corredor("Felipe ");
            Corredor carlos = new Corredor("Carlos ");
            Corredor daniela = new Corredor("Daniela");
            
            // Adiciona corredores no array
            corredores[0] = joao;
            corredores[1] = maria;
            corredores[2] = felipe;
            corredores[3] = carlos;
            corredores[4] = daniela;

            System.out.println("\n\nCorrida " + (i+1) + "\n");
            
            // Inicio da corrida
            joao.start();
            maria.start();
            felipe.start();
            daniela.start();
            carlos.start();
            
            // Espera de 2s para que a corrida acabe e os resultados parciais sejam mostrados
            try {
                Thread.sleep(2000);
            } catch (InterruptedException ex) {
                Logger.getLogger(main.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            // Soma as tempos
            tempos[0] += joao.getTempo();
            tempos[1] += maria.getTempo();
            tempos[2] += felipe.getTempo();
            tempos[3] += carlos.getTempo();
            tempos[4] += daniela.getTempo();
            
        }
        
        // Imprime o total de tempo em que cada um levou
        System.out.println("\n\nTOTAL DE TEMPOS (ms)\n");
        for (int i = 0; i < n_Corredores; i++){
            System.out.println(corredores[i].getNome() + ": " + tempos[i]);
            if (tempos[i] < menorTempo){
                menorTempo = tempos[i];
            }
        }
        System.out.println("\nMenor Tempo = " + menorTempo);
        
        for (int i = 0; i < n_Corredores; i++){
            if (tempos[i] == menorTempo){
                System.out.println("\nVencedor(a): "+corredores[i].getNome());
            }
        }
        
    }
    
}
