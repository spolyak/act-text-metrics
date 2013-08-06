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
	private Integer[] syllableCounts;
	private int syllabelCount;
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
	public float getSyllabelsLengthMean() {
		return (float) syllabelCount/wordCount;
	}

	public int getSyllabelCount() {
		return syllabelCount;
	}

	public void setSyllabelCount(int syllabelCount) {
		this.syllabelCount = syllabelCount;
	}
}
