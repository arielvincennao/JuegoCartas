public class Atributo {
	
	private String nombre;
	private int valor;
	
	public Atributo(String nombre, int valor) {
		this.nombre = nombre;
		this.valor = valor;
	}


	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	
	public int getValor() {
		return valor;
	}


	public void setValor(int valor) {
		this.valor = valor;
	}


	@Override
	public String toString() {
		return "Atributo [nombre=" + nombre + ", valor=" + valor + "]";
	}

	
	
	

}
