package br.com.cej.model;

import java.util.Objects;

public class Funcionario {
    private String nome;
    private String senha;
    private String email;
    private String telefone;
    private int nivelAcesso;

    public Funcionario(String nome, String senha, String email, String telefone, int nivelAcesso) {
        this.nome = nome;
        this.senha = senha;
        this.email = email;
        this.telefone = telefone;
        this.nivelAcesso = nivelAcesso;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public int getNivelAcesso() {
        return nivelAcesso;
    }

    public void setNivelAcesso(int nivelAcesso) {
        this.nivelAcesso = nivelAcesso;
    }

    @Override
    public int hashCode() {
        int prime = 31;
        int result = 1;
        result = prime * result + ((email == null) ? 0 : email.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null || getClass() != obj.getClass())
            return false;
        Funcionario other = (Funcionario) obj;
        return Objects.equals(email, other.email);
    }


}
