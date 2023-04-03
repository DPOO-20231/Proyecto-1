package modelo;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class LectorArchivos {
	public ArrayList<String> leerArchivo(String nombreArchivo) throws IOException{
		
		ArrayList<String> info = new ArrayList<String>();
		
		nombreArchivo = "data\\" + nombreArchivo;
		File archivo = new File(nombreArchivo);
		BufferedReader lector = new BufferedReader(new FileReader(archivo));
		String linea = lector.readLine();
		
		while (linea != null) {
			
			info.add(linea);
			
			linea = lector.readLine();
		}
		
		lector.close();
		return info;
		
	}
}
