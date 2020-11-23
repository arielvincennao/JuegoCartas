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
	private boolean turnoJugador;
	private String mazoPath;

	public Juego(Jugador j1, Jugador j2, int numeroRondasMax, String mazoPath) {
		this.j1 = j1;
		this.j2 = j2;
		this.mazo = new Mazo();
		this.numeroRondasMax = numeroRondasMax;
		this.mazoPath = mazoPath;
		this.turnoJugador = true;
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

	public void Jugar() {

		System.out.println(" ");
		// System.out.println(">>> El mazo generado para jugar es el siguiente:");
		System.out.println(" ");
		this.generarMazo();
		// System.out.println(mazo.toString());

		System.out.println(" ");
		System.out.println("-----------------------------------");
		System.out.println(" ");

		System.out.println("En el mazo hay " + mazo.getCantidadCartas()
				+ " cartas totales.");
		System.out.println("Estas seran repartidas entre " + j1.getNombre()
				+ " y " + j2.getNombre());

		System.out.println(" ");
		System.out.println("-----------------------------------");
		System.out.println(" ");

		this.repartirMazo(mazo, j1, j2);

		System.out.println("La cantidad de cartas del Jugador 1 "
				+ j1.getNombre() + " son: ");
		System.out.println(j1.getMazo().getCantidadCartas());
		// System.out.println(j1.getMazo());
		System.out.println("La cantidad de cartas del Jugador 2 "
				+ j2.getNombre() + " son: ");
		System.out.println(j2.getMazo().getCantidadCartas());
		// System.out.println(j2.getMazo());

		System.out.println(" ");
		System.out.println("Comenzando juego...");
		System.out.println(" ");

		int i = 0;

		while (i < this.getNumeroRondasMax()) {

			i++;

			Atributo atributoElegido;

			System.out.println("------- Ronda " + i + " -------");

			System.out.println("\n");

			// Sistema de turnos

			if (this.turnoJugador == true) {
				Atributo atrJ1 = j1.atributoElegido();
				atributoElegido = j1.getPrimerCarta().getAtributo(atrJ1); // Elegir
																			// atributo
																			// random
				System.out
						.println("El jugador "
								+ j1.getNombre()
								+ " selecciona competir por el atributo "
								+ (j1.getPrimerCarta())
										.getValorNombre(atributoElegido));
			} else {
				Atributo atrJ2 = j2.atributoElegido();
				atributoElegido = j2.getPrimerCarta().getAtributo(atrJ2); // Elegir
																			// atributo
																			// random
				System.out
						.println("El jugador "
								+ j2.getNombre()
								+ " selecciona competir por el atributo "
								+ (j2.getPrimerCarta())
										.getValorNombre(atributoElegido));
			}

			System.out.println("\n");

			Atributo atributoJugador1 = j1.getPrimerCarta().getAtributo(
					atributoElegido);
			Atributo atributoJugador2 = j2.getPrimerCarta().getAtributo(
					atributoElegido);

			int valorCartaJugador1 = j1.getPrimerCarta()
					.getAtributo(atributoElegido).getValor();
			int valorCartaJugador2 = j2.getPrimerCarta()
					.getAtributo(atributoElegido).getValor();

			if (j1.getPrimerCarta().getPocima() != null) { /* Correcion */
				int valorCartaJugador1sinEfecto;
				valorCartaJugador1sinEfecto = j1.getPrimerCarta()
						.getAtributo(atributoElegido).getValor();
				valorCartaJugador1 = j1.getPrimerCarta().aplicarEfecto(
						atributoJugador1);
				System.out.println("La carta de " + j1.getNombre() + " es "
						+ (j1.getPrimerCarta()).getNombre() + " con "
						+ (j1.getPrimerCarta()).getValorNombre(atributoElegido)
						+ " " + valorCartaJugador1sinEfecto
						+ ", se le aplico la pocima "
						+ j1.getPrimerCarta().getPocima().getNombre()
						+ " con valor resultante " + valorCartaJugador1);
			} else {
				System.out.println(j1.getPrimerCarta().toString());
				System.out.println("La carta de " + j1.getNombre() + " es "
						+ (j1.getPrimerCarta()).getNombre() + " con "
						+ (j1.getPrimerCarta()).getValorNombre(atributoElegido)
						+ " " + valorCartaJugador1);
			}

			if (j2.getPrimerCarta().getPocima() != null) {
				int valorCartaJugador2sinEfecto;
				valorCartaJugador2sinEfecto = j2.getPrimerCarta()
						.getAtributo(atributoElegido).getValor();
				valorCartaJugador2 = j2.getPrimerCarta().aplicarEfecto(
						atributoJugador2);
				System.out.println("La carta de " + j2.getNombre() + " es "
						+ (j2.getPrimerCarta()).getNombre() + " con "
						+ (j2.getPrimerCarta()).getValorNombre(atributoElegido)
						+ " " + valorCartaJugador2sinEfecto
						+ ", se le aplico la pocima "
						+ j2.getPrimerCarta().getPocima().getNombre()
						+ " con valor resultante " + valorCartaJugador2);
			} else {
				System.out.println(j2.getPrimerCarta().toString());
				System.out.println("La carta de " + j2.getNombre() + " es "
						+ (j2.getPrimerCarta()).getNombre() + " con "
						+ (j2.getPrimerCarta()).getValorNombre(atributoElegido)
						+ " " + valorCartaJugador2);
			}

			if (valorCartaJugador1 > valorCartaJugador2) {
				System.out.println("Gana la ronda jugador 1 - "
						+ j1.getNombre());

				j1.addCarta(j1.getPrimerCarta());
				j1.deleteCarta(j1.getPrimerCarta()); // Gana el jugador 1
				j1.addCarta(j2.getPrimerCarta());
				j2.deleteCarta(j2.getPrimerCarta());
				this.turnoJugador = true;
				// Agregar la carta al mazo del jugador1 junto con la del j2
				// pero al final de su mazo
				// Sacarle la carta al jugador 2

			} else if (valorCartaJugador1 < valorCartaJugador2) {
				System.out.println("Gana la ronda jugador 2 - "
						+ j2.getNombre());

				j2.addCarta(j2.getPrimerCarta());
				j2.deleteCarta(j2.getPrimerCarta()); // Gana el jugador 2
				j2.addCarta(j1.getPrimerCarta());
				j1.deleteCarta(j1.getPrimerCarta());
				this.turnoJugador = false;

				// Agregar la carta al mazo del jugador2 junto con la del j1
				// pero al final de su mazo
				// Sacarle la carta al jugador 1

			} else {
				// Empate

				j1.addCarta(j1.getPrimerCarta());
				j1.deleteCarta(j1.getPrimerCarta());
				j2.addCarta(j2.getPrimerCarta());
				j2.deleteCarta(j2.getPrimerCarta());
				this.turnoJugador = true;
				// Las cartas de ambos jugadores pasan al final de su mazo y se
				// sigue
				// jugando con la siguiente carta, manteniendo el turno del
				// jugador.

			}

			System.out.println(j1.getNombre() + " tiene "
					+ j1.getCantidadDeCartasEnMazo() + " cartas y "
					+ j2.getNombre() + " tiene "
					+ j2.getCantidadDeCartasEnMazo() + " cartas.");

			if (j1.getCantidadDeCartasEnMazo() == 0) {
				System.out.println("El juego fue ganado por " + j2.getNombre()
						+ " porque " + j1.getNombre() + " tiene a 0 cartas");
				return;
			} else if (j2.getCantidadDeCartasEnMazo() == 0) {
				System.out.println("El juego fue ganado por " + j1.getNombre()
						+ " porque " + j2.getNombre() + " tiene a 0 cartas");
				return;
			}

			System.out.println("\n");

		}

		System.out.println("-----------------------------------");

		if ((j1.getCantidadDeCartasEnMazo() >= 1)
				&& (j2.getCantidadDeCartasEnMazo() >= 1)) {
			if (j1.getCantidadDeCartasEnMazo() > j2.getCantidadDeCartasEnMazo()) {
				System.out.println("El juego fue ganado por " + j1.getNombre()
						+ " porque tiene mas cartas que " + j2.getNombre());
			} else if (j1.getCantidadDeCartasEnMazo() < j2
					.getCantidadDeCartasEnMazo()) {
				System.out.println("El juego fue ganado por " + j2.getNombre()
						+ " porque tiene mas cartas que " + j1.getNombre());
			} else {
				System.out.println("El juego termino en empate");
			}
		}

	}

	public void generarMazo() {
		// URL url = getClass().getResource(jsonFile);
		File jsonInputFile = new File(this.mazoPath);
		InputStream is;
		try {
			is = new FileInputStream(jsonInputFile);
			// Creo el objeto JsonReader de Json.
			JsonReader reader = Json.createReader(is);
			// Obtenemos el JsonObject a partir del JsonReader.
			JsonArray cartas = (JsonArray) reader.readObject().getJsonArray(
					"cartas");
			for (JsonObject carta : cartas.getValuesAs(JsonObject.class)) {
				String nombreCarta = carta.getString("nombre");
				JsonObject atributos = (JsonObject) carta
						.getJsonObject("atributos");

				ArrayList<Atributo> listaAtributos = new ArrayList<Atributo>();

				Set<Entry<String, JsonValue>> kvPairs = atributos.entrySet();

				for (Entry<String, JsonValue> kvPair : kvPairs) {
					Atributo a = new Atributo(kvPair.getKey(),
							atributos.getInt(kvPair.getKey()));
					listaAtributos.add(a);
				}

				Carta c = new Carta(nombreCarta, listaAtributos);
				if (mazo.verificarCarta(c)) {
					mazo.add(c); // Verifico si tienen los mismos atributos
									// antes de ponerla en el mazo
				} else {
					System.out.println("Se encontró una carta trampa " + c);
				}

			}
			reader.close();

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void agregarPocimaAlMazoDelJuego(Pocima pocima) {
		mazo.addPocima(pocima);
	}

	public void repartirMazo(Mazo mazo, Jugador j1, Jugador j2) {
		Mazo mazoJugador1 = new Mazo();
		Mazo mazoJugador2 = new Mazo();

		// Recorre el mazo y reparte dependiendo la cantidad de pocimas

		for (int i = 0; i < mazo.getCantidadCartas(); i++) { /* Correcion */
			if (mazo.cantPocimas() > 0) {
				mazo.repartirPocima(i);
			}
			if ((i % 2 == 0) || (i == 0)) {
				mazoJugador1.add(mazo.getCarta(i));
				j1.setMazo(mazoJugador1);
			} else {
				mazoJugador2.add(mazo.getCarta(i));
				j2.setMazo(mazoJugador2);
			}
		}
	}

	public boolean isTurnoJugador() {
		return turnoJugador;
	}

	public void setTurnoJugador(boolean turnoJugador) {
		this.turnoJugador = turnoJugador;
	}

}
