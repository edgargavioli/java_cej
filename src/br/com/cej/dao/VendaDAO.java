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
        String SQL_COMMAND = "INSERT INTO vendas(data_v, valor_total, id_funcionario) VALUES(?, ?, ?)";

        PreparedStatement pstm = null;

        try {
            pstm = (PreparedStatement) connection.prepareStatement(SQL_COMMAND);
            pstm.setDate(1, Date.valueOf(venda.getData()));
            pstm.setDouble(2, venda.getValorTotal());
            pstm.setInt(3, venda.getFuncionario().getId());

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

    public void SaveProdutosVenda(Venda_Produto venda, Connection connection){
        String SQL_COMMAND = "INSERT INTO produtos_venda(id_venda, id_produto, quantidade_prod) VALUES(?, ?, ?)";

        PreparedStatement pstm = null;

        try {
            pstm = (PreparedStatement) connection.prepareStatement(SQL_COMMAND);
            pstm.setInt(1, venda.getId());
            pstm.setInt(2, venda.getProduto().getId());
            pstm.setInt(3, venda.getQuantidade());

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
                        resultSet.getDate("data").toLocalDate(),
                        resultSet.getDouble("valor_total")
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
        String SQL_COMMAND = "SELECT * FROM produtos_venda WHERE id_venda = ?";

        List<Venda_Produto> vendas = null;

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

    public void Delete(Integer id, Connection connection){
        String SQL_COMMAND = "DELETE FROM vendas WHERE id = ? AND DELETE FROM produtos_venda WHERE id_venda = ?";

        PreparedStatement pstm = null;

        try {
            pstm = (PreparedStatement) connection.prepareStatement(SQL_COMMAND);
            pstm.setInt(1, id);
            pstm.setInt(2, id);

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
