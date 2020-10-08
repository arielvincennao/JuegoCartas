public class Jugador {

	private String nombre;
	private Mazo mazo;
	
	public Jugador(String nombre) {
		this.nombre = nombre;
		//this.mazo = mazo; Crear un metodo para crear el mazo dependiendo de las cartas que haya
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
	
	
}
