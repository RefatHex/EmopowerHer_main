Use postman API to test the application as explained below:<br>
To <b>signup</b> a new user use POST request with api/auth/signup and pass required information as raw JSON in the request body.The role can be admin, mod(moderator), or user which will determine the access to the info.<br>
<img width="635" alt="image" src="https://github.com/pratikshakh01/Login-Signup/assets/55578997/d41527a6-8a0b-42e0-928f-d05f1f95887e"><br>

You can access the public content directly as shown:<br>
<img width="637" alt="image" src="https://github.com/pratikshakh01/Login-Signup/assets/55578997/cc823aa6-e0dc-40f8-bb18-22074877e57a"><br>

To <b>Login</b> as a existing user use POST method with username and password values as raw JSON data in the request body with api/auth/signin as shown. You will recieve response as the user details with the role assigned to it.<br>
<img width="633" alt="image" src="https://github.com/pratikshakh01/Login-Signup/assets/55578997/7a24f111-bb24-4aee-89f5-3a1dbb6ab87c"><br> 
You can also check for cookies.<br>
<img width="635" alt="image" src="https://github.com/pratikshakh01/Login-Signup/assets/55578997/32196256-4006-49b3-977b-f05816f7b58a"><br>

Once logged in you can access resource of the particular role using api/test/[role].<br>
<img width="641" alt="image" src="https://github.com/pratikshakh01/Login-Signup/assets/55578997/511fe92d-6043-480e-bbe5-590e45fa5336"><br>

You can <b>Logout<b> of using the POST method with api/auth/signout. <br>
<img width="640" alt="image" src="https://github.com/pratikshakh01/Login-Signup/assets/55578997/ba98fea0-e1cb-4bf8-8bae-a625cb1639c5"><br>

You can change the database connection properties and values in application.properties file.

