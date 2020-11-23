
public class PocimaAND extends Pocima{
	

	Pocima p1;
	Pocima p2;
	
	
	public PocimaAND(String nombre, Pocima p1, Pocima p2) {
		super(nombre);
		this.p1 = p1;
		this.p2 = p2;
	}
	
	
	@Override
	public int getValorAtributo(Atributo atributo) {
		Atributo aux = new Atributo(atributo.getNombre(), atributo.getValor());
		aux.setValor(p1.getValorAtributo(aux));
		return p2.getValorAtributo(aux);
	}
	
	
}
