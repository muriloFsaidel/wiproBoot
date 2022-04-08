package AulaJava01.PoliHerancaEx5;

//classe filha que herda as características de um animal em geral
public class Leao extends Animal {
	
	//mas tem uma característica em particular
	int garras;
	
	public Leao(String cor, int patas, double altura, double kilograma) {
		super(cor, patas, altura, kilograma);
		this.garras = 4;
	}
	
	// que se comunica e se movimenta, porém, a sua maneira
	@Override
	public String comunicar() {
		return "uraáaaa";
	}
	
	@Override
	public String movimentar() {
		return "corre";
	}
	
}
