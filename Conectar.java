package javaBeans;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Conectar {
    private Connection con; 
    private String sql; 
    private PreparedStatement ps; 
    private ResultSet tab;
    private final String MeuBanco = "Gerente"; 
    private final String servidor = "jdbc:mysql://localhost:3306"; 
    private final String usuario = "root"; 
    private final String senha = "";
    private String statusSQL; 

    public Conectar() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver"); 
            con = DriverManager.getConnection(servidor, usuario, senha);
            criarBanco(); 
            statusSQL = null; 
        } catch (ClassNotFoundException ex) {
            statusSQL = "Driver JDBC não encontrado! " + ex.getMessage();
        } catch (SQLException ex) {
            statusSQL = "Servidor fora do ar ou comando SQL inválido! " + ex.getMessage();
        }
    }

    private void criarBanco() {
        try {
            sql = "CREATE DATABASE IF NOT EXISTS " + MeuBanco; 
            ps = con.prepareStatement(sql); 
            ps.executeUpdate(); 
            
            sql = "USE " + MeuBanco; 
            ps = con.prepareStatement(sql);
            ps.executeUpdate(); 

            statusSQL = null; 
        } catch (SQLException err) {
            statusSQL = "Erro ao executar SQL: " + err.getMessage(); 
        }
    }

    public String getStatusSQL() {
        return statusSQL; 
    }
}

