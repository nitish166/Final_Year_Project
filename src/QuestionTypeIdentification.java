import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;


public class QuestionTypeIdentification {

	public static void main(String[] args) throws IOException {
		String []yesno={"can", "could", "would", "is", "does", "has", "was", "were", "had", "have", "did", "are", "will"};
		String []Commonwords = {"the", "a", "an", "is", "are", "were", "."};
		String	[]	questionwords = {"who", "what", "where", "when", "why", "how", "whose", "which", "whom"};
		BufferedReader br=new BufferedReader(new FileReader("question1.txt"));
		String str=br.readLine();		
		
		while(str!=null){
		int flag=0;
		System.out.print(str+". ");
		String[] str1=str.split(" ");
		for(int i=0;i<str1.length;i++){
			for(int j=0;j<yesno.length;j++){
				if(str1[0].equalsIgnoreCase(yesno[j])){
					System.out.println("\nYesNo");
					flag=1;
					break;
					
				}
				else{
					
				}
			}
			for(int j=0;j<questionwords.length;j++){
				if(str1[i].equalsIgnoreCase(questionwords[j])){
					if (questionwords[j].equalsIgnoreCase("who")||questionwords[j].equalsIgnoreCase("whose")||questionwords[j].equalsIgnoreCase("whom")||questionwords[j].equalsIgnoreCase("which")){
				        System.out.println("\nPersonQuestion");flag=1;}
					else if (questionwords[j].equalsIgnoreCase("where")){
				        System.out.println("\nPlaceQuestion");flag=1;}
				    else if (questionwords[j].equalsIgnoreCase("when")){
						        System.out.println("\nTimeQuestion");flag=1;}
				    else if (questionwords[j].equalsIgnoreCase("how")){
				        System.out.println("\nQuantity/TimeQuestion");flag=1;}
				   
					break;
					
				}
				else{
					
				}
			}
			if(flag==1)
				break;
		}
		if(flag==0)
			System.out.println("\nNotFound");
		str=br.readLine();
		}	
	}
}
