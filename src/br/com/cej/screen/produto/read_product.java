package br.com.cej.screen.produto;

import br.com.cej.dao.ProdutoDAO;
import br.com.cej.model.Produto;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.util.List;

import static db.DB.getConnection;

public class read_product extends JFrame{
    private JButton returnButton;
    private JTable itensTable;
    private JPanel read_product;

    public read_product() {

        setContentPane(read_product);
        setTitle("Produtos");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500, 300);
        setLocationRelativeTo(null);
        setVisible(true);

        DefaultTableModel tableModel = new DefaultTableModel();

        tableModel.addColumn("Descrição");
        tableModel.addColumn("Unidade de medida");
        tableModel.addColumn("Quantidade mínima");
        tableModel.addColumn("Preço de compra");
        tableModel.addColumn("Preço de venda");

        tableModel.addRow(new Object[]{
                "Descrição",
                "Unidade de medida",
                "Quantidade mínima",
                "Preço de compra",
                "Preço de venda"
        });

        itensTable.setModel(tableModel);

        ProdutoDAO ProdutoDAO = new ProdutoDAO();
        List<Produto> produtos = ProdutoDAO.Read(getConnection());

        while (!produtos.isEmpty()) {
            Produto produto = produtos.remove(0);
            tableModel.addRow(new Object[]{
                    produto.getDescricao(),
                    produto.getUnidadeMedida(),
                    produto.getQuantidadeMinimaEstoque(),
                    produto.getPrecoCompra(),
                    produto.getPrecoVenda()
            });
        }

        returnButton.addActionListener(elem -> {
            this.dispose();
            new menu_produto();
        });
    }
}
