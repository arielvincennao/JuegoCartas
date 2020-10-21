import java.util.ArrayList;



public class Carta {
	
	private String nombre;
	private ArrayList <Atributo> atributos; //ArrayList de atributos
	
	public Carta(String nombre, ArrayList <Atributo> atributos) {
		this.nombre = nombre;
		this.atributos = atributos;
	}
	
	
	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	

	public ArrayList<Atributo> getAtributos() {
		return atributos;
	}
	
	public ArrayList<String> getNombresAtributos(){
		ArrayList<String> nombresAtributos = new ArrayList<String>();
		for( int i = 0; i<this.atributos.size(); i++){
			nombresAtributos.add(atributos.get(i).getNombre());
		}
		return nombresAtributos;
	}


	public void setAtributos(ArrayList<Atributo> atributos) {
		this.atributos = atributos;
	}


	@Override
	public String toString() {
		return "Carta [nombre=" + nombre + ", atributos=" + atributos + "] \n";

	
	}

}
