public class Principal{
    public static void main(String[] args) {
        
        Lista<String> lista = new Lista<String>("Alunos");

        lista.addInicio("Rafael");
        lista.addInicio("Felipe");
        lista.addInicio("Gabriel");
        lista.addFinal("Emanuel");
        lista.imprimeLista();
        lista.removeInicio();
        lista.imprimeLista();
        lista.removeFinal();
        lista.imprimeLista();
    }
}