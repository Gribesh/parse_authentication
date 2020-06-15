# Assignment Documentation
(Android App Development)

# Objective:
To create an android app which allows the user to login and logout using a Parse server as a backend.

# Abstract:
The main objective of this documentation is to present a software application for the login and logout use case using a parse server as backend. The application developed for android will enable the new users to signup as well as registered users can log in and view the home page. The system requires devices to be connected via the internet. Java is used as a programming language and Bitnami Parse Server is hosted on AWS.

# Introduction
This is a simple android mobile application where a new user can create a new profile using signup page or previously registered user can log in.

# Features
## Login: 
Input: username , password (valid)
Output: 
	If credentials matches
		Redirect to Home Page
	Else
		Error message is displayed

## SignUp:
Input: username , password, confirm password
Output:
	If (username is unique) && (password is valid) && (password==confirm password)
		Signup the user
		Redirect to Home page
	Else
		Error message is displayed



## Logout:
Input: Press Logout from option menu
Output: 
	If there is current user
		Logout
		Redirect to login page

## ShowPassword
Input: Click
Output: 
	If checked:
		Show password
	Else:
		Hide password

# Testing Result
Username and password shouldn’t be blank.
Passwords should meet the requirement.
- Minimum 8 letters
- At least 1 digit
- At least 1 lower case letter  
- At least 1 upper case letter
- No white spaces
- At least 1 special character
- Password should match with confirm password.


# Conclusion
We can implement authentication using a parse server as a backend conveniently with our android application. It can also be used to store data and files as per our need.

# Future Work
- Improvement in UI.
- Addition of content in home page.  
		
	
 




