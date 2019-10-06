import java.util.Random;

public class Corredor extends Thread{
    private String nome;
    private int tempo;
    private Random gerador;
    
    public Corredor(String nome){
        this.nome = nome;
        gerador = new Random();
    }
    
    public String getNome(){
        return nome;
    }
    
    public int getTempo(){
        return tempo;
    }

    public void calcularVel(){
        this.tempo = gerador.nextInt(1001);
    }

    @Override
    public void run(){
        String saida = nome+": ";

        calcularVel();

        for (int j = 0; j < (tempo/100); j++){
            saida += "-";
        }

        saida += "|" + tempo;

        // Espera o tempo em ms
        try {
            Thread.sleep(tempo);
        }
        catch(InterruptedException ex) {
            Thread.currentThread().interrupt();
        }
        
        System.out.println(saida);
        saida = "";
    }
}
