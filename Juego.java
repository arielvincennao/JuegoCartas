public class Juego {

	private Jugador j1;
	private Jugador j2;
	private int numeroRondas;
	
	public Juego(Jugador j1, Jugador j2) {
		this.j1 = j1;
		this.j2 = j2;
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
	
	
	public void Jugar(){
		System.out.println("------- " + this.getNumeroRondas() + " -------");
		//Llamar funcion pickear cartas randoms del JSON y agregarlas al mazo, funcion elegir atributo a jugar, 
		//funcion repartir entre jugadores y  
	}
	
}
