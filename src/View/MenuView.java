package View;

import Model.Cidade;

import java.util.List;
import java.util.Scanner;

public class MenuView {
    private Scanner scanner;

    public static final String RESET = "\u001B[0m";
    public static final String VERDE = "\u001B[32m";
    public static final String CIANO = "\u001B[36m";
    public static final String BLACK = "\u001B[30m";
    public static final String FUNDO_VERDE = "\u001B[42m";

    public MenuView() {
        this.scanner = new Scanner(System.in);
    }

    public int exibirMenu() {

        String fundoVerdeFontePreta = FUNDO_VERDE + BLACK;

        System.out.println(VERDE + "███    ███ ██    ██ ████████ ██████   █████  ██    ██ ███████ ██      " + RESET);
        System.out.println(VERDE + "████  ████  ██  ██     ██    ██   ██ ██   ██ ██    ██ ██      ██      " + RESET);
        System.out.println(VERDE + "██ ████ ██   ████      ██    ██████  ███████ ██    ██ █████   ██      " + RESET);
        System.out.println(VERDE + "██  ██  ██    ██       ██    ██   ██ ██   ██  ██  ██  ██      ██      " + RESET);
        System.out.println(VERDE + "██      ██    ██       ██    ██   ██ ██   ██   ████   ███████ ███████ " + RESET);

        System.out.println(VERDE + "\n--- Menu ---" + RESET);
        System.out.println(CIANO + "1. Cadastrar nova cidade" + RESET);
        System.out.println(CIANO + "2. Cadastrar novo destino de viagem" + RESET);
        System.out.println(CIANO + "3. Sair" + RESET);
        System.out.print(fundoVerdeFontePreta + "Escolha uma opção: " + RESET);
        return scanner.nextInt();
    }

    // Solicitar dados de uma nova cidade
    public String[] dadosCidade() {
        scanner.nextLine(); // Limpar o buffer
        System.out.print("Digite o nomeCidade da cidade: ");
        String nomeCidade = scanner.nextLine();
        System.out.print("Digite o país da cidade: ");
        String nomePais = scanner.nextLine();
        return new String[]{nomeCidade, nomePais};
    }

    // Solicitar dados de um novo destino
    public int[] dadosDestino(List<Cidade> cidades) {
        System.out.println("\nCidades cadastradas:");
        for (Cidade cidade : cidades) {
            System.out.println("ID: " + cidade.getId() + ", Nome: " + cidade.getNome() + ", País: " + cidade.getPais());
        }
        System.out.print("Digite o ID da cidade: ");
        int cidadeId = scanner.nextInt();
        scanner.nextLine(); // Limpar o buffer
        System.out.print("Digite a data da viagem (AAAA-MM-DD): ");
        String dataViagem = scanner.nextLine();
        return new int[]{cidadeId, Integer.parseInt(dataViagem.replace("-", ""))};
    }

    // Exibir mensagens
    public void exibirMensagem(String mensagem) {
        System.out.println(mensagem);
    }
}
