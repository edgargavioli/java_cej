package br.com.cej.dao;

import br.com.cej.model.Categoria;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CategoriaDAO {
    public void Save(Categoria categoria, Connection connection) {
        String SQL_COMMAND = "INSERT INTO categorias(nome, descricao) VALUES(?, ?)";

        PreparedStatement pstm = null;

        try {
            pstm = (PreparedStatement) connection.prepareStatement(SQL_COMMAND);
            pstm.setString(1, categoria.getNome());
            pstm.setString(2, categoria.getDescricao());

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

            System.out.println("Categoria salva com sucesso!");
        }
    }

    public List<Categoria> Read(Connection connection){
        String SQL_COMMAND = "SELECT * FROM categorias";
        List<Categoria> categorias = new ArrayList<Categoria>();

        PreparedStatement pstm = null;

        try {
            pstm = (PreparedStatement) connection.prepareStatement(SQL_COMMAND);

            ResultSet resultSet = pstm.executeQuery();

            while (resultSet.next()) {
                Categoria categoria = new Categoria(
                        resultSet.getInt("id"),
                        resultSet.getString("nome"),
                        resultSet.getString("descricao")
                );
                categorias.add(categoria);
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

        return categorias;
    }

    public static Categoria GetId(Connection connection, Integer id) {
        String SQL_COMMAND = "SELECT * FROM categorias WHERE id = ?";
        Categoria categoria = null;
        PreparedStatement pstm = null;

        try {
            pstm = (PreparedStatement) connection.prepareStatement(SQL_COMMAND);
            pstm.setInt(1, id);

            ResultSet resultSet = pstm.executeQuery();

            while (resultSet.next()) {
                categoria = new Categoria(
                        resultSet.getInt("id"),
                        resultSet.getString("nome"),
                        resultSet.getString("descricao")
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
        return categoria;
    }

    public void Update(Categoria categoria, Connection connection) {
        String SQL_COMMAND = "UPDATE categorias SET nome = ?, descricao = ? WHERE id = ?";

        PreparedStatement pstm = null;

        try {
            pstm = (PreparedStatement) connection.prepareStatement(SQL_COMMAND);
            pstm.setString(1, categoria.getNome());
            pstm.setString(2, categoria.getDescricao());
            pstm.setInt(3, categoria.getId());

            pstm.execute();
        }
        catch (SQLException e){
            e.printStackTrace();
        }finally {
            try {
                if (pstm != null) {
                    pstm.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public void Delete(Integer id, Connection connection){
        String SQL_COMMAND = "DELETE FROM categorias WHERE id = ?";

        PreparedStatement pstm = null;

        try {
            pstm = (PreparedStatement) connection.prepareStatement(SQL_COMMAND);
            pstm.setInt(1, id);

            pstm.execute();
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            try {
                if (pstm != null) {
                    pstm.close();
                }
            }catch (SQLException e){
                e.printStackTrace();
            }
        }
    }
}
