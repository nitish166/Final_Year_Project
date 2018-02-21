package edu.stanford.nlp.parser.nndep.demo;

import edu.stanford.nlp.ling.HasWord;
import edu.stanford.nlp.ling.TaggedWord;
import edu.stanford.nlp.parser.nndep.DependencyParser;
import edu.stanford.nlp.parser.nndep.demo.DependencyParserDemo;
import edu.stanford.nlp.process.DocumentPreprocessor;
import edu.stanford.nlp.tagger.maxent.MaxentTagger;
import edu.stanford.nlp.trees.GrammaticalStructure;
import edu.stanford.nlp.util.logging.Redwood;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.StringReader;
import java.util.List;

public class Universal_Dependencies  {

  public static Redwood.RedwoodChannels log = Redwood.channels(DependencyParserDemo.class);

  public static void main(String[] args) throws IOException {
    String modelPath = DependencyParser.DEFAULT_MODEL;
    String taggerPath = "edu/stanford/nlp/models/pos-tagger/english-left3words/english-left3words-distsim.tagger";

    for (int argIndex = 0; argIndex < args.length; ) {
      switch (args[argIndex]) {
        case "-tagger":
          taggerPath = args[argIndex + 1];
          argIndex += 2;
          break;
        case "-model":
          modelPath = args[argIndex + 1];
          argIndex += 2;
          break;
        default:
          throw new RuntimeException("Unknown argument " + args[argIndex]);
      }
    }

   // String text = "What day was the game played on.";
    
    BufferedReader bf=new BufferedReader(new FileReader("SampleQuestion.txt"));
	BufferedWriter br1 = new BufferedWriter(new FileWriter("Sample_output_of_universal_Dependencies.txt"));
	  
	String str=bf.readLine();
 
    MaxentTagger tagger = new MaxentTagger("edu/stanford/nlp/models/pos-tagger/english-left3words/english-left3words-distsim.tagger");
    DependencyParser parser = DependencyParser.loadFromModelFile( "edu/stanford/nlp/models/parser/nndep/english_UD.gz");

    DocumentPreprocessor tokenizer = new DocumentPreprocessor(new StringReader(str));
    for (List<HasWord> sentence : tokenizer) 
    {
      List<TaggedWord> tagged = tagger.tagSentence(sentence);
      GrammaticalStructure gs = parser.predict(tagged);
   
      // Print typed dependencies
      log.info(gs);
    //  br1.write();
    }
    bf.close();
    br1.close();
  }
}

