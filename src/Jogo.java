import java.util.ArrayList;
import java.util.Random;

public class Jogo {
   public static final String SEPARADOR = "\n**********************\n";
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
      Personagem john = new Personagem("John", 3, 0, 0);
      ArrayList<Musica> musicasTicoTrovador = new ArrayList<>();
      musicasTicoTrovador.add(new Musica("Vento do Norte"));
      Personagem ticoTrovador = new Personagem("Tico Trovador", 3, 8, 8, musicasTicoTrovador);

      while(john.isVivo() || ticoTrovador.isVivo()) {
         if(john.isVivo()) {
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
            System.out.println(john);
            System.out.println("\n");
         }
         
         if(ticoTrovador.isVivo()) {
            ticoTrovador.aprenderMusica(musicas);
            switch (gerador.nextInt(1,11)) {
               case 1, 2:
                  ticoTrovador.cacar();
                  break;
               case 3, 4:
                  ticoTrovador.comer();
                  break;
               case 5, 6, 7, 8, 9, 10:
                  ticoTrovador.dormir();
                  break;
            }
            System.out.println(ticoTrovador);
         }
         System.out.println(SEPARADOR);
         Thread.sleep(5000);
      }
   }
}
