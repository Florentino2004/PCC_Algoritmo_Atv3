package apresentacao;

import java.util.Scanner;

import negocios.Agenda;
import negocios.DelecaoNome;
import negocios.EdicaodoNome;
import negocios.ListaContatos;

public interface Main {
	
	public static void main (String[] args) {
			
		Scanner opcao = new Scanner (System.in);
		
		System.out.println("===================================");
		System.out.println("              CONTATOS         ");
		System.out.println("===================================");
		
		
		System.out.println("\n");
		System.out.println(" [1] LISTA DE CONTATOS");
		System.out.println(" [2] BUSCAR UM CONTATO");
		System.out.println(" [3] ADICIONAR NOVO CONTATO");
		System.out.println(" [4] EDITAR CONTATO");
		System.out.println(" [5] EXCLUIR CONTATO");
		System.out.println(" [6] SAIR");
		
		
		System.out.printf("\n>> ESCOLHA UMA OPÇÃO: ");
		
		int escolher = opcao.nextInt();
				
				switch(escolher) {
				case 1:
					System.out.println("\n");
					ListaContatos.listarContatos();
					break;
					
				case 2:
					System.out.println("\n");
					ConsultarDados.novaConsulta();
					break;
					
				case 3:
					System.out.println("\n");
					Agenda.addContato();
					break;
					
				
				case 4:
					System.out.println("\n");
					EdicaodoNome.main(args);
					break;
					
				case 5:
					System.out.println("\n");
					DelecaoNome.main(args);
					break;
					
				case 6:
					System.out.println("\n");
					System.exit(0);
					
					
				default:
					System.out.println("\n");
					System.out.println("---- OPÇÃO NÃO EXISTE ----");
					
				}
				
				opcao.close();
		
	}  
	

}
