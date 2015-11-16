package unit.test.progrock.dummy;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.junit.Assert.*;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import hello.Album;
import hello.AlbumRepository;
import hello.Artists;
import hello.Band;
import hello.ProgrssiveRockRepository;
import hello.Track;

@RunWith(MockitoJUnitRunner.class)
public class UnitTestProgRockDummy {
	@Mock
	private ProgrssiveRockRepository progrepo;
	@Mock
	private AlbumRepository albumrepo;
	Band band;
	Album al;
	List<Album> albums;

	@Before
	public void initTests() {

		al = new Album();
		al.setAlbumName("watershed");
		Artists ar = new Artists();
		band = new Band();
		band.setBandName("Opeth");
		al.setBandName(band.getBandName());
		Track track;
		albums = new ArrayList<>();
		albums.add(al);

	}

	@Test
	public void testBandSearchShouldReturnNull() {
		when(progrepo.findByBandName("")).thenReturn(null);
	}

	@Test
	public void testBandShouldReturnBand() {
		when(progrepo.findByBandName("Opeth")).thenReturn(band);
	}

	@Test
	public void testBandShouldReturnAlbums() {
		when(albumrepo.findByBandName("Opeth")).thenReturn(albums);
	}

}
