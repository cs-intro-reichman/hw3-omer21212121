/** Functions for checking if a given string is an anagram. */
public class Anagram {
	public static void main(String args[]) {
		// Tests the isAnagram function.
		System.out.println(isAnagram("silent","listen"));  // true
		System.out.println(isAnagram("William Shakespeare","I am a weakish speller")); // true
		System.out.println(isAnagram("Madam Curie","Radium came")); // true
		System.out.println(isAnagram("Tom Marvolo Riddle","I am Lord Voldemort")); // true

		// Tests the preProcess function.
		System.out.println(preProcess("What? No way!!!"));
		
		// Tests the randomAnagram function.
		System.out.println("silent and " + randomAnagram("silent") + " are anagrams.");
		
		// Performs a stress test of randomAnagram 
		String str = "1234567";
		Boolean pass = true;
		//// 10 can be changed to much larger values, like 1000
		for (int i = 0; i < 10; i++) {
			String randomAnagram = randomAnagram(str);
			System.out.println(randomAnagram);
			pass = pass && isAnagram(str, randomAnagram);
			if (!pass) break;
		}
		System.out.println(pass ? "test passed" : "test Failed");
	}  

	// Returns true if the two given strings are anagrams, false otherwise.
	public static boolean isAnagram(String str1, String str2) {
		String a = preProcess(str1);
		String b = preProcess(str2);
		
		if (a.length() != b.length()){
			return false;
		}
		
		for (int i = 0; i < a.length(); i++){
			char j = a.charAt(i);
			int countA = 0;
			int countB = 0;
			
			for (int k = 0; k < a.length(); k++){
				if (a.charAt(k) == j){
					countA++;
				}
			}
			
			for (int l = 0; l < b.length(); l++){
				if (b.charAt(l) == j){
					countB++;
				}
			}
			
			if (countA != countB){
				return false;
			}
		}
		
		return true;
	}
	   
	// Returns a preprocessed version of the given string: all the letter characters are converted
	// to lower-case, and all the other characters are deleted, except for spaces, which are left
	// as is. For example, the string "What? No way!" becomes "whatnoway"
	public static String preProcess(String str) {
		String result = "";
		int i;
		for (i=0; i<str.length();i++){
			char j = str.charAt(i); 
			if ((j<='z')&&(j>='a') || ((j<='Z')&&(j>='A'))) {
				result = result + Character.toLowerCase(j);
			}
			}
		

		return result;
	} 
	   
	// Returns a random anagram of the given string. The random anagram consists of the same
	// characters as the given string, re-arranged in a random order. 
	public static String randomAnagram(String str) {
		String result = "";
		String remaining = str;
		
		while (remaining.length() > 0){
			int randomIndex = (int)(Math.random() * remaining.length());
			char randomChar = remaining.charAt(randomIndex);
			result = result + randomChar;
			remaining = remaining.substring(0, randomIndex) + remaining.substring(randomIndex + 1);
		}
		
		return result;
	}
}


