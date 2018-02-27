import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;


public class QuestionTypeIdentification {

	public static void main(String[] args) throws IOException {
		String []yesno={"can", "could", "would", "is", "does", "has", "was", "were", "had", "have", "did", "are", "will"};
		String []Commonwords = {"the", "a", "an", "is", "are", "were", "."};
		String	[]	questionwords = {"who/O", "what/O", "where/O", "when/o", "why/o", "how/o", "whose/o", "which/o", "whom/o"};
		String [] questionwords1 = {"few/o","little/o","much/o","many/o","yong/o","old/o","long/o"};
		BufferedReader br=new BufferedReader(new FileReader("SampleQuestion.txt"));
		BufferedWriter br1 = new BufferedWriter(new FileWriter("QuestionTypes.txt"));
		String str=br.readLine();		
		
		while(str!=null){
		int flag=0;
		System.out.print(str+". ");
		String[] str1=str.split(" ");
		for(int i=0;i<str1.length;i++){
			for(int j=0;j<yesno.length;j++){
				if(str1[0].equalsIgnoreCase(yesno[j])){
					System.out.println("\nYesNo");
					br1.write("YesNo\n");
					flag=1;
					break;
					
				}
				else{
					
				}
			}
			for(int j=0;j<questionwords.length;j++){
				if(str1[i].equalsIgnoreCase(questionwords[j])){
					
					if (questionwords[j].equalsIgnoreCase("who/o")||questionwords[j].equalsIgnoreCase("whose/o")||questionwords[j].equalsIgnoreCase("whom/o"))
					{
				       // System.out.println("\nPerson_Type_Question");
				        flag=1;
				        br1.write(str+"\n");
				        br1.write("Person_Type_Question \n");
				        
					}
					
					else if (questionwords[j].equalsIgnoreCase("where/o"))
					{
				      //  System.out.println("\nLocation_Type_Question");
				        flag=1;
				        br1.write(str+"\n");
				        br1.write("Location_Type_Question \n");
				    }
					
				    else if (questionwords[j].equalsIgnoreCase("when/O")||questionwords[j].equalsIgnoreCase("what/o"))
				    {
						//System.out.println("\nTime_Type_Question");
						flag=1;
						br1.write(str+"\n");
						br1.write("Time_Type_Question \n");
						        
			        }
					
				    else if (questionwords[j].equalsIgnoreCase("Which/o"))
				    {
				      //  System.out.println("\nOrganization_Type_Question ");
				        flag=1;
				        br1.write(str+"\n");
				        br1.write("Organization_Type_Question \n");
				     }
					
				    else if (questionwords[j].equalsIgnoreCase("how/o"))
				    {
				    	if (questionwords1[j].equalsIgnoreCase("few/o")||questionwords1[j].equalsIgnoreCase("little/o")||questionwords1[j].equalsIgnoreCase("much/o")||questionwords1[j].equalsIgnoreCase("many/o"))
				    	{
				      //  System.out.println("\nQuantity_Type_Question ");
				        flag=1;
				        br1.write(str+"\n");
				    	br1.write("Quantity_Type_Question \n");
				        }
				        else if(questionwords1[j].equalsIgnoreCase("yong/o")|| questionwords1[j].equalsIgnoreCase("old/o")||questionwords1[j].equalsIgnoreCase("long/o"))
				        {
				      //  System.out.println("\nTime_Type_Question ");	
				        flag=1;
				        br1.write(str+"\n");
				        br1.write("Time_Type_Question \n");
				        }      
				    }
					break;	
				}
				}
			if(flag==1)
				break;
		}
		if(flag==0)
		{
			//System.out.println("\nNotFound ");
			br1.write(str+"\n");
		    br1.write("Time_Type_Question \n");
		}
		str=br.readLine();
		}	
		br1.close();
	}
}
