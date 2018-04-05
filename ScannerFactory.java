import java.util.Scanner;

public class ScannerFactory {
	private static Scanner keyboardScanner;

	public static Scanner getKeyboardScanner() {
		keyboardScanner = new Scanner(System.in);
		return keyboardScanner;
	}
	
}
