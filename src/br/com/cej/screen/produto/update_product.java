package br.com.cej.screen.produto;

import br.com.cej.dao.CategoriaDAO;
import br.com.cej.dao.FornecedorDAO;
import br.com.cej.dao.FuncionarioDAO;
import br.com.cej.dao.ProdutoDAO;
import br.com.cej.model.Categoria;
import br.com.cej.model.Fornecedor;
import br.com.cej.model.Funcionario;
import br.com.cej.model.Produto;

import javax.swing.*;

import static db.DB.getConnection;

public class update_product extends JFrame {
    private JTextField descricao;
    private JTextField unidade_d_medida;
    private JTextField quantidade_minima;
    private JTextField preco_d_compra;
    private JTextField preco_d_venda;
    private JButton voltarButton;
    private JButton aplicarAlteracaoButton;
    private JPanel update_product;
    private JButton deletarButton;
    private JComboBox categorias;
    private JComboBox fornecedores;
    private JComboBox funcionarios;

    public update_product(Produto produto) {
        setContentPane(update_product);
        setTitle("Atualizar Produto");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500, 300);
        setLocationRelativeTo(null);
        setVisible(true);

        descricao.setText(produto.getDescricao());
        unidade_d_medida.setText(produto.getUnidadeMedida());
        quantidade_minima.setText(produto.getQuantidadeMinimaEstoque().toString());
        preco_d_compra.setText(produto.getPrecoCompra().toString());
        preco_d_venda.setText(produto.getPrecoVenda().toString());
        categorias.setSelectedItem(produto.getCategoria().getDescricao());
        fornecedores.setSelectedItem(produto.getFornecedor().getNome());
        funcionarios.setSelectedItem(produto.getFuncionario().getNome());

        CategoriaDAO categoriaDAO = new CategoriaDAO();
        FornecedorDAO fornecedorDAO = new FornecedorDAO();
        FuncionarioDAO funcionarioDAO = new FuncionarioDAO();

        for (Categoria categoria : categoriaDAO.Read(getConnection())) {
            categorias.addItem(categoria.getDescricao());
        }

        for (Funcionario funcionario : funcionarioDAO.Read(getConnection())) {
            funcionarios.addItem(funcionario.getNome());
        }

        for (Fornecedor fornecedor : fornecedorDAO.Read(getConnection())) {
            fornecedores.addItem(fornecedor.getNome());
        }

        voltarButton.addActionListener(e -> {
            new read_product();
            dispose();
        });

        aplicarAlteracaoButton.addActionListener(e -> {
            produto.setDescricao(descricao.getText());
            produto.setUnidadeMedida(unidade_d_medida.getText());
            produto.setQuantidadeMinimaEstoque(Integer.parseInt(quantidade_minima.getText()));
            produto.setPrecoCompra(Double.parseDouble(preco_d_compra.getText()));
            produto.setPrecoVenda(Double.parseDouble(preco_d_venda.getText()));
            produto.setCategoria(categoriaDAO.Read(getConnection()).get(categorias.getSelectedIndex()));
            produto.setFornecedor(fornecedorDAO.Read(getConnection()).get(fornecedores.getSelectedIndex()));
            produto.setFuncionario(funcionarioDAO.Read(getConnection()).get(funcionarios.getSelectedIndex()));

            ProdutoDAO produtoDAO = new ProdutoDAO();

            produtoDAO.Update(produto, getConnection());

            new read_product();
            dispose();
        });

        deletarButton.addActionListener(e -> {
            ProdutoDAO produtoDAO = new ProdutoDAO();

            if (JOptionPane.showConfirmDialog(update_product, "Deseja realmente deletar o produto?", "Deletar produto", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_NO_OPTION) {
                produtoDAO.Delete(produto.getId(), getConnection());
                JOptionPane.showMessageDialog(null, "Produto deletado com sucesso!");
                new read_product();
                dispose();
            }


        });
    }
}
