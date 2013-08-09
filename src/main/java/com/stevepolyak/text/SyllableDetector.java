package com.stevepolyak.text;

public class SyllableDetector {
	/**
	 * Get the number of syllables for a given word
	 * @param s the given word
	 * @return the number of syllables
	 */
	public int count(String s) {
	    s = s.trim();
	    if (s.length() <= 3) {
	        return 1;
	    }
	    s = s.toLowerCase();
	    s = s.replaceAll("[aeiouy]+", "a");
	    s = "x" + s + "x";
	    return s.split("a").length - 1;
	}
	
	
	public int countSyllables(String s)
		{

		int length = s.length();
		int syllable = 0;
		boolean  vowel  = false;

		for(int i=0; i<length; i++) 
			{
			if (isVowel(s.charAt(i)) && (vowel==false)) 
			{
			vowel = true;
			syllable++;
			}// if end 
				else if (isVowel(s.charAt(i)) && (vowel==true))
				{
				vowel = true;
				}// else if end
					else 
					{
					vowel = false;
					}// else end
			}//for end

		return syllable;
		}// countSyllables end
	public static boolean isVowel(char c) {
	    if ((c == 'a') || (c == 'A')) 
		 	{ return true;  
			}//if end
	    
		 else if ((c == 'e') || (c == 'E')) 
		 	{ return true;  
			}// "e" else if end

	    else if ((c == 'i') || (c == 'I')) 
		 	{ return true;  
			}// "i" else if end

	    else if ((c == 'o') || (c == 'O')) 
		 	{ return true;  
			}// "o" else if end
	  
	    else if ((c == 'u') || (c == 'U')) 
		 	{ return true;  
			}// "u" else if end

	    else if ((c == 'y') || (c == 'Y')) 
		 	{ return true;  
		 	}// "y" else if end

	    else 
		 	{ return false; 
			}// else end
	  }// boolean end
}
