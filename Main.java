
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Crear jugadores
		Jugador jugador1 = new Jugador("Juan");
		Jugador jugador2 = new Jugador("Pepe");
		
		Juego juego = new Juego(jugador1, jugador2);
		
		Carta c = new Carta();
		
		System.out.println(c.getNombre());
		
		String mazoPath = "./superheroes.json";
        c.cartaRandom(mazoPath);
		
		juego.Jugar(jugador1, jugador2);

	}

}
