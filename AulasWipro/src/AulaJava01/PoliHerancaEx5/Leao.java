package AulaJava01.PoliHerancaEx5;

public class Leao extends Animal {
	
	int garras;
	
	public Leao(String cor, int patas, double altura, double kilograma) {
		super(cor, patas, altura, kilograma);
		this.garras = 4;
	}
	
	@Override
	public String comunicar() {
		return "uraáaaa";
	}
	
	@Override
	public String movimentar() {
		return "corre";
	}
	
}
