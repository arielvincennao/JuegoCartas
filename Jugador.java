public class Jugador {

	private String nombre;
	private Mazo mazo;
	private Estrategia estrategia;

	
	public Jugador(String nombre) {
		this.nombre = nombre;
		this.mazo = new Mazo();
		this.estrategia = new EstrategiaTimbero();  //Por defecto se juega random
	}
	
	public Jugador(String nombre, Estrategia estrategia) {
		this.nombre = nombre;
		this.estrategia = estrategia;			//Eligiendo estrategia
		this.mazo = new Mazo();
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public Mazo getMazo() {
		return mazo;
	}

	public void setMazo(Mazo mazo) {
		this.mazo = mazo;
	}
	
	public Estrategia getEstrategia() {
		return this.estrategia;
	}
	
	public void setEstrategia(Estrategia estrategia) {
		this.estrategia = estrategia;
	}
	
	public void addCarta(Carta c){
		this.mazo.add(c);
	}
	
	public void deleteCarta(Carta c){
		this.mazo.delete(c);
	}

	public Carta getPrimerCarta(){
		return mazo.getCarta(0);	//Get para agarrar la primer carta del mazo del jugador
	}
	
	public int getCantidadDeCartasEnMazo(){		//Devuelve la cantidad de cartas en el mazo del jugador
		return mazo.getCantidadCartas();
	}
	
	public Atributo atributoElegido(){
		return this.getEstrategia().elegirEstrategia(this.getPrimerCarta());
	}
	
	
}
