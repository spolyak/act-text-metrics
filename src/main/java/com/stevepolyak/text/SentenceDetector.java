package com.stevepolyak.text;

import java.io.IOException;
import java.io.InputStream;

import opennlp.tools.sentdetect.SentenceDetectorME;
import opennlp.tools.sentdetect.SentenceModel;

public class SentenceDetector {

	public String[] getSentences(String text) {
		String sentences[] = null;
		// http://sourceforge.net/apps/mediawiki/opennlp/index.php?title=Sentence_Detector#Detecting_Sentence_Boundaries
		InputStream modelIn = null;
		modelIn = SentenceDetector.class.getClassLoader().getResourceAsStream(
				"/en-sent.bin");
		try {
			SentenceModel model = new SentenceModel(modelIn);
			SentenceDetectorME sentenceDetector = new SentenceDetectorME(model);
			sentences = sentenceDetector.sentDetect(text);
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (modelIn != null) {
				try {
					modelIn.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		if (sentences == null) {
			return new String[0];
		} else {
			return sentences;
		}		
	}
	
	public int count(String text) {
		String sentences[] = null;
		// http://sourceforge.net/apps/mediawiki/opennlp/index.php?title=Sentence_Detector#Detecting_Sentence_Boundaries
		InputStream modelIn = null;
		modelIn = SentenceDetector.class.getClassLoader().getResourceAsStream(
				"/en-sent.bin");
		try {
			SentenceModel model = new SentenceModel(modelIn);
			SentenceDetectorME sentenceDetector = new SentenceDetectorME(model);
			sentences = sentenceDetector.sentDetect(text);
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (modelIn != null) {
				try {
					modelIn.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		if (sentences == null) {
			return 0;
		} else {
			return sentences.length;
		}
	}
}
