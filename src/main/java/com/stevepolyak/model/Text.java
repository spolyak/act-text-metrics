package com.stevepolyak.model;

import com.stevepolyak.math.StandardDeviation;

public class Text {

	private String value;
	
	private boolean results;
	
	//text metrics
	private int paragraphCount;
	private String[] paragraphs;
	private Integer[] paragraphLengths;
	private Integer[] paragraphSentenceLengths;
	private int sentenceCount;
	private String[] sentences;
	private Integer[] sentenceLengths;
	private String[] words;
	private Integer[] wordLengths;
	private int letterCount;
	private Integer[] syllableCounts;
	private int syllableCount;
	private int wordCount;
	
	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public int getParagraphCount() {
		return paragraphCount;
	}

	public void setParagraphCount(int paragraphCount) {
		this.paragraphCount = paragraphCount;
	}

	public boolean getResults() {
		return results;
	}

	public void setResults(boolean results) {
		this.results = results;
	}

	public int getSentenceCount() {
		return sentenceCount;
	}

	public void setSentenceCount(int sentenceCount) {
		this.sentenceCount = sentenceCount;
	}

	public int getWordCount() {
		return wordCount;
	}

	public void setWordCount(int wordCount) {
		this.wordCount = wordCount;
	}
	
	public float getParagraphLengthMean() {
		return (float) wordCount/paragraphCount;
	}

	public String[] getParagraphs() {
		return paragraphs;
	}

	public void setParagraphs(String[] paragraphs) {
		this.paragraphs = paragraphs;
	}

	public Integer[] getParagraphLengths() {
		return paragraphLengths;
	}

	public void setParagraphLengths(Integer[] paragraphLengths) {
		this.paragraphLengths = paragraphLengths;
	}
	
	public float getParagraphLengthSD() {
		return (float) StandardDeviation.standardDeviationCalculate(paragraphSentenceLengths);
	}

	public String[] getSentences() {
		return sentences;
	}

	public void setSentences(String[] sentences) {
		this.sentences = sentences;
	}

	public Integer[] getSentenceLengths() {
		return sentenceLengths;
	}

	public void setSentenceLengths(Integer[] sentenceLengths) {
		this.sentenceLengths = sentenceLengths;
	}

	public Integer[] getParagraphSentenceLengths() {
		return paragraphSentenceLengths;
	}

	public void setParagraphSentenceLengths(Integer[] paragraphSentenceLengths) {
		this.paragraphSentenceLengths = paragraphSentenceLengths;
	}
	public float getSentenceLengthMean() {
		return (float) wordCount/sentenceCount;
	}
	public float getSentenceLengthSD() {
		return (float) StandardDeviation.standardDeviationCalculate(sentenceLengths);
	}

	public Integer[] getSyllableCounts() {
		return syllableCounts;
	}

	public void setSyllableCounts(Integer[] syllableCounts) {
		this.syllableCounts = syllableCounts;
	}

	public String[] getWords() {
		return words;
	}

	public void setWords(String[] words) {
		this.words = words;
	}
	public float getSyllablesLengthMean() {
		return (float) syllableCount/wordCount;
	}

	public int getSyllableCount() {
		return syllableCount;
	}

	public void setSyllableCount(int syllabelCount) {
		this.syllableCount = syllabelCount;
	}
	public float getSyllablesLengthSD() {
		return (float) StandardDeviation.standardDeviationCalculate(syllableCounts);
	}

	public Integer[] getWordLengths() {
		return wordLengths;
	}

	public void setWordLengths(Integer[] wordLengths) {
		this.wordLengths = wordLengths;
	}
	public float getWordLengthMean() {
		return (float) letterCount/wordCount;
	}

	public int getLetterCount() {
		return letterCount;
	}

	public void setLetterCount(int letterCount) {
		this.letterCount = letterCount;
	}
	public float getWordLengthsSD() {
		return (float) StandardDeviation.standardDeviationCalculate(wordLengths);
	}
	
	public double getFleschKincaidGradeLevel() {
	   return (.39*(wordCount/sentenceCount))+(11.8*(syllableCount/wordCount))-15.59;
	}
	public double getFleschReadingEase() {
	   return 206.835 - (1.015*(wordCount/sentenceCount)) - (84.6*(syllableCount/wordCount));
	}
}
