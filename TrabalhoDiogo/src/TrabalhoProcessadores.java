import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

/* Autor: Diogo Silva Rodrigues
IDE: Visual Studio Code
Version: 1.2
Senai - Desenvolvimento de Sistemas
Trabalho Finalizado dia 14/09/2023
*/

public class TrabalhoProcessadores {
    private String nome; //Nome Processador
    private String marca; // Intel
    private String descricao;// Descricao do Processador
    private String modelo;// i5 9400F, Windows 10, computador gamer
    private String velocidade;// Velocidade do Processador em mhz
    static Scanner in = new Scanner(System.in);

    public TrabalhoProcessadores(String nome, String marca, String descricao, String modeloProcessador, String velocidadeProcessador) {
        this.nome = nome;
        this.descricao = descricao;
    }

   //nome
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/INTEL";
    private static final String USER = "root";
    private static final String PASSWORD = "";

    //criar tabela
    public static void criarTabela() {
        try (Connection conn = DriverManager.getConnection(JDBC_URL, USER, PASSWORD);
                Statement stmt = conn.createStatement()) {

                    String createTableSQL = "CREATE TABLE IF NOT EXISTS processadores (" +
                    "id INT AUTO_INCREMENT PRIMARY KEY," +
                    "nome VARCHAR(100)," +
                    "descricao VARCHAR(100)," + 
                    "marca VARCHAR(100)," +     
                    "modelo VARCHAR(100)," +    
                    "velocidade VARCHAR(100)" + 
                    ")";

              //update table
            stmt.executeUpdate(createTableSQL);
            System.out.println("Tabela 'processadores' criada com sucesso.");

        } catch (SQLException e) {
            System.out.println("Erro ao criar tabela: " + e.getMessage());
        }
    }
//inserirProcessador
    public static void inserirProcessador(publicProcessador processador) {
        criarTabela();

        try (Connection conn = DriverManager.getConnection(JDBC_URL, USER, PASSWORD);
                PreparedStatement stmt = conn.prepareStatement(
                    //Inserir dados na tabela
                        "INSERT INTO processadores(nome, marca, descricao, modelo, velocidade) VALUES ( ?, ?, ?, ?, ?)")) {

            stmt.setString(1, processador.getNome());
            stmt.setString(2, processador.getMarca());
            stmt.setString(3, processador.getDescricao());
            stmt.setString(4, processador.getModelo());
            stmt.setString(5, processador.getVelocidade());

            stmt.executeUpdate();
            System.out.println("Processador inserido no banco de dados.");

        } catch (SQLException e) {
            System.out.println("Erro ao inserir no banco de dados: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        // Exemplo de uso
        publicProcessador processador = new publicProcessador();
        // Chamar o método cadastrarProcessador da instância criada
        processador.cadastrarProcessador();    
        TrabalhoProcessadores.inserirProcessador(processador);
    }
}


