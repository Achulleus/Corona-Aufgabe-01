package uebungMitConsole;

import java.util.Random;
import java.io.*;
import java.nio.channels.FileChannel;
import java.nio.file.*;

public class berechnung {
	
	private static int tage = 14;
	private static int werte = 10;
	private static int gesSumme = 0;
	private static int summe = 0;
	private static String[][] arr = new String[tage][werte];

	public static void main(String[] args) {
		Console con = System.console();
		Random ran = new Random();
		Path file = Paths.get("/Users/philipp/Documents/Htl/3.Klasse/Köllö/measurement.txt");
		byte data[];
		
		if(con != null) {
			for(int i = 0; i<tage; i++) {
				for(int j = 0; j<werte; j++) {
					int k = ran.nextInt(16) + 20;
					String s = Integer.toString(k);
					arr[i][j] = s;
				}
			 }
			 for(int i = 0; i<tage; i++) {
				for(int j = 0; j<werte; j++) {
					int k = Integer.parseInt(arr[i][j]);
					summe = summe + k;
					con.printf(arr[i][j]+",", args);
					if(j == werte -1) {
						con.printf("     Durchschnitt: "+ summe/werte);
						gesSumme = gesSumme + summe;
						summe = 0;
						System.out.println();
					}
					if(j == werte-1 && i == tage-1) {
						System.out.println();
						con.printf("Gesamt-Durchschnitts-Temperatur: "+gesSumme/(werte*tage));
					}
				}
			}
		}else {
			System.out.println("Keine Konsole vorhanden!");
		}
	}
}
