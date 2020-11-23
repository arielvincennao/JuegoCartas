
public class EstrategiaTimbero implements Estrategia{

	public Atributo elegirEstrategia(Carta c){
		int maximo = c.cantidadAtributosCarta();
		int atributoSeleccionado = (int) (Math.random() * maximo);
		return c.getAtributos().get(atributoSeleccionado);
	}
	
}
