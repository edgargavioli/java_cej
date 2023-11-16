package br.com.cej.screen.produto;

import br.com.cej.dao.ProdutoDAO;
import br.com.cej.model.Produto;
import br.com.cej.screen.menu_screen;

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

    public create_product() {
        setContentPane(mainPanel);
        setTitle("Cadastrar produto");
        setSize(500, 300);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);

        Criar.addActionListener(elem -> {
            String descricao = this.descricao.getText();
            String unidade_d_medida = this.unidade_d_medida.getText();
            Integer quantidade_minima = Integer.parseInt(this.quantidade_minima.getText());
            Double preco_d_compra = Double.parseDouble(this.preco_d_compra.getText());
            Double preco_d_venda = Double.parseDouble(this.preco_d_venda.getText());

            Produto produto = new Produto(descricao, unidade_d_medida, quantidade_minima, preco_d_compra, preco_d_venda);
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
