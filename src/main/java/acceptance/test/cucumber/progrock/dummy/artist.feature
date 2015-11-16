Feature:artist

  Scenario:newArtist
    Given Artist with firstName Mikael and lastName Akerfeldt as guitar player for band Opeth
    Then artist Mikael Akerfeldt saved!
