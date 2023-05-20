package model;


import java.sql.Date;

public class Reserva {

    private Integer id;
    private Date dataEntrada;
    private Date dateSaida;
    private String valor;
    private String formaPagamento;

    public Reserva(Integer id, Date dataEntrada, Date dateSaida, String valor, String formaPagamento) {
        this.id = id;
        this.dataEntrada = dataEntrada;
        this.dateSaida = dateSaida;
        this.valor = valor;
        this.formaPagamento = formaPagamento;
    }

    public Reserva(Date dataEntrada, Date dateSaida, String valor, String formaPagamento) {
        this.dataEntrada = dataEntrada;
        this.dateSaida = dateSaida;
        this.valor = valor;
        this.formaPagamento = formaPagamento;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return this.id;
    }

    public Date getDataEntrada() {
        return dataEntrada;
    }

    public Date getDateSaida() {
        return dateSaida;
    }

    public String getValor() {
        return valor;
    }

    public String getFormaPagamento() {
        return formaPagamento;
    }
}
