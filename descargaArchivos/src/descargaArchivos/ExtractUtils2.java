package descargaArchivos;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.zip.GZIPInputStream;

public class ExtractUtils2 {

	
	public static byte[] extractTarGZ(InputStream in) throws IOException {
		byte[] buffer = new byte[1024];

		try {
			GZIPInputStream gZIPInputStream = new GZIPInputStream(in);
			int bytes_read = 0;
			while ((bytes_read = gZIPInputStream.read(buffer)) > 0) {
				ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
				do {
					bytes_read = gZIPInputStream.read(buffer);
					outputStream.write(bytes_read);

				} while (bytes_read > 0);
				return outputStream.toByteArray();
			}

			System.out.println("The file was decompressed successfully!");

		} catch (IOException ex) {
			ex.printStackTrace();
		}
		return null;
	}

}
