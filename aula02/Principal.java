

public class Principal{
    public static void main(String[] args) {
        
        No<String> obj1 = new No<String>("Rafael");
        //System.out.println(obj1.toString());

        No<String> obj2 = new No<String>("Livia");
        //System.out.println(obj2.toString());
        
        No<String> obj3 = new No<String>("Noah");
        //System.out.println(obj3.toString());
        
        No<String> obj4 = new No<String>("Noele");
        //System.out.println(obj4.toString());

        obj1.setNextNo(obj2);
        obj2.setNextNo(obj3);
        obj3.setNextNo(obj4);

        //System.out.println(obj1.toString());
        //System.out.println(obj1.getNextNo().toString());
       // System.out.println(obj1.getNextNo().getNextNo().toString());
        //System.out.println(obj1.getNextNo().getNextNo().getNextNo().toString());

        No<String> aux = obj1;
        while(aux != null){
            System.out.println(aux.toString());
            aux = aux.getNextNo();
        }
    }
}