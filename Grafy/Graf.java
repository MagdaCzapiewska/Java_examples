package graf;

import java.util.*;
import java.util.Scanner;
import java.io.*;

public class Graf {
	public static void main(String[] args) {
		Graf g = new Graf(); // Bez tego: cannot make a static reference to non-static method.
		Map<String, Set<String>> opisGrafu = g.czytaj(System.in);
		Map<String, Set<String>> spójneSkładowe = g.utwórzSpójne(opisGrafu);
		g.pisz(System.out, spójneSkładowe);
	}
	
	// Wczytuje słowa wejścia. Po wczytaniu każdej linii do zbioru wierzchołków,
	// uzupełnia mapę, której kluczem jest nazwa wierzchołka, a wartością zbiór jego sąsiadów.
	private Map<String, Set<String>> czytaj(InputStream wejście) {
		Map<String, Set<String>> opisGrafu = new HashMap<>();
		boolean byłPustyWiersz = false;
		
		try (Scanner scanner = new Scanner(wejście)){
			while(!byłPustyWiersz && scanner.hasNextLine()) {
				String wiersz = scanner.nextLine();
				Set<String> wierzchołki = wierzchołki(wiersz);
				if (wierzchołki.isEmpty()) {
					byłPustyWiersz = true;
				}
				dopisz(opisGrafu, wierzchołki);
			}
		}
		return opisGrafu;
	}
	
	// Wczytuje ścieżkę (zbiór wierzchołków).
	private Set<String> wierzchołki(String wiersz) {
		Set<String> wynik = new HashSet<>();
		try (Scanner scanner = new Scanner(wiersz)) {
			while(scanner.hasNext()) {
				wynik.add(scanner.next());
			}
		}
		return wynik;
	}
	
	// Uzupełnia mapę, której kluczem jest nazwa wierzchołka, a wartością zbiór jego sąsiadów.
	private void dopisz(Map<String, Set<String>> opisGrafu, Set<String> wierzchołki) {
		if (!wierzchołki.isEmpty()) {
			Object[] ścieżka = wierzchołki.toArray();
			Set<String> sąsiedzi;
			if (ścieżka.length == 1) {
				if (!opisGrafu.containsKey(ścieżka[0])) {
					sąsiedzi = new HashSet<>();
					opisGrafu.put(ścieżka[0].toString(), sąsiedzi);
				}
			}
			else {
				for (int i = 0; i < ścieżka.length - 1; ++i) {
					infoŻeSąsiedzi(opisGrafu, ścieżka, i, i + 1);
					infoŻeSąsiedzi(opisGrafu, ścieżka, i + 1, i);
				}
			}
		}
	}
	
	// Do opisu grafu dodaje informację, że jeden wierzchołek jest sąsiadem drugiego.
	private void infoŻeSąsiedzi(Map<String, Set<String>> opisGrafu, Object[] ścieżka, int i, int j) {
		if (!ścieżka[i].equals(ścieżka[j])) { // Chcę ignorować informacje o cyklach.
			Set<String> sąsiedzi;
			if (opisGrafu.containsKey(ścieżka[i])) {
				sąsiedzi = opisGrafu.get(ścieżka[i]);
			}
			else {
				sąsiedzi = new HashSet<>();
				opisGrafu.put(ścieżka[i].toString(), sąsiedzi);
			}
			sąsiedzi.add(ścieżka[j].toString());
		}
		
	}
	
	// Na podstawie opisu grafu wyodrębnia spójne składowe.
	private Map<String, Set<String>> utwórzSpójne(Map<String, Set<String>> opisGrafu) {
		Map<String, Set<String>> spójneSkładowe = new HashMap<>();
		while (!opisGrafu.isEmpty()) {
			Set<String> spójnaSkładowa = new HashSet<>();
			Set<String> klucze = new HashSet<>();
			
			String pierwszy = opisGrafu.keySet().iterator().next();
			spójnaSkładowa.add(pierwszy);
			klucze.add(pierwszy);
			Set<String> moiSąsiedzi = opisGrafu.get(pierwszy);
			jednaSpójna(opisGrafu, spójnaSkładowa, klucze, pierwszy, moiSąsiedzi);
			opisGrafu.remove(pierwszy);
			
			SortedSet<String> uporządkowana = new TreeSet<>(spójnaSkładowa);
			spójneSkładowe.put(uporządkowana.iterator().next(), uporządkowana);
		}
		
		return spójneSkładowe;
	}
	
	// Za pomocą rekurencji wyodrębnia jedną spójną składową.
	private void jednaSpójna(Map<String, Set<String>> opisGrafu, Set<String> spójnaSkładowa, 
							 Set<String> klucze, String pierwszy, Set<String> moiSąsiedzi) {
		if (!moiSąsiedzi.isEmpty()) {
			spójnaSkładowa.addAll(moiSąsiedzi);
			klucze.addAll(moiSąsiedzi);
			for (String s: moiSąsiedzi) {
				opisGrafu.get(s).removeAll(klucze);
				jednaSpójna(opisGrafu, spójnaSkładowa, klucze, s, opisGrafu.get(s));
				opisGrafu.remove(s);
			}
		}
	}
	
	// Wypisuje spójne składowe w porządku leksykograficznym.
	private void pisz(PrintStream wyjście, Map<String, Set<String>> spójneSkładowe) {
		SortedSet<String> wynik = new TreeSet<>(spójneSkładowe.keySet());
		for (String s: wynik) {
			String poprzednik = "";
			for (String w: spójneSkładowe.get(s)) {
				wyjście.print(poprzednik + w);
				poprzednik = " ";
			}
			wyjście.println();
		}
	}
}

