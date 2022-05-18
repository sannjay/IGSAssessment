Feature: Feature to test loan calculator.
#Scenario: Check Home Loan Calculator is working with user given valid inputs
    #Given User is on home Loan Calculator page
    #When User selects application type as "Single"
    #And User selects Number of dependants as 0
    #And User selects property to buy as "Home to live in"
    #And User enters annual income as "80000"
    #And User enters other annual income as "10000"
    #And User enters living expenses as "500"
    #And User enters current home loan repayments as "0"
    #And User enters other loan repayments as "100"
    #And User enters other commitments as "0"
    #And User enters credit card limits as "10000"
    #And User clicks on Work out how much I could borrow button
    #Then Validate the estimated value should be displayed as "$479,000"

Scenario: Check Clicking the start over button clears the form
    Given User is on home Loan Calculator page
    When User selects application type as "Joint"
    And User selects Number of dependants as 2
    And User selects property to buy as "Residential investment"
    And User enters annual income as "10000"
    And User enters other annual income as "10000"
    And User enters living expenses as "600"
    And User enters current home loan repayments as "60"
    And User enters other loan repayments as "100"
    And User enters other commitments as "40"
    And User enters credit card limits as "4000"
    And User clicks on start over button
    Then Validate the form is cleared
    
#Scenario: Check Home Loan Calculator is returning a message for improper user input
    #Given User is on home Loan Calculator page
    #When User enters living expenses as "1"
    #And User clicks on Work out how much I could borrow button
    #Then Validate the message should be displayed as "Based on the details you've entered, we're unable to give you an estimate of your borrowing power with this calculator. For questions, call us on 1800 035 500."
