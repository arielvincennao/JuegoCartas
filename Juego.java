import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Map.Entry;
import java.util.Set;

import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonObject;
import javax.json.JsonReader;
import javax.json.JsonValue;



public class Juego {

	private Jugador j1;
	private Jugador j2;
	private Mazo mazo;
	private int numeroRondasMax;
	private int rondaActual;
	private String mazoPath;
	
	public Juego(Jugador j1, Jugador j2, int numeroRondasMax, String mazoPath) {
		this.j1 = j1;
		this.j2 = j2;
		this.mazo = new Mazo();
		this.numeroRondasMax = numeroRondasMax;
		this.rondaActual = 1;
		this.mazoPath = mazoPath;
	}

	public Jugador getJ1() {
		return j1;
	}

	public void setJ1(Jugador j1) {
		this.j1 = j1;
	}

	public Jugador getJ2() {
		return j2;
	}

	public void setJ2(Jugador j2) {
		this.j2 = j2;
	}



	public int getNumeroRondasMax() {
		return numeroRondasMax;
	}

	public void setNumeroRondasMax(int numeroRondasMax) {
		this.numeroRondasMax = numeroRondasMax;
	}
	
	
	public int getRondaActual() {
		return rondaActual;
	}

	public void setRondaActual(int rondaActual) {
		this.rondaActual = rondaActual;
	}
	
	public void Jugar(){
		//For con el numero de rondas
		
		System.out.println(" ");
		System.out.println(">>> El mazo generado para jugar es el siguiente:");
		System.out.println(" ");
		this.generarMazo();
		System.out.println(mazo.toString());
		
		System.out.println(" ");
		System.out.println("-----------------------------------");
		System.out.println(" ");
		
		System.out.println("En el mazo hay " + mazo.getCantidadCartas() + " cartas totales.");
		System.out.println("Estas seran repartidas entre " + j1.getNombre() + " y " + j2.getNombre());
		
		System.out.println(" ");
		System.out.println("-----------------------------------");
		System.out.println(" ");
		
		this.repartirMazo(mazo, j1, j2);
		
		
	//	System.out.println("Las cartas del jugador 1 " + j1.getNombre() + " son: ");
	//	System.out.println(j1.getMazo());
		
	//	System.out.println("Las cartas del jugador 2 " + j2.getNombre() + " son: ");
	//	System.out.println(j2.getMazo());
		
		j1.elegirAtributoRandom();
		
		for(int i = 1; i<=getNumeroRondasMax(); i++){
			System.out.println("------- Ronda " + i + " -------");
			System.out.println("El jugador " + j1.getNombre() + " selecciona competir por el atributo " + j1.getAtributoRandom());
		}

		
		
		
		//Recibe del jugador un atributo cual se usara para competir
		//Debe partir a dos el mazo

		
			//funcion elegir atributo a jugar, 
		//funcion repartir entre jugadores y  comparaciones entre quien gana. Luego definiendo quien gana usar 
		//Carta.addCarta(carta) para agregar a la cola. 
	}

	
	public void generarMazo(){
		//URL url = getClass().getResource(jsonFile);
        File jsonInputFile = new File(this.mazoPath);
        InputStream is;
        try {
            is = new FileInputStream(jsonInputFile);
            // Creo el objeto JsonReader de Json.
            JsonReader reader = Json.createReader(is);
            // Obtenemos el JsonObject a partir del JsonReader.
            JsonArray cartas = (JsonArray) reader.readObject().getJsonArray("cartas");
            for (JsonObject carta : cartas.getValuesAs(JsonObject.class)) {
                String nombreCarta = carta.getString("nombre");
                JsonObject atributos = (JsonObject) carta.getJsonObject("atributos");
                
                ArrayList<Atributo> listaAtributos = new ArrayList<Atributo>(); 
		           
                Set<Entry<String, JsonValue>> kvPairs = atributos.entrySet();

                    for (Entry<String, JsonValue> kvPair: kvPairs) {
                    	Atributo a = new Atributo(kvPair.getKey(), atributos.getInt(kvPair.getKey()));
                    	listaAtributos.add(a);
                    }
                    
                    Carta c = new Carta(nombreCarta, listaAtributos);
                    if(mazo.verificarCarta(c)){
                        mazo.addCarta(c); 
                    }else{
                    	System.out.println("Se encontró una carta trampa " + c);
                    }


            }
            reader.close();

        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

	}

	public void repartirMazo(Mazo mazo, Jugador j1, Jugador j2){
		Mazo mazoJugador1 = new Mazo();
		Mazo mazoJugador2 = new Mazo();
		
		//Recorre el mazo y reparte
		for(int i = 0; i< mazo.getCantidadCartas(); i++){
			
			if((i % 2 == 0) || (i == 0)){
				//System.out.println(mazo.getCarta(i));				//reparte en j1
				mazoJugador1.addCarta((Carta) mazo.getCarta(i));
				j1.setMazo(mazoJugador1);
			}else{
				//System.out.println(mazo.getCarta(i));				//reparte en j2
				mazoJugador2.addCarta((Carta) mazo.getCarta(i));
				j2.setMazo(mazoJugador1);
			}

		}
		System.out.println(mazoJugador1.getCantidadCartas());
		System.out.println(mazoJugador2.getCantidadCartas());
	}
	
}
