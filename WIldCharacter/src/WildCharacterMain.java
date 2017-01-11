import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class WildCharacterMain {
	public static String input = "";
	private static String[] patternArray;
	public static WildCharacter[] wilds = {new WildCharacter('#', WildCharacter.vowels), new WildCharacter('@', WildCharacter.consonants), new WildCharacter('&', WildCharacter.alphabet), new WildCharacter('*', WildCharacter.space)};
	public static void main(String[] args){
		
		try {
			patternArray = Arrays.copyOf(WildCharacter.readFromFile(), 6);
			System.out.println(patternArray[0]);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		searchforPatterns(patternArray[0]);
		//System.out.println(wilds[0].isMatch('i'));
	}
	
	
	public static void searchforPatterns(String input){
		
		for(int i = 1; i < patternArray.length; i++){
			String pattern = patternArray[i];
			for(int j = 0; j < input.length()-patternArray[i].length(); j++){
				boolean wordMatch = true;
				String toCheck = input.substring(j, j+patternArray[i].length());
				
				//System.out.println("String to Check: " + toCheck + "\nPAttern to Check: " + patternArray[i]);
				for(int k = 0; k < toCheck.length(); k++){
					boolean wildMatch = false;
					for(WildCharacter w : wilds){
						if(WildCharacter.isWildChar(patternArray[i].charAt(k), w)){
							//System.out.println(w.isMatch(toCheck.charAt(k)) + " / " + toCheck.charAt(k) + " / " + w.getSymbol());
							if(w.isMatch(toCheck.charAt(k))){
								//System.out.println("DEBUG: Matched char" + toCheck.charAt(k) + " with " + w.toString());
								wildMatch = true;
							}	
						}
					}
//					System.out.println(wildMatch);
//					System.out.println(toCheck.charAt(k) == patternArray[i].charAt(k));
//					System.out.println();
					boolean match = toCheck.charAt(k) == patternArray[i].charAt(k);
					if(!wildMatch && !match){
						//System.out.println("No match for " + toCheck + " : " + patternArray[i]);
						wordMatch = false;
					}
				}
				if(wordMatch){
					System.out.print(j + " ");
				} else{
					//System.out.println("No match");
				}
				
				
				/*if(input.substring(j, j+patternArray[i].length()).equals(patternArray[i])){
					System.out.print(j + " ");
				}*/
			}
			System.out.println();
		}
		
		
		
	}
}
