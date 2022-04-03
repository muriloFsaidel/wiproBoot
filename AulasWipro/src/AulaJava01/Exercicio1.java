package AulaJava01;

import java.util.Random;
import java.util.Scanner;

public class Exercicio1 {

	/*Escreva um programa Java que gera um número aleatório (randômico) entre 0 e 10
	 *(incluindo estes dois valores) e peça ao usuário para adivinhá-lo. Use um laço while para
     *registrar as tentativas feitas e, a cada tentativa, dê dicas informando se o número gerado é
     *maior ou menor que a tentativa feita. Finalmente mostre a quantidade de tentativas feitas até
     *que o número fosse acertado.
	 * 
	 */
	
	public String ex1() {
		
		//instanciando escaneador para ler os dados do teclado
		Scanner leia = new Scanner(System.in);
		
		//instanciando classe para gerar número aleatório
		Random aleatorio = new Random();
		
		//criando variáveis
		int palpite = 0,numeroAleatorio = 0,tentativas = 0;
		
		//gerando número aleatório
		numeroAleatorio = aleatorio.nextInt(11);	
	
		//faça
		do {			
			System.out.println("\rDigite um número entre 0 e 10");
			//recebendo palpite do usuário
			palpite  = leia.nextInt();	
			
			//acumulando o número de tentativas
			tentativas++;
			
			//se o palpite for maior que o número aleatório
			if(palpite > numeroAleatorio)
				System.out.print("Tente um número menor\n");
			//senão se for menor 
			else if (palpite < numeroAleatorio)
				System.out.print("\nTente um número maior\n");
			
			//while o palpite for diferente do número aleatório
			}while(palpite != numeroAleatorio); 
		
		return "Você acertou com o número " + palpite+" após " + tentativas+" tentativas";
	}
}
	
	
