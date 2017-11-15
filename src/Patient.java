
public class Patient {
	private String id;
	private String name;
	private Observation[] observations = new Observation [50];
	private int ocounter = 0;
	
	public Patient(String id, String name)
	{
		this.id = id;
		this.name = name;
	}
	
	public String getId()
	{
		return id;
	}

	public String getName()
	{
		return name;
	}
	
	public boolean ObservationTypeExists(ObservationType type)
	{
		for(int i=0; i<ocounter; i++)
		{
			if(observations[i].getType().equals(type))
			{
				return true;
			}
		}
		return false;
	}
	
	public void addObservation(Observation observation)
	{
		observations[ocounter] = observation;
		ocounter++;
	}
	
	public String toString()
	{
		String temp = String.format("id: %s, name: %s \r\n", id, name);
		for(int i=0;i<ocounter;i++)
		{
			temp += "\t" +observations[i];
		}
		return temp;
	}
}
