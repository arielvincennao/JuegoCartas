import java.util.ArrayList;


public class Mazo {
	
	private ArrayList <Carta> cartas;	
	//Crear un contador?

	public Mazo() {
		this.cartas = new ArrayList<Carta>(); 
	}

	public void addCarta(Carta c){
		this.cartas.add(c);
	}
	
	public boolean verificarCarta(Carta c){
		if(this.getCantidadCartas() > 0){
			if(this.cartas.get(0).getNombresAtributos().equals(c.getNombresAtributos())){
				return true;
			}
			else{
				return false;
			}
		}else{
			return true;
		}
	}
	
	

	public ArrayList<Carta> getCartas() {
		return cartas;
	}

	public void setCartas(ArrayList<Carta> cartas) {
		this.cartas = cartas;
	}
	
	public Object getCarta(int pos){
		return cartas.get(pos);
	}

	public int getCantidadCartas(){
		return cartas.size(); //Devuelve la cantidad de cartas en el mazo
	}
	
	
	@Override
	public String toString() {
		return "Mazo [cartas=" + cartas + "]";
	}
	

}
