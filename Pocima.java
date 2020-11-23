
public abstract class Pocima {
	
	private String nombre;

	public Pocima(String nombre){
		this.nombre = nombre;
	}
	
	public String getNombre(){
		return nombre;
	}

	
	public abstract int getValorAtributo(Atributo atributo);


}
