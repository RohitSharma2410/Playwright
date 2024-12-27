@Api
Feature: Login

  #
  #Scenario: Login
  #Given API is "Login"
  #When Set query parameter "name" with "morpheus"
#	When Set path parameter "2" 
#	When Set request body json data "validLogin"	
#	Then API response state code should be {204}
#	Then API response body should contain parameter "" with <value>

  
  Scenario: Login
  Given API is "Login"
  When Set request body json data "validlogin"	
 Then API response body should contain parameter "token" with "QpwL5tke4Pnpja7X4" 
	