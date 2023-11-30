package br.com.cej.screen.venda;

import br.com.cej.dao.FuncionarioDAO;
import br.com.cej.dao.ProdutoDAO;
import br.com.cej.dao.VendaDAO;
import br.com.cej.model.Funcionario;
import br.com.cej.model.Produto;
import br.com.cej.model.Venda;
import br.com.cej.model.Venda_Produto;

import javax.swing.*;

import java.time.Instant;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

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
    private JTextField quantidade;

    public create_venda() {
        setContentPane(create_venda);
        setTitle("Cadastrar Venda");
        setSize(800, 500);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setVisible(true);

        List<Venda_Produto> venda_produtos = new ArrayList<>();

        int id = (int) (Instant.now().toEpochMilli()+new Random().nextInt(1000));

        FuncionarioDAO funcionarioDAO = new FuncionarioDAO();
        VendaDAO vendaDAO = new VendaDAO();
        Venda venda = new Venda(id, LocalDate.now(), 0.0);
        DefaultListModel<String> model = new DefaultListModel<>();

        data.setText(venda.getData().toString());

        for (Funcionario funcionario : funcionarioDAO.Read(getConnection())) {
            funcionarios.addItem(funcionario.getNome());
        }

        adicionarButton.addActionListener(elem -> {
            Integer id_produto = Integer.parseInt(this.id_produto.getText());
            this.quantidade.setText(this.quantidade.getText().equals("") ? "1" : this.quantidade.getText());
            Integer quantidade = Integer.parseInt(this.quantidade.getText());
            Produto produto = ProdutoDAO.GetId(id_produto, getConnection());
            Venda_Produto venda_produto = new Venda_Produto(quantidade, produto.getId());
            venda_produtos.add(venda_produto);
            model.addElement(produto.getDescricao() + " - " + produto.getPrecoVenda() + " - " + produto.getUnidadeMedida() + " - " + quantidade);
            produtos.setModel(model);
            venda.setValorTotal(produto.getPrecoVenda()*quantidade);
            valorTotal.setText(venda.getValorTotal().toString());
        });

        produtos.addListSelectionListener(elem -> {
            int selectedIndex = produtos.getSelectedIndex();

            if (selectedIndex != -1) { // Verifica se algum item está selecionado
                String produto = model.getElementAt(selectedIndex).toString();
                String[] produtoArray = produto.split(" - ");
                double valorRemovido = Double.parseDouble(produtoArray[1]) * Integer.parseInt(produtoArray[3]);

                venda.setValorTotalToSubtract(valorRemovido);
                valorTotal.setText(venda.getValorTotal().toString());
                venda_produtos.remove(selectedIndex);

                model.remove(selectedIndex);
                produtos.setModel(model);
            }
        });

        finalizarButton.addActionListener(elem -> {
            venda.setData(LocalDate.now());
            venda.setFuncionario(funcionarioDAO.Read(getConnection()).get(funcionarios.getSelectedIndex()));
            vendaDAO.Save(venda, getConnection());
            vendaDAO.SaveProdutosVenda(venda_produtos, venda.getId(), getConnection());
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
