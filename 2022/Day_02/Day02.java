import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Day02 {

	public static long startTime = System.currentTimeMillis();
	
	public static void main(String[] args) throws FileNotFoundException {
		
		ArrayList<String> input = readFile("Dec2_2022.txt");
		
		//Part 1
		char[] elfMove = new char[input.size()];
		char[] personMove = new char[input.size()];
		int rocks = 0; int papers = 0; int scissors = 0;
		int wins = 0; int draws = 0;
		
		for (int i = 0; i < input.size(); i++) {
			elfMove[i] = input.get(i).charAt(0);
			personMove[i] = input.get(i).charAt(input.get(i).length()-1);
		}
		
		for (int i = 0; i < input.size(); i++) {
			if (personMove[i] == 'X')
				rocks++;
			else if (personMove[i] == 'Y')
				papers++;
			else if (personMove[i] == 'Z') 
				scissors++;
			if ((personMove[i] == 'X' && elfMove[i] == 'C') || (personMove[i] == 'Y' && elfMove[i] == 'A') || (personMove[i] == 'Z' && elfMove[i] == 'B'))
				wins++;
			else if ((personMove[i] == 'X' && elfMove[i] == 'A') || (personMove[i] == 'Y' && elfMove[i] == 'B') || (personMove[i] == 'Z' && elfMove[i] == 'C'))
				draws++;
		}
		
		int points = rocks + (papers*2) + (scissors*3) + (draws*3) + (wins*6);
		System.out.println("Part 1: " + points + duration());
		
		
		//Part 2
		rocks = 0;
		papers = 0;
		scissors = 0;
		wins = 0;
		draws = 0;
		points = 0;
		
		for (int i = 0; i < input.size(); i++) {
			if (personMove[i] == 'Y')
				draws++;
			else if (personMove[i] == 'Z') 
				wins++;
			if ((personMove[i] == 'X' && elfMove[i] == 'B') || (personMove[i] == 'Y' && elfMove[i] == 'A') ||  (personMove[i] == 'Z' && elfMove[i] == 'C'))
				rocks++;
			if ((personMove[i] == 'X' && elfMove[i] == 'C') || (personMove[i] == 'Y' && elfMove[i] == 'B') ||  (personMove[i] == 'Z' && elfMove[i] == 'A'))
				papers++;
			if ((personMove[i] == 'X' && elfMove[i] == 'A') || (personMove[i] == 'Y' && elfMove[i] == 'C') ||  (personMove[i] == 'Z' && elfMove[i] == 'B'))
				scissors++;
		}
		
		points = rocks + (papers*2) + (scissors*3) + (draws*3) + (wins*6);
		System.out.println("Part 2: " + points + duration());
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
