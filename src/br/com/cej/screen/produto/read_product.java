package br.com.cej.screen.produto;

import br.com.cej.dao.ProdutoDAO;
import br.com.cej.model.Categoria;
import br.com.cej.model.Produto;
import br.com.cej.screen.menu_screen;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.MouseAdapter;
import java.util.List;

import static db.DB.getConnection;

public class read_product extends JFrame{
    private JButton returnButton;
    private JTable itensTable;
    private JPanel read_product;
    private JButton criarButton;

    public read_product() {

        setContentPane(read_product);
        setTitle("Produtos");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500, 300);
        setLocationRelativeTo(null);
        setVisible(true);

        DefaultTableModel tableModel = new DefaultTableModel();

        tableModel.addColumn("ID");
        tableModel.addColumn("Descrição");
        tableModel.addColumn("Unidade de medida");
        tableModel.addColumn("Quantidade mínima");
        tableModel.addColumn("Preço de compra");
        tableModel.addColumn("Preço de venda");
        tableModel.addColumn("Categoria");
        tableModel.addColumn("Fornecedor");
        tableModel.addColumn("Funcionário");

        tableModel.addRow(new Object[]{
                "ID",
                "Descrição",
                "Unidade de medida",
                "Quantidade mínima",
                "Preço de compra",
                "Preço de venda",
                "Categoria",
                "Fornecedor",
                "Funcionário"
        });

        itensTable.setModel(tableModel);

        ProdutoDAO produtoDAO = new ProdutoDAO();
        List<Produto> produtos = produtoDAO.Read(getConnection());

        while (!produtos.isEmpty()) {
            Produto produto = produtos.remove(0);
            tableModel.addRow(new Object[]{
                    produto.getId(),
                    produto.getDescricao(),
                    produto.getUnidadeMedida(),
                    produto.getQuantidadeMinimaEstoque(),
                    produto.getPrecoCompra(),
                    produto.getPrecoVenda(),
                    produto.getCategoria().getDescricao(),
                    produto.getFornecedor().getNome(),
                    produto.getFuncionario().getNome()
            });
        }

        criarButton.addActionListener(elem -> {
            this.dispose();
            new create_product();
        });
        itensTable.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                int selectedRow = itensTable.rowAtPoint(evt.getPoint());
                if (selectedRow >= 0) {
                    Integer id = (Integer) itensTable.getValueAt(selectedRow, 0);
                    Produto produto = ProdutoDAO.GetId(id, getConnection());
                    new update_product(produto);
                    dispose();
                }
            }
        });

        returnButton.addActionListener(elem -> {
            this.dispose();
            new menu_screen();
        });
    }
}
