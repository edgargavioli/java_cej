package br.com.cej.dao;

import br.com.cej.model.Produto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProdutoDAO{

    //CRUD

    public void Save(Produto produto, Connection connection) {
        String SQL_COMMAND = "INSERT INTO itens(descricao, unidade_medida, quantidade_minima, valor_d_compra, valor_d_venda) VALUES(?, ?, ?, ?, ?)";

        PreparedStatement pstm = null;

        try {
            //EXECUTA UMA QUERY
            pstm = (PreparedStatement) connection.prepareStatement(SQL_COMMAND);
            pstm.setString(1, produto.getDescricao());
            pstm.setString(2, produto.getUnidadeMedida());
            pstm.setInt(3, produto.getQuantidadeMinimaEstoque());
            pstm.setDouble(4, produto.getPrecoCompra());
            pstm.setDouble(5, produto.getPrecoVenda());

            pstm.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            //fechar conexao
            try {
                if (pstm != null) {
                    pstm.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }


        }
    }

    public List<Produto> Read(Connection connection){
        String SQL_COMMAND = "SELECT * FROM itens";
        List<Produto> produtos = new ArrayList<Produto>();

        PreparedStatement pstm = null;

        try {
            //EXECUTA UMA QUERY
            pstm = (PreparedStatement) connection.prepareStatement(SQL_COMMAND);

            ResultSet resultSet = pstm.executeQuery();

            while (resultSet.next()){

                Produto produto = new Produto(resultSet.getInt("id"), resultSet.getString("descricao"), resultSet.getString("unidade_medida"), resultSet.getInt("quantidade_minima"), resultSet.getDouble("valor_d_compra"), resultSet.getDouble("valor_d_venda"));
                produtos.add(produto);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            //fechar conexao
            try {
                if (pstm != null) {
                    pstm.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return produtos;
    }

    public void Update(Produto produto, Connection connection){
        String SQL_COMMAND = "UPDATE itens SET descricao = ?, unidade_medida = ?, quantidade_minima = ?, valor_d_compra = ?, valor_d_venda = ? WHERE id = ?";

        PreparedStatement pstm = null;

        try {
            //EXECUTA UMA QUERY
            pstm = (PreparedStatement) connection.prepareStatement(SQL_COMMAND);
            pstm.setString(1, produto.getDescricao());
            pstm.setString(2, produto.getUnidadeMedida());
            pstm.setInt(3, produto.getQuantidadeMinimaEstoque());
            pstm.setDouble(4, produto.getPrecoCompra());
            pstm.setDouble(5, produto.getPrecoVenda());
            pstm.setInt(6, produto.getId());

            pstm.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            //fechar conexao
            try {
                if (pstm != null) {
                    pstm.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public void Delete(Integer id, Connection connection) {
        String SQL_COMMAND = "DELETE FROM itens WHERE id = ?";

        PreparedStatement pstm = null;

        try {
            //EXECUTA UMA QUERY
            pstm = (PreparedStatement) connection.prepareStatement(SQL_COMMAND);
            pstm.setInt(1, id);

            pstm.execute();

            System.out.println("Produto deletado com sucesso!");
        } catch (SQLException e) {
            System.out.println("Não foi possível deletar o produto!");
            e.printStackTrace();
        } finally {
            //fechar conexao
            try {
                if (pstm != null) {
                    pstm.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

}
