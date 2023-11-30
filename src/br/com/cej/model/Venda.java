package br.com.cej.model;

import br.com.cej.dao.FuncionarioDAO;

import java.time.LocalDate;
import java.util.*;

import static db.DB.getConnection;

//FAZER ALGUMAS COISAS QUE FALTAM DENTRO DO LIST PRODUTOS
public class Venda {
    private Integer id;
    private LocalDate data;
    private Double valorTotal;
    private Funcionario funcionario;
    private List<Venda_Produto> produtos;

    public Venda(LocalDate data, Double valorTotal) {
        this.data = data;
        this.valorTotal = valorTotal;
    }


    public Venda(LocalDate data) {
        this.data = data;
    }

    public Venda(Integer id) {
        this.id = id;
    }

    public Venda() {
    }

    public Venda(int id, LocalDate data, double valorTotal) {
        this.id = id;
        this.data = data;
        this.valorTotal = valorTotal;
    }

    public Venda(int id, LocalDate data, double valorTotal, Integer id_funcionario) {
        this.id = id;
        this.data = data;
        this.valorTotal = valorTotal;
        this.funcionario = FuncionarioDAO.GetId(getConnection(), id_funcionario);
    }

    public Integer getId() {
        return id;
    }

    public LocalDate getData() {
        return data;
    }

    public Double getValorTotal() {
        return valorTotal;
    }

    public Funcionario getFuncionario() {
        return funcionario;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public void setValorTotal(Double valorTotal) {
        this.valorTotal += valorTotal;
    }

    public void setValorTotalToSubtract(Double valorTotal) {
        this.valorTotal -= valorTotal;
    }

}
