import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class EveryQuestionWithNER {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new FileReader("QuestionWithNER.txt"));
		BufferedWriter bw = new BufferedWriter(new FileWriter("EveryQuestionWithNER.txt"));
    	int cnt = 0;
		String str=br.readLine();
		String[] NER = { "organization", "loction", "person", "date", "percent", "money" };


		while ((str = br.readLine()) != null) {
			
			String str1[] = str.split(" ");
		    for(int i=0; i<str1.length; i++)
		    {
            String str2[]= str1[i].split("/");
				for(int j=0;j<NER.length;j++)
				{
					if (str2[1].equalsIgnoreCase(NER[j]))
					{
						bw.write(str + "\n");
						cnt++;
					}
					
				}
			}
		}
		System.out.println(cnt);
		br.close();
		bw.close();

	}

}
