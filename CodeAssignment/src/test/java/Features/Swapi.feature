@apiAssignment
Feature: Veirfy SWAPI API

  @api1
  Scenario: Verify People End Point returning success response
  Given I send the GET request to People end point
  Then Verify the expected response status code is 200
  @api1
  Scenario Outline: Verify  total number of people where height is greater than 200
  Given I send the GET request to People end point
  Then Verify the expected response status code is 200
  And Verify the total no of people where height is greater than "<height>" is equal to "<expectedCount>"
  
  Examples:
  | height | expectedCount |
  |     50 |            10 |
  @api1
  Scenario Outline: Verify The Person Names in the response
    Given I send the GET request to People end point
    Then Verify the expected response status code is 200
    And Verify the person names are matching with "<names>"

    Examples: 
      | names                                                   |
      | Darth Vader, Leia Organa, Owen Lars, Beru Whitesun lars |

  @api1
  Scenario: Verify The total no of people checked
    Given I send the GET request to People end point
    Then Verify the total no of people checked is 82
