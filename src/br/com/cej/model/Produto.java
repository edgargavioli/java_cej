package br.com.cej.model;

import java.util.Objects;
import java.util.Date;

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
    private String codigoBarras;
    private Date validade;
    private String lote;
    private Date dataCompra;
    private Date dataChegada;

    // Construtor
    public Produto(Integer id, String descricao, String localizacao, Double precoCompra, Double precoVenda, String unidadeMedida,
                   Double peso, Integer quantidadeMinimaEstoque, Categoria categoria, Fornecedor fornecedor,
                   Funcionario funcionario, String codigoProduto, String codigoBarras, Date validade, String lote,
                   Date dataCompra, Date dataChegada) {
        this.id = id;
        this.descricao = descricao;
        this.localizacao = localizacao;
        this.precoCompra = precoCompra;
        this.precoVenda = precoVenda;
        this.unidadeMedida = unidadeMedida;
        this.peso = peso;
        this.quantidadeMinimaEstoque = quantidadeMinimaEstoque;
        this.categoria = categoria;
        this.fornecedor = fornecedor;
        this.funcionario = funcionario;
        this.codigoProduto = codigoProduto;
        this.codigoBarras = codigoBarras;
        this.validade = validade;
        this.lote = lote;
        this.dataCompra = dataCompra;
        this.dataChegada = dataChegada;
    }

    public Produto(String descricao, String unidadeMedida, Integer quantidadeMinimaEstoque, Double precoCompra, Double precoVenda){
        this.descricao = descricao;
        this.unidadeMedida = unidadeMedida;
        this.quantidadeMinimaEstoque = quantidadeMinimaEstoque;
        this.precoCompra = precoCompra;
        this.precoVenda = precoVenda;
    }

    public Produto(Integer id, String descricao, String unidadeMedida, Integer quantidadeMinimaEstoque, Double precoCompra, Double precoVenda){
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

    public String getLocalizacao() {
        return localizacao;
    }

    public void setLocalizacao(String localizacao) {
        this.localizacao = localizacao;
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

    public Double getPeso() {
        return peso;
    }

    public void setPeso(Double peso) {
        this.peso = peso;
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

    public String getCodigoBarras() {
        return codigoBarras;
    }

    public void setCodigoBarras(String codigoBarras) {
        this.codigoBarras = codigoBarras;
    }

    public Date getValidade() {
        return validade;
    }

    public void setValidade(Date validade) {
        this.validade = validade;
    }

    public String getLote() {
        return lote;
    }

    public void setLote(String lote) {
        this.lote = lote;
    }

    public Date getDataCompra() {
        return dataCompra;
    }

    public void setDataCompra(Date dataCompra) {
        this.dataCompra = dataCompra;
    }

    public Date getDataChegada() {
        return dataChegada;
    }

    public void setDataChegada(Date dataChegada) {
        this.dataChegada = dataChegada;
    }

    @Override
    public int hashCode() {
        return Objects.hash(descricao, precoCompra, categoria);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null || getClass() != obj.getClass())
            return false;
        Produto other = (Produto) obj;
        return Objects.equals(descricao, other.descricao) &&
                Double.compare(other.precoCompra, precoCompra) == 0 &&
                Objects.equals(categoria, other.categoria);
    }
}


