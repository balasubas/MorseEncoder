package net.morse.controller;


import net.morse.encode.EncodeToMorse;
import net.morse.form.MorseForm;
import net.wave.converter.TextToSound;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * The Class MorseController.
 */
@Controller
public class MorseController {
	
	/** The temp txt. */
	private String tempTxt="";

	
	//This was declared as a bean in the dispatch servlet file and so it is instantiated upon application startup. 
	//No need to instantiate.
	/** The convert. */
	@Autowired
	private EncodeToMorse convert; 
	
	/**
	 * This is the main morse page where the text area and all buttons are displayed.
	 * 
	 * As per Spring specifications the method is mapped to a URI which
	 * is called by the front end jsp page 
	 *
	 * @param toMorse the to morse
	 * @param result the result
	 * @return the string
	 */
    @RequestMapping(value = "/changeToMorse", method = RequestMethod.POST) 
    public String morseMain(@ModelAttribute("toMorse") 
    MorseForm toMorse, BindingResult result) { 
    	tempTxt = toMorse.getTextIn();
    	
    	//redirect the form data to encodeToMorse() controller method
        return "redirect:toMorse.html"; 
    } 
    
    /**
     * Once the user clicks the button to encode an alpha String into morse
     * the front end sends the request to this URI for encoding.
     *
     * @return the model and view
     */
    @RequestMapping("/toMorse") 
    public ModelAndView encodeToMorse() { 
    	String tempMorseOut="";
    	MorseForm tempForm = new MorseForm();
    	tempForm.setTextIn(tempTxt);
    	
    	if(tempTxt.length() > 0){
	    	tempMorseOut = convert.encode(tempTxt);
	    	tempForm.setMorseOut(tempMorseOut);
    	}
        return new ModelAndView("toMorse", "command", tempForm); 
    }
    
    /**
     * This encodes the morse code output into an audio stream. 
     * The classes responsible for ebcoding text to audio are found in the
     * MorseWave class. The MorseWave source code will be included in the
     * portfolio.
     *
     * @param toMorse the to morse
     * @param result the result
     * @return the model and view
     */
    @RequestMapping("/toAudio")
    public ModelAndView encodeToAudio(@ModelAttribute("toMorse") 
    MorseForm toMorse, BindingResult result){
    	
    	String converted = toMorse.getMorseOut();
    	
    	if((converted != null) && (converted.length() > 0)){
	    	//Instantiate the text to sound class
	    	TextToSound tts = new TextToSound();
	    	
	    	//Split the string into an array
	    	String[] morse = converted.split("|");
	    	
	    	//This method encodes each morse code string into a sound
	    	tts.inFeed(morse);
	    	
	    	//Play the encoded string into audio,
	    	tts.stream();
    	}
    	return new ModelAndView("toMorse", "command", toMorse); 
    	
    }

}
