
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class saveData {

	public static void saveTasks(ArrayList<String> tasks) {
		try (FileWriter writer = new FileWriter("saveData.txt", false)) {
			for (String task : tasks) {
				writer.write(task + "\n");
			}
		} catch (IOException e) {
			System.err.println("Failed to write to saveData.txt: " + e.getMessage());
		}
	}	

	public static ArrayList<String> loadTasks() {
		ArrayList<String> taskPayload = new ArrayList<>();
		try (FileReader fis = new FileReader("./saveData.txt");
			 BufferedReader reader = new BufferedReader(fis);
			 Scanner scanner = new Scanner(reader)) {
	
			while (scanner.hasNextLine()) {  
				taskPayload.add(scanner.nextLine());
			}

		} catch (FileNotFoundException e) {
			System.err.println("saveData.txt not found: " + e.getMessage());
		} catch (IOException e) {
			System.err.println("Failed to read from saveData.txt: " + e.getMessage());
		}
		return taskPayload;
	}

	public static void saveXP(int level, int levelProgress) {
		try (FileWriter writer = new FileWriter("./saveLevel.txt", false)) {
			writer.write("playerLevel: " + level + "\n");
			writer.write("levelProgress: " + levelProgress);
		} catch (IOException e) {
			System.err.println("Failed to write to saveDataLevel.txt: " + e.getMessage());
		}
	}	

	public static int[] loadXP() {
		int[] playerStats = new int[2]; 

		try (FileReader fis = new FileReader("./saveLevel.txt");
			 BufferedReader reader = new BufferedReader(fis);
			 Scanner scanner = new Scanner(reader)) {

				scanner.useDelimiter("[^\\d]+");
	
				if (scanner.hasNext()){
					playerStats[0] = scanner.nextInt();
					playerStats[1] = scanner.nextInt();
				}

		} catch (FileNotFoundException e) {
			System.err.println("saveData.txt not found: " + e.getMessage());
		} catch (IOException e) {
			System.err.println("Failed to read from saveData.txt: " + e.getMessage());
		}

		return playerStats;
	}
}
