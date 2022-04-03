package AulaJava01;

//import java.util.Scanner;

public class Aulas1 {
	
	//ctrl+f = look for uses of the variable || mouse over the variable, right click, refactor, rename 
	//ctrl. vai até a variável em qualquer ponto
	//System.out.println("Hello World");//write sos as a shortcut
	//ctrl+b == clean the line			
	
	
	
	public static void main(String[] args) {
		
		//instanciando os exercícios
		Exercicio1 exercise1 = new Exercicio1();
		Exercicio2 exercise2 = new Exercicio2();
		Exercicio3 exercise3 = new Exercicio3();
		
		//chamando suas funções e métodos para exibir no console 
	    System.out.println(exercise1.ex1());
	    System.out.println(exercise2.ex2());
	    exercise3.ex3();	   
		
	}

}
