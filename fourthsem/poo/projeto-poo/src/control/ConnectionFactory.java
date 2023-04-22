package control;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;
import model.Produto;

public class ConnectionFactory {

  private Connection connection = null;
  private Statement statement = null;
  private ResultSet resultSet = null;

  public void conectar() {
    String servidor = "jdbc:mysql://localhost:3306/mercearia";
    String usuario = "root";
    String senha = "";
    try {
      Class.forName("com.mysql.jdbc.Driver");
      this.connection = DriverManager.getConnection(servidor, usuario, senha);
      this.statement = this.connection.createStatement();
    } catch (Exception e) {
      JOptionPane.showMessageDialog(
        null,
        "Erro ao conectar ao banco!\n" + e,
        "Erro",
        JOptionPane.ERROR_MESSAGE
      );
      System.out.println(e);
    }
  }

  public int cadastrarProduto(Produto produto) {
    int status = 0;
    try {
      String query =
        "INSERT INTO produto (idProduto, nome, preco, dataValidade) VALUES (" +
        produto.getId() +
        ", '" +
        produto.getNome() +
        "', " +
        produto.getPreco() +
        ", '" +
        produto.getDataValidade() +
        "');";
      status = this.statement.executeUpdate(query);
    } catch (Exception e) {
      JOptionPane.showMessageDialog(
        null,
        "Erro ao inserir o produto\n" + e,
        "Erro",
        JOptionPane.ERROR_MESSAGE
      );
    }
    return status;
  }

  public int excluirProduto(int idProduto) {
    int status = 0;
    try {
      String query = "DELETE FROM produto WHERE idProduto = " + idProduto + ";";
      status = this.statement.executeUpdate(query);
    } catch (Exception e) {
      JOptionPane.showMessageDialog(
        null,
        "Erro ao excluir o produto\n" + e,
        "Erro",
        JOptionPane.ERROR_MESSAGE
      );
    }
    return status;
  }

  public int alterarProduto(Produto produto) {
    int status = 0;
    try {
      String query =
        "UPDATE produto SET nome = '" +
        produto.getNome() +
        "', dataValidade = '" +
        produto.getDataValidade() +
        "', preco = " +
        produto.getPreco() +
        " WHERE idProduto = " +
        produto.getId() +
        ";";
      status = this.statement.executeUpdate(query);
    } catch (Exception e) {
      JOptionPane.showMessageDialog(
        null,
        "Erro ao alterar o produto\n" + e,
        "Erro",
        JOptionPane.ERROR_MESSAGE
      );
    }
    return status;
  }

  public Produto consultarProduto(int idProduto) {
    Produto produto = new Produto();
    try {
      String query =
        "SELECT * FROM produto WHERE idProduto = " + idProduto + ";";
      this.resultSet = this.statement.executeQuery(query);

      if (resultSet.next()) {
        produto.setId(this.resultSet.getInt("idProduto"));
        produto.setNome(this.resultSet.getString("nome"));
        produto.setDataValidade(this.resultSet.getString("dataValidade"));
        produto.setPreco(this.resultSet.getDouble("preco"));
      } else {
        produto.setId(0);
      }
    } catch (Exception e) {
      JOptionPane.showMessageDialog(
        null,
        "Erro ao alterar o produto\n" + e,
        "Erro",
        JOptionPane.ERROR_MESSAGE
      );
    }
    return produto;
  }

  public boolean estaConectado() {
    if (this.connection == null) {
      return false;
    }
    return true;
  }
}
