#@Api

Feature: Delete
    Scenario: Delete
   Given I am requesting "Delete" api
  When update path with path param as "2"
   When call API
   Then response status should be {204}