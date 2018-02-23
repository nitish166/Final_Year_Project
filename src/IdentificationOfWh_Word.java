
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.FileReader;
public class IdentificationOfWh_Word {

	public static void main(String[] args) throws Exception{
		
		BufferedReader br =  new BufferedReader (new FileReader("Question.txt"));
		BufferedWriter br1 = new BufferedWriter (new FileWriter("ListOfWh_wordQuestion.txt"));
		String str ;
		String []wh_word = {"which","where","what","who","how","when","why","whom","whose",};
		int cnt=0;
		while((str=br.readLine())!=null)
		{
			String str1[] = str.split(" ");
			
			
				for(int j=0;j<wh_word.length;j++)
				{
					if(str1[0].equalsIgnoreCase(wh_word[j]))
					{
						br1.write(str+"\n");
						cnt++;
					}
					
				}
				
		}
		System.out.println(cnt);
		br.close();
		br1.close();
		
		
	}

}
