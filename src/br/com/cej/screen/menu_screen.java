package br.com.cej.screen;

import br.com.cej.screen.fornecedor.read_fornecedor;
import br.com.cej.screen.funcionario.read_funcionario;
import br.com.cej.screen.produto.read_product;
import br.com.cej.screen.categoria.read_categoria;

import javax.swing.*;

public class menu_screen extends JFrame{
    private JPanel menu_screen;
    private JButton produtoButton;
    private JButton funcionariosButton;
    private JButton categoriasButton;
    private JButton fornecedoresButton;

    public menu_screen() {
        setContentPane(menu_screen);
        setTitle("Cadastrar produto");
        setSize(500, 300);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);

        produtoButton.addActionListener(elem -> {
            this.dispose();
            new read_product();
        });

        funcionariosButton.addActionListener(elem -> {
            this.dispose();
            new read_funcionario();
        });

        categoriasButton.addActionListener(elem -> {
            this.dispose();
            new read_categoria();
        });

        fornecedoresButton.addActionListener(elem -> {
            this.dispose();
            new read_fornecedor();
        });
    }
}
