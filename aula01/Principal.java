
import java.util.ArrayList;

public class Principal{
    public static void main(String[] args){

        Pessoa obj1 = new Pessoa("Rafael", 22);
        Pessoa obj2 = new Pessoa("Livia", 21);
        Pessoa obj3 = new Pessoa("Regina", 47);

       // System.out.println(obj1.toString());
       // System.out.println(obj2.toString());
       // System.out.println(obj3.toString());

        // Cria um ArrayList para armazenar Strings
        ArrayList<Pessoa> listaP = new ArrayList<Pessoa>();

        // Adiciona elementos ao ArrayList
        listaP.add(obj1);
        listaP.add(obj2);
        listaP.add(obj3);

        // Imprime o ArrayList
       // System.out.println(listaP.get(0));

        for(Pessoa auxP : listaP){
            System.out.println(auxP.toString());

        }
    }
}