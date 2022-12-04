import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;

public class Day01 {

	public static long startTime = System.currentTimeMillis();
	
	public static void main(String[] args) throws FileNotFoundException {

		ArrayList<String> list = readFile("Dec1_2022.txt");
		
		//Part 1
		ArrayList<Integer> calories = new ArrayList<Integer>();
		int currentSum = 0;
		
		for (String str: list) {
			if (str.equalsIgnoreCase("")) {
				calories.add(currentSum);
				currentSum = 0;
			}
			else {
				currentSum += Integer.parseInt(str);
			}
		}
		
		Collections.sort(calories);
		long endTime = System.currentTimeMillis();
		
		System.out.println("Part 1: " + calories.get(calories.size()-1) + duration());
		
		
		//Part 2
		int top3Sum = (calories.get(calories.size()-1)) + (calories.get(calories.size()-2)) + (calories.get(calories.size()-3));
		System.out.println("Part 2: " + top3Sum + duration());
	}
	
	public static String duration() {
		
		long endTime = System.currentTimeMillis();
		
		return ("\tDuration: " + (endTime - startTime) + "ms");
	}
	
	public static ArrayList<String> readFile (String fileName) throws FileNotFoundException {
		
		ArrayList<String> input = new ArrayList<String>();
		
		File inFile = new File(fileName);
		Scanner scan = new Scanner(inFile);
		
		while (scan.hasNext()) {
			input.add(scan.nextLine());
		}
		scan.close();
		
		return input;
	}
}
