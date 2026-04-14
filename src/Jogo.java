import java.util.Random;

public class Jogo {
   public static final String SEPARADOR = "\n**********************";
   public static void main(String[] args) throws Exception {
      var gerador = new Random();
      Personagem john = new Personagem("John", 10, 0, 0);
      while(true) {
         switch (gerador.nextInt(1,4)) {
            case 1:
               john.cacar();
               break;
            case 2:
               john.comer();
               break;
            case 3:
               john.dormir();
               break;
         }
         System.out.println(john);
         System.out.println(SEPARADOR);
         Thread.sleep(5000);
      }
   }
}
