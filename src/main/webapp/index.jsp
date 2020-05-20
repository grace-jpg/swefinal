<%@ page language="java" contentType="text/html; charset=US-ASCII"
    pageEncoding="US-ASCII"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "https://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=US-ASCII">
  <script>
    var servletURL = window.location.origin;
  </script>
<title>Truth Table</title>
</head>
<body>
<h2>Truth Table</h2>
<p>please enter a boolean: </p>
<input type="text" id="fname" name="fname" placeholder=""/>

<button onclick="window.location.assign(servletURL+'/hello');">Simple servlet </button>


</body>
</html>
