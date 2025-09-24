public class Principal {
    public static void main(String[] args) {
        ListaDupla<String> lista = new ListaDupla<String>("Alunos"); 
        
        lista.addMeio(0, "Jhuly");
        lista.addMeio(1, "Gabriel");
        lista.addMeio(2, "Felipe");
        lista.addMeio(4, "Rafael");
        lista.addMeio(5, "Emanuel");

        lista.imprimeLista();
    }
}