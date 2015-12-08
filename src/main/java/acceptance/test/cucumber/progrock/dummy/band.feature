Feature: Band

  Scenario: newBand
    Given Band with name Opeth that plays prog rock
    When User searchs for Artist with name Mikael
    Then  Artist should be found with name Mikael that plays for Opeth
