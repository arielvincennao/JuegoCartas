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
		
		this.generarMazo();
		
		mazo.repartirCartas();
		
		System.out.println(mazo.toString());
		
		for(int i = 1; i<=getNumeroRondasMax(); i++){
			System.out.println("------- Ronda " + i + " -------");
			j1.elegirAtributoRandom();
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
    	int cont = 0;
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
                    
                    mazo.addCarta(c); 
                
                    //String NAtributo = atributos.get(nombreAtributo);

                cont++;

            }
            System.out.println("Las cartas en el mazo son: " + cont); //El mazo sabe todas las que hay
            reader.close();

        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

	}

	
}
