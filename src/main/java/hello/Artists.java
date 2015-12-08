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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Artists other = (Artists) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
}
