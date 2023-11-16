package br.com.cej.screen.categoria;

import br.com.cej.dao.CategoriaDAO;
import br.com.cej.model.Categoria;

import javax.swing.*;

import static db.DB.getConnection;

public class create_categoria extends JFrame{
    private JButton voltarButton;
    private JTextField nome;
    private JTextField descricao;
    private JButton criarButton;
    private JPanel create_categoria;

    public create_categoria() {
        setContentPane(create_categoria);
        setTitle("Cadastrar categoria");
        setSize(500, 300);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);

        criarButton.addActionListener(elem -> {
            String nome = this.nome.getText();
            String descricao = this.descricao.getText();

            Categoria categoria = new Categoria(nome, descricao);
            CategoriaDAO categoriaDAO = new CategoriaDAO();

            categoriaDAO.Save(categoria, getConnection());

            JOptionPane.showMessageDialog(null, "Categoria cadastrada com sucesso!");

            this.dispose();

            new read_categoria();
        });

        voltarButton.addActionListener(elem -> {
            this.dispose();
            new read_categoria();
        });
    }
}
