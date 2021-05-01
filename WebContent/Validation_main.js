function validate(){
    var username=document.getElementById("username").value;
    var password=document.getElementById("password").value;
    if(username == "" || username == null)
    {
    	 document.getElementById("s_u").innerHTML="Username is required";
         document.getElementById("username").focus();
         return false;    
     }

    if(password == ""|| password == null)
     {
         document.getElementById("s_p").innerHTML="Password is required";
         document.getElementById("password").focus();
         return false;;
     }
     document.getElementById("s_p").innerHTML="";
     document.getElementById("s_u").innerHTML="";
     return true;
    
}
function focus_body(){
	document.getElementById("username").focus();
}