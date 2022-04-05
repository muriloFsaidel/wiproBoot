package AulaJava01;

import java.text.DecimalFormat;
import java.util.Scanner;

public class WiproStore {
	
	public void WiproSupermercado() {
		
		    System.out.println("Grupo 2: Isaque Silva\nMurilo Fernandes Saidel\nPedro Duarte\nRenan Santos Abreu de Barros\nThiago Barbosa de Araujo");
			
		    //referência responsável por formatar um número e retoná-lo como string 
			DecimalFormat duasCasas = new DecimalFormat("###.##");
			
			//variáveis de entrada
			int codigoProdutoUsuario = 0, quantidadeProdutoUsuario = 0, continuarCompra = 0;
			//variáveis de entrada e controle
			int choice = 0, jaExisteNoCarrinho = 1, formaDePagamento=0;
			//váriaveis para cálculo
			Double precoTotal = 0.00,precoAbsoluto = 0.00, descontoNaCompra = 0.00, precoAbsolutoComDescontoAserPago = 0.00, valorTributario = 0.00, juros = 0.00;
			String precoComImposto = "", parcelado = "", sDescontoNaCompra = "", sPrecoAbsolutoComDescontoAserPago = "", sParceladoPrecoAbsolutoComDescontoAserPago = "", sValorTributario="";
			
			//referência para ler dados de entrada
			Scanner leia = new Scanner(System.in);
			
			//arrays de dados do produto e carrinho
			int[] codigoProduto = {1,2,3,4,5,6,7,8,9,10};
			String[] nomeProduto = {"Leite","Cereal","Arroz","Atum","Feijão","Azeite","Óleo","Sabão","Sal","Açucar"};
			int[] quantidadeProduto = {10,10,10,10,10,10,10,10,10,10};
			Double[] precoProduto = {4.57,3.02,9.43,3.55,6.55,4.55,7.33,1.99,3.82,4.29};
			Integer[][] carrinho = new Integer[10][2];
			
			//preenchimento do carrinho do Integer, como efeito de verificação de produto existente não, pois foi definida como Integer.
			for(int i = 0; i < carrinho.length; i++) {
				carrinho[i][0] = 0;
				carrinho[i][1] = 0;
			}
			
			//laço de repetição para incluir produtos no carrinho, incrementar sua quantidade na compra de um produto existente e deduzir do estoque
			 do {		
				 
				System.out.println("*******************************************************************");
				System.out.println("                            WIPRO STORE                         ");
				System.out.println("*******************************************************************");
				System.out.println("CÓDIGO         PRODUTO         QTD.PRODUTOS             PREÇO UNIT");
					
				//listando produtos e seus valores
					for(int i = 0; i < codigoProduto.length;i++) {
						System.out.println(codigoProduto[i]+"\t\t"+nomeProduto[i]+"\t\t"+quantidadeProduto[i]+"\t\t\t"+precoProduto[i]);
					}
				System.out.println("*******************************************************************");
				
				//solicitando dados de entrada
				System.out.println("Olá! Digite o código do produto desejado:");
				codigoProdutoUsuario = leia.nextInt();
				System.out.println("Insira a quantidade desejada do produto:");
				quantidadeProdutoUsuario = leia.nextInt();
				
				
				if(quantidadeProdutoUsuario > quantidadeProduto[codigoProdutoUsuario-1] ) {
					System.out.println("\nQuantidade não disponível, favor informar uma quantidade menor ou igual que "+quantidadeProduto[codigoProdutoUsuario-1]+"e maior que 0\n");
				}else {
					//decrementando estoque em caso de compra
					quantidadeProduto[codigoProdutoUsuario-1]-= quantidadeProdutoUsuario;
					
					//verificando se o produto já está no carrinho e se sim, aumentando sua quantidade
					for(int i = 0; i < carrinho.length; i++) {
						if(codigoProdutoUsuario == carrinho[i][0] ) {
							carrinho[i][1] += quantidadeProdutoUsuario;
							jaExisteNoCarrinho = 0;
						}
					}
					
					//caso não exista, encontra o primeiro espaço disponível e exibindo o produto adicionado
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
				//se a escolha for não
				if(choice == 1) {
					//não continuar compra
					continuarCompra = 1;	
				}			
			 
			}while(continuarCompra == 0);
			 
			 //exibindo carrinho após as compras
			 System.out.println("\nITENS DO CARRINHO:");
			 System.out.println("Nome\t\tQtde. no carrinho\t\tPreço unit.(R$)\t\tPreço Total (R$)");
			 
			 //varrendo carrinho, calculando preços e exibindo os valores do carrinho
			 for(int i = 0; i < carrinho.length; i++) {
				 
				 if (carrinho[i][0]!= 0) {
					 precoTotal = (precoProduto[carrinho[i][0]-1]) * (carrinho[i][1]);		
					 precoAbsoluto+= precoTotal;
					 System.out.println(nomeProduto[carrinho[i][0]-1]+ "\t\t\t"+carrinho[i][1] +"\t\t\t\t"+precoProduto[carrinho[i][0]-1] +"\t\t\t"+precoTotal);
				 }
				 
			 }
			 
			 //calculando o preço com isposto
			 precoComImposto = duasCasas.format((precoAbsoluto * 9) / 100 + precoAbsoluto) ;	 
			 
			 //exibindo preço com imposto
			 System.out.println("\nO valor total da compra com imposto de 9%: R$"+precoComImposto);
			
			 //laço de repetição para escolher a forma de pagamento que caso não for válida, solicita a forma de pagamento novamente
			 do {
				 System.out.println("Opções de pagamento:\n");
				 System.out.println("[1]À vista em dinheiro ou cartão MASTERCARD, recebe 20% de desconto,"+
					 			"\n[2]À vista no cartão de crédito, recebe 15% de desconto,"+
					            "\n[3]Em duas vezes, preço normal de etiqueta sem juros,"+
					 			"\n[4]Em três vezes, preço normal de etiqueta mais juros de 10%\n");
				 System.out.println("qual seria a forma de pagamento?");
				 formaDePagamento = leia.nextInt();
			 
			 //cálculo para cada forma de pagamento
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
			 
			 //exibindo nota fiscal
			 System.out.println("\nWipro STORE\nRua dos Bôbos, n°0 - Mercadinho - LTDA\nCNPJ: 1234554321-00\n");
			 System.out.println("\t\t\t\t\t\tNota Fiscal\t\t\t\t\t\t\t");
			 System.out.println("*************************************************************************************************");
			 System.out.println("Nome\t\t\tQtde. no carrinho\t\tPreço unit.(R$)\t\tPreço Total (R$)");
			 
			 
			 //varrendo carrinho, calculando preços e exibindo os valores do carrinho
			 for(int i = 0; i < carrinho.length; i++) {
				 
				 if (carrinho[i][0]!= 0) {
					 precoTotal = (precoProduto[carrinho[i][0]-1]) * (carrinho[i][1]);		
					 precoAbsoluto+= precoTotal;
					 System.out.println(nomeProduto[carrinho[i][0]-1]+ "\t\t\t"+carrinho[i][1] +"\t\t\t\t"+precoProduto[carrinho[i][0]-1] +"\t\t\t"+precoTotal);
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
			
			 //verificando se o pagamento foi parcelado ou não
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
}
