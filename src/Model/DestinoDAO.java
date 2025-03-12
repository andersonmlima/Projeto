package Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DestinoDAO {
    private Connection conexao;

    public DestinoDAO(Connection conexao) {
        this.conexao = conexao;
    }

    public void cadastrarDestino(Destino destino) throws SQLException {
        String sql = "INSERT INTO destino (id_cidade, data_viagem) VALUES (?, ?)";
        try (PreparedStatement declaracao = conexao.prepareStatement(sql)) {
            declaracao.setInt(1, destino.getCidadeID());
            declaracao.setDate(2, destino.getDataViagem());
            declaracao.executeUpdate();
        }
    }
}
