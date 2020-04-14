package it.polito.tdp.sspellchecker.model;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.EnumMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Model {

	Map<String, String> dizionari = new LinkedHashMap<String, String>();

	public Model() {
		// dizionari = new LinkedHashMap<String,String>();

	}

	public enum Lingua {

		ITALIAN, ENGLISH

	}

	public List<String> spellcheck(Lingua lingua, String text) {

		// inizializzo dizionario
		List<String> parole = new LinkedList<String>();

		String directory="src/main/resources/";
		switch (lingua) {
		case ITALIAN:
			directory += "Italian.txt";
			//System.out.println("Caso italiano");
			break;
		case ENGLISH:
			directory += "English.txt";
			//System.out.println("Caso inglese");
			break;
		default:
			System.out.println("Errore dizionario mancante");
			
		}
		try {
			FileReader fr = new FileReader(directory);
			BufferedReader br = new BufferedReader(fr);
			String word;
			while ((word = br.readLine()) != null) {
				parole.add(word);
			}
			br.close();

		} catch (IOException e) {
			System.out.println("Errore apertura file");
		}
		// divido il testo
		String[] textSplitted = text.split("\\s+");
		// controllo errori
		List<String> errori = new LinkedList<String>();
		 for(String s:textSplitted) {
			 if(parole.contains(s)!=true)errori.add(s);
		 }
		return errori;

	}
	
	

}
