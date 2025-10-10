public class ArvoreAVL {

    private No raiz;

    public ArvoreAVL() {
        this.raiz = null;
    }


     // Método público para iniciar a inserção de um novo dado na árvore.
    public void inserir(int dado) {
        this.raiz = inserirNo(this.raiz, dado);
    }

    // Obtém a altura de um nó. Retorna 0 se o nó for nulo.
    private int getAltura(No no) {
        if (no == null) {
            return 0;
        }
        return no.getAltura();
    }

    
    // Retorna o maior valor entre dois inteiros.
    
    private int maximo(int a, int b) {
        return Math.max(a, b);
    }

    
    // Calcula o fator de balanceamento de um nó.
    // A fórmula é: (altura da subárvore esquerda) - (altura da subárvore direita)
    private int fatorDeBalanceamento(No no) {
        if (no == null) {
            return 0;
        }
        return getAltura(no.getEsquerda()) - getAltura(no.getDireita());
    }

    // --- ROTAÇÕES ---

    //Realiza uma rotação simples para a direita.
    private No rotacaoDireita(No y) {
        No x = y.getEsquerda();
        No T2 = x.getDireita();

        // Realiza a rotação
        x.setDireita(y);
        y.setEsquerda(T2);

        // Atualiza as alturas
        y.setAltura(maximo(getAltura(y.getEsquerda()), getAltura(y.getDireita())) + 1);
        x.setAltura(maximo(getAltura(x.getEsquerda()), getAltura(x.getDireita())) + 1);

        // Retorna a nova raiz da subárvore
        return x;
    }

    
    //Realiza uma rotação simples para a esquerda.
    private No rotacaoEsquerda(No x) {
        No y = x.getDireita();
        No T2 = y.getEsquerda();

        // Realiza a rotação
        y.setEsquerda(x);
        x.setDireita(T2);

        // Atualiza as alturas
        x.setAltura(maximo(getAltura(x.getEsquerda()), getAltura(x.getDireita())) + 1);
        y.setAltura(maximo(getAltura(y.getEsquerda()), getAltura(y.getDireita())) + 1);

        // Retorna a nova raiz da subárvore
        return y;
    }


    
    // Método recursivo que insere um novo nó e realiza o balanceamento.
    private No inserirNo(No no, int dado) {
        // 1. Inserção padrão de uma Árvore de Busca Binária
        if (no == null) {
            return new No(dado);
        }

        if (dado < no.getDado()) {
            no.setEsquerda(inserirNo(no.getEsquerda(), dado));
        } else if (dado > no.getDado()) {
            no.setDireita(inserirNo(no.getDireita(), dado));
        } else {
            // Dados duplicados não são inseridos
            return no;
        }

        // 2. Atualiza a altura do nó ancestral
        no.setAltura(1 + maximo(getAltura(no.getEsquerda()), getAltura(no.getDireita())));

        // 3. Calcula o fator de balanceamento para verificar se a árvore precisa de rebalanceamento
        int balanceamento = fatorDeBalanceamento(no);

        // 4. Se o nó estiver desbalanceado, existem 4 casos de rotação

        // Caso Esquerda-Esquerda (Rotação Simples à Direita)
        if (balanceamento > 1 && dado < no.getEsquerda().getDado()) {
            return rotacaoDireita(no);
        }

        // Caso Direita-Direita (Rotação Simples à Esquerda)
        if (balanceamento < -1 && dado > no.getDireita().getDado()) {
            return rotacaoEsquerda(no);
        }

        // Caso Esquerda-Direita (Rotação Dupla)
        if (balanceamento > 1 && dado > no.getEsquerda().getDado()) {
            no.setEsquerda(rotacaoEsquerda(no.getEsquerda()));
            return rotacaoDireita(no);
        }

        // Caso Direita-Esquerda (Rotação Dupla)
        if (balanceamento < -1 && dado < no.getDireita().getDado()) {
            no.setDireita(rotacaoDireita(no.getDireita()));
            return rotacaoEsquerda(no);
        }

        // Retorna o nó (sem alterações ou após o balanceamento)
        return no;
    }

    //Método público para imprimir a árvore em pré-ordem, começando da raiz.
    public void imprimirPreOrdem() {
        imprimirPreOrdem(this.raiz);
        System.out.println(); // Pula uma linha no final
    }

    private void imprimirPreOrdem(No no) {
        if (no != null) {
            System.out.print(no.getDado() + " ");
            imprimirPreOrdem(no.getEsquerda());
            imprimirPreOrdem(no.getDireita());
        }
    }
}