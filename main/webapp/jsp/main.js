

document.getElementById("form").addEventListener("submit",function(event){
	
  var password=document.getElementById("password").value;
  var confim_passwd=document.getElementById("confirm-password").value;
  
  var message=document.getElementById("message");
  
  console.log('fffffffffff');
  if(password!==confim_passwd){
	  console.log('daz');
	 message.textContent="les mots de passe ne correspondent pas";
	message.style.color='red';
	event.preventDefault();
  }
});