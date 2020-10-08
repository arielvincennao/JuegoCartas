public class Juego {

	private Jugador j1;
	private Jugador j2;
	private Mazo mazo;
	private int numeroRondas;
	
	public Juego(Jugador j1, Jugador j2) {
		this.j1 = j1;
		this.j2 = j2;
		this.mazo = new Mazo();
		this.numeroRondas = 0;
	}

	public Jugador getJ1() {
		return j1;
	}

	public void setJ1(Jugador j1) {
		this.j1 = j1;
	}

	public Jugador getJ2() {
		return j2;
	}

	public void setJ2(Jugador j2) {
		this.j2 = j2;
	}

	public int getNumeroRondas() {
		return numeroRondas;
	}

	public void setNumeroRondas(int numeroRondas) {
		this.numeroRondas = numeroRondas;
	}
	
	
	public void Jugar(Jugador j1, Jugador j2){
		//For con el numero de rondas
		System.out.println("------- Ronda " + this.getNumeroRondas() + " -------");
		j1.elegirAtributoRandom();
		System.out.println("El jugador " + j1.getNombre() + " selecciona competir por el atributo " + j1.getAtributoRandom());
		
		mazo.repartirCartas();
		
		//Recibe del jugador un atributo cual se usara para competir
		//Debe partir a dos el mazo

		
			//funcion elegir atributo a jugar, 
		//funcion repartir entre jugadores y  comparaciones entre quien gana. Luego definiendo quien gana usar 
		//Carta.addCarta(carta) para agregar a la cola. 
	}
	
}
