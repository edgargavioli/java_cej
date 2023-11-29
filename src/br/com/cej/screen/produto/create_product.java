package br.com.cej.screen.produto;

import br.com.cej.dao.FornecedorDAO;
import br.com.cej.dao.FuncionarioDAO;
import br.com.cej.dao.ProdutoDAO;
import br.com.cej.model.Fornecedor;
import br.com.cej.model.Funcionario;
import br.com.cej.model.Produto;
import br.com.cej.model.Categoria;
import br.com.cej.dao.CategoriaDAO;

import javax.swing.*;

import static db.DB.*;

public class create_product extends JFrame {
    private JPanel mainPanel;
    private JTextField descricao;
    private JTextField unidade_d_medida;
    private JTextField quantidade_minima;
    private JTextField preco_d_compra;
    private JTextField preco_d_venda;
    private JButton Criar;
    private JButton returnButton;
    private JComboBox categorias;
    private JComboBox funcionario;
    private JComboBox fornecedor;

    public create_product() {
        setContentPane(mainPanel);
        setTitle("Cadastrar produto");
        setSize(500, 300);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);

        CategoriaDAO categoriaDAO = new CategoriaDAO();
        FuncionarioDAO funcionarioDAO = new FuncionarioDAO();
        FornecedorDAO fornecedorDAO = new FornecedorDAO();

        for (Categoria categoria : categoriaDAO.Read(getConnection())) {
            categorias.addItem(categoria.getDescricao());
        }

        for (Funcionario funcionario : funcionarioDAO.Read(getConnection())) {
            this.funcionario.addItem(funcionario.getNome());
        }

        for (Fornecedor fornecedor : fornecedorDAO.Read(getConnection())) {
            this.fornecedor.addItem(fornecedor.getNome());
        }

        Criar.addActionListener(elem -> {
            String descricao = this.descricao.getText();
            String unidade_d_medida = this.unidade_d_medida.getText();
            Integer quantidade_minima = Integer.parseInt(this.quantidade_minima.getText());
            Double preco_d_compra = Double.parseDouble(this.preco_d_compra.getText());
            Double preco_d_venda = Double.parseDouble(this.preco_d_venda.getText());
            Categoria categoria = categoriaDAO.Read(getConnection()).get(categorias.getSelectedIndex());
            Funcionario funcionario = funcionarioDAO.Read(getConnection()).get(this.funcionario.getSelectedIndex());
            Fornecedor fornecedor = fornecedorDAO.Read(getConnection()).get(this.fornecedor.getSelectedIndex());

            Produto produto = new Produto(descricao, unidade_d_medida, quantidade_minima, preco_d_compra, preco_d_venda, categoria, fornecedor, funcionario);
            ProdutoDAO produtoDAO = new ProdutoDAO();

            produtoDAO.Save(produto, getConnection());

            JOptionPane.showMessageDialog(null, "Produto cadastrado com sucesso!");

            this.dispose();

            new read_product();
        });

        returnButton.addActionListener(elem -> {
            this.dispose();
            new read_product();
        });
    }
}
