
public class ObservationType {
	private String name;
	private String code;
	
	public ObservationType(String name, String code)
	{
		this.name = name;
		this.code = code;
	}
	
	public String getName()
	{
		return name;
	}
	
	public String getCode()
	{
		return code;
	}
	
	public String toString()
	{
		return String.format("name: %s, code: %s \r\n",name,code);
	}

}
