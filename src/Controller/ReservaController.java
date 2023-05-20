package Controller;

import DAO.ReservaDAO;
import Javautil.ConnectionFactory;
import model.Reserva;

import java.sql.Connection;
import java.sql.Date;
import java.util.List;

public class ReservaController {
    private ReservaDAO reservaDAO;

    public ReservaController() {
        Connection connection = new ConnectionFactory().recuperarConexao();
        this.reservaDAO = new ReservaDAO(connection);
    }

    public void salvar(Reserva reserva) {
        this.reservaDAO.salvar(reserva);
    }

    public List<Reserva> listar() {
        return this.reservaDAO.listar();
    }

    public List<Reserva> buscarId(Integer id) {
        return this.reservaDAO.buscarId(id);
    }

    public void editar(Integer id, Date dataEntrada, Date dataSaida) {
        this.reservaDAO.editar(id, dataEntrada, dataSaida);
    }

    public void deletar(Integer id) {
        this.reservaDAO.deletar(id);
    }
}
