package org.thunlp.language.chinese;

import junit.framework.Assert;
import junit.framework.TestCase;

public class NaiveBigramWordSegmentTest extends TestCase {
	public void testBasic() {
		NaiveBigramWordSegment ws = new NaiveBigramWordSegment();
		String input = "我们是中国人,是不善于speak English的~";
		String[] standard = { "我们", "们是", "是中", "中国", "国人", "人,", ",是", "是不", "不善", "善于", "于s", "sp", "pe", "ea", "ak",
				"k ", " E", "En", "ng", "gl", "li", "is", "sh", "h的", "的~" };

		String[] output = ws.segment(input);
		Assert.assertEquals(standard.length, output.length);
		for (int i = 0; i < output.length; i++) {
			// System.out.println(output[i]);
			Assert.assertEquals(standard[i], output[i]);
		}
	}
}
