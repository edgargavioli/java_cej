package br.com.cej.screen.fornecedor;

import br.com.cej.dao.FornecedorDAO;
import br.com.cej.model.Fornecedor;

import javax.swing.*;

import static db.DB.getConnection;

public class create_fornecedor extends JFrame{
    private JTextField nome;
    private JTextField cnpj;
    private JTextField endereco;
    private JTextField email;
    private JTextField telefone;
    private JButton voltarButton;
    private JButton criarButton;
    private JPanel create_fornecedor;

    public create_fornecedor(){
        setContentPane(create_fornecedor);
        setTitle("Cadastrar fornecedor");
        setSize(500, 300);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);

        criarButton.addActionListener(elem -> {
            String nome = this.nome.getText();
            String cnpj = this.cnpj.getText();
            String endereco = this.endereco.getText();
            String email = this.email.getText();
            String telefone = this.telefone.getText();

            Fornecedor fornecedor = new Fornecedor(nome, cnpj, endereco, email, telefone);
            FornecedorDAO fornecedorDAO = new FornecedorDAO();

            fornecedorDAO.Save(fornecedor, getConnection());

            JOptionPane.showMessageDialog(null, "Fornecedor cadastrado com sucesso!");

            this.dispose();

            new read_fornecedor();
        });

        voltarButton.addActionListener(elem -> {
            this.dispose();
            new read_fornecedor();
        });
    }
}
