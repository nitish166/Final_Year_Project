import java.awt.List;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;


public class SentenceExtraction {

	public static StringBuffer processstring(String curr)
	{
		StringBuffer ans=new StringBuffer();
		for(int i=0;i<curr.length();i++)
		{
			if(curr.charAt(i)=='('||curr.charAt(i)==')'||curr.charAt(i)=='('||curr.charAt(i)=='\\'||curr.charAt(i)=='/'||curr.charAt(i)=='\"'||curr.charAt(i)==',')		
			{
				continue;
				
			}
			ans.append(curr.charAt(i));
		}
		return ans;
	}
	static ArrayList removeduplicaes(String []array)
	{
		ArrayList ans=new ArrayList();
		for(int i=0;i<array.length;i++)
		{
			int cnt=0;
			for(int j=0;j<array.length;j++)
				if(array[i].equals(array[j]))
					cnt++;
			if(cnt==1)
				ans.add(array[i]);
		}
		return ans;
		
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader( new FileReader ("SampleParagraph.txt"));
		BufferedReader br1 = new BufferedReader( new FileReader ("ContentWords.txt"));
		BufferedWriter br2 = new BufferedWriter(new FileWriter("SentenceExtraction.txt"));

		String str = br.readLine();
		String str1 = br1.readLine();
		String [] ContentWordSplit = str1.split(" ");
		String [] array = str.split("\\.");
		int score[]=new int[array.length];
		for(int i=0;i<array.length;i++)
		{
			int cnt=0;
			String[] array1 = array[i].split(" ");
			ArrayList t2=removeduplicaes(array1);
			for(int j=0;j<t2.size();j++)
			{
				String temp=processstring((String) t2.get(j)).toString();
				
				for(int k=0;k<ContentWordSplit.length;k++)
					{
					//System.out.println(ContentWordSplit[k]);
						if(temp.equalsIgnoreCase(ContentWordSplit[k]))
						{
						//	System.out.println(cnt);
							//System.out.println(temp);
							
							cnt++;
					    }	
					}
			}
			score[i]=cnt;
			br2.write(array[i]+"\n");
			br2.write(cnt+"\n");
			//System.out.println(array[i]);
			//System.out.println("Score: "+cnt);
		}
      br2.close();
	}

}
