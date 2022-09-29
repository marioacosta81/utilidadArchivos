package descargaArchivos;

import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.google.common.io.ByteSource;

public class Descarga6 {

	private static List<Download> listArrays = new ArrayList<Download>();

	public static void main(String[] args) {
		System.out.println("Hola");
		try {

			String url1 = "http://cfdisat.blob.core.windows.net/lco/l_RFC_2020_06_04_1.txt.gz";
//			String url2 = "http://cfdisat.blob.core.windows.net/lco/l_RFC_2020_06_04_2.txt.gz";
//			String url3 = "http://cfdisat.blob.core.windows.net/lco/l_RFC_2020_06_04_3.txt.gz";
//			String url4 = "http://cfdisat.blob.core.windows.net/lco/l_RFC_2020_06_04_4.txt.gz";
//			String url5 = "http://cfdisat.blob.core.windows.net/lco/l_RFC_2020_06_04_5.txt.gz";
//			String url6 = "http://cfdisat.blob.core.windows.net/lco/l_RFC_2020_06_04_6.txt.gz";
//			String url7 = "http://cfdisat.blob.core.windows.net/lco/l_RFC_2020_06_04_7.txt.gz";

//			String[] urlArray = new String[] { url1, url2, url3, url4, url5, url6, url7 };

			String[] urlArray = new String[] { url1 };
			for (String url : urlArray) {
				HiloDescargaInternal hd = new HiloDescargaInternal(url);
				// hd.start();
				hd.run();

			}
//			while (true) {
//				if (listArrays.size() > 6) {
//					break;
//				}
//			}

			System.out.println("  fin ");

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	private static class HiloDescargaInternal extends Thread {

		private String url;

		public HiloDescargaInternal(String url) {
			this.url = url;
		}

		public void run() {
			try {
				// Thread.sleep(3000);

				// descarga del archivo
//				DescargaUtil util = new DescargaUtil();
				// byte[] array = util.getFileUrl(url);

				
//				byte[] array = Files.readAllBytes(Paths.get("C:\\Users\\mario\\Desktop\\brechasSat\\bigFiles\\LCO_2020-06-02_1.XML.gz"));
//				InputStream in2 = ByteSource.wrap(array).openStream();
				
				byte[] array = Files.readAllBytes(Paths.get("C:\\Users\\mario\\Desktop\\brechasSat\\bigFiles\\LCO_2020-06-02_1.XML\\LCO_2020-06-02_1.XML"));
//				InputStream in2 = ByteSource.wrap(array).openStream();
				
				
				// descomprimir archivo
				//byte[] array2 = ExtractUtils2.extractTarGZ(in2);

				// lectura linea por linea con streamng
				InputStream targetStream = ByteSource.wrap(array).openStream();
				Scanner sc = new Scanner(targetStream, StandardCharsets.UTF_8.name());
				long cont = 0L;
				System.out.println("**********************************************************************");
				while (sc.hasNextLine()) {
					String line = sc.nextLine();
					System.out.println(line);
					cont++;
					if(cont>100) { break;}
						
					// System.out.println(line);
				}
				// note that Scanner suppresses exceptions
				if (sc.ioException() != null) {
					throw sc.ioException();
				}

				// llenado de lista general
				Download download = new Download();
				download.byteArray = array;
				download.countLines = cont;
				synchronized (listArrays) {
					listArrays.add(download);
				}

				System.out.println("termina run " + url);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

	}

}
