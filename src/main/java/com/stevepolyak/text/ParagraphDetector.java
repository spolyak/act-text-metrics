package com.stevepolyak.text;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ParagraphDetector {

	public int count(String text) {
		String text1 = text.replaceAll("(\r?\n)+", "\n");
		Matcher m = Pattern.compile("(\n)").matcher(text1);
		int lines = 1;
		while (m.find()) {
			lines++;
		}
		return lines;
	}
	
	public String[] getParagraphs(String text) {
		String text1 = text.replaceAll("(\r?\n)+", "\n");
		Matcher m = Pattern.compile("(.*\n)").matcher(text1);
		List<String> lines = new ArrayList<String>();
		while (m.find()) {
			lines.add(m.group(1));
		}
		return lines.toArray(new String[lines.size()]);
	}
	
}
