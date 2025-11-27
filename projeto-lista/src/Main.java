import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    private static ArrayList<String> lista = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int opcao;
        
        do {
            exibirMenu();
            opcao = lerOpcao();
            
            switch (opcao) {
                case 1:
                    adicionarItem();
                    break;
                case 2:
                    listarItens();
                    break;
                case 3:
                    removerItem();
                    break;
                case 4:
                    System.out.println("Saindo do programa...");
                    break;
                default:
                    System.out.println("Opção inválida! Tente novamente.");
            }
        } while (opcao != 4);
        
        scanner.close();
    }

    private static void exibirMenu() {
        System.out.println("\n===== MENU DE GERENCIAMENTO DE LISTA =====");
        System.out.println("1. Adicionar item à lista");
        System.out.println("2. Listar itens");
        System.out.println("3. Remover item pelo índice");
        System.out.println("4. Sair");
        System.out.print("Escolha uma opção: ");
    }

    private static int lerOpcao() {
        try {
            return Integer.parseInt(scanner.nextLine().trim());
        } catch (NumberFormatException e) {
            return -1;
        }
    }

    private static void adicionarItem() {
        System.out.print("Digite o item a ser adicionado: ");
        String item = scanner.nextLine();
        lista.add(item);
        System.out.println("Item '" + item + "' adicionado com sucesso!");
    }

    private static void listarItens() {
        if (lista.isEmpty()) {
            System.out.println("A lista está vazia.");
        } else {
            System.out.println("\n===== ITENS DA LISTA =====");
            for (int i = 0; i < lista.size(); i++) {
                System.out.println(i + ". " + lista.get(i));
            }
        }
    }

    private static void removerItem() {
        if (lista.isEmpty()) {
            System.out.println("A lista está vazia. Não há itens para remover.");
            return;
        }
        
        listarItens();
        System.out.print("Digite o índice do item a ser removido: ");
        
        try {
            int indice = Integer.parseInt(scanner.nextLine().trim());
            if (indice >= 0 && indice < lista.size()) {
                String itemRemovido = lista.remove(indice);
                System.out.println("Item '" + itemRemovido + "' removido com sucesso!");
            } else {
                System.out.println("Índice inválido!");
            }
        } catch (NumberFormatException e) {
            System.out.println("Índice inválido! Digite um número.");
        }
    }
}
