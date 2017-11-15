
public class MeasurementObservation extends Observation{
//	private String [] categories;
	private int value;
	
	public MeasurementObservation(ObservationType type, int value)
	{
		super(type);
		this.value = value;
	}
	
	/*public String getCategories()
	{
		return categories;
	}*/
	
	/*public int getValue()
	{
		return value;
	} */

	public String toString()
	{
		return String.format("name: %s, code: %s, value: %d \r\n, type.getName(),type.getCode(),value");
	}
}
