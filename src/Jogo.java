import java.util.Random;

public class Jogo {
   public static final String SEPARADOR = "\n**********************";
   public static void main(String[] args) throws Exception {
      var gerador = new Random();
      boolean continuar = true;
      Personagem john = new Personagem("John", 3, 0, 0);
      while(continuar) {
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
         if(john.isVivo()) {
            System.out.println(john);
            System.out.println(SEPARADOR);
            Thread.sleep(5000);
         }
         else {
            System.out.println("--> " + john.getNome() + " ESTA MORTO.\n\n Inventario final:");
            System.out.println(john.exibirInventario());
            continuar = false;
         }
         
      }
   }
}
