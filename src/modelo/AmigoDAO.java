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

public class AmigoDAO extends AbstractTableModel{
List<Amigo> amigos;
    public AmigoDAO() {
        amigos = new ArrayList<>();
    }

    public void inserir(Amigo amigo)  {
        Connection con = ConnectionFactory.getConexao();
        try {
            PreparedStatement pstmt = con.prepareStatement(
                    "insert into amigos "
                    + "(nome, sobrenome, email, fone) VALUES (?,?,?,?)");
           // pstmt.setInt( amigo.getIdAmigo());
            pstmt.setString(1, amigo.getNome());
            pstmt.setString(2, amigo.getSobrenome());
            pstmt.setString(3, amigo.getEmail());
            pstmt.setString(4, amigo.getFone());
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
                    "delete from amigos "
                    + " where nome=?");
            pstmt.setString(1, nome);
            pstmt.execute();
            pstmt.close();
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<Amigo> listar() {
        Connection con = null;
        List<Amigo> resultado = new ArrayList<>();
        try {
            con = ConnectionFactory.getConexao();
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("select * from amigos");
            while (rs.next()) {
                Amigo amigo = new Amigo();
                amigo.setIdAmigo(rs.getInt("amigoID"));
                amigo.setNome(rs.getString("nome"));
                amigo.setSobrenome(rs.getString("sobrenome"));
                amigo.setEmail(rs.getString("email"));
                amigo.setFone(rs.getString("fone"));
                resultado.add(amigo);
            }
        } catch (Exception ex) {
            Logger.getLogger(AmigoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            ConnectionFactory.fechaConexao(con);
    }
        return resultado;
    }

    public void atualizar(Amigo amigo) throws Exception {
        Connection con = ConnectionFactory.getConexao();
        try {
            PreparedStatement pstmt = con.prepareStatement(
                    "update amigos set nome=?, sobrenome=?, email=?, fone=? where amigoID=?");
            pstmt.setString(1, amigo.getNome());
            pstmt.setString(2, amigo.getSobrenome());
            pstmt.setString(3, amigo.getEmail());
            pstmt.setString(4, amigo.getFone());
            pstmt.setInt(5, amigo.getIdAmigo());
            pstmt.execute();
            pstmt.close();
            con.close();
            System.out.println("Deu bom");
        } catch (Exception e) {
            System.out.println("Não foi possível consultar tabela...");
        }
    }
   
    @Override
    public int getRowCount() {
        return this.amigos.size();
    }

    @Override
    public int getColumnCount() {
        return Amigo.class.getDeclaredFields().length;
    }

   @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Amigo amigo = this.getAmigoAt(rowIndex);
        if (columnIndex == 0) {
            return "" + amigo.getIdAmigo();
        } else if (columnIndex == 1) {
            return amigo.getNome();
        } else if (columnIndex == 2) {
            return  amigo.getSobrenome();
            } else if (columnIndex == 3) {
            return  amigo.getEmail();
            } else if (columnIndex == 4) {
            return  amigo.getFone();
        } else {
            return "ERRO";
        }
    }

    public Amigo getAmigoAt(int index) {
        return this.amigos.get(index);
    }
}
