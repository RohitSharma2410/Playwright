@Api

Feature: Createuser

  Scenario: Createuser
  Given API is "Createuser"
  When Set request body json data "createuservalid"	
 Then API response body should contain parameter "name" with "morpheus" 
 