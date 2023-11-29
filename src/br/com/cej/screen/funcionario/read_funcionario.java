package br.com.cej.screen.funcionario;

import br.com.cej.dao.FuncionarioDAO;
import br.com.cej.model.Funcionario;
import br.com.cej.screen.menu_screen;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

import static db.DB.getConnection;

public class read_funcionario extends JFrame{
    private JButton voltarButton;
    private JButton criarButton;
    private JTable funcionariosTable;
    private JPanel read_funcionario;

    public read_funcionario(){
        setContentPane(read_funcionario);
        setTitle("Funcionários");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500, 300);
        setLocationRelativeTo(null);
        setVisible(true);

        DefaultTableModel tableModel = new DefaultTableModel();

        tableModel.addColumn("ID");
        tableModel.addColumn("Nome");
        tableModel.addColumn("Senha");
        tableModel.addColumn("Email");
        tableModel.addColumn("Telefone");

        tableModel.addRow(new Object[]{
                "ID",
                "Nome",
                "Senha",
                "Email",
                "Telefone"
        });

        funcionariosTable.setModel(tableModel);

        FuncionarioDAO funcionarioDAO = new FuncionarioDAO();
        List<Funcionario> funcionarios = funcionarioDAO.Read(getConnection());

        while (!funcionarios.isEmpty()) {
            Funcionario funcionario = funcionarios.remove(0);
            tableModel.addRow(new Object[]{
                    funcionario.getId(),
                    funcionario.getNome(),
                    funcionario.getSenha(),
                    funcionario.getEmail(),
                    funcionario.getTelefone()
            });
        }

        criarButton.addActionListener(elem -> {
            new create_funcionario();
            dispose();
        });

        funcionariosTable.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int selectedRow = funcionariosTable.rowAtPoint(e.getPoint());

                if (selectedRow >=0){
                    Integer id = (Integer) funcionariosTable.getValueAt(selectedRow, 0);
                    String nome = (String) funcionariosTable.getValueAt(selectedRow, 1);
                    String senha = (String) funcionariosTable.getValueAt(selectedRow, 2);
                    String email = (String) funcionariosTable.getValueAt(selectedRow, 3);
                    String telefone = (String) funcionariosTable.getValueAt(selectedRow, 4);

                    Funcionario funcionario = new Funcionario(id, nome, senha, email, telefone);

                    dispose();
                    new update_funcionario(funcionario);
                }
            }
        });

        voltarButton.addActionListener(elem -> {
            new menu_screen();
            dispose();
        });
    }
}
