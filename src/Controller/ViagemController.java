package Controller;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import Model.Cidade;
import Model.CidadeDAO;
import Model.Destino;
import Model.DestinoDAO;
import View.MenuView;

public class ViagemController {
    private Connection connection;
    private CidadeDAO cidadeDAO;
    private DestinoDAO destinoDAO;
    private MenuView menuView;

    public ViagemController() {
        try {
            // Conectar ao banco de dados
            String url = "jdbc:mysql://localhost:3306/mytravel";
            String user = "root"; // Substitua pelo seu usuário do MySQL
            String password = "root"; // Substitua pela sua senha do MySQL
            connection = DriverManager.getConnection(url, user, password);

            // Criar tabelas (se não existirem)
            criarTabelas();

            // Inicializar DAOs e View
            cidadeDAO = new CidadeDAO(connection);
            destinoDAO = new DestinoDAO(connection);
            menuView = new MenuView();
        } catch (SQLException e) {
            System.err.println("Erro ao conectar ao banco de dados: " + e.getMessage());
        }
    }

    // Criar tabelas
    private void criarTabelas() throws SQLException {
        try (Statement stmt = connection.createStatement()) {
            String sqlCidades = "CREATE TABLE IF NOT EXISTS cidade (" +
                    "id INT AUTO_INCREMENT PRIMARY KEY, " +
                    "nome VARCHAR(100) NOT NULL, " +
                    "pais VARCHAR(100) NOT NULL)";
            stmt.execute(sqlCidades);

            String sqlDestinos = "CREATE TABLE IF NOT EXISTS destino (" +
                    "id INT AUTO_INCREMENT PRIMARY KEY, " +
                    "id_cidade INT NOT NULL, " +
                    "data_viagem DATE NOT NULL, " +
                    "FOREIGN KEY (id_cidade) REFERENCES cidade(id))";
            stmt.execute(sqlDestinos);
        }
    }
    public void iniciar() {
        while (true) {
            int opcao = menuView.exibirMenu();
            switch (opcao) {
                case 1:
                    cadastrarCidade();
                    break;
                case 2:
                    cadastrarDestino();
                    break;
                case 3:
                    System.out.println("Saindo...");
                    return;
                default:
                    System.out.println("Opção inválida!");
            }
        }
    }
    private void cadastrarCidade() {
        try {
            String[] dadosCidade = menuView.dadosCidade();
            Cidade cidade = new Cidade(dadosCidade[0], dadosCidade[1]);
            cidadeDAO.cadastrarCidade(cidade);
            menuView.exibirMensagem("Cidade cadastrado com sucesso!");
        } catch (Exception e) {
            menuView.exibirMensagem("ERRO ao cadastrar cidade: " + e.getMessage());
        }
    }

    private void cadastrarDestino() {
        try {
            List<Cidade> cidades = cidadeDAO.listarCidades();
            if (cidades.isEmpty()) {
                menuView.exibirMensagem("Nenhuma cidade cadastrada, cadastre uma cidade primeiro.");
                return;
            }
            int[] dadosDestino = menuView.dadosDestino(cidades);
            Destino destino = new Destino(dadosDestino[0], new Date(dadosDestino[1]));
            destinoDAO.cadastrarDestino(destino);
            menuView.exibirMensagem("Destino cadastrado com sucesso!");
        } catch (Exception e) {
            menuView.exibirMensagem("ERRO ao cadastrar destino: " + e.getMessage());
        }
    }
}
