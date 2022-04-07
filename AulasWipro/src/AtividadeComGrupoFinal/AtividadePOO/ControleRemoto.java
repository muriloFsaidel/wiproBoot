package AtividadeComGrupoFinal.AtividadePOO;

public class ControleRemoto {

	private Televisao tv;
	public ControleRemoto(Televisao tv) {
		super();
		this.tv = tv;
	}
	
	public void aumentarVolume() {
		if(tv.incVol() == 1) {
			System.out.println("volume aumentado para "+tv.getVolume());
		}else {
			System.out.println("volume já está no máximo"+tv.getVolume());
		}
	}
	
	public void diminuirVolume() {
		if(tv.decVol() == 1) {
			System.out.println("volume diminuido para "+tv.getVolume());
		}else {
			System.out.println("não possível diminuir o volume");
		}
	}
	
	public void aumentarCanal() {
		tv.incCanal();
		System.out.println("Novo Canal: "+tv.getCanal());
	}
	
	public void diminuirCanal() {
	   tv.decCanal();
	   System.out.println("Novo Canal: "+tv.getCanal());
	}
	
	public void trocarCanal(int canal) {
		  System.out.println("Canal trocado com sucesso para "+tv.trocarCanal(canal));
	}
	
	public int volume() {
		return tv.getVolume();
	}
	
	public int canal() {
		return tv.getCanal();
	}
	
	public void desligar() {
		tv.setLigado(false);
	}
}
