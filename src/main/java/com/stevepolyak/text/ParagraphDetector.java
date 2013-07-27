package com.stevepolyak.text;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ParagraphDetector {

	public int count(String text) {
		Matcher m = Pattern.compile("(\n)").matcher(text);
		int lines = 1;
		while (m.find()) {
			lines++;
		}
		return lines;
	}
}
