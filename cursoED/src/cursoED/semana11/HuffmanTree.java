package cursoED.semana11;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class HuffmanTree {
	private char[] charArray;
	private int[] charfreq;
	private Map<Character, String> charCodificado = new HashMap<>();
	private Map<String, Character> codificadoChar = new HashMap<>();
	HuffmanNode root;

	HuffmanTree(char[] charArray, int[] charfreq) {
		this.charArray = charArray;
		this.charfreq = charfreq;
		root = buildTree();
		buildMaps(root, "");
	}

	public String getCodificado(char car) {
		return charCodificado.get(car);
	}

	public String getDesCodificado(String str) {
		String result = "";
		String codigo = "";
		for (int i = 0; i < str.length(); i++) {
			// Por completar.
			codigo += str.charAt(i);
			if (codificadoChar.containsKey(codigo)) {
				result += codificadoChar.get(codigo);
				codigo = "";
			}
		}

		if (!codigo.isEmpty()) { 
			return "";
		}
		return result;
	}

	private void buildMaps(HuffmanNode root, String s) {
		if (root.left == null && root.right == null && Character.isLetter(root.c)) { 
			// Por completar.
			charCodificado.put(root.c, s);
			codificadoChar.put(s, root.c);
			return;
		}
		buildMaps(root.left, s + "0");
		buildMaps(root.right, s + "1"); 
	}

	private HuffmanNode buildTree() {
		PriorityQueue<HuffmanNode> q = new PriorityQueue<HuffmanNode>(charArray.length, new FreqComparator());
		for (int i = 0; i < charArray.length; i++) {
			// Por completar.
			HuffmanNode hn = new HuffmanNode();
			hn.c = charArray[i];
			hn.freq = charfreq[i];
			hn.left = null;
			hn.right = null; 
			q.add(hn);

		}
		HuffmanNode root = null;
		while (q.size() > 1) {
			// Por completar.
			HuffmanNode x = q.poll();
			HuffmanNode y = q.poll();
			HuffmanNode z = new HuffmanNode(); 
			z.freq = x.freq + y.freq;
			z.c = '-';
			z.left = x;
			z.right = y;
			root = z;
			q.offer(z);
		}
		return root;
	}
}
