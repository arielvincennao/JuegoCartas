import java.util.ArrayList;


public class Mazo {
	
	private int numeroCartas;	
	private ArrayList <Carta> cartas;	
	//Crear un contador?

	public Mazo(int numeroCartas) {
		this.numeroCartas = numeroCartas;
		this.cartas = new ArrayList<Carta>(); 
	}

	public void addCarta(Carta C){
		this.cartas.add(C);
	}

	public int getNumeroCartas() {
		return numeroCartas;
	}

	public void setNumeroCartas(int numeroCartas) {
		this.numeroCartas = numeroCartas;
	}
	
	
	/*public ArrayList<Carta> getCartas() {
		return cartas;
	}

	public void setCartas(ArrayList<Carta> cartas) {
		this.cartas = cartas;
	}*/
	
	

}
