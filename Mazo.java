import java.util.ArrayList;


public class Mazo {
	
	private ArrayList <Carta> cartas;	
	//Crear un contador?

	public Mazo() {
		this.cartas = new ArrayList<Carta>(); 
	}

	public void addCarta(Carta C){
		this.cartas.add(C);
	}
	
	public void verificarCartas(){
		//Si está todo OK las reparte
	}
	
	
	public void repartirCartas(){
		//repartir cartas
	}

	@Override
	public String toString() {
		return "Mazo [cartas=" + cartas + "]";
	}
	
	
	/*public ArrayList<Carta> getCartas() {
		return cartas;
	}

	public void setCartas(ArrayList<Carta> cartas) {
		this.cartas = cartas;
	}*/
	
	
	

}
