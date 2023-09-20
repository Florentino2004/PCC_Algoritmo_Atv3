package negocios;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

import apresentacao.Contato;

public class Agenda {
	
	public static void main(String[] args) {
		addContato();
	}


    public static void addContato() {
        Scanner leia = new Scanner(System.in);
        Contato contato = new Contato();

        System.out.println("Nome do novo contato:");
        contato.setNome(leia.nextLine());

        System.out.println("Endereço do novo contato:");
        contato.setEndereco(leia.nextLine());

        System.out.println("Telefone do novo contado:");
        contato.setFone(leia.nextLine());

        System.out.println("E-mail do novo contato:");
        contato.setEmail(leia.nextLine());
        
        Agenda agenda = new Agenda();
        agenda.incluirContato(contato);
        
        leia.close();
        
    }
        
    
    public void incluirContato (Contato contato) {
    	
    	Scanner leia = new Scanner(System.in);
    	Connection c = null;
        PreparedStatement stmt = null;

        try {
            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection("jdbc:sqlite:listadecontatos.db");

            String sql = "INSERT INTO people (nome, endereco, telefone, email) VALUES (?, ?, ?, ?);";
            stmt = c.prepareStatement(sql);

            stmt.setString(1, contato.getNome());
            stmt.setString(2, contato.getEndereco());
            stmt.setString(3, contato.getFone());
            stmt.setString(4, contato.getEmail());

            stmt.executeUpdate();
            System.out.println("Contato adicionado com sucesso!");
        } catch (SQLException | ClassNotFoundException e) {
            System.err.println("Não foi possível inserir o contato: " + e.getMessage());
        } finally {
            try {
                if (stmt != null) {
                    stmt.close();
                }
                if (c != null) {
                    c.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        leia.close();
        
    }
    
    	
    
    
}

