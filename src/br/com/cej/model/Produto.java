package br.com.cej.model;

import br.com.cej.dao.CategoriaDAO;
import br.com.cej.dao.FornecedorDAO;
import br.com.cej.dao.FuncionarioDAO;

import java.util.Objects;
import java.util.Date;

import static db.DB.getConnection;

public class Produto {

    private Integer id;
    private String descricao;
    private String localizacao;
    private Double precoCompra;
    private Double precoVenda;
    private String unidadeMedida;
    private Double peso;
    private Integer quantidadeMinimaEstoque;
    private Categoria categoria;
    private Fornecedor fornecedor;
    private Funcionario funcionario;
    private String codigoProduto;

    // Construtor
    public Produto(String descricao, String unidadeMedida, Integer quantidadeMinimaEstoque, Double precoCompra, Double precoVenda, Categoria categoria, Fornecedor fornecedor, Funcionario funcionario){
        this.descricao = descricao;
        this.unidadeMedida = unidadeMedida;
        this.quantidadeMinimaEstoque = quantidadeMinimaEstoque;
        this.precoCompra = precoCompra;
        this.precoVenda = precoVenda;
        this.categoria = categoria;
        this.fornecedor = fornecedor;
        this.funcionario = funcionario;
    }

    public Produto(Integer id, String descricao, String unidadeMedida, Integer quantidadeMinimaEstoque, Double precoCompra, Double precoVenda, Integer idCategoria, Integer idFornecedor, Integer idFuncionario){
        this.descricao = descricao;
        this.unidadeMedida = unidadeMedida;
        this.quantidadeMinimaEstoque = quantidadeMinimaEstoque;
        this.precoCompra = precoCompra;
        this.precoVenda = precoVenda;
        this.id = id;
        this.categoria = CategoriaDAO.GetId(getConnection(), idCategoria);
        this.fornecedor = FornecedorDAO.GetId(getConnection(), idFornecedor);
        this.funcionario = FuncionarioDAO.GetId(getConnection(), idFuncionario);
    }

    public Produto(Integer id, String descricao, String unidadeMedida, Integer quantidadeMinimaEstoque, Double precoCompra, Double precoVenda, Categoria categoria){
        this.descricao = descricao;
        this.unidadeMedida = unidadeMedida;
        this.quantidadeMinimaEstoque = quantidadeMinimaEstoque;
        this.precoCompra = precoCompra;
        this.precoVenda = precoVenda;
        this.id = id;
    }

    public Integer getId(){
        return id;
    }
    public void setId(Integer id){
        this.id = id;
    }
    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Double getPrecoCompra() {
        return precoCompra;
    }

    public void setPrecoCompra(Double precoCompra) {
        this.precoCompra = precoCompra;
    }

    public Double getPrecoVenda() {
        return precoVenda;
    }

    public void setPrecoVenda(Double precoVenda) {
        this.precoVenda = precoVenda;
    }

    public String getUnidadeMedida() {
        return unidadeMedida;
    }

    public void setUnidadeMedida(String unidadeMedida) {
        this.unidadeMedida = unidadeMedida;
    }

    public Integer getQuantidadeMinimaEstoque() {
        return quantidadeMinimaEstoque;
    }

    public void setQuantidadeMinimaEstoque(Integer quantidadeMinimaEstoque) {
        this.quantidadeMinimaEstoque = quantidadeMinimaEstoque;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public Fornecedor getFornecedor() {
        return fornecedor;
    }

    public void setFornecedor(Fornecedor fornecedor) {
        this.fornecedor = fornecedor;
    }

    public Funcionario getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }

    public String getCodigoProduto() {
        return codigoProduto;
    }

    public void setCodigoProduto(String codigoProduto) {
        this.codigoProduto = codigoProduto;
    }
}


