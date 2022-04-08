package AulaJava01.PoliHerancaEx5;

//classe pai Animal do mundo real que possui:
public abstract class Animal {
	
	//atributos
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

	//comportamentos
	public abstract String comunicar();
	
	public abstract String movimentar();
	
}
