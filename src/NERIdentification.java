import edu.stanford.nlp.ie.AbstractSequenceClassifier;
import edu.stanford.nlp.ie.crf.*;
import edu.stanford.nlp.io.IOUtils;
import edu.stanford.nlp.ling.CoreLabel;
import edu.stanford.nlp.ling.CoreAnnotations;
import edu.stanford.nlp.sequences.DocumentReaderAndWriter;
import edu.stanford.nlp.util.Triple;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.List;

public class NERIdentification {

  public static void main(String[] args) throws Exception {

    String serializedClassifier = "classifiers/english.conll.4class.distsim.crf.ser.gz";

    if (args.length > 0) {
      serializedClassifier = args[0];
    }

    AbstractSequenceClassifier<CoreLabel> classifier = CRFClassifier.getClassifier(serializedClassifier);

      if (args.length > 1) {

    } else {
	     BufferedReader bf=new BufferedReader(new FileReader("question1.txt"));
	     BufferedWriter br1 = new BufferedWriter(new FileWriter("QuestionWithNER.txt"));
	     String str ="";
	     str=bf.readLine();
       while(str != null){
    	   br1.write(classifier.classifyToString(str, "slashTags", false));
    	   br1.write("\n");
    	   str = bf.readLine();
    	  
       }
       bf.close();
       br1.close();
    }
  }

}


