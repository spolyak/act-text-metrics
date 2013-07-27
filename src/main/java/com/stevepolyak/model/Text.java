package com.stevepolyak.model;

public class Text {

	private String value;
	
	private boolean results;
	
	//text metrics
	private int paragraphCount;
	
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
}
