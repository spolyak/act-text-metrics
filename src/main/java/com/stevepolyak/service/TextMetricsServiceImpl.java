package com.stevepolyak.service;

import org.springframework.stereotype.Service;

import com.stevepolyak.model.Text;
import com.stevepolyak.text.ParagraphDetector;

@Service
public class TextMetricsServiceImpl implements TextMetricsService {

	ParagraphDetector paragraphDetector;

	public TextMetricsServiceImpl() {
		paragraphDetector = new ParagraphDetector();
	}

	@Override
	public Text compute(Text text) {
		text.setParagraphCount(paragraphDetector.count((text.getValue())));
		text.setResults(true);
		return text;
	}
}
