package AulaJava01.PoliHerancaEx5;

public class Executar {

	public static void main(String[] args) {
		
		Animal leao = new Leao("Amarelo",4,1.70,80.5);
		Animal pato = new Pato("Branco",2,0.5,20);
		
		System.out.println("Cor: "+leao.cor+", Patas: "+leao.patas+", Altura: "+leao.altura+", Peso: "+leao.kilograma+" leão faz "+leao.comunicar()+" e "+leao.movimentar());
		System.out.println("Cor: "+pato.cor+", Patas: "+pato.patas+", Altura: "+pato.altura+", Peso: "+pato.kilograma+" pato faz "+pato.comunicar()+" e "+pato.movimentar());
	}

}
