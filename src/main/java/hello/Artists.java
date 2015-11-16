package hello;


import org.springframework.data.annotation.Id;

public class Artists {
	@Id
    private String id;
	private String bandName;
    public String getBandName() {
		return bandName;
	}

	public void setBandName(String bandName) {
		this.bandName = bandName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getInstrument() {
		return instrument;
	}

	public void setInstrument(String instrument) {
		this.instrument = instrument;
	}

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
