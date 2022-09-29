package descargaArchivos;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

import org.apache.commons.compress.archivers.ArchiveEntry;
import org.apache.commons.compress.archivers.tar.TarArchiveEntry;
import org.apache.commons.compress.archivers.tar.TarArchiveInputStream;
import org.apache.commons.compress.compressors.gzip.GzipCompressorInputStream;

public class ExtractUtils {

	@SuppressWarnings(value = { "resource" })
	public static byte[] extractTarGZ(InputStream in) throws IOException {
		try {
			GzipCompressorInputStream gzipIn = new GzipCompressorInputStream(in,true);
			//try (TarArchiveInputStream tarIn = new TarArchiveInputStream(gzipIn, StandardCharsets.UTF_8.name())) {
			try (TarArchiveInputStream tarIn = new TarArchiveInputStream(gzipIn)) {
				ArchiveEntry entry = null;

				
				
				
				while ((entry = /*(TarArchiveEntry)*/ tarIn.getNextEntry()) != null) {
					/** If the entry is a directory, create the directory. **/
					if (!entry.isDirectory()) {
						byte[] data = new byte[1024];
						int count = 0;
						ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
						do {
							count = tarIn.read(data, 0, 1024);
							outputStream.write(data);

						} while (count != -1);
						return outputStream.toByteArray();
					}
				}
				System.out.println("Untar completed successfully!");
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return null;
	}

}
