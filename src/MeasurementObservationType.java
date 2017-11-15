
public class MeasurementObservationType extends ObservationType {
	private String unit;
	
	public MeasurementObservationType(String name, String code, String unit)
	{
		super(name,code);
		this.unit = unit;
	}
	
	public String getUnit()
	   {
	      return unit;
	   }
	
/*	public String getUnit()
	{
		return unit;
	} */
}
