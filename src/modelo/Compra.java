package modelo;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author olive
 */
public class Compra {
    private int codigo;
    private int idProduto;
    private int idCliente;
    private int qtd;
    private double total;

    public Compra() {
    }

    public Compra(double total) {
        this.total = total;
    }

    public Compra(int codigo, int idProduto, int idCliente, int qtd) {
        this.codigo = codigo;
        this.idProduto = idProduto;
        this.idCliente = idCliente;
        this.qtd = qtd;
    }

    public Compra(int idProduto, int idCliente, int qtd) {
        this.idProduto = idProduto;
        this.idCliente = idCliente;
        this.qtd = qtd;
    }

    @Override
    public String toString() {
        return "Compra{" + "codigo=" + codigo + ", idProduto=" + idProduto + ", idCliente=" + idCliente + ", qtd=" + qtd + '}';
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public int getIdProduto() {
        return idProduto;
    }

    public void setIdProduto(int idProduto) {
        this.idProduto = idProduto;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public int getQtd() {
        return qtd;
    }

    public void setQtd(int qtd) {
        this.qtd = qtd;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

}
