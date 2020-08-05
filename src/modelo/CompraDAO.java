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

public class CompraDAO extends AbstractTableModel{
List<Compra> compras;
    public CompraDAO() {
        compras = new ArrayList<>();
    }

    public void inserir(Compra compra)  {
        Connection con = ConnectionFactory.getConexao();
        try {
            PreparedStatement pstmt = con.prepareStatement(
                    "insert into compra "
                    + "(qtd_produto, codCliente, codProduto) VALUES (?,?,?)");
            pstmt.setInt(1, compra.getQtd());
            pstmt.setInt(2, compra.getIdCliente());
            pstmt.setInt(3, compra.getIdProduto());
            pstmt.execute();
            pstmt.close();
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void deletar(int cod){
        Connection con = ConnectionFactory.getConexao();
        try {
            PreparedStatement pstmt = con.prepareStatement(
                    "delete from compra "
                    + " where codigo=?");
            pstmt.setInt(1, cod);
            pstmt.execute();
            pstmt.close();
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<Compra> listar() {
        Connection con = null;
        List<Compra> resultado = new ArrayList<>();
        try {
            con = ConnectionFactory.getConexao();
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("select * from compra");
            while (rs.next()) {
                Compra compra = new Compra();
                compra.setCodigo(rs.getInt("codigo"));
                compra.setQtd(rs.getInt("qtd_produto"));
                compra.setIdCliente(rs.getInt("codCliente"));
                compra.setIdProduto(rs.getInt("codProduto"));

                resultado.add(compra);
            }
        } catch (Exception ex) {
            Logger.getLogger(CompraDAO.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            ConnectionFactory.fechaConexao(con);
    }
        return resultado;
    }

    public void atualizar(Compra compra) throws Exception {
        Connection con = ConnectionFactory.getConexao();
        try {
            PreparedStatement pstmt = con.prepareStatement(
                    "update produto set qtd_produto=?, codCliente=?, codProduto=? where codigo=?");
            pstmt.setInt(1, compra.getQtd());
            pstmt.setInt(2, compra.getIdCliente());
            pstmt.setInt(3, compra.getIdProduto());
            pstmt.setInt(4, compra.getCodigo());
            pstmt.execute();
            pstmt.close();
            con.close();
        } catch (Exception e) {
            System.out.println("Não foi possível consultar tabela...");
        }
    }
   
@SuppressWarnings("empty-statement")
    public List<Compra> listarPreco() {
        Connection con = null;
        List<Compra> resultado = new ArrayList<>();
        try {
            con = ConnectionFactory.getConexao();
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("select qtd_produto*preco as total from compra c inner join produto p on c.codProduto=p.codigo inner join cliente cl on c.codCliente=cl.codigo");
                Compra compra = new Compra();
            
                compra.setTotal(rs.getDouble("total"));

                resultado.add(compra);
          
        } catch (Exception ex) {
            Logger.getLogger(CompraDAO.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            ConnectionFactory.fechaConexao(con);
    };
    return resultado;
    }
    
    
    @Override
    public int getRowCount() {
        return this.compras.size();
    }

    @Override
    public int getColumnCount() {
        return Produto.class.getDeclaredFields().length;
    }

   @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Compra compra = this.getCompraAt(rowIndex);
        if (columnIndex == 0) {
            return "" + compra.getCodigo();
        } else if (columnIndex == 1) {
            return compra.getQtd();
        } else if (columnIndex == 2) {
            return  compra.getIdCliente();
            }else if (columnIndex == 3) {
            return  compra.getIdProduto();
            } else {
            return "ERRO";
        }
    }

    public Compra getCompraAt(int index) {
        return this.compras.get(index);
    }
}
