package Day4;

import java.util.Objects;

public class CharCounting implements Comparable<CharCounting> {
	
	private char key;
	private int value;
	
	public CharCounting(char key, int value) {
		this.key = key;
		this.value = value;
	}

	public char getKey() {
		return key;
	}

	public int getValue() {
		return value;
	}

	@Override
	public int hashCode() {
		return Objects.hash(key, value);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CharCounting other = (CharCounting) obj;
		return key == other.key && value == other.value;
	}

	@Override
	public int compareTo(CharCounting o) {
		if (this.value > o.getValue()) {
			return 1;
		} else if (this.value < o.getValue()) {
			return -1;
		} else {
			if (this.getKey() < o.getKey()) {
				return 1;
			} else if (this.getKey() > o.getKey()){
				return -1;
			} else {
				return 0;
			}
		}
	}
}
