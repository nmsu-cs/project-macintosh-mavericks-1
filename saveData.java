
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.Buffer;
import java.util.ArrayList;
import java.util.Properties;
import java.util.Scanner;

import javax.swing.JLabel;

public class saveData {

	// This needs to make use of a JSON or something
	public static void save(ArrayList<String> tasks){

		int counter = 1;

		try {
			
			FileWriter writer = new FileWriter("saveData.txt");

			for (String task: tasks){
				writer.write("Task" + counter++ + ": " + task +"\n");
			}

			writer.close();

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e){
			e.printStackTrace();
		}
	}

	// This needs some work
	public static ArrayList<String> load(){

		ArrayList<String> taskPayload = new ArrayList<>();

		try {
			
			FileReader fis = new FileReader("./saveData.txt");
			BufferedReader reader = new BufferedReader(fis);
            Scanner scanner = new Scanner(reader);

			while (scanner.hasNext()){
				taskPayload.add(scanner.next());
			}

			scanner.close();
			reader.close();
			fis.close();

		} catch (FileNotFoundException e){
			e.printStackTrace();
		} catch (IOException e){
			e.printStackTrace();
		}

		return taskPayload;
	}
}
