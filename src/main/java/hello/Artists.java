package hello;


import org.springframework.data.annotation.Id;

public class Artists {
	@Id
    private String id;
	private String bandName;
    private String firstName;
    private String lastName;
    private String instrument ;
    

    

    public Artists() {}

    public Artists(String firstName, String lastName, String instrument) {
        this.firstName = firstName;
        this.lastName = lastName	;
        this.instrument = instrument;
    }

    @Override
    public String toString() {
        return String.format(
                "Band[id=%s, firstName='%s', lastName='%s',instrument='%s']",
                id, firstName, lastName,instrument);
    }
}
