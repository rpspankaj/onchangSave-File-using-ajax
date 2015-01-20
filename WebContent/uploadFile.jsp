<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<!-- Include jTable script file. -->
<script src="js/jquery-1.8.2.js" type="text/javascript"></script>
<script src="js/jquery-ui-1.10.3.custom.js" type="text/javascript"></script>
<script src="js/jquery.jtable.js" type="text/javascript"></script>


<script>
$(function() {
                  $('#file').change(function (e) {
                    	 
                    	 var data;

                    	    data = new FormData();
                    	    data.append('file', $('#file')[0].files[0]);

                    	    $.ajax({
                    	        url: 'abc.up',
                    	        data: data,
                    	        processData: false,
                    	        type: 'POST',

                    	        // This will override the content type header, 
                    	        // regardless of whether content is actually sent.
                    	        // Defaults to 'application/x-www-form-urlencoded'
                    	        contentType: false, 

                    	        //Before 1.5.1 you had to do this:
                    	        beforeSend: function (x) {
                    	            if (x && x.overrideMimeType) {
                    	                x.overrideMimeType("multipart/form-data");
                    	            }
                    	        },
                    	        // Now you should be able to do this:
                    	        mimeType: 'multipart/form-data',    //Property added in 1.5.1

                    	        success: function (data) {
                    	            alert(data);
                    	        }
                    	    });

                    	    e.preventDefault();
                    	 
                     });
                     
                     
             
       });
       
      
  </script>
</head>
<body>
	<!-- <form action="abc.up" enctype="multipart/form-data" method="post" accept-charset="utf-8"> -->
	
			choose:<input type="file" id="file" name="file">
			<input type="submit"  value="SaveFile">  
	<!-- </form> -->
		
		
</body>
</html>