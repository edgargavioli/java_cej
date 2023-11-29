package br.com.cej.dao;

import br.com.cej.model.Categoria;
import br.com.cej.model.Funcionario;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class FuncionarioDAO {
    public void Save(Funcionario funcionario, Connection connection) {
        String SQL_COMMAND = "INSERT INTO funcionarios(nome_acesso, senha_acesso, email, telefone) VALUES(?, ?, ?, ?)";

        PreparedStatement pstm = null;

        try {
            pstm = (PreparedStatement) connection.prepareStatement(SQL_COMMAND);
            pstm.setString(1, funcionario.getNome());
            pstm.setString(2, funcionario.getSenha());
            pstm.setString(3, funcionario.getEmail());
            pstm.setString(4, funcionario.getTelefone());

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

            System.out.println("Funcionario salvo com sucesso!");
        }
    }

    public static Funcionario GetId(Connection connection, Integer id) {
        String SQL_COMMAND = "SELECT * FROM funcionarios WHERE id = ?";
        Funcionario funcionario = null;
        PreparedStatement pstm = null;

        try {
            pstm = (PreparedStatement) connection.prepareStatement(SQL_COMMAND);
            pstm.setInt(1, id);

            ResultSet resultSet = pstm.executeQuery();

            while (resultSet.next()) {
                funcionario = new Funcionario(
                        resultSet.getInt("id"),
                        resultSet.getString("nome_acesso"),
                        resultSet.getString("senha_acesso"),
                        resultSet.getString("email"),
                        resultSet.getString("telefone")
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
        return funcionario;
    }

    public List<Funcionario> Read(Connection connection) {
        String SQL_COMMAND = "SELECT * FROM funcionarios";
        List<Funcionario> funcionarios = new ArrayList<Funcionario>();

        PreparedStatement pstm = null;

        try {
            pstm = (PreparedStatement)connection.prepareStatement(SQL_COMMAND);

            ResultSet resultSet = pstm.executeQuery();

            while (resultSet.next()) {
                Funcionario funcionario = new Funcionario(
                        resultSet.getInt("id"),
                        resultSet.getString("nome_acesso"),
                        resultSet.getString("senha_acesso"),
                        resultSet.getString("email"),
                        resultSet.getString("telefone")
                );

                funcionarios.add(funcionario);
            } } catch (SQLException e) {
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
        return funcionarios;
    }

    public void Update(Funcionario funcionario, Connection connection) {
        String SQL_COMMAND = "UPDATE funcionarios SET nome_acesso = ?, senha_acesso = ?, email = ?, telefone = ? WHERE id = ?";

        PreparedStatement pstm = null;

        try {
            pstm = (PreparedStatement)connection.prepareStatement(SQL_COMMAND);
            pstm.setString(1, funcionario.getNome());
            pstm.setString(2, funcionario.getSenha());
            pstm.setString(3, funcionario.getEmail());
            pstm.setString(4, funcionario.getTelefone());
            pstm.setInt(5, funcionario.getId());

            pstm.execute();
        }catch (SQLException e) {
            e.printStackTrace();
        }finally {
            try {
                if (pstm != null) {
                    pstm.close();
                }
            }catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public void Delete(Integer id, Connection connection) {
        String SQL_COMMAND = "DELETE FROM funcionarios WHERE id = ?";

        PreparedStatement pstm = null;

        try {
            pstm = (PreparedStatement)connection.prepareStatement(SQL_COMMAND);
            pstm.setInt(1, id);

            pstm.execute();
        }catch (SQLException e) {
            e.printStackTrace();
        }finally {
            try {
                if (pstm != null) {
                    pstm.close();
                }
            }catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
