@GetRequestTest
Feature: Test get request for languages supported by the client generator

  Scenario: TC_001:This scenario test get request for languages which are supported by the client
    Given As a user generates setup for api call
    And As a user on online generator swagger api base
    When As a user send GET request to get languages supported by client generator
    Then As a user verify that status code is 200 success
