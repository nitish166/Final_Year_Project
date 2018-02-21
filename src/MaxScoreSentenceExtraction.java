import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;


public class MaxScoreSentenceExtraction {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader( new FileReader ("SentenceExtraction.txt"));
		BufferedWriter br2 = new BufferedWriter(new FileWriter("MaxScoreSentenceExtraction.txt"));

		int mx1=0,mx2=0;
		String mxx1=null,mxx2=null;
		while(true)
		{
			String t1=br.readLine();
			if(t1==null)
				break;
			int t2=Integer.parseInt(br.readLine());
			if(t2>=mx1&&t2<mx2)
			{
				mx1=t2;
				mxx1=t1;
			}
			else if(t2>=mx2)
			{
				int temp=mx2;
				String tt=mxx2;
				mx2=t2;
				mxx2=t1;
				mx1=temp;
				mxx1=tt;
			}	
		}
		br2.write(mxx2+" "+"\nScore: "+mx2+"\n");
		br2.write(mxx1+" "+"\nScore: "+mx1+"\n");
		
		br2.close();
		
	}

}
