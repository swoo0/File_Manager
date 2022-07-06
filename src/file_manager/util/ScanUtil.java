package file_manager.util;

import java.util.Scanner;

public class ScanUtil {

	private static Scanner scan = new Scanner(System.in);
	
	public static String next(){
		return scan.next();
	}
	
	public static String nextLine(){
		return scan.nextLine();
	}
	
	public static int nextInt(){
		return Integer.parseInt(scan.nextLine());
	}
}
