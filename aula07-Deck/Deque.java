public class Deque<T>{

    private NoDuplo<T> primeiroNo;
    private NoDuplo<T> ultimoNo;
    private String nomeDeque;
    private int tamanho;

    public Deque(){
        this("Deque");
    }

    public Deque(String nomeDeque) {
        this.nomeDeque = nomeDeque;
        this.primeiroNo = null;
        this.ultimoNo = null;
        this.tamanho = 0;
    }

    public void atualizaIndice(){
        if (primeiroNo == null) {
            System.out.println("Deque Vazia!");
        } else {
            NoDuplo<T> atual = primeiroNo;
            int indice = 0;
            while (atual != null) {
                atual.setIndice(indice);
                atual = atual.getProximoNo();
                indice++;
            }
        }
    }

    public void addInicio(T dado) {
        NoDuplo<T> novoNo = new NoDuplo<T>(dado);
        if (primeiroNo == null) {
            primeiroNo = novoNo;
            ultimoNo = novoNo;
            return;
        } else {
            novoNo.setProximoNo(primeiroNo);
            primeiroNo.setAnteriorNo(novoNo);
            primeiroNo = novoNo;
            //ultimoNo.setProximoNo(primeiroNo);
            //primeiroNo.setAnteriorNo(ultimoNo);
        }
        atualizaIndice();
        tamanho++;
    }

    public void addFinal(T dado) {
        NoDuplo<T> novoNo = new NoDuplo<T>(dado);
        if (ultimoNo == null) {
            ultimoNo = novoNo;
            primeiroNo = novoNo;
            return;
        } else {
            novoNo.setAnteriorNo(ultimoNo);
            ultimoNo.setProximoNo(novoNo);
            ultimoNo = novoNo;
            //ultimoNo.setProximoNo(primeiroNo);
            //primeiroNo.setAnteriorNo(ultimoNo);
        }
        ultimoNo.setIndice(tamanho);
        tamanho++;
    }

    public void removeInicio() {
        if (primeiroNo == null) {
            System.out.println("Deque Vazia!");
        } else {
            System.out.println("Dado: " + primeiroNo.getDado() + " removido");

            if (primeiroNo == ultimoNo) {
                primeiroNo = null;
                ultimoNo = null;
                return;
            } else {
                primeiroNo = primeiroNo.getProximoNo();
                primeiroNo.setAnteriorNo(ultimoNo);
            }
        }
        tamanho--;
    }

    public void removeFinal() {
        if (ultimoNo == null) {
            System.out.println("Deque Vazia!");
        } else {
            System.out.println("Dado: " + ultimoNo.getDado() + " removido");

            if (primeiroNo == ultimoNo) {
                primeiroNo = null;
                ultimoNo = null;
                return;
            } else {
                ultimoNo = ultimoNo.getAnteriorNo();
                ultimoNo.setProximoNo(primeiroNo);
            }
        }
        atualizaIndice();
        tamanho--;
    }

    public void imprimeDeque() {
        if (primeiroNo == null) {
            System.out.println("Deque Vazio!");
        } else {
            System.out.println("Dados do Deque " + nomeDeque);
            NoDuplo<T> aux = primeiroNo;
            while (aux.getProximoNo() != primeiroNo) {
                System.out.println(aux.toString());
                aux = aux.getProximoNo();
            }
        }
    }
}