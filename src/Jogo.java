import java.util.ArrayList;
import java.util.Random;

public class Jogo {
   public static final String SEPARADOR = "\n**********************";
   public static void main(String[] args) throws Exception {

      ArrayList<Musica> musicas = new ArrayList<>();
      musicas.add(new Musica("Stairway to Heaven"));
      musicas.add(new Musica("Einstein Groovin"));
      musicas.add(new Musica("Valse di Fantastica"));
      musicas.add(new Musica("Die Fledermaus"));
      musicas.add(new Musica("Space oddity"));
      musicas.add(new Musica("Life on Mars?"));
      musicas.add(new Musica("Theme of Laura"));
      musicas.add(new Musica("Diamonds"));
      musicas.add(new Musica("Thousand Knives"));
      musicas.add(new Musica("Beauty and the Beast"));


      var gerador = new Random();
      boolean continuar = true;
      Personagem john = new Personagem("John", 3, 0, 0);
      while(continuar) {
         switch (gerador.nextInt(1,5)) {
            case 1:
               john.cacar();
               break;
            case 2:
               john.comer();
               break;
            case 3:
               john.dormir();
               break;
            case 4:
               john.aprenderMusica(musicas);
         }
         if(john.isVivo()) {
            System.out.println(john);
            System.out.println(SEPARADOR);
            Thread.sleep(5000);
         }
         else {
            System.out.println("--> " + john.getNome() + " ESTA MORTO.");
            System.out.println("\nInventario Final:\n" + john.exibirInventario());
            System.out.println("\nRepertorio Final:\n" + john.exibirRepertorio());
            continuar = false;
         }
         
      }
   }
}
