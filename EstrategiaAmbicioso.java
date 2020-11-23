
public class EstrategiaAmbicioso implements Estrategia{

	@Override
	public Atributo elegirEstrategia(Carta carta) {
		Atributo a = carta.buscarMayorValorAtributo();
		return a;
	}

}
