public class ListaCircular<T> {

    private String nomeListaCircular;
    private No<T> primeiroNo;
    private No<T> ultimoNo;
    private int tamanho;

    public ListaCircular() {
        this("Lista Circular");
    }

    public ListaCircular(String nomeListaCircular) {
        this.nomeListaCircular = nomeListaCircular;
        this.primeiroNo = null;
        this.ultimoNo = null;
    }

    public int  tamanhoLista(){
        return tamanho;
    }

    public void addInicio(T dado) {
        No<T> novoNo = new No<T>(dado);
        if (primeiroNo == null) {
            primeiroNo = novoNo;
            ultimoNo = novoNo;
            novoNo.setNextNo(novoNo);
        } else {
            novoNo.setNextNo(primeiroNo);
            ultimoNo.setNextNo(novoNo);
            primeiroNo = novoNo;
        }
        tamanho++;
    }

    public void addFinal(T dado) {
        No<T> novoNo = new No<T>(dado);
        if (ultimoNo == null) {
            ultimoNo = novoNo;
            primeiroNo = novoNo;
            novoNo.setNextNo(novoNo);
        } else {
            ultimoNo.setNextNo(novoNo);
            novoNo.setNextNo(primeiroNo);
            ultimoNo = novoNo;
        }
        tamanho++;
    }
    
    public void removeInicio() {
        if (primeiroNo == null) {
            System.out.println("Lista Circular Vazia!");
        } else {
            System.out.println("Dado: " + primeiroNo.getDado() + " removido");

            if (primeiroNo == primeiroNo.getNextNo()) {
                primeiroNo = null;
                ultimoNo = null;
            } else {
                ultimoNo.setNextNo(primeiroNo.getNextNo());
                primeiroNo = primeiroNo.getNextNo();
            }
        }
    }

    public void removeFinal() {
        if (ultimoNo == null) {
            System.out.println("ListaCircular Vazia!");
        } else {
            System.out.println("Dado: " + ultimoNo.getDado() + " removido");

            if (primeiroNo == ultimoNo) {
                primeiroNo = null;
                ultimoNo = null;
            } else {
                No<T> aux = primeiroNo;
                while (aux.getNextNo() != ultimoNo) {
                    aux = aux.getNextNo();
                }
                aux.setNextNo(primeiroNo);
                ultimoNo = aux;
            }
        }
    }

    public void imprimeListaCircular() {
        if (primeiroNo == null) {
            System.out.println("Lista Circular Vazia!");
        } else {
            System.out.println("Dados da Lista Circular " + nomeListaCircular);
            No<T> aux = primeiroNo;
            while (aux.getNextNo() != primeiroNo) {
                System.out.println(aux.getDado());
                aux = aux.getNextNo();
            }
        }
    }

}