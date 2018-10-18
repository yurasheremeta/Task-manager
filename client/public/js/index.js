let serverUrl = 'http://localhost:8080/auth/';

$(document).ready(function(){
  $('#signupForm').submit(function(e){
    e.preventDefault();
    signup();

  });
});

function signup(){
  let user = {
    firstName: $('#firstName').val(),
    lastName: $('#lastName').val(),
    username: $('#username').val(),
    password: $('#password').val()
  }

  $.ajax({
    url: serverUrl + 'signup',
    method: 'POST',
    data: JSON.stringify(user),
    contentType:'application/json',
    complete: function(data){
      if(data.status == 500){
        console.log('Error');
      }

      if(data.status == 201 ){
        $(location).attr('href' , 'home.html');
      }
    }
  })


}