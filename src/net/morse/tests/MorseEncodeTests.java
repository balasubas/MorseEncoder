package net.morse.tests;

import static org.junit.Assert.*;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Properties;



import net.morse.encode.EncodeToMorse;

import org.junit.Before;
import org.junit.Test;

public class MorseEncodeTests {

	private HashMap<String,String> morseMap = null;
	private final String OUTPUT = ".- ... .-.";
	private final String INPUT ="ABC";
	EncodeToMorse emc = null;
	
	@Before
	public void init() {
		morseMap = new HashMap<>();
		populate();
		emc = new EncodeToMorse(morseMap);

	}
	
	@Test
	public void convertToMorseTest(){
		equals(emc.encode(INPUT) == OUTPUT);
	}
	
	
	
	//Load the hashmap with morse code and alpha mappings
		private void populate(){
			
			try {
				InputStream in = new FileInputStream("main/resources/morse.properties");
				Properties prop = new Properties();
				prop.load(in);
				
				for(Object g: prop.keySet()){
					String letter = (String) g;
					String morse = (String) prop.get(g);
					morseMap.put(letter, morse);
				}
				
				in.close();
				
			} catch (IOException e) {
				e.printStackTrace();
			}
			
		}

}
