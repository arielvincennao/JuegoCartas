import java.util.ArrayList;



public class Carta {
	
	private String nombre;
	private ArrayList <Atributo> atributos; //ArrayList de atributos
	private Pocima pocimaCarta;
	
	public Carta(String nombre, ArrayList <Atributo> atributos) {
		this.nombre = nombre;
		this.atributos = atributos;
		this.pocimaCarta = null;
	}
	

	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public Pocima getPocima() {
		return pocimaCarta;
	}


	public void setPocima(Pocima pocima) {
		this.pocimaCarta = pocima;
	}
	
	public int cantidadAtributosCarta(){
		return atributos.size();
	}
	
	
	public int getValorAtributo(Atributo atributo){
		return atributo.getValor();
	}
	
	public String getValorNombre(Atributo atributo){
		return atributo.getNombre();
		
	}
	
	public Atributo getAtributo(Atributo atributo){
		for(int i= 0; i<this.cantidadAtributosCarta(); i++){
			if(this.getAtributos().get(i).getNombre().equals(atributo.getNombre())){
				return this.getAtributos().get(i);
			}
		}
		return null;
	}
	
	public ArrayList<Atributo> getAtributos(){
		ArrayList<Atributo> atributosCopia = new ArrayList<>(this.atributos);
		return atributosCopia;
	}
	
	
	public ArrayList<Integer> getValorAtributos(){
		ArrayList<Integer> valorAtributos = new ArrayList<Integer>();
		for( int i = 0; i<this.atributos.size(); i++){						//Devuelve ArrayList de los valores de los atributos
			valorAtributos.add(atributos.get(i).getValor());
		}
		return valorAtributos;
		
	}
	
	public ArrayList<String> getNombresAtributos(){
		ArrayList<String> nombresAtributos = new ArrayList<String>();
		for( int i = 0; i<this.atributos.size(); i++){						//Devuelve ArrayList de los nombres de los atributos
			nombresAtributos.add(atributos.get(i).getNombre());
		}
		return nombresAtributos;
	}


	public boolean contieneAtributo(String atributo){
		return this.getNombresAtributos().contains(atributo);
	}
	
	public void setValorAtributo(int pos, int valor){
		this.getAtributos().get(pos).setValor(valor);
	}
	
	public int buscarPosicionAtributo(String atributo){
		int pos = 0;
		if(this.contieneAtributo(atributo)){
		for( int i = 0; i<this.getAtributos().size(); i++){
			if(this.getAtributos().get(i).getNombre().equals(atributo)){
				pos = i;
				}
			}
		}
		return pos;
	}
	
	public int aplicarEfecto(Atributo atributo){
		int valorAplicado;
		valorAplicado = this.getPocima().getValorAtributo(atributo);
		return valorAplicado;
	}
	
	public Atributo buscarMayorValorAtributo(){
		int maxValor = 0;
		Atributo pos = null;
		for(int i=0; i<this.cantidadAtributosCarta(); i++){
			if(this.getValorAtributo(this.getAtributos().get(i)) > maxValor){
				maxValor = this.getValorAtributo(this.getAtributos().get(i));
				pos = this.getAtributos().get(i);
			}
		}
		return pos;
	}
	

	@Override
	public String toString() {
		return "Carta [nombre=" + nombre + ", atributos=" + atributos + "] \n";

	
	}


}
