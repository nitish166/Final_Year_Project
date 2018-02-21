import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;


public class ContentWordExtraction {

	public static void main(String[] args) throws IOException {
		String [] ContentWord = {"NN","NNS","NNP","NNPS","VB","VBD","VBG","VBN","VBP","VBZ","JJ","JJR","JJS","RB","RBR","RBS"};
		BufferedReader br = new BufferedReader( new FileReader ("QuestionWithPOS.txt"));
		BufferedWriter br1 = new BufferedWriter(new FileWriter("ContentWords.txt"));
		String str = br.readLine();
		
		
			String[] str1 = str.split(" ");
			for( int i=0;i<str1.length;i++)
			{
				String array2[]=str1[i].split("_");
				
				for(int j=0;j<ContentWord.length;j++)
				{
					if(array2[1].equalsIgnoreCase(ContentWord[j]))
					{
					//System.out.println(array2[0]+" "+array2[1]);
					//System.out.print(array2[0]+" ");
					br1.write(array2[0]+" ");
					break;
					}
				}
				
				
			}
			
		
			br1.close();
			br.close();
	}

}
