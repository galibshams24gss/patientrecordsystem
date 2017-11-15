import java.util.*;
import java.io.*;
public class PatientRecordSystemMenu {

	public static void main(String[] args) {
		PatientRecordSystem prs = new PatientRecordSystem();
		
		while(true)
		{
			Scanner kb = new Scanner(System.in);
			
			System.out.println("==============================");
	         System.out.println("Patient Record System Main Menu");
	         System.out.println("==============================");
	         System.out.println("1. Add a Measurement Observation Type");
	         System.out.println("2. Add a Category Observation Type");
	         System.out.println("3. Add a Patient");
	         System.out.println("4. Add a Measurement Observation Type");
	         System.out.println("5. Add a Category Observation Type");
	         System.out.println("6. Display Details of an Observation Type");
	         System.out.println("7. Display a Patient Record by the Patient ID");
	         System.out.println("8. Save Data");
	         System.out.println("9. Load Data");
	         System.out.println("D. Display all Data for Inspection");
	         System.out.println("X. Exit");
	         System.out.print("Please Enter an Option (1-9 or D or X): ");
	         
	         String option = kb.nextLine().toUpperCase();
	         
	         switch(option)
	         {
	         case "1":
	         {
	        	 System.out.print("Enter the Measurement Observation Type Code: ");
                 String code = kb.nextLine();
                 System.out.print("Enter the Measurement Observation Type Name: ");
                 String name = kb.nextLine();
                 System.out.print("Enter the Measurement Observation Type Unit: ");
                 String unit = kb.nextLine();
                 
                 try
                 {
                	 prs.addMeasurementObservationType(code,name,unit);
                	 
                 }
                 
                 catch(Exception e)
                 {
                	 System.out.println(e.getMessage());
                 }
                 
	         }
	         
	         case "2":
	         {
	        	 System.out.print("Enter the Category Observation Type Code: ");
                 String code = kb.nextLine();
                 System.out.print("Enter the Category Observation Type Name: ");
                 String name = kb.nextLine();
                 
                 System.out.print("Enter the Number of Categories: ");
                 int categoryNumber= kb.nextInt();
                 kb.nextLine();
                 
                 String[] category = new String[categoryNumber];
                 for(int i=1; i<categoryNumber; i++)
                 {
                	 System.out.print("Enter Category"+i+": ");
                	 String temp = kb.nextLine();
                	 
                	 category[i-1] = temp;
                 }
                 
                 try
                 {
                	 prs.addCategoryObservationType(code, name, category);
                	 
                 }
                 
                 catch(Exception e)
                 {
                	 System.out.println(e.getMessage());
                 }
                 
	         }
	         
	         case "3":
	         {
	        	 System.out.print("Enter the Patient id: ");
                 String id = kb.nextLine();
                 System.out.print("Enter the Patient Name: ");
                 String name = kb.nextLine();
                 
                 try
                 {
                	 prs.addPatient(id,name);      	 
                 }
                 
                 catch(Exception e)
                 {
                	 System.out.println(e.getMessage());
                 }
                 
	         }
	         
	         case "4":
	         {
	        	 System.out.print("Enter the measurement observation code: ");
                 String code = kb.nextLine();
                 System.out.print("Enter the measurement observation Name: ");
                 String name = kb.nextLine();
                 System.out.print("Enter the measurement observation  value: ");
                 int value = kb.nextInt();
                 
                 try
                 {
                	 prs.addMeasurementObservation(code,name,value);      	 
                 }
                 
                 catch(Exception e)
                 {
                	 System.out.println(e.getMessage());
                 }
                 
	         }
	         
	         case "5":
             {
                System.out.print("Enter the Patient ID: ");
                String code = kb.nextLine();
                System.out.print("Enter the Obsevation Type Code: ");
                String name = kb.nextLine();
                System.out.print("Enter the Observation Type Value: ");
                String value = kb.nextLine();

                try
                {
                   prs.addCategoryObservation(code,name,value);
                }
                catch (Exception e)
                {
                   System.out.println(e.getMessage());
                }
                break;
             }
             
	         case "6":
             {
                System.out.print("Enter the Observation Type Code: ");
                String code = kb.nextLine();
                try
                {
                   System.out.println(prs.findType(code));
                }
                catch (Exception e)
                {
                   System.out.println(e.getMessage());
                }
                break;
             }
             
	         case "7":
             {
                System.out.print("Enter the Patient ID: ");
                String id = kb.nextLine();
                try
                {
                   System.out.println(prs.findPatient(id));
                }
                catch (Exception e)
                {
                   System.out.println(e.getMessage());
                }
                break;
             }
             
	         case "8":
             {
                try
                {
                   prs.saveData();
                }
                catch (Exception e)
                {
                   System.out.println(e.getMessage());
                }
                System.out.println("Data Saved");
                break;

             }
             
	         case "9":
             {
                try
                {
                   prs.loadData();
                }
                catch(Exception e)
                {
                   System.out.println(e.getMessage());
                }
                System.out.println("Data Loaded");
                break;

             }
             
             
             
	         case "D":
	         {
	        	 System.out.println("Patient Information");
                 for (int i=0; i<prs.pcounter;i++)
                 {
                    System.out.println(prs.patients[i]);
                 }
                 break;
	         }
	        	
	         
		case "X":
        {
           System.out.print("Bye! See You Next Time, Thank you!");
           System.exit(0);
        }
	         
		}
		
		}
	}
}
