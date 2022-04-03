package AulaJava01;

import java.util.Scanner;

public class Exercicio2 {
	
	/*
	 * Faça um programa para receber o nome de um aluno e informar 2 notas, em seguida calcular
	 * a média do aluno e apresentar ao final a média calculada e a situação de Aprovação do aluno.
	 * (aprovado com média >= 6).
	 */
	
public String ex2() {
	
		//instanciando escaneador para ler os dados do teclado
		Scanner leia = new Scanner(System.in);
		
		//criando variáveis
		String nome ="",situacao ="";
		float nota1,nota2,media = 0;
		
		System.out.println("Digite o nome do aluno");
		//capturando o nome do aluno
		nome = leia.nextLine();
		
		System.out.println("Digite o valor da primeira nota");
		//capturando o valor da nota 1
		nota1 = leia.nextFloat();
		
		System.out.println("Digite o valor da segunda nota");
		//capturando o valor da nota 2
		nota2 = leia.nextFloat();
		
		//enquanto o valor for inválido,
		while((nota1 >10) && (nota2 >10)) {
			
			System.out.println("\nDigite notas válidas com valor de 1 a 10\n");
			
			System.out.println("Digite o valor da primeira nota");
			nota1 = leia.nextFloat();
			
			System.out.println("Digite o valor da segunda nota");
			nota2 = leia.nextFloat();  		
		}
		
		//calculando média
		media = (nota1+nota2) / 2;
		
		//se a média for maior que 6
		if (media >= 6) {
			situacao = "aprovado";
		//senão	
		}else {
			situacao ="reprovado";
		}	
		
		return "O aluno "+nome+" com a média "+media+" está "+situacao;
	}
}
