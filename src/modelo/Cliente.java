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
public class Cliente {

    private int idCliente;
    private String nome;
    private String endereco;
    private String fone;

    public Cliente() {
    }

    public Cliente(String nome, String endereco, String fone) {
        this.nome = nome;
        this.endereco = endereco;
        this.fone = fone;
    }

    public Cliente(int idAmigo, String nome, String endereco, String fone) {
        this.idCliente = idAmigo;
        this.nome = nome;
        this.endereco = endereco;
        this.fone = fone;
    }

    @Override
    public String toString() {
        return "Cliente{" + "idAmigo=" + idCliente + ", nome=" + nome + ", endereco=" + endereco + ", fone=" + fone + '}';
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getFone() {
        return fone;
    }

    public void setFone(String fone) {
        this.fone = fone;
    }
}
