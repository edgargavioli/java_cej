package br.com.cej.screen.venda;

import br.com.cej.dao.FuncionarioDAO;
import br.com.cej.dao.ProdutoDAO;
import br.com.cej.dao.VendaDAO;
import br.com.cej.model.Funcionario;
import br.com.cej.model.Produto;
import br.com.cej.model.Venda;

import javax.swing.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

import static db.DB.getConnection;

public class create_venda extends JFrame {
    private JTextField data;
    private JComboBox funcionarios;
    private JButton finalizarButton;
    private JList produtos;
    private JTextField id_produto;
    private JButton adicionarButton;
    private JButton cancelarButton;
    private JTextField valorTotal;
    private JPanel create_venda;

    public create_venda() {
        setContentPane(create_venda);
        setTitle("Cadastrar Venda");
        setSize(500, 500);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setVisible(true);

        FuncionarioDAO funcionarioDAO = new FuncionarioDAO();
        VendaDAO vendaDAO = new VendaDAO();
        Venda venda = new Venda(LocalDate.now(), 0.0);
        DefaultListModel<String> model = new DefaultListModel<>();

        data.setText(venda.getData().toString());

        for (Funcionario funcionario : funcionarioDAO.Read(getConnection())) {
            funcionarios.addItem(funcionario.getNome());
        }

        adicionarButton.addActionListener(elem -> {
            Integer id_produto = Integer.parseInt(this.id_produto.getText());
            Produto produto = ProdutoDAO.GetId(id_produto, getConnection());
            model.addElement(produto.getDescricao() + " - " + produto.getPrecoVenda() + " - " + produto.getUnidadeMedida());
            produtos.setModel(model);
            venda.setValorTotal(produto.getPrecoVenda());
            valorTotal.setText(venda.getValorTotal().toString());
        });

        finalizarButton.addActionListener(elem -> {
            venda.setData(LocalDate.now());
            venda.setFuncionario(funcionarioDAO.Read(getConnection()).get(funcionarios.getSelectedIndex()));
            vendaDAO.Save(venda, getConnection());
            JOptionPane.showMessageDialog(null, "Venda cadastrada com sucesso!");
            dispose();
            new read_venda();
        });

        cancelarButton.addActionListener(elem -> {
            dispose();
            new read_venda();
        });
    }
}
