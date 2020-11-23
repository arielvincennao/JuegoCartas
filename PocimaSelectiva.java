
public class PocimaSelectiva extends PocimaPorcentaje{

	private String atributo;
	
	public PocimaSelectiva(String nombre, double porcentaje, String atributo) {
		super(nombre, porcentaje);
		this.atributo = atributo;
	}
	
	

	@Override
	public int getValorAtributo(Atributo atributo) {
		if(atributo.getNombre().equals(this.atributo)){		//Si el nombre del atributo que le traigo es igual al atributo de la pocima
			return super.getValorAtributo(atributo);
		}else{
			return atributo.getValor();
		}
	}

}
