public class Principal {
    public static void main(String[] args) {
        ListaDupla<String> lista = new ListaDupla<String>("Alunos");

        lista.addInicio("Rafael");
        lista.addInicio("Emanuel");
        lista.addFinal("Felipe");
        lista.addFinal("Gabriel");
        lista.addFinal("Jhuly");
        lista.atualizaIndice();

        lista.imprimeLista();

        lista.removeInicio();

        lista.imprimeLista();
        
        lista.removeFinal();

        lista.imprimeLista();
    }
}