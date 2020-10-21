public class Jugador {

	private String nombre;
	private Mazo mazo;
	private Object atributoRandom; //El jugador 
	
	public Jugador(String nombre) {
		this.nombre = nombre;
		this.mazo = new Mazo();
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

	public Object getAtributoRandom() {
		return atributoRandom;
	}

	public void setAtributoRandom(Object atributoRandom) {
		this.atributoRandom = atributoRandom;
	}

	public void elegirAtributoRandom(){
		this.setAtributoRandom("fuerza"); //Atributo random de la primera carta del arreglo json
	}
	
}
