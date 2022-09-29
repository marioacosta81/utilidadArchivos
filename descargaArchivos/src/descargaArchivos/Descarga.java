package descargaArchivos;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.Calendar;

public class Descarga {

	public static void main(String[] args) {
		System.out.println("Hola");
		try {

			String url = "http://cfdisat.blob.core.windows.net/lco/LCO_2020-06-04_1.XML.gz"; // dirección url del
																								// recurso a descargar
			String name = "lineadecodigo.jpg"; // nombre del archivo destino

			// Directorio destino para las descargas
			String folder = "descargas/";

			// Crea el directorio de destino en caso de que no exista
			File dir = new File(folder);

			if (!dir.exists())
				if (!dir.mkdir())
					return; // no se pudo crear la carpeta de destino

			File file = new File(folder + name);

			URLConnection conn = new URL(url).openConnection();
			conn.connect();
			System.out.println("\nempezando descarga: \n");
			System.out.println(">> URL: " + url);
			System.out.println(">> Nombre: " + name);
			System.out.println(">> tamaño: " + conn.getContentLength() + " bytes");
			System.out.println(Calendar.getInstance().getTime().toString() + "   inicio ");

			InputStream in = conn.getInputStream();
			OutputStream out = new ByteArrayOutputStream(); // FileOutputStream(file);

			int b = 0;
			while (b != -1) {
				b = in.read();
				if (b != -1)
					out.write(b);
			}
			System.out.println(Calendar.getInstance().getTime().toString() + "   fin ");
			System.out.println("  fin ");

		} catch (MalformedURLException e) {
			System.out.println("la url:  no es valida!");
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
