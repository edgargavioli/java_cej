package br.com.cej.dao;

import br.com.cej.model.Produto;
import br.com.cej.model.Venda;
import br.com.cej.model.Venda_Produto;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


public class VendaDAO {
    public void Save(Venda venda, Connection connection){
        String SQL_COMMAND = "INSERT INTO vendas(data_v, valor_total, id_funcionario, id) VALUES(?, ?, ?, ?)";

        PreparedStatement pstm = null;

        try {
            pstm = (PreparedStatement) connection.prepareStatement(SQL_COMMAND);
            pstm.setDate(1, Date.valueOf(venda.getData()));
            pstm.setDouble(2, venda.getValorTotal());
            pstm.setInt(3, venda.getFuncionario().getId());
            pstm.setInt(4, venda.getId());

            pstm.execute();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            //fechar conexao
            try {
                if (pstm != null) {
                    pstm.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }

            System.out.println("Venda salva com sucesso!");
        }
    }

    public List<Venda> Read(Connection connection){
        String SQL_COMMAND = "SELECT * FROM vendas";
        List<Venda> vendas = new ArrayList<Venda>();
        PreparedStatement pstm = null;

        try {
            pstm = (PreparedStatement) connection.prepareStatement(SQL_COMMAND);

            ResultSet resultSet = pstm.executeQuery();

            while (resultSet.next()) {
                Venda venda = new Venda(
                        resultSet.getInt("id"),
                        resultSet.getDate("data_v").toLocalDate(),
                        resultSet.getDouble("valor_total"),
                        resultSet.getInt("id_funcionario")
                );
                vendas.add(venda);
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (pstm != null) {
                    pstm.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return vendas;
    }

    public List<Venda_Produto> ReadAll(Connection connection){
        String SQL_COMMAND = "SELECT * FROM produtos_venda WHERE id_venda = ?";
        List<Venda_Produto> vendas = new ArrayList<Venda_Produto>();
        PreparedStatement pstm = null;

        try {
            pstm = (PreparedStatement) connection.prepareStatement(SQL_COMMAND);

            ResultSet resultSet = pstm.executeQuery();

            while (resultSet.next()) {
                Venda_Produto venda = new Venda_Produto(
                        resultSet.getInt("id"),
                        resultSet.getInt("quantidade"),
                        resultSet.getInt("id_venda"),
                        resultSet.getInt("id_produto")
                );
                vendas.add(venda);
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (pstm != null) {
                    pstm.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return vendas;
    }

    public void SaveProdutosVenda(List<Venda_Produto> venda, Integer id, Connection connection){
        String SQL_COMMAND = "INSERT INTO vendas_itens(id_venda, id_item, quantidade) VALUES(?, ?, ?)";

        PreparedStatement pstm = null;

        try {
            pstm = (PreparedStatement) connection.prepareStatement(SQL_COMMAND);
            for (Venda_Produto venda_produto : venda) {
                pstm.setInt(1, id);
                pstm.setInt(2, venda_produto.getProduto().getId());
                pstm.setInt(3, venda_produto.getQuantidade());

                pstm.execute();
            }

            pstm.execute();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            //fechar conexao
            try {
                if (pstm != null) {
                    pstm.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }

            System.out.println("Venda salva com sucesso!");
        }
    }

    public static Venda GetId(Integer id, Connection connection){
        String SQL_COMMAND = "SELECT * FROM vendas WHERE id = ?";
        Venda venda = null;
        PreparedStatement pstm = null;

        try {
            pstm = (PreparedStatement) connection.prepareStatement(SQL_COMMAND);
            pstm.setInt(1, id);

            ResultSet resultSet = pstm.executeQuery();

            while (resultSet.next()) {
                venda = new Venda(
                        resultSet.getInt("id"),
                        resultSet.getDate("data_v").toLocalDate(),
                        resultSet.getDouble("valor_total"),
                        resultSet.getInt("id_funcionario")
                );
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (pstm != null) {
                    pstm.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return venda;
    }

    public List<Venda_Produto> GetAllVendas(Integer id, Connection connection){
        String SQL_COMMAND = "SELECT * FROM vendas_itens WHERE id_venda = ?";

        ArrayList<Venda_Produto> vendas = new ArrayList<Venda_Produto>();

        PreparedStatement pstm = null;

        try {
            pstm = (PreparedStatement) connection.prepareStatement(SQL_COMMAND);
            pstm.setInt(1, id);

            ResultSet resultSet = pstm.executeQuery();

            while (resultSet.next()) {
                Venda_Produto venda = new Venda_Produto(
                        resultSet.getInt("id"),
                        resultSet.getInt("quantidade"),
                        resultSet.getInt("id_venda"),
                        resultSet.getInt("id_item")
                );
                vendas.add(venda);
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (pstm != null) {
                    pstm.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return vendas;
    }

    public void Delete(Integer id, Connection connection){
        String SQL_COMMAND = "DELETE FROM vendas WHERE id = ?";
        String SQL_COMMAND2 = "DELETE FROM vendas_itens WHERE id_venda = ?";

        PreparedStatement pstm = null;
        PreparedStatement pstm2 = null;

        try {
            pstm = (PreparedStatement) connection.prepareStatement(SQL_COMMAND);
            pstm.setInt(1, id);
            pstm2 = (PreparedStatement) connection.prepareStatement(SQL_COMMAND2);
            pstm2.setInt(1, id);

            pstm.execute();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            //fechar conexao
            try {
                if (pstm != null) {
                    pstm.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }

            System.out.println("Venda deletada com sucesso!");
        }
    }
}
