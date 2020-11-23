
public class PocimaPorcentaje extends Pocima{

	private double porcentaje;
	
	public PocimaPorcentaje(String nombre, double porcentaje){
		super(nombre);
		this.porcentaje = porcentaje;
	}
	
	
	@Override
	public int getValorAtributo(Atributo atributo) {
			return (int) (atributo.getValor() * this.porcentaje);			//50*0.5 = 25%- 
	}																		//50*1.5 = 100%+
	
	
}
