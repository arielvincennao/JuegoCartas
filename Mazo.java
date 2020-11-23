import java.util.ArrayList;
import java.util.Random;


public class Mazo {
	
	private ArrayList <Carta> cartas;	
	private ArrayList <Pocima> pocimas;


	public Mazo() {
		this.cartas = new ArrayList<Carta>(); 
		this.pocimas = new ArrayList<Pocima>();
	}

	public void add(Carta c){
		this.cartas.add(c);
	}
	
	public void delete(Carta c){
		this.cartas.remove(c);
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
	

	
	public Carta getCarta(int pos){
		return cartas.get(pos);
	}

	public int getCantidadCartas(){
		return cartas.size(); //Devuelve la cantidad de cartas en el mazo
	}
	
	public void addPocima(Pocima p){
		this.pocimas.add(p);			
	}
	
	public void deletePocima(int pos){
		this.pocimas.remove(pos);
	}
	
	public ArrayList<Pocima> getPocimas(){
		ArrayList<Pocima> pocimasCopia = new ArrayList<>(this.pocimas);
		return pocimasCopia;
	}
	
	public int cantPocimas(){
		return this.getPocimas().size();
	}
	
	public int ElegirPocimaRandom(){
		int maxPociones = this.cantPocimas();//Cant de pociones en el juego
		Random rand = new Random();
		int numeroPocimaElegida = rand.nextInt(maxPociones); //Cant de pociones -1
		
		return numeroPocimaElegida;
	}
	
	
	@Override
	public String toString() {
		return "Mazo [cartas=" + cartas + "]";
	}

	public void repartirPocima(int i) {
		int nrandom;
		nrandom = this.ElegirPocimaRandom();
		this.getCarta(i).setPocima(this.getPocimas().get(nrandom)); //random en i
		this.deletePocima(nrandom);	//random en i
	}
	

}
