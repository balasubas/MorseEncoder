package net.morse.encode;

import java.util.HashMap;

import org.springframework.stereotype.Service;

/**
 * The Class EncodeToMorse - this is responsible for encoding a text string into morse code.
 */
@Service
public class EncodeToMorse {

//This Map is populated via the bean declared in spring-servlet.xml - it uses Spring util configuration. 
//We are no longer using Java's standard way of loading a properties file. 	
/** The morse loaded. */
private HashMap<String,String> morseLoaded;

/**
 * Instantiates a new encode to morse.
 *
 * @param morseLoaded the morse loaded
 */
public EncodeToMorse(HashMap<String,String> morseLoaded){
	this.morseLoaded = morseLoaded;
}

/**
 * Accesses the alpha to morse code conversion. 
 * We will use this to convert alpha to morse.
 *
 * @return the morse loaded
 */
public HashMap<String,String> getMorseLoaded(){
	return morseLoaded;
}

/**
 * Tester method for printing out converted code.
 */
public void printCode(){
	for(String letter:getMorseLoaded().keySet()){
		System.out.println(letter + " ---> " + getMorseLoaded().get(letter));
	}
}

/**
 * Encode the alpha text String into morse code.
 *
 * @param text the text
 * @return the string
 */
public String encode(String text){
	
	String temp = "";
	
	//Use a string builder when combining strings for better 
	//efficiency.
	StringBuilder sb = new StringBuilder();
	
	try {
		temp = text.trim();
		
		for(String g:temp.split("")){
			String encoded = getMorseLoaded().get(g.toUpperCase());
			sb.append(encoded);
			sb.append(" ");
		}
		
	}catch(NullPointerException nlp){
		return "UNABLE TO CONVERT STRING";
	}
	
	return sb.toString().replaceAll("null", "|");
}

}
