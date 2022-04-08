package AulaJava01.PoliHerancaEx5;

//classe filha que herda as características de um animal em geral
public class Pato extends Animal {
	
	//mas tem uma característica em particular
	private int asa;
	
	public Pato(String cor, int patas, double altura, double kilograma) {
		super(cor, patas, altura, kilograma);
		this.asa = 2;
	}
	
	// que se comunica e se movimenta, porém, a sua maneira
	@Override
	public String comunicar() {
		return "quack,quack";
	}
	
	@Override
	public String movimentar() {
		return "bate asas";
	}

}
