
public class CategoryObservationType extends ObservationType {
	private String[] categories;
	
	public CategoryObservationType(String name, String code, String[] categories)
	{
		super(name,code);
		this.categories=categories;
	}
	
	public String [] getCategories()
	   {
	      return categories;
	   }
	
	public boolean CategoryExists(String category)
	{
		for(int i = 0; i < categories.length; i++)
		{
			if(categories[i].equals(category))
			{
				return true;
			}
		}
		return false;
	}
}
