package descargaArchivos;

import java.util.ArrayList;
import java.util.List;

public class Descarga3 {

	public static void main(String[] args) {
		System.out.println("Hola");
		try {

			String url1 = "http://cfdisat.blob.core.windows.net/lco/LCO_2020-06-04_1.XML.gz";
			String url2 = "http://cfdisat.blob.core.windows.net/lco/LCO_2020-06-04_2.XML.gz";
			String url3 = "http://cfdisat.blob.core.windows.net/lco/LCO_2020-06-04_3.XML.gz";
			String url4 = "http://cfdisat.blob.core.windows.net/lco/LCO_2020-06-04_4.XML.gz";
			String url5 = "http://cfdisat.blob.core.windows.net/lco/LCO_2020-06-04_5.XML.gz";
			String url6 = "http://cfdisat.blob.core.windows.net/lco/LCO_2020-06-04_6.XML.gz";
			String url7 = "http://cfdisat.blob.core.windows.net/lco/LCO_2020-06-04_7.XML.gz";

			String[] urlArray = new String[] { url1, url2, url3, url4, url5, url6, url7 };
			DescargaUtil util = new DescargaUtil();

			List<byte[]> listArrays = new ArrayList<byte[]>();

			for (String url : urlArray) {
				byte[] array = util.getFileUrl(url);
				listArrays.add(array);
			}

			System.out.println("  fin ");

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
