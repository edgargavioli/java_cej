package br.com.cej.screen;

import br.com.cej.screen.produto.menu_produto;

import javax.swing.*;

public class menu_screen extends JFrame{
    private JPanel menu_screen;
    private JButton produtoButton;

    public menu_screen() {
        setContentPane(menu_screen);
        setTitle("Cadastrar produto");
        setSize(500, 300);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);

        produtoButton.addActionListener(elem -> {
            this.dispose();
            new menu_produto();
        });
    }
}
