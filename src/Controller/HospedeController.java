package Controller;

import java.sql.Connection;
import java.sql.Date;
import java.util.List;

import DAO.HospedeDAO;
import Javautil.ConnectionFactory;
import model.Hospede;

public class HospedeController {

    private HospedeDAO hospedeDAO;

    public HospedeController() {
        Connection connection = new ConnectionFactory().recuperarConexao();
        this.hospedeDAO = new HospedeDAO(connection);
    }

    public void salvar(Hospede hospede) {
        this.hospedeDAO.salvar(hospede);
    }

    public List<Hospede> listar() {
        return this.hospedeDAO.listar();
    }

    public List<Hospede> buscarSobrenome(String sobrenome) {
        return this.hospedeDAO.buscarSobrenome(sobrenome);
    }

    public void editar(Integer id, String nome, String sobrenome, Date dataNascimento, String nacionalidade, String telefone) {
        this.hospedeDAO.editar(id, nome, sobrenome, dataNascimento, nacionalidade, telefone);
    }

    public void deletar(Integer id) {
        this.hospedeDAO.deletar(id);
    }

    public void deletarIdReserva(Integer idReserva) {
        this.hospedeDAO.deletarIdReserva(idReserva);
    }
}
