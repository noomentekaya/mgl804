Feature:tourdate

  Scenario: newAlbm
    Given Tour date in City Montreal 
    When User searchs for band King Crimson tour date
    Then TourDate 16/11/2015 is Found
