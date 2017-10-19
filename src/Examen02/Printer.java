package Examen02;
public class Printer {
	private Queue<String> printerSpool;
	
	public Printer() {
		printerSpool = new Queue<String>();
	}
	
	public void printDocument(String name) {
		printerSpool.offer(name);
	}
	
	public void runPrinter() throws InterruptedException {
		while(!printerSpool.isEmpty()) {
			System.out.println("Printing: " + printerSpool.remove().toString());
			Thread.sleep(5000);
		}
		System.out.println("Finished printing documents");
	}
}
