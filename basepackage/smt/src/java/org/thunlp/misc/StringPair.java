package org.thunlp.misc;

public class StringPair implements Comparable<StringPair> {
	public String first;
	public String second;

	@Override
	public int compareTo(StringPair o) {
		int cmp = first.compareTo(o.first);
		if (cmp == 0)
			cmp = second.compareTo(o.second);
		return cmp;
	}

	@Override
	public boolean equals(Object o) {
		if (!(o instanceof StringPair)) {
			return false;
		}
		StringPair sp = (StringPair) o;
		return first.equals(sp.first) && second.equals(sp.second);
	}

	@Override
	public int hashCode() {
		return (first.hashCode() + second.hashCode()) / 2;
	}
}
