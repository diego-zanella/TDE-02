package arvore;
import java.util.Scanner;

public class Arvore_busca {
    Node raiz;
    public Arvore_busca(){
        raiz = null;
    }
    public void Inserir(int value) {
        raiz = inserirRecursivo(raiz, value);
    }

    private Node inserirRecursivo(Node raiz, int value) {
        if (raiz == null) {
            raiz = new Node(value);
            return raiz;
        }
        if (value < raiz.data) {
            raiz.esquerdo = inserirRecursivo(raiz.esquerdo, value);
        } else if (value > raiz.data) {
            raiz.direito = inserirRecursivo(raiz.direito, value);
        }

        return raiz;
    }

    public void printArvore() {
        if (raiz == null) {
            System.out.println("A árvore está vazia.");
        } else {
            System.out.println("Árvore Binária de Busca (in-order):");
            travessia(raiz, "in-order");
            System.out.println("\nÁrvore Binária de Busca (pré-ordem):");
            travessia(raiz, "pre-order");
            System.out.println("\nÁrvore Binária de Busca (pós-ordem):");
            travessia(raiz, "post-order");
        }
    }

    private void travessia(Node raiz, String tipo) {
        if (raiz != null) {
            if (tipo.equals("pre-order")) {
                System.out.print(raiz.data + " ");
            }
            travessia(raiz.esquerdo, tipo);
            if (tipo.equals("in-order")) {
                System.out.print(raiz.data + " ");
            }
            travessia(raiz.direito, tipo);
            if (tipo.equals("post-order")) {
                System.out.print(raiz.data + " ");
            }
        }
    }

    public void removerMaior() {
        raiz = removerMaiorRecursivo(raiz);
    }
    
    private Node removerMaiorRecursivo(Node raiz) {
        if (raiz == null) {
            return null;
        }
        if (raiz.direito == null) {
            return raiz.esquerdo; 
        }
        raiz.direito = removerMaiorRecursivo(raiz.direito);
        return raiz;
    }

    public void removerMenor() {
        raiz = removerMenorRecursivo(raiz);
    }
    
    private Node removerMenorRecursivo(Node raiz) {
        if (raiz == null) {
            return null;
        }
        if (raiz.esquerdo == null) {
            return raiz.direito; 
        }
        raiz.esquerdo = removerMenorRecursivo(raiz.esquerdo);
        return raiz;
    }

    public void remover(int value) {
        raiz = removeRecursivo(raiz, value);
    }
    
    private Node removeRecursivo(Node raiz, int value) {
        if (raiz == null) {
            return raiz; 
        }
    
        if (value < raiz.data) {
            raiz.esquerdo = removeRecursivo(raiz.esquerdo, value);
        } else if (value > raiz.data) {
            raiz.direito = removeRecursivo(raiz.direito, value);
        } else {
            if (raiz.esquerdo == null) {
                return raiz.direito;
            } else if (raiz.direito == null) {
                return raiz.esquerdo;
            }
            raiz.data = valorMin(raiz.direito);
            raiz.direito = removeRecursivo(raiz.direito, raiz.data);
        }
        return raiz;
    }
    
    private int valorMin(Node root) {
        int minValue = root.data;
        while (root.esquerdo != null) {
            minValue = root.esquerdo.data;
            root = root.esquerdo;
        }
        return minValue;
    }    

    public static void main(String[] args) {
        Arvore_busca arvore = new Arvore_busca();
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.print("Insira um valor (ou digite 'sair' para encerrar): ");
            String input = scanner.nextLine();

            if (input.equalsIgnoreCase("sair")) {
                break;
            }
            try {
                int valor = Integer.parseInt(input);
                arvore.Inserir(valor);
            } catch (NumberFormatException e) {
                System.out.println("Entrada inválida. Por favor, insira um valor inteiro válido.");
            }
        }
        arvore.printArvore();

        arvore.removerMaior();
        arvore.printArvore();

        arvore.removerMenor();
        arvore.printArvore();

        int valorRemover = 5;
        arvore.remover(valorRemover);
        arvore.printArvore();
    }
}
