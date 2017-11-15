import java.util.*;
import java.io.*;
public class PatientRecordSystem {
	Patient[] patients = new Patient[100];
	ObservationType[] observationTypes = new ObservationType[50];
	 int pcounter = 0;
	int ocounter = 0;
	
	public void addMeasurementObservationType(String code, String name, String unit) throws Exception
	{
		if(findType(code) == null)
		{
			observationTypes[ocounter] = new MeasurementObservationType(code, name, unit);
			ocounter++;
		}
		else 
		{
			throw new Exception("ERROR: Observation type code already exists");
		}
	}
	
	public void addCategoryObservationType(String name, String code, String[] categories) throws Exception
	{
		if(findType(code) == null)
		{
			observationTypes[ocounter] = new CategoryObservationType(code, name, categories);
			ocounter++;
		}
		else 
		{
			throw new Exception("ERROR: Observation type code already exists");
		}
	}

	public void addPatient(String id, String name) throws Exception
	{
		if(findPatient(id) == null)
		{
			patients[pcounter] = new Patient(id,name);
			pcounter++;
		}
		else
		{
			throw new Exception("ERROR: Patient with that id already exists");
		}
		
	}
	
	public void addMeasurementObservation(String name, String code, int value) throws Exception
	{
		Patient p= findPatient(id);
		if(p.ObservationTypeExists(findType(code)))
		{
			throw new Exception("already");
		}
		else
		{
			p.addObservation(new MeasurementObservation(findType(code),value));
		}
	}
	
	public void addCategoryObservation(String name, String code, String value) throws Exception
	{
		Patient p= findPatient(id);
		if(p.ObservationTypeExists(findType(code)))
		{
			throw new Exception("already");
		}
		else
		{
			if(((CategoryObservationType)findType(code)).CategoryExists(value))
			{
				p.addObservation(new CategoryObservation(findType(code),value));
			}
			else
			{
				throw new Exception("ERROR: Invalid category value");
			}
		}
	}
	
	public Patient findPatient(String id)
	{
		for(int i=0; i<pcounter; i++)
		{
			if(patients[i].getId().equals(id))
			{
				return patients[i];
			}
		}
		return null;
	}
	
	public ObservationType findType(String code)
	{
		for(int i=0; i<ocounter; i++)
		{
			if(observationTypes[i].getCode().equals(code))
			{
				return observationTypes[i];
			}
		}
		return null;
	}
	
	public String toString()
	{
		String temp = "PRS records \r\n";
		if(ocounter != 0)
		{
			temp += "Observation types\r\n";
		}
		for(int i =0; i<ocounter; i++)
		{
		temp += observationTypes[i];
		}
		
		if(pcounter != 0)
		{
			temp += "Patients\r\n";
		}
		for(int i =0; i<pcounter; i++)
		{
		temp += patients[i];
		}
		return temp;
}
	
	public void saveData() throws Exception
	{
		  PrintWriter MOTp = new PrintWriter(new File("PRS-MeasurementObservationTypes.txt"));
	      PrintWriter COTp = new PrintWriter(new File("PRS-CategoryObservationTypes.txt"));
	      PrintWriter PAT = new PrintWriter(new File("PRS-Patients.txt"));
	      PrintWriter MOn = new PrintWriter(new File("PRS-MeasurementObservations.txt"));
	      PrintWriter COn = new PrintWriter(new File("PRS-CategoryObservations.txt"));
	      
	      for(Patient patient: patients)
	      {
	    	  if(patient instanceof Patient)
	    	  {
	    		  Patient pat = (Patient) patient;
	    		  PAT.println(pat.getId() + ";" + pat.getName());
	    	  }
	      }
	      
	      for(ObservationType obs: observationTypes)
	      {
	    	  if(obs instanceof MeasurementObservationType)
	    	  {
	    		  MeasurementObservationType obss = (MeasurementObservationType) obs;
	    		  MOTp.println(obss.getCode() + "; " + obss.getName() + "; " + obss.getUnit());
	    	  }
	    	  
	    	  else if(obs instanceof CategoryObservationType)
	    	  {
	    		  CategoryObservationType obss = (CategoryObservationType) obs;
	    		  String cat = "";
	    		  for(String is: obss.getCategories())
	    		  {
	    			  cat += is+",";
	    		  }
	    		  COTp.println(obss.getCode() + "; " + obss.getName() + "; " +cat);
	    	  }
	      }
	      
	      MOTp.close();
	      COTp.close();
	      PAT.close();
	      MOn.close();
	      COn.close();

	}
	
	
	public void loadData() throws Exception
	{
		BufferedReader Pat = new BufferedReader(new FileReader("PRS-Patients.txt"));
		String input1 = Pat.readLine();
		while(input1 != null)
		{
			StringTokenizer token = new StringTokenizer(input1,";");
			String id = token.nextToken();
			String name = token.nextToken();	
			
			addPatient(id,name);
			
			input1 = Pat.readLine();
		}
		Pat.close();
		
		
		BufferedReader MOTps = new BufferedReader(new FileReader("PRS-MeasurementObservationTypes.txt"));
		String input = MOTps.readLine();
		while(input != null)
		{
			StringTokenizer token = new StringTokenizer(input, ";");
			String id = token.nextToken();
	        String name = token.nextToken();
	        String unit = token.nextToken();
	        
	        addMeasurementObservationType(id, name, unit);
	        input = MOTps.readLine();
		}
		MOTps.close();
		
		
		BufferedReader COTps = new BufferedReader(new FileReader("PRS-CategoryObservationTypes.txt"));
	    String input2 = COTps.readLine();
	    while (input2!=null)
	    {
	    	StringTokenizer token = new StringTokenizer(input2, ";");
	    	String code = token.nextToken();
	        String name = token.nextToken();
	        
	        StringTokenizer tokens = new StringTokenizer(input2, ",");
	        int index = 0;
	        String [] categories = new String[index];
	        
	        while(tokens.hasMoreElements())
	        {
	        	String s = tokens.nextToken();
	        	for(int i=0; i<categories.length; i++)
	        	{
	        		categories[i] = s;
	        		index++;
	        	}
	        }
	        
	        addCategoryObservationType(code,name,categories);
	        input2 = COTps.readLine();
	    }
	    COTps.close();
	}
	
	
}
