import java.awt.List;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;
public class QuestionAndAnswerExtraction {
	static  String str;
	static BufferedWriter br1;
	static ArrayList findAnswer(int end,int index,int questionnum)
	    {
		ArrayList ans=new ArrayList();
		int counter=1;
		while(end<=index)
		{
			end=end+6;
			int end2=str.indexOf("\"}",end);
			ans.add(questionnum+"."+counter+") "+str.substring(end+3,end2));
			end=str.indexOf("\"text\":",end2);
			counter++;
		}
		return ans;
	}
	static void  findQuestion(int index,int last) throws IOException
	{
		ArrayList ans=new ArrayList();
		String question="\"question\":";
		String id="\"id\":";
		int counter=1;
		int cnt=index;
		cnt=str.indexOf("\"text\":",index);
		index=str.indexOf(question,index);
		
		ans=findAnswer(cnt,index,counter);
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
			br1.write(counter+") "+str.substring(q1+13,q2)+"\n");
			Iterator itr=ans.iterator();
			while(itr.hasNext())
			{
				br1.write(itr.next().toString()+"\n");
			}
			cnt=str.indexOf("\"text\":",cnt);
			counter++;
			ans=findAnswer(cnt,index,counter);		
		}	
	}
	public static void main(String[] args) throws IOException {
	     BufferedReader br=new BufferedReader(new FileReader("Dataset.txt"));
	     br1=new BufferedWriter(new FileWriter("QuestionAndAnswer.txt"));   
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
	    	br1.write("Paragraph: "+counter+"\n");
	    	index=str.indexOf(word,index);
	    	findQuestion(first,index);
	    	counter++;	    	
	     }
	     findQuestion(first,str.length());
	     br1.close();
		}


}