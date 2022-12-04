import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Day04 {

	public static long startTime = System.currentTimeMillis();
	
	public static void main(String[] args) throws FileNotFoundException {
		
		ArrayList<String> input = readFile("Dec4_2022.txt");
		
		int contains = 0; //For Part 1
		int overlaps = 0; //For Part 2
		
		for (String str : input) {
			String[] elves = str.split(",");
			String[] elf1 = elves[0].split("-");
			String[] elf2 = elves[1].split("-");
			int elf1Low = Integer.parseInt(elf1[0]);
			int elf1High = Integer.parseInt(elf1[1]);
			int elf2Low = Integer.parseInt(elf2[0]);
			int elf2High = Integer.parseInt(elf2[1]);
			
			//Part 1
			if ((elf1Low <= elf2Low && elf1High >= elf2High) || (elf1Low >= elf2Low && elf1High <= elf2High))
				contains++;
			
			
			//Part 2
			if ((elf2Low <= elf1Low && elf2High >= elf1Low) || (elf2Low <= elf1High && elf2High >= elf1High))
				overlaps++;
			else if ((elf1Low <= elf2Low && elf1High >= elf2Low) || (elf1Low <= elf2High && elf1High >= elf2High))
				overlaps++;
		}
		
		System.out.println("Part 1: " + contains + duration());
		System.out.println("Part 2: " + overlaps + duration());
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
