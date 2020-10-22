@regression
  Feature: Google search validation 

@searchandvalidatelogo  
  Scenario Outline: Validate user can search given keyword and validate JP Morgan logo displayed after clicking search result  
    Given User navigate to google homepage "<expectedtitle>"
    When User searches using given data "<searchdata>" and select search result on googlepage
    Then User verify JP Mogan logo displayed on home page successfully
         
   Examples: 
  
    | expectedtitle   | searchdata  |
    | Google          | J.P. Morgan |