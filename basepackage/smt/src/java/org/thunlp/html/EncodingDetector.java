package org.thunlp.html;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EncodingDetector {
	private static Pattern charsetPat = Pattern.compile("; ?charset=([A-Za-z0-9_-]+)", Pattern.CASE_INSENSITIVE);

	public static String detect(byte[] page) {
		int previewLength = page.length > 1024 ? 1024 : page.length;
		String charsetName = "gbk";
		String preview = new String(page, 0, previewLength);
		Matcher m = charsetPat.matcher(preview);
		if (m.find()) {
			charsetName = m.group(1);
		}
		return charsetName;
	}
}
