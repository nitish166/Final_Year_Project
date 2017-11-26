import edu.stanford.nlp.util.logging.Redwood;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.List;

import edu.stanford.nlp.ling.SentenceUtils;
import edu.stanford.nlp.ling.TaggedWord;
import edu.stanford.nlp.ling.HasWord;
import edu.stanford.nlp.ling.CoreLabel;
import edu.stanford.nlp.process.CoreLabelTokenFactory;
import edu.stanford.nlp.process.DocumentPreprocessor;
import edu.stanford.nlp.process.PTBTokenizer;
import edu.stanford.nlp.process.TokenizerFactory;
import edu.stanford.nlp.tagger.maxent.MaxentTagger;


public class POSIdentification  {


  public static void main(String[] args) throws Exception {
      
	 
	  MaxentTagger tagger =  new MaxentTagger("models/english-left3words-distsim.tagger"); 
	  BufferedReader bf=new BufferedReader(new FileReader("question1.txt"));
	  BufferedWriter br1 = new BufferedWriter(new FileWriter("QuestionWithPOS.txt"));
	  
	  String str=bf.readLine();
	  
	   while(str != null)
	  {
	   String tagged = tagger.tagString(str);
   	   br1.write(tagged);
   	   br1.write("\n");
   	   str = bf.readLine();
      }
	  bf.close();
	  br1.close();
      }

}
