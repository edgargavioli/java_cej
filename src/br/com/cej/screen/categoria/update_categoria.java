package br.com.cej.screen.categoria;

import br.com.cej.dao.CategoriaDAO;
import br.com.cej.model.Categoria;

import javax.swing.*;

import static db.DB.getConnection;

public class update_categoria extends JFrame{
    private JTextField nome;
    private JTextField descricao;
    private JButton aplicarAlteracaoButton;
    private JButton voltarButton;
    private JButton deletarButton;
    private JPanel update_categoria;

    public update_categoria(Categoria categoria) {
        setContentPane(update_categoria);
        setTitle("Atualizar categoria");
        setSize(500, 300);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);

        nome.setText(categoria.getNome());
        descricao.setText(categoria.getDescricao());

        voltarButton.addActionListener(elem -> {
            this.dispose();
            new read_categoria();
        });

        aplicarAlteracaoButton.addActionListener(elem -> {
            categoria.setNome(nome.getText());
            categoria.setDescricao(descricao.getText());

            CategoriaDAO categoriaDAO = new CategoriaDAO();

            categoriaDAO.Update(categoria, getConnection());

            this.dispose();
            new read_categoria();
        });

        deletarButton.addActionListener(e -> {
            CategoriaDAO categoriaDAO = new CategoriaDAO();

            if (JOptionPane.showConfirmDialog(update_categoria, "Deseja realmente deletar a categoria?", "Deletar categoria", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_NO_OPTION) {
                categoriaDAO.Delete(categoria.getId(), getConnection());
                JOptionPane.showMessageDialog(null, "Categoria deletada com sucesso!");
                this.dispose();
                new read_categoria();
            }
        });
    }

}
