
public class Main {

	public static void main(String[] args) {
		
		//Atributo fuerza = new Atributo("fuerza");
		//Estrategia ambicioso = new EstrategiaAmbicioso();
		//Estrategia obstinado = new EstrategiaObstinado(fuerza);
		//Estrategia timbero = new EstrategiaTimbero();
		
		//Jugador jugador1 = new Jugador("Juan", fuerza);
		//Jugador jugador2 = new Jugador("Pepe", obstinado);
		
		//Crear jugadores
		Jugador jugador1 = new Jugador("Juan");
		Jugador jugador2 = new Jugador("Pepe");
		
		
		
		
		//Url de mi json
		String mazoPath = "./superheroes.json";
		
		//Creo un juego, con sus dos jugadores, las rondas maximas que se van a jugar y la URL json de mi mazo
		Juego juego = new Juego(jugador1, jugador2,  5, mazoPath);
		
		/*Pocima p1 = new PocimaModificada("Pocima Modificada 1" , 1);
		juego.agregarPocimaAlMazoDelJuego(p1);
		Pocima p2 = new PocimaModificada("Pocima Modificada 2" , 2);
		juego.agregarPocimaAlMazoDelJuego(p2);
		Pocima p3 = new PocimaModificada("Pocima Modificada 3" , 3);
		juego.agregarPocimaAlMazoDelJuego(p3);
		Pocima p4 = new PocimaSelectiva("Pocion Selectiva", 2.0, "fuerza");
		juego.agregarPocimaAlMazoDelJuego(p4);*/
		
		juego.Jugar();

	}

}
