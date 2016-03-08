<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%> 
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" 
"http://www.w3.org/TR/html4/loose.dtd"> 
<html>
<head>

<link rel="stylesheet" type="text/css" href="resources/css/style1.css">
<script src ="resources/scripts/jquery-2.0.0.js"></script>
<script src ="resources/scripts/jquery-ui-1.10.3.custom.js"></script>


<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title><tiles:insertAttribute name="title" ignore="true" /></title> 

</head> 
<body> 
<table border="1" cellpadding="2" cellspacing="2" align="center"> 
    <tr> 
        <td height="90" colspan="12"><tiles:insertAttribute name="header" /> 
        </td> 
    </tr> 
    <tr> 
        <td width="850"><tiles:insertAttribute name="body" /></td> 
    </tr> 
    <tr> 
        <td height="90" colspan="12"><tiles:insertAttribute name="footer" /> 
        </td> 
    </tr> 
</table> 
</body> 
</html>