import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;


public class ParagraphExtraction {
     public static void main(String[] args) throws IOException {
     BufferedReader br=new BufferedReader(new FileReader("Dataset.txt"));
     BufferedWriter br1=new BufferedWriter(new FileWriter("Paragraph.txt"));
     String str;
     str=br.readLine();
     String word="\"context\":";
     int index=str.indexOf(word);
     int counter=1;
     while(index>=0)
     {
    	 String ans;
    	 index=index+10;
    	 while(str.charAt(index)!='\"')
    		 index++;
    	index++;
    	int last=str.indexOf("\"qas\"", index);
    	ans=str.substring(index, last);
        br1.write(counter+") "+ans.substring(0,ans.length()-3)+"\n");
    	index=str.indexOf(word,index+1);
    	counter++;
     }
	}

}
