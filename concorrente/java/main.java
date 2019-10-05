import java.util.logging.Level;
import java.util.logging.Logger;

public class main {

    public static void main(String[] args) {
        int n_Tiros = 10;
        int menorTempo = 10000;
        int[] velocidades = new int[5];
        Corredor[] corredores = new Corredor[5];
        
        
        for (int i = 0; i < n_Tiros; i++){
            Corredor joao = new Corredor("João   ");
            Corredor maria = new Corredor("Maria  ");
            Corredor felipe = new Corredor("Felipe ");
            Corredor carlos = new Corredor("Carlos ");
            Corredor daniela = new Corredor("Daniela");
            
            corredores[0] = joao;
            corredores[1] = maria;
            corredores[2] = felipe;
            corredores[3] = carlos;
            corredores[4] = daniela;

            System.out.println("\n\nCorrida " + (i+1) + "\n");
            
            
            joao.start();
            maria.start();
            felipe.start();
            daniela.start();
            carlos.start();
            
            try {
                Thread.sleep(2000);
            } catch (InterruptedException ex) {
                Logger.getLogger(main.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            velocidades[0] +=  joao.getVelocidade();
            velocidades[1] +=  maria.getVelocidade();
            velocidades[2] +=  felipe.getVelocidade();
            velocidades[3] +=  carlos.getVelocidade();
            velocidades[4] +=  daniela.getVelocidade();
            
        }
        
        System.out.println("\n\nTOTAL DE TEMPOS (ms)\n");
        for (int i = 0; i < 5; i++){
            System.out.println(corredores[i].getNome() + ": " + velocidades[i]);
            if (velocidades[i] < menorTempo){
                menorTempo = velocidades[i];
            }
        }
        System.out.println("\nMenor Tempo = " + menorTempo);
        
        for (int i = 0; i < 5; i++){
            if (velocidades[i] == menorTempo){
                System.out.println("\nVencedor(a): "+corredores[i].getNome());
            }
        }
        
    }
    
}
