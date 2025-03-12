package Model;

import java.sql.Connection; // Classe Connection do pacote java.sql
import java.sql.PreparedStatement; // Classe PreparedStatement do pacote java.sql
import java.sql.ResultSet; // Classe ResultSet do pacote java.sql
import java.sql.SQLException; // Classe SQLException do pacote java.sql
import java.sql.Statement; // Classe Statement do pacote java.sql
import java.util.ArrayList; // Classe ArrayList do pacote java.util
import java.util.List; // Importa a interface List do pacote java.util

// Classe pública CidadeDAO
// Atributo privado
public class CidadeDAO {
    private Connection connection;

    // Construtor público
    // Atribui o valor do parâmetro ao atributo da classe.
    public CidadeDAO(Connection connection) {
        this.connection = connection;
    }

    // Cadastrar uma nova cidade
    // Definir uma query SQL para inserir uma nova cidade no banco de dados.
    // Prepara a declaração SQL e habilita a recuperação de chaves geradas.
    public void cadastrarCidade(Cidade cidade) throws SQLException {
        String sql = "INSERT INTO cidade (nome, pais) VALUES (?, ?)";
        try (PreparedStatement declaracao = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            declaracao.setString(1, cidade.getNome());
            declaracao.setString(2, cidade.getPais());
            declaracao.execute();

            // Recupera o ID gerado
            // Obtém as chaves geradas automaticamente
            // Verifica se há uma chave gerada
            // Define o ID gerado no objeto cidade
            try (ResultSet generatedKeys = declaracao.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    cidade.setId(generatedKeys.getInt(1));
                }
            }
        }
    }

    // Listar todas as cidades
    // Cria uma lista para armazenar as cidades
    // Define a query SQL para selecionar todas as cidades
    // Cria uma declaração SQL
    // Cria um objeto Cidade com os dados do banco
    public List<Cidade> listarCidades() throws SQLException {
        List<Cidade> cidades = new ArrayList<>();
        String sql = "SELECT * FROM cidade;";
        try (Statement preparedStatement = connection.createStatement();
             ResultSet resultSet = preparedStatement.executeQuery(sql)) {
            while (resultSet.next()) {
                Cidade cidade = new Cidade(resultSet.getString("nome"), resultSet.getString("pais"));
                cidade.setId(resultSet.getInt("id"));
                cidades.add(cidade);
            }
        }
        return cidades;
    }
}
