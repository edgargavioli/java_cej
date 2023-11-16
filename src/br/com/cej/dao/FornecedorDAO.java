package br.com.cej.dao;

import br.com.cej.model.Fornecedor;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class FornecedorDAO {
    public void Save(Fornecedor fornecedor, Connection connection) {
        String SQL_COMMAND = "INSERT INTO fornecedores(nome, cnpj, endereco, email, telefone) VALUES(?, ?, ?, ?, ?)";

        PreparedStatement pstm = null;

        try {
            pstm = (PreparedStatement) connection.prepareStatement(SQL_COMMAND);
            pstm.setString(1, fornecedor.getNome());
            pstm.setString(2, fornecedor.getCnpj());
            pstm.setString(3, fornecedor.getEndereco());
            pstm.setString(4, fornecedor.getEmail());
            pstm.setString(5, fornecedor.getTelefone());

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

            System.out.println("Fornecedor salvo com sucesso!");
        }
    }

    public List<Fornecedor> Read(Connection connection) {
        String SQL_COMMAND = "SELECT * FROM fornecedores";
        List<Fornecedor> fornecedores = new ArrayList<Fornecedor>();

        PreparedStatement pstm = null;

        try {
            pstm = (PreparedStatement) connection.prepareStatement(SQL_COMMAND);

            ResultSet resultSet = pstm.executeQuery();

            while (resultSet.next()) {
                Fornecedor fornecedor = new Fornecedor(
                        resultSet.getInt("id"),
                        resultSet.getString("nome"),
                        resultSet.getString("cnpj"),
                        resultSet.getString("endereco"),
                        resultSet.getString("email"),
                        resultSet.getString("telefone")
                );
                fornecedores.add(fornecedor);
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

        return fornecedores;
    }

    public void Update(Fornecedor fornecedor, Connection connection) {
        String SQL_COMMAND = "UPDATE fornecedores SET nome = ?, cnpj = ?, endereco = ?, email = ?, telefone = ? WHERE id = ?";

        PreparedStatement pstm = null;

        try {
            pstm = (PreparedStatement) connection.prepareStatement(SQL_COMMAND);
            pstm.setString(1, fornecedor.getNome());
            pstm.setString(2, fornecedor.getCnpj());
            pstm.setString(3, fornecedor.getEndereco());
            pstm.setString(4, fornecedor.getEmail());
            pstm.setString(5, fornecedor.getTelefone());
            pstm.setInt(6, fornecedor.getId());

            pstm.execute();
        }catch (SQLException e){
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
        String SQL_COMMAND = "DELETE FROM fornecedores WHERE id = ?";

        PreparedStatement pstm = null;

        try {
            pstm = (PreparedStatement)connection.prepareStatement(SQL_COMMAND);
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

