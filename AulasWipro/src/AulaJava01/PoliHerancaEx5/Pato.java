package AulaJava01.PoliHerancaEx5;

public class Pato extends Animal {
	
	private int asa;
	
	public Pato(String cor, int patas, double altura, double kilograma) {
		super(cor, patas, altura, kilograma);
		this.asa = 2;
	}
	
	@Override
	public String comunicar() {
		return "quack,quack";
	}
	
	@Override
	public String movimentar() {
		return "bate asas";
	}

}
