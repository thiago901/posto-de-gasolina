/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.mileniumfalcon.dao;

import br.com.mileniumfalcon.models.Produto;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author pablo.santana
 */
public class ProdutoDAO {

    public static boolean salvar(Produto produto) {
        Connection connection = null;
        boolean retorno = false;

        try {
            connection = DbConnectionDAO.openConnection();
            PreparedStatement comando = connection.prepareStatement("INSERT INTO Produto "
                    + "(Nome, TipoProduto, QntEstoque, ValorUnitario) "
                    + "VALUES (?, ?, ?, ?);", Statement.RETURN_GENERATED_KEYS);
            comando.setString(1, produto.getNome());
            comando.setString(2, produto.getTipoProduto());
            comando.setDouble(3, produto.getQtdProduto());
            comando.setDouble(4, produto.getVlrUnitario());

            int linhasAfetadas = comando.executeUpdate();

            if (linhasAfetadas > 0) {
                int idProduto = 0;
                ResultSet resultSet = comando.getGeneratedKeys();

                while (resultSet.next()) {
                    idProduto = resultSet.getInt(1);
                }

                comando = connection.prepareStatement("INSERT INTO filial_produto "
                        + "(IdFilial, IdProduto) VALUES (?, ?);");
                comando.setInt(1, produto.getFilial().getId());
                comando.setInt(2, idProduto);

                linhasAfetadas = comando.executeUpdate();

                if (linhasAfetadas > 0) {
                    retorno = true;
                } else {
                    retorno = false;
                }

            } else {
                retorno = false;
            }

        } catch (SQLException ex) {
            System.out.println(ex);
            retorno = false;
        } catch (ClassNotFoundException ex) {
            retorno = false;
        }

        DbConnectionDAO.closeConnection(connection);
        return retorno;
    }

    public static Produto pesquisarProduto(String nome) {

        Connection connection = null;
        System.out.println(nome);
        try {
            connection = DbConnectionDAO.openConnection();
            PreparedStatement comando = connection.prepareStatement("SELECT * FROM Produto WHERE Nome LIKE ?");
            comando.setString(1, "%" + nome + "%");
            ResultSet rs = comando.executeQuery();

            Produto produto = new Produto();

            while (rs.next()) {
                produto.setId(rs.getInt("IdProduto"));
                produto.setNome(rs.getString("Nome"));
                produto.setTipoProduto(rs.getString("TipoProduto"));
                produto.setQtdProduto(rs.getDouble("QntEstoque"));
                produto.setVlrUnitario(rs.getDouble("ValorUnitario"));

            }
            DbConnectionDAO.closeConnection(connection);
            return produto;

        } catch (ClassNotFoundException ex) {
            return null;

        } catch (SQLException ex) {
            System.out.println(ex);
            return null;
        }
    }

    public static boolean excluir(int id) throws SQLException {
        Connection connection = null;
        boolean retorno = false;

        try {
            connection = DbConnectionDAO.openConnection();
            PreparedStatement comando = connection.prepareStatement("DELETE FROM Produto "
                    + "WHERE IdProduto = ?");
            comando.setInt(1, id);

            int linhasAfetadas = comando.executeUpdate();

            if (linhasAfetadas > 0) {
                retorno = true;

            } else {
                retorno = false;
            }

        } catch (ClassNotFoundException ex) {
            retorno = false;
        } catch (SQLException ex) {
            System.out.println(ex);
            retorno = false;
        }

        DbConnectionDAO.closeConnection(connection);
        return retorno;

    }

    public static Produto pesquisarPorId(int id) {

        Connection connection = null;

        try {
            connection = DbConnectionDAO.openConnection();
            PreparedStatement comando = connection.prepareStatement("SELECT * FROM Produto WHERE IdProduto = ?");
            comando.setInt(1, id);
            ResultSet rs = comando.executeQuery();

            Produto produto = new Produto();

            while (rs.next()) {
                produto.setNome(rs.getString("Nome"));
                produto.setTipoProduto("TipoProduto");
                produto.setQtdProduto(rs.getDouble("QntEstoque"));
                produto.setVlrUnitario(rs.getDouble("ValorUnitario"));
            }
            DbConnectionDAO.closeConnection(connection);
            return produto;

        } catch (ClassNotFoundException ex) {
            return null;

        } catch (SQLException ex) {
            System.out.println(ex);
            return null;
        }
    }

    public static boolean editar(Produto produto) {
        Connection connection = null;
        boolean retorno;

        try {
            connection = DbConnectionDAO.openConnection();
            PreparedStatement comando = connection.prepareStatement("UPDATE Produto "
                    + "SET Nome = ?, TipoProduto = ?, QntEstoque = ?, ValorUnitario = ? WHERE IdProduto = ?");

            comando.setString(1, produto.getNome());
            comando.setString(2, produto.getTipoProduto());
            comando.setDouble(3, produto.getQtdProduto());
            comando.setDouble(4, produto.getVlrUnitario());
            comando.setInt(5, produto.getId());
            int linhasAfetadas = comando.executeUpdate();

            if (linhasAfetadas > 0) {

                comando = connection.prepareStatement("UPDATE filial_produto SET "
                        + "IdFilial = ? WHERE IdProduto = ?");
                comando.setInt(1, produto.getFilial().getId());
                comando.setInt(2, produto.getId());

                linhasAfetadas = comando.executeUpdate();

                if (linhasAfetadas > 0) {
                    retorno = true;
                } else {
                    retorno = false;
                }
            } else {
                retorno = false;
            }

        } catch (ClassNotFoundException ex) {
            retorno = false;

        } catch (SQLException ex) {
            System.out.println(ex);
            retorno = false;
        }

        DbConnectionDAO.closeConnection(connection);
        return retorno;

    }
}