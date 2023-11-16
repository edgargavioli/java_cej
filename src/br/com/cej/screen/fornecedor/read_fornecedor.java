package br.com.cej.screen.fornecedor;

import br.com.cej.dao.FornecedorDAO;
import br.com.cej.model.Fornecedor;
import br.com.cej.screen.menu_screen;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

import static db.DB.getConnection;

public class read_fornecedor extends JFrame{
    private JButton voltarButton;
    private JTable fornecedoresTable;
    private JPanel read_fornecedor;
    private JButton criarButton;

    public read_fornecedor(){
        setContentPane(read_fornecedor);
        setTitle("Fornecedores");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500, 300);
        setLocationRelativeTo(null);
        setVisible(true);

        DefaultTableModel tableModel = new DefaultTableModel();

        tableModel.addColumn("ID");
        tableModel.addColumn("Nome");
        tableModel.addColumn("CNPJ");
        tableModel.addColumn("Endereço");
        tableModel.addColumn("Email");
        tableModel.addColumn("Telefone");

        tableModel.addRow(new Object[]{
                "ID",
                "Nome",
                "CNPJ",
                "Endereço",
                "Email",
                "Telefone"
        });

        fornecedoresTable.setModel(tableModel);

        FornecedorDAO fornecedorDAO = new FornecedorDAO();
        List<Fornecedor> fornecedores = fornecedorDAO.Read(getConnection());

        while (!fornecedores.isEmpty()) {
            Fornecedor fornecedor = fornecedores.remove(0);
            tableModel.addRow(new Object[]{
                    fornecedor.getId(),
                    fornecedor.getNome(),
                    fornecedor.getCnpj(),
                    fornecedor.getEndereco(),
                    fornecedor.getEmail(),
                    fornecedor.getTelefone()
            });
        }

        voltarButton.addActionListener(elem -> {
            this.dispose();
            new menu_screen();
        });

        fornecedoresTable.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int selectedRow = fornecedoresTable.rowAtPoint(e.getPoint());

                if (selectedRow >=0){
                    Integer id = (Integer) fornecedoresTable.getValueAt(selectedRow, 0);
                    String nome = (String) fornecedoresTable.getValueAt(selectedRow, 1);
                    String cnpj = (String) fornecedoresTable.getValueAt(selectedRow, 2);
                    String endereco = (String) fornecedoresTable.getValueAt(selectedRow, 3);
                    String email = (String) fornecedoresTable.getValueAt(selectedRow, 4);
                    String telefone = (String) fornecedoresTable.getValueAt(selectedRow, 5);

                    Fornecedor fornecedor = new Fornecedor(id, nome, cnpj, endereco, email, telefone);

                    new update_fornecedor(fornecedor);

                    dispose();
                }
            }
        });

        criarButton.addActionListener(elem -> {
            new create_fornecedor();
            dispose();
        });
    }
}
