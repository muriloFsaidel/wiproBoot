package AulaJava01;

import java.util.Scanner;

public class Exercicio3 {

	/*
	 * Faça um programa para receber os nomes de 4 candidatos a líder de uma turma, em seguida
	 * receber os votos dos alunos existentes na sala, e ao final mostrar o total de votos de cada
     * candidato e ainda o candidato vencedor da eleição.
	 */
	
	public void ex3() {
		//instanciando escaneador para ler os dados do teclado
		Scanner leia = new Scanner(System.in);
		
		//criando vetor de candidatos
		String[] candidatos = new String[4];
		
		//criando vetor de votos de cada candidato
		int[] votosPorCandidato = new int[4];
		
		//criando variáveis
		int numeroAlunos = 0,choice = 0;		
		String empate="";
		Boolean vencedor=false;
		
		System.out.println("Digite o número de alunos eleitores");
		//capturando o número de eleitores
		numeroAlunos = leia.nextInt();	
		
		//saltando linhas
		System.out.println("");		
		
		//criando vetor com tamanho do número de alunos/eleitores
		int[] votos = new int[numeroAlunos];
		
		//para indice = 0, enquanto ele for menor que 4 então leia o nome dos candidatos e incremente o valor do índice
		for(int i = 0; i < 4; i++) {			
			
			System.out.println("Digite o nome do "+(i+1)+"° candidato");
			//capturando o nome dos candidatos e armazenando no vetor candidatos
			candidatos[i] = leia.next();
			
			//saltando linha
			System.out.println("");
		}		
		//iniciando votação
		for(int i = 0; i < votos.length; i++) {
			
			System.out.println("Candidato "+candidatos[0]+" n° 1");
			System.out.println("Candidato "+candidatos[1]+" n° 2");
			System.out.println("Candidato "+candidatos[2]+" n° 3");
			System.out.println("Candidato "+candidatos[3]+" n° 4");
			
			System.out.println("Digite o número do candidato escolhido");
			//armazenando a escolha do eleitor em choice
			choice = leia.nextInt();			
			
			System.out.println("");
			
			//se a escolha for inválida, fazer digitar novamente o número do candidato
			if(choice > 4) {
				System.out.println("digite um valor válido de 1 a 4");
				choice = leia.nextInt();
			}
			
			//dada a escolha
			switch (choice) {
			
			//caso candidato 1
			case 1:
				//registrando voto 
				votos[i] = choice;
				//registrando mais voto para o candidato 1
				votosPorCandidato[0]+=1;
				//pausa
				break;
			
			//caso candidato 2	
			case 2:
				//registrando voto 
				votos[i] = choice;
				//registrando mais voto para o candidato 2
				votosPorCandidato[1]+=1;
				//pausa
				break;
				
			//caso candidato 3	
			case 3:
				//registrando voto 
				votos[i] = choice;
				//registrando mais voto para o candidato 3
				votosPorCandidato[2]+=1;
				//pausa
				break;			
				
			//caso candidato 4	
			case 4:
				//registrando voto 
				votos[i] = choice;
				//registrando mais voto para o candidato 4
				votosPorCandidato[3]+=1;
				//pausa
				break;	
			}
			
		}
		
		// imprimindo candidato e quantos votos cada um recebeu
		for(int i = 0; i < 4; i++) {			
			System.out.println("O Candidato "+candidatos[i]+" recebeu : "+votosPorCandidato[i]+" voto(s).\n");			
		}		
		
		System.out.println("Total de votos: "+votos.length+".");	
		
		//verificando o vencedor caso algum dos candidatos tem mais votos que os demais e caso haja um empate acumular
		 for(int i = 0; i < 4; i++) {				 
				switch(i) {
				case 0:
					if( (votosPorCandidato[0] > votosPorCandidato[1]) && (votosPorCandidato[0] > votosPorCandidato[2]) && (votosPorCandidato[0] > votosPorCandidato[3]) ) {
						vencedor=true;
						System.out.print("\nO vencedor é o candidato "+candidatos[i]+" com "+votosPorCandidato[i]+ " votos e empataram os seguintes candidatos: ");
					}else if((votosPorCandidato[0] == votosPorCandidato[1]) || (votosPorCandidato[0] == votosPorCandidato[2])|| (votosPorCandidato[0] == votosPorCandidato[3])){
							empate+=candidatos[0]+" com "+votosPorCandidato[0]+" voto(s), ";
					}
					break;
					
				case 1:
					if((votosPorCandidato[1] > votosPorCandidato[0]) && (votosPorCandidato[1] > votosPorCandidato[2]) && (votosPorCandidato[1] > votosPorCandidato[3])) {
						vencedor=true;
						System.out.print("\nO vencedor é o candidato "+candidatos[i]+" com "+votosPorCandidato[i]+ " votos e empataram os seguintes candidatos: ");
					}else if((votosPorCandidato[1] == votosPorCandidato[0]) ||  (votosPorCandidato[1] == votosPorCandidato[2]) || (votosPorCandidato[1] == votosPorCandidato[3]) ){
							empate+=candidatos[1]+" com "+votosPorCandidato[1]+" voto(s), ";		
					 }				
					break;					
				case 2:
					if((votosPorCandidato[2] > votosPorCandidato[0]) && (votosPorCandidato[2] > votosPorCandidato[1]) && (votosPorCandidato[2] > votosPorCandidato[3])) {
						vencedor=true;
						System.out.print("\nO vencedor é o candidato "+candidatos[i]+" com "+votosPorCandidato[i]+ " votos e empataram os seguintes candidatos: ");
					}else if((votosPorCandidato[2] == votosPorCandidato[0]) || (votosPorCandidato[2] == votosPorCandidato[1]) || (votosPorCandidato[2] == votosPorCandidato[3])){
							empate+=candidatos[2]+" com "+votosPorCandidato[2]+" voto(s), ";					
     				}	
					break;					
				case 3:
					if((votosPorCandidato[3] > votosPorCandidato[0]) && (votosPorCandidato[3] > votosPorCandidato[1]) && (votosPorCandidato[3] > votosPorCandidato[2])) {
						vencedor=true;						
						System.out.print("\nO vencedor é o candidato "+candidatos[i]+" com "+votosPorCandidato[i]+ " votos e empataram os seguintes candidatos: ");
					}else if((votosPorCandidato[3] == votosPorCandidato[0]) || (votosPorCandidato[3] == votosPorCandidato[1]) || (votosPorCandidato[3] == votosPorCandidato[2])){
							empate+=candidatos[3]+" com "+votosPorCandidato[3]+" voto(s), ";							
					}		
					break;
				}		
		 }
		 //votosPorCandidato[0] == votosPorCandidato[1] && votosPorCandidato[0] == votosPorCandidato[2] && votosPorCandidato[0] == votosPorCandidato[3]
		 if (vencedor == false) {
			 System.out.println("\n não há vencedor.");
		 }
		 
		 //caso haja vencedor mostrar se alguém empatou
		 if(vencedor == true) {
			 System.out.println(empate+".");
		 }		
	}
}
