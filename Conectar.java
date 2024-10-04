package javaBeans;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Conectar {
    private Connection con; // Variável que armazena a conexão com o banco de dados
    private String sql; // Variável que armazena os comandos SQL
    private PreparedStatement ps; // Objeto que prepara o SQL
    private ResultSet tab; // Armazena um conjunto de registros
    private final String MeuBanco = "Gerente"; // Nome do banco a ser criado
    private final String servidor = "jdbc:mysql://localhost:3306"; // Caminho do servidor SQL
    private final String usuario = "root"; // Nome do usuário do banco SQL
    private final String senha = ""; // Senha do banco SQL
    private String statusSQL; // Status da operação SQL

    public Conectar() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver"); // Carrega o driver JDBC
            con = DriverManager.getConnection(servidor, usuario, senha);
            criarBanco(); // Função que cria o banco de dados
            statusSQL = null; // Armazena NULL se não houver erros nos comandos SQL
        } catch (ClassNotFoundException ex) {
            statusSQL = "Driver JDBC não encontrado! " + ex.getMessage();
        } catch (SQLException ex) {
            statusSQL = "Servidor fora do ar ou comando SQL inválido! " + ex.getMessage();
        }
    }

    private void criarBanco() {
        try {
            sql = "CREATE DATABASE IF NOT EXISTS " + MeuBanco; // Armazena SQL
            ps = con.prepareStatement(sql); // Prepara o comando
            ps.executeUpdate(); // Executa o comando SQL
            
            sql = "USE " + MeuBanco; // Seleciona o banco de dados
            ps = con.prepareStatement(sql);
            ps.executeUpdate(); // Executa o comando SQL dentro do servidor

            statusSQL = null; // Coloca null nas operações bem-sucedidas
        } catch (SQLException err) {
            statusSQL = "Erro ao executar SQL: " + err.getMessage(); // Houve erros
        }
    }

    public String getStatusSQL() {
        return statusSQL; // Retorna o status da operação SQL
    }
}

