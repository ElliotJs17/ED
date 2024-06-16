package cursoED.semana12;

public class BTreeNode {
	protected int[] keys; // An array of keys
	protected int t; // Minimum degree (defines the range for number
			// of keys)
	BTreeNode[] C; // An array of child pointers
	int n; // Current number of keys
	boolean leaf; // Is true when node is leaf. Otherwise false

	// Constructor
	public BTreeNode(int t, boolean leaf) {
		this.t = t;
		this.leaf = leaf;
		this.keys = new int[2 * t - 1];
		this.C = new BTreeNode[2 * t]; 
		this.n = 0;
	}

	// A function to traverse all nodes in a subtree rooted
	// with this node
	public void traverse() {

		// There are n keys and n+1 children, traverse
		// through n keys and first n children
		int i = 0;
		for (i = 0; i < this.n; i++) {

			// If this is not leaf, then before printing
			// key[i], traverse the subtree rooted with
			// child C[i].
			if (this.leaf == false) {
				C[i].traverse();
			}
			System.out.print(keys[i] + " ");
		}

		// Print the subtree rooted with last child
		if (leaf == false)
			C[i].traverse();
	}

	// A function to search a key in the subtree rooted with
	// this node.
	public BTreeNode search(int k) { // returns NULL if k is not present.

		// Find the first key greater than or equal to k
		int i = 0;
		while (i < n && k > keys[i])
			i++;

		// If the found key is equal to k, return this node
		if (keys[i] == k)
			return this;

		// If the key is not found here and this is a leaf
		// node
		if (leaf == true)
			return null;

		// Go to the appropriate child
		return C[i].search(k);
	}

	public void insertNonFull(int k) {
		int i = n - 1;
		if (leaf) {
			while (i >= 0 && keys[i] > k) {
				keys[i + 1] = keys[i];
				i--;
			}
			keys[i + 1] = k;
			n++;
		} else {
			while (i >= 0 && keys[i] > k) {
				i--;
			}
			if (C[i + 1].n == 2 * t - 1) {
				splitChild(i + 1, C[i + 1]);
				if (keys[i + 1] < k) {
					i++;
				}
			}
			C[i + 1].insertNonFull(k);
		}
	}

	public void splitChild(int i, BTreeNode y) {
		BTreeNode z = new BTreeNode(y.t, y.leaf);
		z.n = t - 1;
		for (int j = 0; j < t - 1; j++) {
			z.keys[j] = y.keys[j + t];
		}
		if (!y.leaf) {
			for (int j = 0; j < t; j++) {
				z.C[j] = y.C[j + t];
			}
		}
		y.n = t - 1;
		for (int j = n; j > i; j--) {
			C[j + 1] = C[j];
		}
		C[i + 1] = z;
		for (int j = n - 1; j >= i; j--) {
			keys[j + 1] = keys[j];
		}
		keys[i] = y.keys[t - 1];
		n++;
	}

}
