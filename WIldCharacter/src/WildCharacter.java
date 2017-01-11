import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class WildCharacter {
	private char symbol;
	public char getSymbol() {
		return symbol;
	}

	private char[] reps;
	public WildCharacter(char symbol, char[] reps){
		this.symbol = symbol;
		this.reps = Arrays.copyOf(reps, reps.length);
	}
	
	public static char[] vowels = {'a', 'e', 'i', 'o', 'u'};
	public static char[] consonants = {'b', 'c', 'd', 'f', 'g', 'h', 'j', 'k', 'l', 'm', 'n', 'p', 'q', 'r', 's', 't', 'v', 'w', 'x', 'y', 'z'};
	public static char[] alphabet = {'a', 'e', 'i', 'o', 'u', 'b', 'c', 'd', 'f', 'g', 'h', 'j', 'k', 'l', 'm', 'n', 'p', 'q', 'r', 's', 't', 'v', 'w', 'x', 'y', 'z'};
	public static char[] space = {' '};
	
	public static boolean isWildChar(char c, WildCharacter w){
		if(c == w.symbol){
			return true;
		}else{
			return false;
		}
	}
	
	public boolean isMatch(char in){
		
		for(char c : reps){
			if(c == in)
				return true;
		}
		
		return false;
	}
	
	public String toString(){
		return this.symbol + "";
	}
	
	public static String[] readFromFile() throws FileNotFoundException{
		File in = new File("file.txt");
		String[] patterns = new String[6];
		Scanner fileScanner = new Scanner(in);
		int i= 0;
		while (fileScanner.hasNextLine() && i < patterns.length) {
		  patterns[i] = fileScanner.nextLine();
		  i++;
		}
		fileScanner.close();
		
		return patterns;
	}
	
	
}