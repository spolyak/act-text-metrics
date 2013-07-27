package com.stevepolyak.text;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ParagraphDetectorMain {

	public static void main(String[] args) {
		String sentence = "A wonderful fact v2.0 B.F. Skinner to reflect upon, that every human creature is constituted to be that profound secret and mystery to every other.\n A solemn consideration, when I enter a great city by night, that every one of those darkly clustered houses encloses its own secret; that every room in every one of them encloses its own secret; that every beating heart in the hundreds of thousands of breasts there, is, in some of its imaginings, a secret to the heart nearest it! Something of the awfulness, even of Death itself, is referable to this. No more can I turn the leaves of this dear book that I loved, and vainly hope in time to read it all. No more can I look into the depths of this unfathomable water, wherein, as momentary lights glanced into it, I have had glimpses of buried treasure and other things submerged. It was appointed that the book should shut with a spring, for ever and for ever, when I had read but a page. It was appointed that the water should be locked in an eternal frost, when the light was playing on its surface, and I stood in ignorance on the shore.";
		Matcher m = Pattern.compile("(\n)|(\r)|(\r\n)").matcher(sentence);
		int lines = 1;
		while (m.find()) {
			lines++;
		}
		System.out.println("Paragraph Count: " + lines);
	}
}
