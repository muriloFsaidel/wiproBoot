package AtividadeComGrupoFinal.AtividadePOO;

public class Televisao {

	//estado
	private boolean ligado;
	//controle
	private int volume = 0;
	private int volumeMax = 100;
	private int canal = 0;
	
	public Televisao(int volume, int canal) {
		super();
		this.ligado = true;
		this.volume = volume;
		this.canal = canal;
	}
	
	public boolean isLigado() {
		return ligado;
	}
	public void setLigado(boolean ligado) {
		this.ligado = ligado;
	}
	
	public int getVolume() {
		return volume;
	}
	public int getCanal() {
		return canal;
	}

	public int incVol() {
		if(this.volume <= volumeMax) {
			this.volume++; 
			return 1;
		}else {
			return 0;
		}
		
	}
	
	public int decVol() {
		if(this.volume > 0 ) {
			volume--;
			return 1;
		}else {
			return 0;
		}
	}
	
	public void incCanal() {
		this.canal++;
	}
	
	public void decCanal() {
		if(this.canal > 0) {
			canal--;
		}else {
			System.out.println("canal não existente");
		}
	}
	
	public int trocarCanal(int canal) {
		this.canal = canal;
		return canal;
	}
	
	
	
	
	
}
