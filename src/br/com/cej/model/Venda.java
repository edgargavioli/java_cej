package br.com.cej.model;

import java.util.*;

//FAZER ALGUMAS COISAS QUE FALTAM DENTRO DO LIST PRODUTOS
public class Venda {
    private Integer id;
    private Produto produto;
    private List<Produto> produtosList = new List<Produto>() {
        @Override
        public int size() {
            return 0;
        }

        @Override
        public boolean isEmpty() {
            return false;
        }

        @Override
        public boolean contains(Object o) {
            return false;
        }

        @Override
        public Iterator<Produto> iterator() {
            return null;
        }

        @Override
        public Object[] toArray() {
            return new Object[0];
        }

        @Override
        public <T> T[] toArray(T[] a) {
            return null;
        }

        @Override
        public boolean add(Produto produto) {
            return false;
        }

        @Override
        public boolean remove(Object o) {
            return false;
        }

        @Override
        public boolean containsAll(Collection<?> c) {
            return false;
        }

        @Override
        public boolean addAll(Collection<? extends Produto> c) {
            return false;
        }

        @Override
        public boolean addAll(int index, Collection<? extends Produto> c) {
            return false;
        }

        @Override
        public boolean removeAll(Collection<?> c) {
            return false;
        }

        @Override
        public boolean retainAll(Collection<?> c) {
            return false;
        }

        @Override
        public void clear() {

        }

        @Override
        public boolean equals(Object o) {
            return false;
        }

        @Override
        public int hashCode() {
            return 0;
        }

        @Override
        public Produto get(int index) {
            return null;
        }

        @Override
        public Produto set(int index, Produto element) {
            return null;
        }

        @Override
        public void add(int index, Produto element) {

        }

        @Override
        public Produto remove(int index) {
            return null;
        }

        @Override
        public int indexOf(Object o) {
            return 0;
        }

        @Override
        public int lastIndexOf(Object o) {
            return 0;
        }

        @Override
        public ListIterator<Produto> listIterator() {
            return null;
        }

        @Override
        public ListIterator<Produto> listIterator(int index) {
            return null;
        }

        @Override
        public List<Produto> subList(int fromIndex, int toIndex) {
            return null;
        }
    };
    private Integer quantidadeProduto;
    private Integer quantidadeItensTotal;
    private Double valorTotal;
    private Funcionario funcionario;
    private String cpfCliente;

    public Venda(Integer id, Produto produto, String codigoBarras, String codigoProduto, Double valorProduto, Integer quantidadeProduto,
                 String lote, Integer quantidadeItensTotal, Double valorTotal, Funcionario funcionario, String cpfCliente) {
        this.id = id;
        this.produto = produto;
        this.quantidadeProduto = quantidadeProduto;
        this.quantidadeItensTotal = quantidadeItensTotal;
        this.valorTotal = valorTotal;
        this.funcionario = funcionario;
        this.cpfCliente = cpfCliente;
    }

    public  Integer getId(){
        return id;
    }
    public void setId(Integer id){
        this.id = id;
    }
    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public Integer getQuantidadeProduto() {
        return quantidadeProduto;
    }

    public void setQuantidadeProduto(Integer quantidadeProduto) {
        this.quantidadeProduto = quantidadeProduto;
    }

    public Integer getQuantidadeItensTotal() {
        return quantidadeItensTotal;
    }

    public void setQuantidadeItensTotal(Integer quantidadeItensTotal) {
        this.quantidadeItensTotal = quantidadeItensTotal;
    }

    public Double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(Double valorTotal) {
        this.valorTotal = valorTotal;
    }

    public Funcionario getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }

    public String getCpfCliente() {
        return cpfCliente;
    }

    public void setCpfCliente(String cpfCliente) {
        this.cpfCliente = cpfCliente;
    }
    public void addProduto(Produto produto){
        produtosList.add(produto);
    }
    public void removeProduto(Produto produto){
        produtosList.remove(produto);
    }
    @Override
    public int hashCode() {
        int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null || getClass() != obj.getClass())
            return false;
        Venda other = (Venda) obj;
        return id == other.id;
    }

}
