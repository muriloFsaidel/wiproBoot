package AulaJava01;

import java.text.DecimalFormat;
import java.util.Scanner;


public class Aulas1 {
	
	//ctrl+f = look for uses of the variable || mouse over the variable, right click, refactor, rename 
	//ctrl. vai até a variável em qualquer ponto
	//System.out.println("Hello World");//write sos as a shortcut
	//ctrl+b == clean the line			
	
	
	public static void WiproSupermercado() {
		
		DecimalFormat duasCasas = new DecimalFormat("###.##");
		
		int codigoProdutoUsuario = 0, quantidadeProdutoUsuario = 0, continuarCompra = 0, choice=0, jaExisteNoCarrinho = 1, formaDePagamento=0;	
		Double precoTotal = 0.00,precoAbsoluto = 0.00, descontoNaCompra = 0.00, precoAbsolutoComDescontoAserPago = 0.00, valorTributario = 0.00, juros = 0.00;
		String precoComImposto = "", parcelado = "", sDescontoNaCompra = "", sPrecoAbsolutoComDescontoAserPago = "", sParceladoPrecoAbsolutoComDescontoAserPago = "", sValorTributario="";
		Scanner leia = new Scanner(System.in);
		
		int[] codigoProduto = {1,2,3,4,5,6,7,8,9,10};
		String[] nomeProduto = {"Leite","Cereal","Arroz","Atum","Feijão","Azeite","Óleo","Sabão","Sal","Açucar"};
		int[] quantidadeProduto = {10,10,10,10,10,10,10,10,10,10};
		Double[] precoProduto = {4.57,3.02,9.43,3.55,6.55,4.55,7.33,1.99,3.82,4.29};
		Integer[][] carrinho = new Integer[10][2];
		
		for(int i = 0; i < carrinho.length; i++) {
			carrinho[i][0] = 0;
			carrinho[i][1] = 0;
		}
		
		 do {		
			 
			System.out.println("*******************************************************************");
			System.out.println("                            WIPRO STORE                         ");
			System.out.println("*******************************************************************");
			System.out.println("CÓDIGO         PRODUTO         QTD.PRODUTOS             PREÇO UNIT");
				
				for(int i = 0; i < codigoProduto.length;i++) {
					System.out.println(codigoProduto[i]+"\t\t"+nomeProduto[i]+"\t\t"+quantidadeProduto[i]+"\t\t\t"+precoProduto[i]);
				}
			System.out.println("*******************************************************************");
			
			System.out.println("Olá! Digite o código do produto desejado:");
			codigoProdutoUsuario = leia.nextInt();
			System.out.println("Insira a quantidade desejada do produto:");
			quantidadeProdutoUsuario = leia.nextInt();
			
			if(quantidadeProdutoUsuario > quantidadeProduto[codigoProdutoUsuario-1] ) {
				System.out.println("\nQuantidade não disponível, favor informar uma quantidade menor ou igual que "+quantidadeProduto[codigoProdutoUsuario-1]+"\n");
			}else {
				
				quantidadeProduto[codigoProdutoUsuario-1]-= quantidadeProdutoUsuario;
				
				for(int i = 0; i < carrinho.length; i++) {
					if(codigoProdutoUsuario == carrinho[i][0] ) {
						carrinho[i][1] += quantidadeProdutoUsuario;
						jaExisteNoCarrinho = 0;
					}
				}
				
				if(jaExisteNoCarrinho == 1) {
					for(int i = 0; i < carrinho.length; i++) {
						if(carrinho[i][0] == 0) {
							carrinho[i][0] = codigoProduto[codigoProdutoUsuario-1];
							carrinho[i][1] = quantidadeProdutoUsuario;
							System.out.println("\n"+quantidadeProdutoUsuario+" un. de "+nomeProduto[codigoProdutoUsuario-1]+" adicionado com sucesso no carrinho !!\n");
							break;							
						}
						
					}					
					
				}
				
				//System.out.println("Produto: "+nomeProduto[codigoProdutoUsuario-1]+", quantidade atual:"+quantidadeProduto[codigoProdutoUsuario-1]);
				System.out.println("Deseja continuar a sua compra? SIM = 0 , NÃO = 1");
				choice = leia.nextInt();
			}		
			
			if(choice == 1) {
				continuarCompra = 1;	
			}			
		 
		}while(continuarCompra == 0);
		 
		 System.out.println("\nITENS DO CARRINHO:");
		 System.out.println("Nome                      Qtde. no carrinho              Preço unit.(R$)        Preço Total (R$)");
		 
		 
		 for(int i = 0; i < carrinho.length; i++) {
			 
			 if (carrinho[i][0]!= 0) {
				 precoTotal = (precoProduto[carrinho[i][0]-1]) * (carrinho[i][1]);		
				 precoAbsoluto+= precoTotal;
				 System.out.println(nomeProduto[carrinho[i][0]-1]+ "                 "+carrinho[i][1] +"                              "+precoProduto[carrinho[i][0]-1] +"                    "+precoTotal);
			 }
			 
		 }
		 
		 precoComImposto = duasCasas.format((precoAbsoluto * 9) / 100 + precoAbsoluto) ;	 
		 
		 System.out.println("\nO valor total da compra com imposto de 9%: R$"+precoComImposto);
		
		 do {
			 System.out.println("Opções de pagamento:\n");
			 System.out.println("[1]À vista em dinheiro ou cartão MASTERCARD, recebe 20% de desconto,"+
				 			"\n[2]À vista no cartão de crédito, recebe 15% de desconto,"+
				            "\n[3]Em duas vezes, preço normal de etiqueta sem juros,"+
				 			"\n[4]Em três vezes, preço normal de etiqueta mais juros de 10%\n");
			 System.out.println("qual seria a forma de pagamento?");
			 formaDePagamento = leia.nextInt();
		 
		 //conta
			 if(formaDePagamento == 1) {
				 descontoNaCompra = (precoAbsoluto * 20) / 100;
				 sDescontoNaCompra = duasCasas.format(descontoNaCompra);
				 valorTributario = (precoAbsoluto * 9) / 100;
				 sValorTributario = duasCasas.format(valorTributario); 
				 precoAbsolutoComDescontoAserPago = (precoAbsoluto - descontoNaCompra) + valorTributario;
				 sPrecoAbsolutoComDescontoAserPago  = duasCasas.format(precoAbsolutoComDescontoAserPago);
				 
			 }
			 else if(formaDePagamento == 2) {
				 descontoNaCompra = (precoAbsoluto * 15) / 100;
				 sDescontoNaCompra = duasCasas.format(descontoNaCompra);
				 valorTributario = (precoAbsoluto * 9) / 100;
				 sValorTributario = duasCasas.format(valorTributario); 
				 precoAbsolutoComDescontoAserPago = (precoAbsoluto - descontoNaCompra) + valorTributario;
				 sPrecoAbsolutoComDescontoAserPago  = duasCasas.format(precoAbsolutoComDescontoAserPago);
			 }
			 else if(formaDePagamento == 3) {
				 valorTributario = (precoAbsoluto * 9) / 100;
				 sValorTributario = duasCasas.format(valorTributario); 
				 
				 precoAbsolutoComDescontoAserPago = (precoAbsoluto - descontoNaCompra) + valorTributario;
				 sPrecoAbsolutoComDescontoAserPago = duasCasas.format(precoAbsolutoComDescontoAserPago);
				 
				 sParceladoPrecoAbsolutoComDescontoAserPago =  duasCasas.format(precoAbsolutoComDescontoAserPago / 2);	
				 parcelado = "parcelado em 2x vezes de "+sParceladoPrecoAbsolutoComDescontoAserPago;
			 }
			 else if(formaDePagamento == 4) {
				 juros = (precoAbsoluto * 10) / 100;
				 
				 valorTributario = (precoAbsoluto * 9) / 100;
				 sValorTributario = duasCasas.format(valorTributario); 
				 
				 precoAbsolutoComDescontoAserPago = precoAbsoluto + juros + valorTributario;	
				 sPrecoAbsolutoComDescontoAserPago = duasCasas.format(precoAbsolutoComDescontoAserPago);
				 
				 sParceladoPrecoAbsolutoComDescontoAserPago =  duasCasas.format(precoAbsolutoComDescontoAserPago / 3);				 
				 parcelado = "parcelado em 3x vezes de "+sParceladoPrecoAbsolutoComDescontoAserPago;
			 }else {
				 System.out.println("Digite uma opção válida");
			 }
		 }while(formaDePagamento > 4 || formaDePagamento <= 0);
		 
		 
		 System.out.println("\nWipro STORE\nRua dos Bôbos, n°0 - Mercadinho - LTDA\nCNPJ: 1234554321-00\n");
		 System.out.println("                           Nota Fiscal                                    ");
		 System.out.println("*************************************************************************************************");
		 System.out.println("Nome                      Qtde. no carrinho              Preço unit.(R$)        Preço Total (R$)");
		 
		 
		 
		 for(int i = 0; i < carrinho.length; i++) {
			 
			 if (carrinho[i][0]!= 0) {
				 precoTotal = (precoProduto[carrinho[i][0]-1]) * (carrinho[i][1]);		
				 precoAbsoluto+= precoTotal;
				 System.out.println(nomeProduto[carrinho[i][0]-1]+ "                 "+carrinho[i][1] +"                              "+precoProduto[carrinho[i][0]-1] +"                    "+precoTotal);
			 }
			 
		 }
		//int i2 = 0;
		 /*do {		 
			 precoTotal = (precoProduto[carrinho[i2][0]-1]) * (carrinho[i2][1]);		
			 precoAbsoluto+= precoTotal;
			 System.out.println(nomeProduto[carrinho[i2][0]-1]+ "                   "+carrinho[i2][1] +"                              "+precoProduto[carrinho[i2][0]-1] +"                    "+precoTotal);
			 i2++;
		 }while(carrinho[i2][0]!= 0);*/
		 
		 System.out.println("**************************************************************************************************\n\n");
		
		 if(parcelado=="") {
		 System.out.println("DESCONTO NA COMPRA: R$"+ sDescontoNaCompra);
		 System.out.println("VALOR TOTAL A SER PAGO: R$"+sPrecoAbsolutoComDescontoAserPago);
		 System.out.println("VALOR TRIBUTÁRIO:  R$"+sValorTributario);
		 }else {
			 System.out.println("DESCONTO NA COMPRA: R$0,00");
			 System.out.println("VALOR TOTAL A SER PAGO: R$"+sPrecoAbsolutoComDescontoAserPago+" "+parcelado);
			 System.out.println("VALOR TRIBUTÁRIO:  R$"+sValorTributario);
		 }		 
		
	}
	
	
	public static void main(String[] args) {
		
		//instanciando os exercícios
		//Exercicio1 exercise1 = new Exercicio1();
		//Exercicio2 exercise2 = new Exercicio2();
		//Exercicio3 exercise3 = new Exercicio3();
		
		//chamando suas funções e métodos para exibir no console 
	    //System.out.println(exercise1.ex1());
	    //System.out.println(exercise2.ex2());
	    //exercise3.ex3();	 
		
		WiproSupermercado();		
	}

}
