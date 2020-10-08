import java.util.ArrayList;

public class Jugador {

	private String nombre;
	private ArrayList <Carta> cartas;
	private Object atributoRandom;
	
	public Jugador(String nombre) {
		this.nombre = nombre;
		Mazo m = new Mazo();
		//this.mazo = mazo; Crear un metodo para crear el mazo dependiendo de las cartas que haya
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
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
