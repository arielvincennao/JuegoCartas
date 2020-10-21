
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//Crear jugadores
		Jugador jugador1 = new Jugador("Juan");
		Jugador jugador2 = new Jugador("Pepe");
		
		//Url de mi json
		String mazoPath = "./superheroes.json";
		
		Juego juego = new Juego(jugador1, jugador2, 5, mazoPath);
		
		juego.Jugar();

	}

}
