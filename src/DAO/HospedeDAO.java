package DAO;

import model.Hospede;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class HospedeDAO {
    private Connection connection;

    public HospedeDAO(Connection connection) {
        this.connection = connection;
    }

    public void salvar(Hospede hospede) {
        try {
            String sql = "INSERT INTO hospedes (nome, sobrenome, nasc, nacionalidade, telefone, id_reserva) VALUES(?, ?, ?, ?, ?, ?)";

            try (PreparedStatement pstm = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
                pstm.setString(1, hospede.getNome());
                pstm.setString(2, hospede.getSobrenome());
                pstm.setDate(3, hospede.getDataNascimento());
                pstm.setString(4, hospede.getNacionalidade());
                pstm.setString(5, hospede.getTelefone());
                pstm.setInt(6, hospede.getIdReserva());

                pstm.executeUpdate();

                try (ResultSet rst = pstm.getGeneratedKeys()){
                    while (rst.next()) {
                        hospede.setId(rst.getInt(1));
                    }
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Hospede> listar() {
        try {
            List<Hospede> hospedes = new ArrayList<>();
            String sql = "SELECT * FROM HOSPEDES";

            try (PreparedStatement pstm = connection.prepareStatement(sql)) {
                pstm.execute();

                try (ResultSet rst = pstm.getResultSet()) {
                    while (rst.next()) {
                        Hospede hospede = new Hospede(rst.getInt(1), rst.getString(2), rst.getString(3), rst.getDate(4), rst.getString(5), rst.getString(6), rst.getInt(7));

                        hospedes.add(hospede);
                    }
                }
            }
            return hospedes;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Hospede> buscarSobrenome(String sobrenome) {
        try {
            List<Hospede> hospedes = new ArrayList<Hospede>();

            String sql = "SELECT * FROM HOSPEDES WHERE SOBRENOME = ?";

            try (PreparedStatement pstm = connection.prepareStatement(sql)) {
                pstm.setString(1, sobrenome);
                pstm.execute();

                try (ResultSet rst = pstm.getResultSet()) {
                    while (rst.next()) {
                        Hospede hospede = new Hospede(rst.getInt(1), rst.getString(2), rst.getString(3), rst.getDate(4), rst.getString(5), rst.getString(6), rst.getInt(7));

                        hospedes.add(hospede);
                    }
                }
            }
            return hospedes;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void editar(Integer id, String nome, String sobrenome, Date dataNascimento, String nacionalidade, String telefone) {
        try (PreparedStatement stm = connection
                .prepareStatement("UPDATE HOSPEDES H SET H.NOME = ?, H.SOBRENOME = ?, H.DATA_NASCIMENTO = ?, H.NACIONALIDADE = ?, H.TELEFONE = ? WHERE ID = ?")) {
            stm.setString(1, nome);
            stm.setString(2, sobrenome);
            stm.setDate(3, dataNascimento);
            stm.setString(4, nacionalidade);
            stm.setString(5, telefone);
            stm.setInt(6, id);
            stm.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void deletar(Integer id) {
        try (PreparedStatement stm = connection.prepareStatement("DELETE FROM hospedes WHERE id = ?")) {
            stm.setInt(1, id);
            stm.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void deletarIdReserva(Integer idReserva) {
        try (PreparedStatement stm = connection.prepareStatement("DELETE FROM HOSPEDES WHERE ID_RESERVA = ?")) {
            stm.setInt(1, idReserva);
            stm.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
