package br.com.cej.screen.produto;

import br.com.cej.dao.ProdutoDAO;
import br.com.cej.model.Produto;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
        tableModel.addColumn("Editar");

        tableModel.addRow(new Object[]{
                "Descrição",
                "Unidade de medida",
                "Quantidade mínima",
                "Preço de compra",
                "Preço de venda",
                "Editar"
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

        itensTable.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                if(!e.getValueIsAdjusting()){
                    int selectedRow = itensTable.getSelectedRow();
                    if(selectedRow>=0){
                        String Descricao = (String) tableModel.getValueAt(selectedRow, 0);
                        String Unidade_Medida = (String) tableModel.getValueAt(selectedRow, 1);
                        Integer Quantidade_Minima = (Integer) tableModel.getValueAt(selectedRow, 2);
                        Double Preco_Compra = (Double) tableModel.getValueAt(selectedRow, 3);
                        Double Preco_Venda = (Double) tableModel.getValueAt(selectedRow, 4);
                    }
                }
            }
        });

        returnButton.addActionListener(elem -> {
            this.dispose();
            new menu_produto();
        });
    }
}
