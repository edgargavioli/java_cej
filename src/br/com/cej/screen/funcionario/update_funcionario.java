package br.com.cej.screen.funcionario;

import br.com.cej.dao.FuncionarioDAO;
import br.com.cej.model.Funcionario;

import javax.swing.*;

import static db.DB.getConnection;

public class update_funcionario extends JFrame{
    private JTextField nome;
    private JTextField senha;
    private JTextField email;
    private JTextField telefone;
    private JButton voltarButton;
    private JButton aplicarAlteracaoButton;
    private JButton deletarButton;
    private JPanel update_funcionario;

    public update_funcionario(Funcionario funcionario){
        setContentPane(update_funcionario);
        setTitle("Atualizar funcionário");
        setSize(500, 300);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);

        nome.setText(funcionario.getNome());
        senha.setText(funcionario.getSenha());
        email.setText(funcionario.getEmail());
        telefone.setText(funcionario.getTelefone());

        voltarButton.addActionListener(elem -> {
            this.dispose();
            new read_funcionario();
        });

        aplicarAlteracaoButton.addActionListener(elem -> {
            funcionario.setNome(nome.getText());
            funcionario.setSenha(senha.getText());
            funcionario.setEmail(email.getText());
            funcionario.setTelefone(telefone.getText());

            FuncionarioDAO funcionarioDAO = new FuncionarioDAO();

            funcionarioDAO.Update(funcionario, getConnection());

            this.dispose();
            new read_funcionario();

        });

        deletarButton.addActionListener(e -> {
            FuncionarioDAO funcionarioDAO = new FuncionarioDAO();

            if (JOptionPane.showConfirmDialog(update_funcionario, "Deseja realmente deletar o funcionário?", "Deletar funcionário", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_NO_OPTION) {
                funcionarioDAO.Delete(funcionario.getId(), getConnection());
                JOptionPane.showMessageDialog(null, "Funcionário deletado com sucesso!");
                this.dispose();
                new read_funcionario();
            }
        });
    }
}
