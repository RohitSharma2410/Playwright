@Web
Feature:Login


  Scenario Outline: login in applcation
   Given I am on Login page
   When login with <username> and <password>
   Then login should be succesfull
   Examples:
   ||username||password||
   ||"standard_user"||"secret_sauce"||
   
  Scenario Outline: login fail
   Given I am on Login page
   When login with <username> and <password>
   Then login should fail
   Examples:
   ||username||password||
   ||"rohit"||"rohit"||


