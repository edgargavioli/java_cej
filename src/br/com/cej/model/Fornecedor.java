package br.com.cej.model;

public class Fornecedor {
    private Integer id;
    private String nome;
    private String contato;
    private String cnpj;
    private String endereco;
    private String email;
    private String telefone;

    public Fornecedor(Integer id, String nome, String contato, String cnpj, String endereco, String email, String telefone) {
        this.id = id;
        this.nome = nome;
        this.contato = contato;
        this.cnpj = cnpj;
        this.endereco = endereco;
        this.email = email;
        this.telefone = telefone;
    }
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getContato() {
        return contato;
    }

    public void setContato(String contato) {
        this.contato = contato;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
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

    @Override
    public int hashCode() {
        int prime = 31;
        int result = 1;
        result = prime * result + ((cnpj == null) ? 0 : cnpj.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null || getClass() != obj.getClass())
            return false;
        Fornecedor other = (Fornecedor) obj;
        if (cnpj == null) {
            return other.cnpj == null;
        } else {
            return cnpj.equals(other.cnpj);
        }
    }

    @Override
    public String toString() {
        return "Fornecedor{" +
                "nome='" + nome + '\'' +
                ", contato='" + contato + '\'' +
                ", cnpj='" + cnpj + '\'' +
                ", endereco='" + endereco + '\'' +
                ", email='" + email + '\'' +
                ", telefone='" + telefone + '\'' +
                '}';
    }
}
