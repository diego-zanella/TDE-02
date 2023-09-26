package arvore;

public class Node {
    int data;
    Node esquerdo, direito;

    public Node(int data) {
        this.data = data;
        esquerdo = direito = null;
    }
}
