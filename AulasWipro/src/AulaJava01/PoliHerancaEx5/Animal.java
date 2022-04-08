package AulaJava01.PoliHerancaEx5;

public abstract class Animal {
	
	protected String cor;
	protected int patas;
	protected double altura;
	protected double kilograma;
	
	public Animal(String cor, int patas, double altura, double kilograma) {
		this.cor = cor;
		this.patas = patas;
		this.altura = altura;
		this.kilograma = kilograma;
	}

	public abstract String comunicar();
	
	public abstract String movimentar();
	
}
