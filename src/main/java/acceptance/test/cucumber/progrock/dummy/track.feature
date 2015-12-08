Feature:track

  Scenario: lyrics
    Given Album with name orchid issued in 1995
    When User search for Track forest of october
    Then  track forest of octber is found in album orchid
