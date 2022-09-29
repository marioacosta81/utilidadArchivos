package descargaArchivos;

public class Descarga2 {

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

			DescargaUtil util = new DescargaUtil();
			byte[] array1 = util.getFileUrl(url1);
			byte[] array2 = util.getFileUrl(url2);
			byte[] array3 = util.getFileUrl(url3);
			byte[] array4 = util.getFileUrl(url4);
			byte[] array5 = util.getFileUrl(url5);
			byte[] array6 = util.getFileUrl(url6);
			byte[] array7 = util.getFileUrl(url7);

			System.out.println("  fin ");

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
