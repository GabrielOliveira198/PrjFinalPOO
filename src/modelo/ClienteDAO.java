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
import javax.swing.JOptionPane;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author olive
 */

public class ClienteDAO extends AbstractTableModel{
List<Cliente> clientes;
    public ClienteDAO() {
        clientes = new ArrayList<>();
    }

    public void inserir(Cliente cliente)  {
        Connection con = ConnectionFactory.getConexao();
        try {
            PreparedStatement pstmt = con.prepareStatement(
                    "insert into cliente "
                    + "(nome , endereco, fone) VALUES (?,?,?)");
            pstmt.setString(1, cliente.getNome());
            pstmt.setString(2, cliente.getEndereco());
            pstmt.setString(3, cliente.getFone());
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
                    "delete from cliente "
                    + " where nome=?");
            pstmt.setString(1, nome);
            pstmt.execute();
            pstmt.close();
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<Cliente> listar() {
        Connection con = null;
        List<Cliente> resultado = new ArrayList<>();
        try {
            con = ConnectionFactory.getConexao();
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("select * from cliente");
            while (rs.next()) {
                Cliente cliente = new Cliente();
                cliente.setIdCliente(rs.getInt("codigo"));
                cliente.setNome(rs.getString("nome"));
                cliente.setEndereco(rs.getString("endereco"));
                cliente.setFone(rs.getString("fone"));
                resultado.add(cliente);
            }
        } catch (Exception ex) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            ConnectionFactory.fechaConexao(con);
    }
        return resultado;
    }

    public void atualizar(Cliente cliente) throws Exception {
        Connection con = ConnectionFactory.getConexao();
        try {
            PreparedStatement pstmt = con.prepareStatement(
                    "update amigos set nome=?, endereco=?, fone=? where codigo=?");
            pstmt.setString(1, cliente.getNome());
            pstmt.setString(2, cliente.getEndereco());
            pstmt.setString(3, cliente.getFone());
            pstmt.setInt(4, cliente.getIdCliente());
            pstmt.execute();
            pstmt.close();
            con.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Não foi possível consultar tabela...");
        }
    }
   
    @Override
    public int getRowCount() {
        return this.clientes.size();
    }

    @Override
    public int getColumnCount() {
        return Cliente.class.getDeclaredFields().length;
    }

   @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Cliente cliente = this.getClienteAt(rowIndex);
        if (columnIndex == 0) {
            return "" + cliente.getIdCliente();
        } else if (columnIndex == 1) {
            return cliente.getNome();
      } else if (columnIndex == 2) {
            return  cliente.getEndereco();
            } else if (columnIndex == 3) {
            return  cliente.getFone();
        } else {
            return "ERRO";
        }
    }

    public Cliente getClienteAt(int index) {
        return this.clientes.get(index);
    }
}
