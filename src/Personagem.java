import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import lombok.Getter;

public class Personagem {
   private @Getter String nome;
   private int energia;
   private int fome;
   private int sono;
   private @Getter boolean vivo;
   private List<String> mochila = new ArrayList<>();
   private List<Musica> repertorio = new ArrayList<>();

   Personagem() {
      System.out.println("Construindo novo personagem");
      energia = 10;
      fome = 0;
      sono = 0;
      vivo = true;
   }

   Personagem(int energia, int fome, int sono) {
      System.out.println("Construindo novo personagem");
      this.energia = energia <= 0 || energia > 10 ? 10 : energia;
      this.fome = fome >= 0 && fome <= 10 ? fome : 0;
      this.sono = sono >= 0 && sono <= 10 ? sono : 0;
      vivo = true;
   }

   Personagem(String nome, int energia, int fome, int sono) {
      System.out.println("Construindo novo personagem");
      this.nome = nome;
      this.energia = energia <= 0 || energia > 10 ? 10 : energia;
      this.fome = fome >= 0 && fome <= 10 ? fome : 0;
      this.sono = sono >= 0 && sono <= 10 ? sono : 0;
      vivo = true;
   }

   Personagem(String nome, int energia, int fome, int sono, ArrayList<Musica> repertorio) {
      System.out.println("Construindo novo personagem");
      this.nome = nome;
      this.energia = energia <= 0 || energia > 10 ? 10 : energia;
      this.fome = fome >= 0 && fome <= 10 ? fome : 0;
      this.sono = sono >= 0 && sono <= 10 ? sono : 0;
      this.repertorio = repertorio;
      vivo = true;
   }

   void cacar(){
      if(energia >= 2) {
         System.out.printf("%s caçando\n", nome);
         encontrarItem();
         energia -= 2; // energia = energia - 2
         if(energia <= 0) vivo = false;
      } 
      else {
         System.out.printf(
         "%s sem energia para caçar\n",
         nome
         );
      }
      // fome +=1 fome++ ++fome
      if (fome < 10) fome = fome + 1;
      // sono = sono + 1 > 10 ? sono : sono + 1;
      sono = sono == 10 ? sono : sono + 1;
   }

   //método comer
   void comer() {
      if(fome >= 1){
         System.out.println(nome + " comendo");
         energia = Math.min(energia + 1, 10);
         fome--;
      }
      else {
         System.out.println(nome + " sem fome");
      }
   }

   //método dormir
   void dormir() {
      if(sono >= 1) {
         System.out.print(nome + " dormindo\n");
         energia = energia == 10 ? energia : energia + 1;
         sono -= 1;
      }
      else {
         System.out.println(nome + " sem sono");
      }
   }

   private void encontrarItem() {
      var gerador = new Random();
      switch (gerador.nextInt(1, 6)) {
         case 1:
            mochila.add("pena");
            break;
         case 2:
            mochila.add("couro");
            break;
         case 3:
            mochila.add("osso");
            break;
         case 4:
            mochila.add("presa");
            break;
         case 5:
            mochila.add("garra");
            break;
      }
   }

   public String exibirInventario() {
      var sb = new StringBuilder();
      if(mochila.size() == 0) {
         sb.append("A mochila esta vazia...");
      }
      else {
         for(int i = 0; i < mochila.size(); i++) {
            sb.append((i + 1)+ ". " + mochila.get(i) + "\n");
         }
      }
      return sb.toString();
   }

   public void aprenderMusica(ArrayList<Musica> disponiveis) {
      var gerador = new Random();
      String nomeMusicaSorteada = disponiveis.get(gerador.nextInt(0, 10)).getTitulo();
      for(int i = 0; i < repertorio.size(); i++) {
         if(repertorio.get(i).getTitulo() == nomeMusicaSorteada) {
            System.out.println(nome + " não conseguiu aprender uma musica");
            return;
         }
      }
      repertorio.add(new Musica(nomeMusicaSorteada));
      System.out.println(nome + " aprendeu " + nomeMusicaSorteada + "!");
   }

   public void duelar(Personagem oponente) {
      if(!(repertorio.size() == 0)) {
         System.out.println(nome + " iniciou duelo com " + oponente.nome);
         var gerador = new Random();
         Musica musicaAleatoria = repertorio.get(gerador.nextInt(0, repertorio.size()));
         for(int i = 0; i < oponente.repertorio.size(); i++) {
            if(musicaAleatoria.getTitulo() == oponente.repertorio.get(i).getTitulo()) {
               energia--;
               oponente.energia--;
               if(energia <= 0) vivo = false;
               if(oponente.energia <= 0) oponente.vivo = false;
               System.out.println("O publico ficou enteado");
               return;
            }
         }

         oponente.energia--;
         if(oponente.energia <= 0) oponente.vivo = false;
         oponente.repertorio.add(musicaAleatoria);
         System.out.println(nome + " Ganhou o duelo");
      } 
   }

   public String exibirRepertorio() {
      var sb = new StringBuilder();
      if(repertorio.size() == 0) {
         sb.append("Repertorio vazio...");
      }
      else {
         for(int i = 0; i < repertorio.size(); i++) {
            sb.append((i + 1)+ ". " + repertorio.get(i) + "\n");
         }
      }

      return sb.toString();
   }

   public String toString() {
      var sb = new StringBuilder();
      if(vivo) {
         sb.append("--> NOME: " + nome);
         sb.append("\n");
         sb.append("ENERGIA: " + energia);
         sb.append("\n");
         sb.append("FOME: " + fome);
         sb.append("\n");
         sb.append("SONO: " + sono);
         sb.append("\n");
         sb.append("MOCHILA: \n");
         sb.append(exibirInventario());
         sb.append("\n");
         sb.append("REPERTORIO: \n");
         sb.append(exibirRepertorio());
      }
      else {
         System.out.println("--> " + nome + " ESTA MORTO.");
         System.out.println("\nInventario Final:\n" + exibirInventario());
         System.out.println("Repertorio Final:\n" + exibirRepertorio());
      }
      
      return sb.toString();
   }
}
