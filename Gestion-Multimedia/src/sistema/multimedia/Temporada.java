package sistema.multimedia;


public class Temporada {
	private int numero;
	private int Episodios;
	public Temporada(int numero, int episodios) {
		this.numero=numero;
		this.Episodios=episodios;
}
// Getters y setters 
	public int getNumero() {return numero;
	}
	public void setNumero(int numero) { this.numero=numero;
		}
	
	public int getEpisodios() {return Episodios;
	}
	public void setEpisodios(int episodios) {this.Episodios=episodios;}
	}
