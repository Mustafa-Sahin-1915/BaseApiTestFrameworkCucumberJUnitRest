@PostRequestTest
Feature: Test post request for languages supported by the client generator

  Scenario Outline: TC_001:This scenario test post request for languages which are supported by the client
    Given As a user generates setup for api call for post
    And As a user on online generator swagger api base for post
    When As a user send POST request to generate a client library for "<language>"
    Then As a user verify that status code is 200 success for post
    Examples:
      | language |
      | java     |

