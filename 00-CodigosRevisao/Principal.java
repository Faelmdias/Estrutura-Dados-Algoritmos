public class Principal{

    public static void main(String[] args){

        Pessoa obj1 = new Pessoa();
        Pessoa obj2 = new Pessoa("Rafael", 22);
        Pessoa obj3 = new Pessoa("Livia", 21, 12345678910l);

        System.out.println(obj1.toString());
        System.out.println(obj2.toString());
        System.out.println(obj3.toString());
        
    }
}