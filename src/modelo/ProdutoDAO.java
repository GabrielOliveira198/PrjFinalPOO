/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import conexao.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author olive
 */

public class ProdutoDAO extends AbstractTableModel{
List<Produto> produtos;
    public ProdutoDAO() {
        produtos = new ArrayList<>();
    }

    public void inserir(Produto produto)  {
        Connection con = ConnectionFactory.getConexao();
        try {
            PreparedStatement pstmt = con.prepareStatement(
                    "insert into produto "
                    + "(descricao, preco) VALUES (?,?)");
            pstmt.setString(1, produto.getDescricao());
            pstmt.setDouble(2, produto.getPreco());
            pstmt.execute();
            pstmt.close();
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void deletar(String nome){
        Connection con = ConnectionFactory.getConexao();
        try {
            PreparedStatement pstmt = con.prepareStatement(
                    "delete from produto "
                    + " where descricao=?");
            pstmt.setString(1, nome);
            pstmt.execute();
            pstmt.close();
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<Produto> listar() {
        Connection con = null;
        List<Produto> resultado = new ArrayList<>();
        try {
            con = ConnectionFactory.getConexao();
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("select * from produto");
            while (rs.next()) {
                Produto produto = new Produto();
                produto.setIdproduto(rs.getInt("codigo"));
                produto.setDescricao(rs.getString("descricao"));
                produto.setPreco(rs.getDouble("preco"));
                resultado.add(produto);
            }
        } catch (Exception ex) {
            Logger.getLogger(ProdutoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            ConnectionFactory.fechaConexao(con);
    }
        return resultado;
    }

    public void atualizar(Produto produto) throws Exception {
        Connection con = ConnectionFactory.getConexao();
        try {
            PreparedStatement pstmt = con.prepareStatement(
                    "update produto set descricao = ?, preco = ? where codigo = ?");
            pstmt.setString(1, produto.getDescricao());
            pstmt.setDouble(2, produto.getPreco());
            pstmt.setInt(3, produto.getIdproduto());
            
            pstmt.execute();
            pstmt.close();
            con.close();
        } catch (Exception e) {
            System.out.println("ID: "+produto.getIdproduto());
            System.out.println("PRECO : "+produto.getPreco());
            System.out.println("Descricao:  "+produto.getDescricao());
            System.out.println("Não foi possível consultar tabela...");
        }
    }
   
    @Override
    public int getRowCount() {
        return this.produtos.size();
    }

    @Override
    public int getColumnCount() {
        return Produto.class.getDeclaredFields().length;
    }

   @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Produto amigo = this.getProdutoAt(rowIndex);
        if (columnIndex == 0) {
            return "" + amigo.getIdproduto();
        } else if (columnIndex == 1) {
            return amigo.getDescricao();
        } else if (columnIndex == 2) {
            return  amigo.getPreco();
            } else {
            return "ERRO";
        }
    }

    public Produto getProdutoAt(int index) {
        return this.produtos.get(index);
    }
}
