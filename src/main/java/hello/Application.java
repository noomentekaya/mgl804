package hello;
import java.io.Console;
import java.util.ArrayList;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.sun.xml.internal.bind.v2.schemagen.xmlschema.List;

@SpringBootApplication
public class Application implements CommandLineRunner {

	@Autowired
	private ProgrssiveRockRepository repository;
	@Autowired
	private AlbumRepository albumprepo;
	@Autowired
	private TrackRepository trackrepo ;
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.print("\nEnter band name: ");
		Scanner scanner = new Scanner(System.in);
		String bandName = scanner.nextLine();
		System.out.print("\nEnter genre: ");
		
		String genre = scanner.nextLine();
		
		System.out.print("\nEnter album name: ");
		
		String albumName = scanner.nextLine();
		System.out.print("\nEnter album issue date: ");
		
		String issueDate = scanner.nextLine();
		System.out.print("\nEnter track name: ");
		ArrayList<Track> tracks = new ArrayList<Track>();
		ArrayList<Album> albums = new ArrayList<Album>();
		
		String trackName = scanner.nextLine();
		Track t = new Track(trackName,"bla bla bla");
		Band b = new Band(bandName, genre);
		
		repository.deleteAll();
		albumprepo.deleteAll();
		Album al =new Album(albumName,issueDate);
		
		
		b.setAlbums(albums);
		t.setAlbumName(al.getAlbumName());
		t.setBandName(b.getBandName());
		tracks.add(t);
		albums.add(al);
		al.setTracks(tracks);
		al.setBandName(bandName);
		albumprepo.save(al);
		repository.save(b);
		trackrepo.save(t);
		repository.save(new Band("Dark Tranquillity", "Melodic Death Metal"));
		
		System.out.println("bands found with findAll():");
		System.out.println("-------------------------------");
		for (Band band : repository.findAll()) {
			System.out.println(band);
		}
		System.out.println();

		
		System.out.println(repository.findByBandName("opeth"));
		System.out.println("albums by Opeth are : "+albumprepo.findByBandName("opeth"));
		for (Artists artisy : repository.findByLastName("Stanne")) {
			System.out.println(artisy);
		}
		System.out.println("search for tracks by : ");
		String search = scanner.nextLine();
		for (Track track : trackrepo.findByBandName(search)){
		System.out.println(track);
	}
		scanner.close();
	}

}
