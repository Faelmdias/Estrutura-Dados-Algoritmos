public class Principal{
    public static void main(String[] args) {
        
        Deque<String> deque = new Deque<String>("Letra");

        deque.addInicio("A");
        deque.addFinal("B");
        deque.addInicio("C");
        deque.addFinal("R");

        deque.imprimeDeque();
        
    }
}