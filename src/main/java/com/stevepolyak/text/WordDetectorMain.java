package com.stevepolyak.text;

import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import edu.stanford.nlp.ling.CoreLabel;
import edu.stanford.nlp.ling.HasWord;
import edu.stanford.nlp.ling.Word;
import edu.stanford.nlp.parser.charniak.CharniakParser;
import edu.stanford.nlp.process.CoreLabelTokenFactory;
import edu.stanford.nlp.process.DocumentPreprocessor;
import edu.stanford.nlp.process.PTBTokenizer;
import edu.stanford.nlp.process.WordTokenFactory;

public class WordDetectorMain {

	public static void main(String[] args) {

		String sentence = "A wonderful fact v2.0 B.F. Skinner to reflect upon, that every human creature is constituted to be that profound secret and mystery to every other.\n A solemn consideration, when I enter a great city by night, that every one of those darkly clustered houses encloses its own secret; that every room in every one of them encloses its own secret; that every beating heart in the hundreds of thousands of breasts there, is, in some of its imaginings, a secret to the heart nearest it! Something of the awfulness, even of Death itself, is referable to this. No more can I turn the leaves of this dear book that I loved, and vainly hope in time to read it all. No more can I look into the depths of this unfathomable water, wherein, as momentary lights glanced into it, I have had glimpses of buried treasure and other things submerged. It was appointed that the book should shut with a spring, for ever and for ever, when I had read but a page. It was appointed that the water should be locked in an eternal frost, when the light was playing on its surface, and I stood in ignorance on the shore.";
		String s1 = "This would be a great place for you to move. There is a lot close by, like Publix is right down the road.There are also some good places for dinner and for breakfaest. My favorite place to go is to Marias. Some good breakfeast places are Dunkin Daunts, and Old Hickry House. also if you like to read you can go by the public library close by. there is even Somithe King.there are alot of sidewalks if you like to walk. There is so much that I did not tell you, you need to come and see it yourself!";
		String s2 = "This would be a great place for you to move. I like cheese.";
        String s3 = "I would tell them that there is a lot of nice people were I live so do you want to come and live in my town?lt will be so fun and can come to my school and you can play with at reasese we will have a lot of fun just think about it amagine how much fun stuff we will play with and we can have sleep overs we can even play cars if you wanted.we can even play mind craft but I really like to with cars. But I do not care what we play with I hope we will see each other. I hope you come here.";

		CharniakParser cp = new CharniakParser();
		PTBTokenizer<HasWord> ptbt = new PTBTokenizer(new StringReader(s1),
				new WordTokenFactory(), "");
		List<Word> tokens = new ArrayList<Word>();
		for (Word token; ptbt.hasNext();) {
			token = (Word) ptbt.next();
			// if(!token.word().trim().equals(".")) {
			// tokens.add(token);
			// }
			if (!token.word().trim().matches("\\.|,|-|\\?|!")) {
				tokens.add(token);
			} else {
				System.out.println("no match: " + token.word());
			}
		}
		System.out.println("Word count: " + tokens.size());

		/* DocumentPreprocessor dp = new DocumentPreprocessor(new StringReader(s1));
		for (List sentencea : dp) {
			System.out.println(sentencea);
		}
		// option #2: By token
		PTBTokenizer ptbta = new PTBTokenizer(new StringReader(s1),
				new CoreLabelTokenFactory(), "");
		for (CoreLabel label; ptbta.hasNext();) {
			label = (CoreLabel) ptbta.next();
			System.out.println(label);
		} */
	}
}
