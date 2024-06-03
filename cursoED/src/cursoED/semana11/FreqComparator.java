package cursoED.semana11;

import java.util.Comparator;

public class FreqComparator implements Comparator<HuffmanNode>{
	public int compare(HuffmanNode x, HuffmanNode y) {
		return x.freq - y.freq;
	}
}
