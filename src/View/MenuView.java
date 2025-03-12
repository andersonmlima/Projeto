package View;

import Model.Cidade;
import java.util.List;
import java.util.Scanner;

public class MenuView {
    private Scanner scanner;

    public MenuView() {
        this.scanner = new Scanner(System.in);
    }

    public int exibirMenu() {
        System.out.println("\n--- Menu ---");
        System.out.println("1. Cadastrar nova cidade");
        System.out.println("2. Cadastrar novo destino de viagem");
        System.out.println("3. Sair");
        System.out.print("Escolha uma opção: ");
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
