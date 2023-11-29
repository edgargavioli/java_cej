package br.com.cej.screen.fornecedor;

import br.com.cej.dao.FornecedorDAO;
import br.com.cej.model.Fornecedor;

import javax.swing.*;

import static db.DB.getConnection;

public class update_fornecedor extends JFrame {
    private JTextField nome;
    private JTextField cnpj;
    private JTextField endereco;
    private JTextField email;
    private JTextField telefone;
    private JButton voltarButton;
    private JButton deletarButton;
    private JButton aplicarAlteracoesButton;
    private JPanel update_fornecedor;

    public update_fornecedor(Fornecedor fornecedor){
        setContentPane(update_fornecedor);
        setTitle("Atualizar fornecedor");
        setSize(500, 300);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);

        nome.setText(fornecedor.getNome());
        cnpj.setText(fornecedor.getCnpj());
        endereco.setText(fornecedor.getEndereco());
        email.setText(fornecedor.getEmail());
        telefone.setText(fornecedor.getTelefone());

        voltarButton.addActionListener(elem -> {
            this.dispose();
            new read_fornecedor();
        });

        aplicarAlteracoesButton.addActionListener(elem -> {
            fornecedor.setNome(nome.getText());
            fornecedor.setCnpj(cnpj.getText());
            fornecedor.setEndereco(endereco.getText());
            fornecedor.setEmail(email.getText());
            fornecedor.setTelefone(telefone.getText());

            FornecedorDAO fornecedorDAO = new FornecedorDAO();

            fornecedorDAO.Update(fornecedor, getConnection());

            this.dispose();
            new read_fornecedor();
        });

        deletarButton.addActionListener(elem -> {
            FornecedorDAO fornecedorDAO = new FornecedorDAO();

            if (JOptionPane.showConfirmDialog(update_fornecedor, "Deseja realmente deletar o fornecedor?", "Deletar fornecedor", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
                fornecedorDAO.Delete(fornecedor.getId(), getConnection());
                JOptionPane.showMessageDialog(null, "Fornecedor deletado com sucesso!");
                this.dispose();
                new read_fornecedor();
            }
        });
    }
}
