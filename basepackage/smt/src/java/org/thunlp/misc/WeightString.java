package org.thunlp.misc;

public class WeightString implements Comparable<WeightString> {
	public String text = null;
	public double weight = 0.0;

	public WeightString() {
		this.text = null;
		this.weight = 0.0;
	}

	public WeightString(String text, double weight) {
		this.text = text;
		this.weight = weight;
	}

	public int compareTo(WeightString o) {
		if (o instanceof WeightString) {
			double w = ((WeightString) o).weight;
			return Double.compare(this.weight, w);
		}
		return 0;
	}

	public String toString() {
		return text + ":" + weight;
	}
}
