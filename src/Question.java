
import java.awt.List;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;
public class Question {
	static  String str;
	static BufferedWriter br1;
	
	static void  findQuestion(int index,int last) throws IOException
	{
		ArrayList ans=new ArrayList();
		String question="\"question\":";
		String id="\"id\":";
		int counter=1;
		int cnt=index;
		cnt=str.indexOf("\"text\":",index);
		index=str.indexOf(question,index);
		
		
		while(index>=0&&index<=last)
		{
			int end=index;
			while(str.charAt(end)!='?')
				end++;
			int q1=index;
			int q2=end;
			index=end;
			cnt=index;
			index=str.indexOf(question,end);
			br1.write(str.substring(q1+13,q2)+"\n");
			Iterator itr=ans.iterator();
			while(itr.hasNext())
			{
				br1.write(itr+"\n");
			}
			cnt=str.indexOf("\"text\":",cnt);
			counter++;
				
		}	
	}
	public static void main(String[] args) throws IOException {
	     BufferedReader br=new BufferedReader(new FileReader("Dataset.txt"));
	     br1=new BufferedWriter(new FileWriter("Question.txt"));   
	     str=br.readLine();
	     String word="\"context\":";
	     int index=str.indexOf(word);
	     System.out.println(index);
	     int counter=1;
	     int first=0;
	     while(index>=0)
	     {
	    	index=index+1;
	    	first=index;
	    	index=str.indexOf(word,index);
	    	findQuestion(first,index);
	    	counter++;	    	
	     }
	     findQuestion(first,str.length());
	     br1.close();
		}


}