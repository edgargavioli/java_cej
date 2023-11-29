package br.com.cej.screen.venda;

import br.com.cej.dao.VendaDAO;
import br.com.cej.model.Venda;
import br.com.cej.screen.menu_screen;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.MouseAdapter;
import java.util.List;

import static db.DB.getConnection;

public class read_venda extends JFrame {
    private JButton voltarButton;
    private JButton novaVendaButton;
    private JTable vendas;
    private JPanel read_venda;

    public read_venda() {
        setContentPane(read_venda);
        setTitle("Vendas");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500, 300);
        setLocationRelativeTo(null);
        setVisible(true);

        DefaultTableModel tableModel = new DefaultTableModel();

        tableModel.addColumn("ID");
        tableModel.addColumn("Data");
        tableModel.addColumn("Valor");
        tableModel.addColumn("Funcionário");

        tableModel.addRow(new Object[]{
                "ID",
                "Data",
                "Valor",
                "Funcionário"
        });

        vendas.setModel(tableModel);

        VendaDAO vendaDAO = new VendaDAO();
        List<Venda> vendas = vendaDAO.Read(getConnection());

        while (!vendas.isEmpty()) {
            Venda venda = vendas.remove(0);

            tableModel.addRow(new Object[]{
                    venda.getId(),
                    venda.getData(),
                    venda.getValorTotal(),
                    venda.getFuncionario().getNome()
            });
        }

        novaVendaButton.addActionListener(elem -> {
            this.dispose();
            new create_venda();
        });

        voltarButton.addActionListener(elem -> {
            this.dispose();
            new menu_screen();
        });
    }
}
