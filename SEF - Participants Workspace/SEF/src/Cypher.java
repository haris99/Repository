import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Cypher {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int key = 3;
		String newString = "";
		FileInputStream fstream = null;
		BufferedReader br = null;
		String strLine = "";
		try {
			File file = new File("C:\\SEF - Participants Workspace\\SEF - Participants Workspace\\SEF\\src\\file.txt");
			fstream = new FileInputStream(file);
			br = new BufferedReader(new InputStreamReader(fstream));
			while ((strLine = br.readLine()) != null) {
				char arr[] = strLine.toCharArray();

				for (char c : arr) {
					c = (char) (int) (Integer.valueOf(c) + key);
					newString = newString + String.valueOf(c);
				}

			}

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		int guessKey;
		boolean finished = false;
		System.out.println(newString);
		String Cypher = newString;
		while (finished == false) {
			newString = Cypher;
			System.out.println("Input cypher");
			guessKey = sc.nextInt();
			char arr[] = newString.toCharArray();
			newString = "";
			for (char c : arr) {
				c = (char) (int) (Integer.valueOf(c) - guessKey);
				newString = newString + String.valueOf(c);
			}
			System.out.println(newString);
		}
		// Close the input stream
		try {
			br.close();
			sc.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
