
public class PocimaModificada extends Pocima{

	private int numero;
	
	public PocimaModificada(String nombre, int numero) {
		super(nombre);
		this.numero = numero;
	}
	

	@Override
	public int getValorAtributo(Atributo atributo) {
		return this.numero;
	}
	
}
