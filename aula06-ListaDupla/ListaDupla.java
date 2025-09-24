public class ListaDupla<T>{

    private NoDuplo<T> primeiroNo;
    private NoDuplo<T> ultimoNo;
    private String nomeLista;
    private int tamanho;

    public ListaDupla() {
        this("ListaDupla");
    }

    public ListaDupla(String nomeLista) {
        this.nomeLista = nomeLista;
        this.primeiroNo = null;
        this.ultimoNo = null;
        this.tamanho = 0;
    }

    public void atualizaIndice(){
        if (primeiroNo == null) {
            System.out.println("Lista Vazia!");
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
        } else {
            novoNo.setProximoNo(primeiroNo);
            primeiroNo.setAnteriorNo(novoNo);
            primeiroNo = novoNo;
        }
        atualizaIndice();
        tamanho++;
    }

    public void addFinal(T dado) {
        NoDuplo<T> novoNo = new NoDuplo<T>(dado);
        if (ultimoNo == null) {
            ultimoNo = novoNo;
            primeiroNo = novoNo;
        } else {
            novoNo.setAnteriorNo(ultimoNo);
            ultimoNo.setProximoNo(novoNo);
            ultimoNo = novoNo;
        }
        ultimoNo.setIndice(tamanho);
        tamanho++;
    }

    public void removeInicio() {
        if (primeiroNo == null) {
            System.out.println("Lista Vazia!");
        } else {
            System.out.println("Dado: " + primeiroNo.getDado() + " removido");

            if (primeiroNo == ultimoNo) {
                primeiroNo = null;
                ultimoNo = null;
            } else {
                primeiroNo = primeiroNo.getProximoNo();
                primeiroNo.setAnteriorNo(null);
            }
        }
        tamanho--;
    }

    public void removeFinal() {
        if (ultimoNo == null) {
            System.out.println("Lista Vazia!");
        } else {
            System.out.println("Dado: " + ultimoNo.getDado() + " removido");

            if (primeiroNo == ultimoNo) {
                primeiroNo = null;
                ultimoNo = null;
            } else {
                ultimoNo = ultimoNo.getAnteriorNo();
                ultimoNo.setProximoNo(null);
            }
        }
        atualizaIndice();
        tamanho--;
    }

    public void addMeio(int posicao, T dado) {
        //if (posicao < 0 || posicao > tamanho) {
        //    System.out.println("Índice inválido!");
        //}else 
            if (posicao == 0) {
                addInicio(dado);
                return;
            }else 
                if (posicao >= tamanho) {
                    addFinal(dado);
                    return;
                }else{
                    NoDuplo<T> novoNo = new NoDuplo<>(dado);
                    NoDuplo<T> atual = primeiroNo;

                    int indice = 0;
                    while (atual != null && indice < posicao) {
                        atual = atual.getProximoNo();
                        indice++;
                    }

                    novoNo.setProximoNo(atual);
                    novoNo.setAnteriorNo(atual.getAnteriorNo());
                    atual.getAnteriorNo().setProximoNo(novoNo);
                    atual.setAnteriorNo(novoNo);
                }
        tamanho++;
        atualizaIndice();
    }

    public void removeMeio(int posicao) {
        //if (posicao < 0 || posicao >= tamanho) {
        //    System.out.println("Índice inválido!");
        //}else
            if (posicao == 0) {
                removeInicio();
                return;
            }else
                if (posicao == tamanho - 1) {
                    removeFinal();
                    return;
                }else{
                    NoDuplo<T> atual = primeiroNo;
                    int indice = 0;
                    while ( indice < posicao) {
                        atual = atual.getProximoNo();
                        indice++;
                    }

                    System.out.println("Dado: " + atual.getDado() + " removido");

                    atual.getAnteriorNo().setProximoNo(atual.getProximoNo());
                    atual.getProximoNo().setAnteriorNo(atual.getAnteriorNo());
                    }    
        tamanho--;
        atualizaIndice();
    }

    public void imprimeLista() {
        if (primeiroNo == null) {
            System.out.println("Lista Vazia!");
        } else {
            System.out.println("Dados da lista " + nomeLista);
            NoDuplo<T> aux = primeiroNo;
            while (aux != null) {
                System.out.println(aux.toString());
                aux = aux.getProximoNo();
            }
        }
    }
}