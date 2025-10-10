public class Principal {
    public static void main(String[] args) {
        ArvoreAVL arvore = new ArvoreAVL();

        System.out.println("Inserindo valores 10, 20, 30...");
        arvore.inserir(10);
        arvore.inserir(20);
        arvore.inserir(30); // Causa desbalanceamento e uma rotação à esquerda no nó 10

        System.out.print("Árvore em pré-ordem após inserções: ");
        arvore.imprimirPreOrdem(); // Esperado: 20 10 30

        System.out.println("\nInserindo valores 40, 50...");
        arvore.inserir(40);
        arvore.inserir(50); // Causa desbalanceamento e rotações

        System.out.print("Árvore final em pré-ordem: ");
        arvore.imprimirPreOrdem(); // A estrutura final dependerá das rotações

        System.out.println("\nInserindo valores 32...");
        arvore.inserir(32);

        System.out.print("Árvore final em pré-ordem: ");
        arvore.imprimirPreOrdem(); // A estrutura final dependerá das rotações

        System.out.println("\nInserindo valores 35...");
        arvore.inserir(35); // Causa desbalanceamento e rotações

        System.out.print("Árvore final em pré-ordem: ");
        arvore.imprimirPreOrdem(); // A estrutura final dependerá das rotações
    }
}