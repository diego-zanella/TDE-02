package game;

import java.util.*;

public class JogoPilha {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite o tamanho das pilhas: ");
        int size = scanner.nextInt();

        System.out.print("Ordenar em ordem crescente (1) ou decrescente (2): ");
        int order = scanner.nextInt();

        Stack pilha1 = new Stack();
        Stack pilha2 = new Stack();
        Stack pilha3 = new Stack();

        Random random = new Random();
        for (int i = 0; i < size; i++) {
            pilha1.push(random.nextInt(100) + 1);
        }

        int moves = 0;
        boolean ascending = order == 1;

        while (true) {
            System.out.println("Pilha 1: ");
            pilha1.printStack();
            System.out.println("Pilha 2: ");
            pilha2.printStack();
            System.out.println("Pilha 3: ");
            pilha3.printStack();

            System.out.println("Menu de opções:");
            System.out.println("0 - Sair do jogo.");
            System.out.println("1 - Movimentar.");
            System.out.println("2 - Solução automática.");

            int choice = scanner.nextInt();

            if (choice == 0) {
                break;
            } else if (choice == 1) {
                System.out.print("Pilha de origem (1, 2 ou 3): ");
                int sourceStack = scanner.nextInt();
                System.out.print("Pilha de destino (1, 2 ou 3): ");
                int targetStack = scanner.nextInt();

                Stack source = null;
                Stack target = null;

                if (sourceStack == 1) {
                    source = pilha1;
                } else if (sourceStack == 2) {
                    source = pilha2;
                } else if (sourceStack == 3) {
                    source = pilha3;
                }

                if (targetStack == 1) {
                    target = pilha1;
                } else if (targetStack == 2) {
                    target = pilha2;
                } else if (targetStack == 3) {
                    target = pilha3;
                }

                if (source != null && target != null) {
                    int sourceValue = source.peek();
                    int targetValue = target.peek();

                    if (source.isEmpty()) {
                        System.out.println("Pilha de origem está vazia.");
                    } else if (target.isEmpty() || (ascending && sourceValue < targetValue) || (!ascending && sourceValue > targetValue)) {
                        target.push(source.pop());
                        moves++;
                    } else {
                        System.out.println("Movimento inválido! O número deve ser menor (ou maior, se ordem decrescente) que o topo da pilha de destino.");
                    }
                } else {
                    System.out.println("Pilha de origem ou destino inválida.");
                }
            } else if (choice == 2) {
                int[] arr = new int[size];
                Stack sourceStack = pilha1; 

                for (int i = 0; i < size; i++) {
                    arr[i] = sourceStack.pop(); 
                }
                boolean swapped;
                do {
                    swapped = false;
                    for (int i = 0; i < size - 1; i++) {
                        if ((ascending && arr[i] > arr[i + 1]) || (!ascending && arr[i] < arr[i + 1])) {
                            int temp = arr[i];
                            arr[i] = arr[i + 1];
                            arr[i + 1] = temp;
                            swapped = true;
                        }
                    }
                } while (swapped);

                    Stack targetStack = pilha3;
                    for (int i = 0; i < size; i++) {
                        targetStack.push(arr[i]);
                    }

                    moves += size;
            } else {
                System.out.println("Opção inválida. Escolha 0, 1 ou 2.");
            }

            if (ascending) {
                if (pilha2.size() == size || pilha3.size() == size) {
                    System.out.println("Ordenação concluída em " + moves + " jogadas.");
                    break;
                }
            } else {
                if (pilha2.size() == size || pilha3.size() == size) {
                    System.out.println("Ordenação concluída em " + moves + " jogadas.");
                    break;
                }
            }
        }
    }
}