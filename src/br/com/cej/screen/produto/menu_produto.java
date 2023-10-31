package br.com.cej.screen.produto;

import javax.swing.*;
import br.com.cej.screen.menu_screen;

public class menu_produto extends JFrame{
    private JButton criarProdutoButton;
    private JButton listarProdutosButton;
    private JButton editarProdutoButton;
    private JButton deletarProdutoButton;
    private JPanel menu_produto;
    private JButton returnButton;

    public menu_produto() {
        setContentPane(menu_produto);
        setTitle("Menu Produto");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500, 300);
        setLocationRelativeTo(null);
        setVisible(true);

        criarProdutoButton.addActionListener(elem -> {
            this.dispose();
            new create_product();
        });

        listarProdutosButton.addActionListener(elem -> {
            this.dispose();
            new read_product();
        });

        returnButton.addActionListener(elem -> {
            this.dispose();
            new menu_screen();
        });

    }
}
