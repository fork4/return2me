<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.HashMap, java.util.Iterator,com.fork4.return2me.em.Extension" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Extensions</title>
		
		<script language="javascript" src="js/jquery-1.7.2.min.js"></script>
		<script language="javascript" src="js/jquery-ui-1.8.21.custom.min.js"></script>
		
		<link rel="stylesheet" href="css/jquery-ui-1.8.21.custom.css" type="text/css" media="all" />
		<link rel="stylesheet" href="css/r2m.css" type="text/css" media="all" />
		
		<script type="text/javascript">
		  var _gaq = _gaq || [];
  		_gaq.push(['_setAccount', 'UA-33771959-1']);		
  _gaq.push(['_trackPageview']);

  (function() {
    var ga = document.createElement('script'); ga.type = 'text/javascript'; ga.async = true;
    ga.src = ('https:' == document.location.protocol ? 'https://ssl' : 'http://www') + '.google-analytics.com/ga.js';
    var s = document.getElementsByTagName('script')[0]; s.parentNode.insertBefore(ga, s);
  })();

</script>
	</head>
	<body>

		<h2 style="color: #FFF; text-shadow: 2px 2px 2px #000; margin-left: 20px;">Return2Me Representative Console</h2>
		
		
		<div class="section" style="width: 400px; padding-bottom: 20px;">

			<form action="gen" method="post">
				<h3>Register An Extension</h3>
				<table>
					<tr>
						<td>Your Number</td> 
						<td><input type="text" name="repPhone" id="repPhone" /></td>
					</tr>
					<tr>
						<td>Customer's Number</td>
						<td><input type="text" name="custPhone" id="custPhone" value="" /></td>
					</tr>
					<tr>
						<td>One Time Use Only</td>
						<td><input type="checkbox" name="oneTimeUse" id="oneTimeUse" value="true" checked="checked" /></td>
					</tr>
					<tr>
						<td colspan="2" align="right">
						<input type="submit" name="Submit" value="Create Extension" style="width: 140px; height: 50px;">
						</td>
				</table>				
			</form>
			<br />
		</div>
		
		<br />
		

	</body>
</html>