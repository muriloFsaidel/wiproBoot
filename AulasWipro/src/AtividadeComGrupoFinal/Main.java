package AtividadeComGrupoFinal;

import java.util.Scanner;

import AtividadeComGrupoFinal.AtividadePOO.ControleRemoto;
import AtividadeComGrupoFinal.AtividadePOO.Televisao;

public class Main {
	
	public static void question1() {
		
		int choice = 0, novoCanal = 0;
		Scanner botao = new Scanner(System.in);

		ControleRemoto remoteControl = new ControleRemoto(new Televisao(20,5));
		
		do {
			
			System.out.println("*********************************************************");
			System.out.println("\t\tOferecido pelos integrantes do grupo 4\t\t\t\t");
			System.out.println("\t\tTV Tabajara - Sua melhor opção\t\t\t\t\n");
			System.out.println("\t\tVocê está assistindo ao canal "+remoteControl.canal()+"\t\t\t\t\n\t\tVolume: "+remoteControl.volume());
			System.out.println("[1] aumentar volume");
			System.out.println("[2] diminuir volume");
			System.out.println("[3] próximo canal");
			System.out.println("[4] canal anterior");
			System.out.println("[5] trocar Canal");
			System.out.println("[6] volume atual");
			System.out.println("[7] desligar televisão");
			System.out.println("********************************************************");
			choice = botao.nextInt();
			
			switch(choice) {
			
			case 1:
				System.out.println("********************************************************");
				remoteControl.aumentarVolume();
				break;
				
			case 2:
				System.out.println("********************************************************");
				remoteControl.diminuirVolume();
				break;
				
			case 3:
				System.out.println("********************************************************");
				remoteControl.aumentarCanal();			
				break;
				
			case 4:	
				System.out.println("********************************************************");
				remoteControl.diminuirCanal();
				break;
				
			case 5:
				System.out.println("********************************************************");
				System.out.println("informe novo canal");
				novoCanal = botao.nextInt();
				remoteControl.trocarCanal(novoCanal);
				break;
				
			//case 6:	
				//System.out.println(remoteControl.canal());
				//break;
				
			case 6:
				System.out.println("********************************************************");
				System.out.println("Som volume: "+remoteControl.volume());
				break;
				
			case 7:
				System.out.println("********************************************************");
				remoteControl.desligar();
				break;
				
			default:
				System.out.println("Informe um valor válido");
			}
			
		}while(choice != 7);
		
	}

	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		question1();
	}
}
