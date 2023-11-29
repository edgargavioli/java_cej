package br.com.cej.screen.produto;

import br.com.cej.dao.ProdutoDAO;
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
