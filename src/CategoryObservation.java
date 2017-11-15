
public class CategoryObservation extends Observation{
	private String value;
	
	public CategoryObservation(ObservationType type, String value)
	{
		super(type);
		this.value = value;
	}
	
/*	public String getValue()
	{
		return value;
	}*/
	
	
	public String toString()
	{
		String.format("name: %s, code: %s, value: %s \r\n", type.getName(), type.getCode(), value);
	}
}
