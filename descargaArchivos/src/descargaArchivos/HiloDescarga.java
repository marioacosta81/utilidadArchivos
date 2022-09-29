package descargaArchivos;

public class HiloDescarga extends Thread {

	private String url;
	private byte[] array;

	public byte[] getArray() {
		return array;
	}

	public HiloDescarga(String url) {
		this.url = url;
	}

	public void run() {
		DescargaUtil util = new DescargaUtil();
		this.array = util.getFileUrl(url);
	}

}
