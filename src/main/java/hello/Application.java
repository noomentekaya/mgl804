package hello;
import java.util.ArrayList;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;


@SpringBootApplication
public class Application implements CommandLineRunner {

	@Autowired
	private ProgrssiveRockRepository repository;
	@Autowired
	private AlbumRepository albumprepo;
	@Autowired
	private TrackRepository trackrepo ;
	@Autowired
	private ArtistRepo artistRepo ;
	@Autowired
	private TourDateRepository tourRepo ;
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
	
	public void displayChoice (){
		System.out.println("Options: ");
		System.out.println("a: Enter new band information");
		System.out.println("b: Modify existing band information");
		System.out.println("c: search band albums");
		System.out.println("d: Read band lyrics");
		System.out.println("e: See band tour dates");
		System.out.println("q: Quit");
		}
	Band band = new Band();
	@Override
	public void run(String... args) throws Exception {
		displayChoice();
		Scanner scanner = new Scanner(System.in);
		String choice ;
		 do {
	            choice = scanner.nextLine();
	            switch (choice) {
	            case "a":
	            	System.out.print("\nEnter band name: ");
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
	        		ArrayList<Artists> artists = new ArrayList<Artists>();
	        		Artists artist = new Artists();
	        		
	        		String trackName = scanner.nextLine();
	        		Track t = new Track(trackName,"bla bla bla");
	        		Band b = new Band(bandName, genre);
	        		trackrepo.deleteAll();
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
	        		artist.setBandName(bandName);
	        		System.out.println("enter artist name :");
	        		artist.setLastName(scanner.nextLine());
	        		System.out.println("enter artist firstname :");
	        		artist.setFirstName(scanner.nextLine());
	        		System.out.println("enter artist instrument :");
	        		artist.setInstrument(scanner.nextLine());
	        		artists.add(artist);
	        		b.setArtists(artists);
	        		artistRepo.save(artist);
	        		
	        		albumprepo.save(al);
	        		repository.save(b);
	        		trackrepo.save(t);
	        		System.out.println("Band "+bandName+" Saved !");
	            case "b":

	            	System.out.println("what band do you like to edit or add information to ?");
	            	String bandNameSearch = scanner.nextLine();
	            	Band band = new Band();
	            	band = repository.findByBandName(bandNameSearch);
	            	System.out.println("would you like to add another a)artist b)album c)tour date q)return?");

	            	String bandChoice =scanner.nextLine();
	            	switch(bandChoice){
	            	case "a" :
	            		Artists a = new Artists();
	            		System.out.println("enter new artist name");
	            		a.setFirstName(scanner.nextLine());
	            		System.out.println("enter new artist last name");
	            		a.setLastName(scanner.nextLine());
	            		System.out.println("enter artist instrument :");
		        		a.setInstrument(scanner.nextLine());
		        		java.util.List<Artists> artistsmodify = new ArrayList<Artists>();
		        		artistsmodify = artistRepo.findByBandName(bandNameSearch);
		        		artistsmodify.add(a);
		        		band.setArtists(artistsmodify);
		        		artistRepo.save(a);
		        		repository.save(band);
		        		displayChoice();
		        	break;
	            	case "b":
	            		System.out.print("\nEnter album name: ");
		        		
		        		String newalbumName = scanner.nextLine();
	            		System.out.print("\nEnter Issue Date: ");

		        		String newissueDate = scanner.nextLine();
		        		java.util.List<Album> listalbums = new ArrayList<>();
		        		
		        		listalbums	= albumprepo.findByBandName(bandNameSearch);
		        		Album aa = new Album();
		        		aa.setBandName(bandNameSearch);
		        		aa.setAlbumName(newalbumName);
		        		aa.setIssued(newissueDate);
		        		listalbums.add(aa);
		        		band.setAlbums(listalbums);
		        		repository.save(band);
		        		albumprepo.save(aa);
		        		displayChoice();
		        		break;
	            	case "c":
	            		System.out.println("enter band Name for tour dates");
	            		java.util.List<TourDates> tours = new ArrayList<>();
	            		TourDates tour = new TourDates();
	            		Band bandtour = repository.findByBandName(scanner.nextLine());
	            		System.out.println("enter date");
	            		tour.setDate(scanner.nextLine());
	            		System.out.println("enter venue");
	            		tour.setVenue(scanner.nextLine());
	            		System.out.println("enter city");
	            		tour.setCity(scanner.nextLine());
	            		System.out.println("enter country");
	            		tour.setCountry(scanner.nextLine());
	            		tour.setBandName(bandtour.getBandName());
	            		tourRepo.save(tour);
	            		tours.add(tour);
	            		bandtour.setDateAndPlace(tours);
	            		repository.save(bandtour);
	            		displayChoice();
	            		break;
	            		
		        		
		        		
	            		
	            		
	            	}
	            case "c":
	            	System.out.println("enter band name to list all albums ");
	            String s = scanner.nextLine();
	            	for (Album aa : albumprepo.findByBandName(s)){
	            		System.out.println(aa.getAlbumName());
	            		System.out.println(aa.getIssued());
	            		System.out.println(aa.getTracks());

	            	}
	            	displayChoice();
	            	break;
	            case "d":
	             	System.out.println("enter album name to read lyrics ");
	            	for (Track tt : trackrepo.findByAlbumName(scanner.nextLine())){
	            		System.out.println(tt.getAlbumName());
	            		System.out.println(tt.getLyrics());
	            		

	            	}
	            	displayChoice();
	            	break;
	            case "e":
	            	System.out.println("enter album name to read lyrics ");
	            	String search1  = scanner.nextLine();

	            	for (Track tt : trackrepo.findByAlbumName(search1)){
	            		System.out.println(tt.getAlbumName());
	            		System.out.println(tt.getLyrics());
	            		

	            	}
	            	displayChoice();
	            	break;
	            case "f":
	            	System.out.println("enter band name to check dates ");
	            	String search  = scanner.nextLine();
	            	for (TourDates tt : tourRepo.findByBandName(search)){
	            		System.out.println(tt.getDate());
	            		System.out.println(tt.getVenue());
	            		System.out.println(tt.getCity());
	            		System.out.println(tt.getCountry());

	            	}
	            	displayChoice();
	            	break;
	            case "q":
	            } // end of switch
	        } while (!choice.equals("q"));
		
		
		
		
		/*System.out.print("\nEnter band name: ");
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
		ArrayList<Artists> artists = new ArrayList<Artists>();
		Artists artist = new Artists();
		
		String trackName = scanner.nextLine();
		Track t = new Track(trackName,"bla bla bla");
		Band b = new Band(bandName, genre);
		trackrepo.deleteAll();
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
		artist.setBandName(bandName);
		System.out.println("enter artist name :");
		artist.setLastName(scanner.nextLine());
		System.out.println("enter artist firstname :");
		artist.setFirstName(scanner.nextLine());
		System.out.println("enter artist instrument :");
		artist.setInstrument(scanner.nextLine());
		artists.add(artist);
		b.setArtists(artists);
		artistRepo.save(artist);
		
		albumprepo.save(al);
		repository.save(b);
		trackrepo.save(t);*/	
		repository.save(new Band("Dark Tranquillity", "Melodic Death Metal"));
		
		System.out.println("bands found with findAll():");
		System.out.println("-------------------------------");
		for (Band band : repository.findAll()) {
			System.out.println(band);
		}
		System.out.println();

		
		System.out.println(repository.findByBandName("opeth"));
		String search = scanner.nextLine();

		System.out.println("albums by "+search+" are : "+albumprepo.findByBandName(search));
		for (Artists artisy : repository.findByLastName("Stanne")) {
			System.out.println(artisy);
		}
		System.out.println("search for tracks by : ");
		for (Track track : trackrepo.findByBandName(search)){
		System.out.println(track);
	}
		scanner.close();
	}

}
