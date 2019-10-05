import java.util.Random;

public class Corredor extends Thread{
    private String nome;
    private int velocidade;
    Random gerador;
    int tiros;
    private double corridaTempoSoma;
    private int corridaCount;
    
    public Corredor(String nome){
        this.nome = nome;
        this.tiros = 10;
        this.corridaTempoSoma = 0.0;
        this.corridaCount = 0;
        gerador = new Random();
    }
    
    public String getNome(){
        return nome;
    }
    
    public void calcularVel(){
        this.velocidade = gerador.nextInt(1001);
    }
    
    public int getVelocidade(){
        return velocidade;
    }
    
    @Override
    public void run(){
        String saida = nome+": ";
        calcularVel();

        //Contabiliza a corrida
        corridaCount++;
        corridaTempoSoma += velocidade;

        for (int j = 0; j < (velocidade/100); j++){
            saida += "-";
        }

        saida += "|" + velocidade;
        try {
            Thread.sleep(velocidade);
        }
        catch(InterruptedException ex) {
            Thread.currentThread().interrupt();
        }
        System.out.println(saida);
        saida = "";
    }
    
    public double calcularMedia(){
        return corridaTempoSoma/corridaCount;
    }
    
    
}
