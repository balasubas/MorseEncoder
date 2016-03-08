<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%> 
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<html>

<!-- Spring url tags -->
<spring:url  var="url_to_audio" value="/toAudio"/>

<h2>Morse Code Encoder</h2>	
	
<form:form id="morseEncodeForm" method="post" action="changeToMorse.html">
   
    <table> 
	    <tr> 
	        <td><form:label id="textIn" path="textIn">Input Text Here: </form:label></td> 
	        <td><form:textarea  id="inputCode" path="textIn" rows="10" cols="50"/></td>  
	    </tr> 
	    <tr> 
	        <td><form:label path="morseOut">Morse Code: </form:label></td> 
	        <td><form:textarea id = "outputCode" path="morseOut" rows="10" cols="50"/></td> 
	    </tr> 
	    <tr> 
	        <td colspan="2"> 
              <div class="buttons" style="margin-left: 100px">
	            <input type="submit" value="Convert To Morse Code"/>
	            <input type="button" value="Close" onClick ="closeWin();"/>
                <input type="button" value="Clear" onClick ="clearText();"/>
                <input type="button" value="Encode To Audio" onClick ="soundOff();"/>
              </div>
	        </td> 
	    </tr> 
	</table>       
</form:form>
<script type="text/javascript">	
function soundOff(){
	//Submit the form to the convert to the encodeToAudio method of the  MorseController.
	$('#morseEncodeForm').attr('action','${url_to_audio}').submit();
}
function clearText(){
	//Clear both text areas
    $('#inputCode').val('');
    $('#outputCode').val('');
}    
function closeWin(){
	//This may or may not work depending on the browser
    window.close();
}
$(document).ready(function() {	
	var url_home = '/MorseEncoder/';
	//Jquery section:
	
	//Navigate back to the main menu
	$(":header").click(function(){
		window.location.href=url_home;
	});
	
	
		
});
</script>
</html>