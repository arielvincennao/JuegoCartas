import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonObject;
import javax.json.JsonReader;


public class Carta {
	
	private String nombre;
	private String atributo; //ArrayList de atributos
	private int valor;
	
	public Carta() {
		this.nombre = nombre; //Devolver valores de la funcion que pickea
		this.atributo = atributo;//Devolver valores de la funcion que pickea	JSON
		this.valor = valor;//Devolver valores de la funcion que pickea
	}
	
	
	public String getNombre() {
		return nombre;
	}



	public void setNombre(String nombre) {
		this.nombre = nombre;
	}



	public String getAtributo() {
		return atributo;
	}



	public void setAtributo(String atributo) {
		this.atributo = atributo;
	}



	public int getValor() {
		return valor;
	}



	public void setValor(int valor) {
		this.valor = valor;
	}



	public void cartaRandom(String jsonFile){
        //URL url = getClass().getResource(jsonFile);
    	int cont = 0;
        File jsonInputFile = new File(jsonFile);
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
                String atributosStr = "";
                for (String nombreAtributo:atributos.keySet())
                    atributosStr = atributosStr + nombreAtributo + ": " +
                            atributos.getInt(nombreAtributo) + "; ";
                System.out.println(nombreCarta+"\t\t\t"+atributosStr);
                this.setNombre(nombreCarta);
                cont++;

            }
            System.out.println("Las cartas en el mazo son: " + cont); //El mazo sabe todas las que hay
            reader.close();

        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }


	@Override
	public String toString() {
		return "Carta [nombre=" + nombre + "]";
	}
	
	
	
}
