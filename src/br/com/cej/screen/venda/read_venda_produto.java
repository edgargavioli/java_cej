package br.com.cej.screen.venda;

import br.com.cej.dao.VendaDAO;
import br.com.cej.model.Venda;
import br.com.cej.model.Venda_Produto;

import javax.swing.*;

import java.util.List;

import static db.DB.getConnection;

public class read_venda_produto extends JFrame{
    private JButton voltar;
    private JList itensVendidos;
    private JTextField data;
    private JTextField funcionario;
    private JPanel read_venda_produto;
    private JButton deletarButton;

    public read_venda_produto(int id) {
        setContentPane(read_venda_produto);
        setTitle("Venda");
        setSize(500, 500);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setVisible(true);

        voltar.addActionListener(elem -> {
            dispose();
            new read_venda();
        });

        VendaDAO venda_produtoDAO = new VendaDAO();
        Venda venda = venda_produtoDAO.GetId(id, getConnection());
        List<Venda_Produto> venda_produtos = venda_produtoDAO.GetAllVendas(id, getConnection());

        data.setText(venda.getData().toString());
        funcionario.setText(venda.getFuncionario().getNome());

        DefaultListModel<String> model = new DefaultListModel<>();

        for (Venda_Produto venda_produto : venda_produtos) {
            model.addElement(venda_produto.getProduto().getDescricao() + " - " + venda_produto.getProduto().getPrecoVenda() + " - " + venda_produto.getProduto().getUnidadeMedida() + " - " + venda_produto.getQuantidade()+"\n");
        }
        itensVendidos.setModel(model);

        deletarButton.addActionListener(elem -> {
            venda_produtoDAO.Delete(id, getConnection());
            dispose();
            new read_venda();
        });

    }
}
