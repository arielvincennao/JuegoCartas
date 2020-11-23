
public class EstrategiaObstinado implements Estrategia{
	
	private Atributo atributoElegido;
	
	public EstrategiaObstinado(Atributo atributoElegido){
		this.atributoElegido = atributoElegido;
	}
	
	public Atributo getAtributoElegido(){
		return this.atributoElegido;
	}

	@Override
	public Atributo elegirEstrategia(Carta carta) {
		return this.getAtributoElegido();
	}

}
