Feature: Test an API

  @regression
  Scenario: Test
    Given Send a get request to url "https://petstore.swagger.io/v2/user"
    And set username as "RaviRanjan" in body
    Then check response 200
    Then validate the response where username as "unknown"