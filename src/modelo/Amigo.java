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
public class Amigo {

    private int idAmigo;
    private String nome;
    private String sobrenome;
    private String email;
    private String fone;

    public Amigo() {
    }

    public Amigo(int idAmigo, String nome, String sobrenome, String email, String fone) {
        this.idAmigo = idAmigo;
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.email = email;
        this.fone = fone;
    }

    public Amigo(String nome, String sobreNome, String email, String fone) {
        this.nome = nome;
        this.sobrenome = sobreNome;
        this.email = email;
        this.fone = fone;
    }

    public int getIdAmigo() {
        return idAmigo;
    }

    public void setIdAmigo(int idAmigo) {
        this.idAmigo = idAmigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFone() {
        return fone;
    }

    public void setFone(String fone) {
        this.fone = fone;
    }

    @Override
    public String toString() {
        return "Amigo{" + "idAmigo=" + idAmigo + ", nome=" + nome + ", sobrenome=" + sobrenome + ", email=" + email + ", fone=" + fone + '}';
    }

}
