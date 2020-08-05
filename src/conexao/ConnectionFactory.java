/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conexao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author olive
 */
public class ConnectionFactory {

    private static final String USUARIO = "root";
    private static final String SENHA = "";
    private static final String URL = "jdbc:mysql://localhost:3306/construcao";
    
    private static Connection conexao;

    // Conectar ao banco
    private static Connection conectar() {
        // Capturar a conexão
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(URL, USUARIO, SENHA);
        } catch (SQLException ex) {
            System.out.println("Erro: conectar()" + ex);
        }
        // Retorna a conexao aberta
        return conn;
    }

    public static Connection getConexao() {
        try {
            if (conexao == null || conexao.isClosed()) {
                conexao = conectar();
            }
        } catch (SQLException ex) {
            System.out.println("Erro: getConexao() " + ex);
        }
        return conexao;
    }

    public static void fechaConexao(Connection con) {
        try {
            con.close();
        } catch (SQLException ex) {
            System.out.println("Erro: fechaConexao " + ex);
        }
    }
}