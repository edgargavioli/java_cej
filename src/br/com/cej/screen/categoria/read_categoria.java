package br.com.cej.screen.categoria;

import br.com.cej.dao.CategoriaDAO;
import br.com.cej.model.Categoria;
import br.com.cej.screen.menu_screen;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

import static db.DB.getConnection;

public class read_categoria extends JFrame{
    private JButton voltarButton;
    private JButton criarButton;
    private JTable tableCategoria;
    private JPanel read_categorias;

    public read_categoria(){
        setContentPane(read_categorias);
        setTitle("Categorias");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500, 300);
        setLocationRelativeTo(null);
        setVisible(true);

        DefaultTableModel tableModel = new DefaultTableModel();

        tableModel.addColumn("ID");
        tableModel.addColumn("Nome");
        tableModel.addColumn("Descrição");

        tableModel.addRow(new Object[]{
            "ID",
            "Nome",
            "Descrição"
        });

        tableCategoria.setModel(tableModel);

        CategoriaDAO categoriaDAO = new CategoriaDAO();
        List<Categoria> categorias = categoriaDAO.Read(getConnection());

        while (!categorias.isEmpty()) {
            Categoria categoria = categorias.remove(0);
            tableModel.addRow(new Object[]{
                categoria.getId(),
                categoria.getNome(),
                categoria.getDescricao()
            });
        }

        voltarButton.addActionListener(e -> {
            new menu_screen();
            dispose();
        });

        criarButton.addActionListener(e -> {
            new create_categoria();
            dispose();
        });

        tableCategoria.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int selectedRow = tableCategoria.rowAtPoint(e.getPoint());

                if (selectedRow >= 0) {
                    Integer id = (Integer)tableCategoria.getValueAt(selectedRow, 0);
                    String nome = (String)tableCategoria.getValueAt(selectedRow, 1);
                    String descricao = (String)tableCategoria.getValueAt(selectedRow, 2);

                    Categoria categoria = new Categoria(id, nome, descricao);

                    dispose();
                    new update_categoria(categoria);
                }
            }
        });
    }
}
