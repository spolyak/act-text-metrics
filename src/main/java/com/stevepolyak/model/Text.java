package com.stevepolyak.model;

import com.stevepolyak.math.StandardDeviation;

public class Text {

	private String value;
	
	private boolean results;
	
	//text metrics
	private int paragraphCount;
	private String[] paragraphs;
	private Integer[] paragraphLengths;
	private int sentenceCount;
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
		return wordCount/paragraphCount;
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
		return (float) StandardDeviation.standardDeviationCalculate(paragraphLengths);
	}
}
