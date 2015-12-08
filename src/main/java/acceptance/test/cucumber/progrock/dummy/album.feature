Feature:album

  Scenario: newAlbm
    Given Album with name Watershed issued in 2008
    When User search for Band Opeth
    Then Album Still life Should be in Opeth album list
