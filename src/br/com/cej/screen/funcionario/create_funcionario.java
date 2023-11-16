package br.com.cej.screen.funcionario;

import br.com.cej.dao.FuncionarioDAO;
import br.com.cej.model.Funcionario;

import javax.swing.*;

import static db.DB.getConnection;

public class create_funcionario extends JFrame {
    private JButton voltarButton;
    private JButton criarButton;
    private JTextField nome;
    private JTextField senha;
    private JTextField email;
    private JTextField telefone;
    private JPanel main_painel;

    public create_funcionario() {
        setContentPane(main_painel);
        setTitle("Cadastrar funcionário");
        setSize(500, 300);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);

        criarButton.addActionListener(elem -> {
            String nome = this.nome.getText();
            String senha = this.senha.getText();
            String email = this.email.getText();
            String telefone = this.telefone.getText();

            Funcionario funcionario = new Funcionario(nome, senha, email, telefone);
            FuncionarioDAO funcionarioDAO = new FuncionarioDAO();

            funcionarioDAO.Save(funcionario, getConnection());

            JOptionPane.showMessageDialog(null, "Funcionário cadastrado com sucesso!");

            this.dispose();

            new read_funcionario();
        });

        voltarButton.addActionListener(elem -> {
            this.dispose();
            new read_funcionario();
        });
    }
}
