package org.thunlp.text;

import junit.framework.Assert;
import junit.framework.TestCase;

public class DocumentVectorTest extends TestCase {
	private Lexicon lexicon;
	private String[][] docs = { { "I", "eat", "breakfast", "at", "home" },
			{ "I", "make", "breakfast", "for", "my", "family" },
			{ "A", "nice", "organized", "family", "tree", "by", "me" } };

	public void setUp() {
		lexicon = new Lexicon();
		for (String[] doc : docs)
			lexicon.addDocument(doc);
	}

	public void testVectorBuild() {
		DocumentVector dv = new DocumentVector(lexicon);
		String doc = "a nice family breakfast for nice me";
		Term[] v = dv.build(lexicon.convertDocument(doc.split(" ")), true);
		Assert.assertNotNull(v);
		Assert.assertEquals(6, v.length);
		for (int i = 1; i < v.length; i++) {
			Assert.assertTrue(v[i].id > v[i - 1].id);
		}
		double m = 0.0;
		for (Term t : v) {
			m += t.weight * t.weight;
		}
		Assert.assertTrue(Math.abs(m - 1) < 0.00000001);
	}

	public void testDotProduct() {
		Lexicon lexicon = new Lexicon();
		DocumentVector dv = new DocumentVector(lexicon);
		String doc1 = "eat breakfast";
		String doc2 = "eat tree";
		lexicon.addDocument(doc1.split(" "));
		lexicon.addDocument(doc2.split(" "));
		Term[] v1 = dv.build(lexicon.convertDocument(doc1.split(" ")), true);
		Term[] v2 = dv.build(lexicon.convertDocument(doc2.split(" ")), true);
		Assert.assertEquals(1.0, dv.dotProduct(v1, v1));
		Assert.assertTrue(Math.abs(dv.dotProduct(v1, v2) - 0.2847) < 0.001);
	}
}
