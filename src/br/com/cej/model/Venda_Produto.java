package br.com.cej.model;

import br.com.cej.dao.ProdutoDAO;
import br.com.cej.dao.VendaDAO;
import db.DB;

import static db.DB.getConnection;

public class Venda_Produto {
    private Integer id;
    private Integer quantidade;
    private Venda venda;
    private Produto produto;

    public Venda_Produto(Integer id, Integer quantidade, Integer vendaId, Integer produtoId) {
        this.id = id;
        this.quantidade = quantidade;
        this.venda = VendaDAO.GetId(vendaId, getConnection());
        this.produto = ProdutoDAO.GetId(produtoId, getConnection());
    }
    public Venda_Produto(Integer id, Integer quantidade, Venda venda, Produto produto) {
        this.id = id;
        this.quantidade = quantidade;
        this.venda = venda;
        this.produto = produto;
    }

    public Venda_Produto(Integer quantidade, Venda venda, Produto produto) {
        this.quantidade = quantidade;
        this.venda = venda;
        this.produto = produto;
    }

    public Venda_Produto(Integer id, Integer quantidade) {
        this.id = id;
        this.quantidade = quantidade;
    }

    public Venda_Produto(Integer quantidade) {
        this.quantidade = quantidade;
    }

    public Venda_Produto() {
    }

    public Integer getId() {
        return id;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

    public Venda getVenda() {
        return venda;
    }

    public void setVenda(Venda venda) {
        this.venda = venda;
    }

    public Produto getProduto(){
        return produto;
    }

    public void setProduto(Produto produto){
        this.produto = produto;
    }
}
