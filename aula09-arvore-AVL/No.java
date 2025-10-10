public class No {
    private int dado;
    private int altura;
    private No esquerda;
    private No direita;

    //Construtor para criar um novo nó.
    // Um nó recém-criado é sempre uma folha, então sua altura inicial é 1.
    public No(int dado) {
        this.dado = dado;
        this.altura = 1;
        this.esquerda = null;
        this.direita = null;
    }

    // --- Getters e Setters ---

    public int getDado() {
        return dado;
    }

    public void setDado(int dado) {
        this.dado = dado;
    }

    public int getAltura() {
        return altura;
    }

    public void setAltura(int altura) {
        this.altura = altura;
    }

    public No getEsquerda() {
        return esquerda;
    }

    public void setEsquerda(No esquerda) {
        this.esquerda = esquerda;
    }

    public No getDireita() {
        return direita;
    }

    public void setDireita(No direita) {
        this.direita = direita;
    }
}