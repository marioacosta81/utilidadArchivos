package descargaArchivos;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.net.URLConnection;
import java.util.Calendar;

public class DescargaUtil {

	public byte[] getFileUrl(String url) {

		try {
			System.out.println("\nempezando descarga: \n");
			System.out.println(">> URL: " + url);
			URLConnection conn = new URL(url).openConnection();
			conn.connect();
			System.out.println(">> tamaño: " + conn.getContentLength() + " bytes");
			System.out.println(Calendar.getInstance().getTime().toString() + "   inicio ");

			InputStream in = conn.getInputStream();
			OutputStream out = new ByteArrayOutputStream();
			int b = 0;
			while (b != -1) {
				b = in.read();
				if (b != -1)
					out.write(b);
			}
			System.out.println(Calendar.getInstance().getTime().toString() + "   termina descarga ");
			return ((ByteArrayOutputStream) out).toByteArray();

		} catch (IOException ex) {
			ex.printStackTrace();
			System.out.println("la url:  no es valida!");
			return null;
		}

	}

}
