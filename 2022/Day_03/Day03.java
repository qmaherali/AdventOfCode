import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Day03 {

	public static long startTime = System.currentTimeMillis();
	
	public static void main(String[] args) throws FileNotFoundException {
		
		ArrayList<String> input = readFile("Dec3_2022.txt");
		
		//Part 1
		long sum = 0;
		
		for (String str : input) {
			int half = str.length()/2;
			String s = str.substring(half);
			for (int i = 0; i < half; i++) {
				char c = str.charAt(i);
					if (s.contains(String.valueOf(c))) {
						if (c <= 'Z')
							sum += (c - 'A') + 27;
						else
							sum += (c - 'a') + 1;
						break;
				}
			}
		}
		
		System.out.println("Part 1: " + sum + duration());
		
		
		//Part 2
		sum = 0;
		
		ArrayList<Character> chars = new ArrayList<>();
		ArrayList<Character> badge = new ArrayList<>();
		
		for (int i = 0; i < input.size(); i += 3) {
			for (Character c : input.get(i).toCharArray()) {
				if (input.get(i+1).contains(String.valueOf(c)) && input.get(i+2).contains(String.valueOf(c)))
					badge.add(c);
			}
			
			char c = badge.get(badge.size()-1);
			
			if (c <= 'Z')
				sum += (c - 'A') + 27;
			else
				sum += (c - 'a') + 1;
		}
		
		System.out.println("Part 2: " + sum + duration());
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
