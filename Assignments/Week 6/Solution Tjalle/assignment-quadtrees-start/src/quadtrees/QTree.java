package quadtrees;

import java.io.IOException;
import java.io.Reader;
import java.io.Writer;

public class QTree {
	private QuadTreeNode root;

	public QTree(Reader input) {
		try {
			root = readQTree(input);
		} catch (IOException ioException) {
			ioException.printStackTrace();
		}
	}

	public QTree(Bitmap bitmap) {
		root = bitmap2QTree(0, 0, bitmap.getWidth(), bitmap);
	}

	public void fillBitmap(Bitmap bitmap) {
		root.fillBitmap(0, 0, bitmap.getWidth(), bitmap);
	}

	public void writeQTree(Writer sb) throws IOException {
		try {
			root.writeNode(sb);
		} catch (IOException ioException) {
			ioException.printStackTrace();
		}
	}

	private static QuadTreeNode readQTree(Reader input) throws IOException {

		// Setting to WhiteLeaf here instead of adding another else statement
		QuadTreeNode result = new WhiteLeaf();

		try {
			if (input.read() == 1) {

				QuadTreeNode[] innerTree = new QuadTreeNode[] { readQTree(input), readQTree(input), readQTree(input),
						readQTree(input) };
				result = new GreyNode(innerTree);

			} else if (input.read() == 0) {

				result = new BlackLeaf();

			}
		} catch (IOException ioException) {
			ioException.printStackTrace();
		}

		return result;
	}

	public static QuadTreeNode bitmap2QTree(int x, int y, int width, Bitmap bitmap) {
		// Setting to WhiteLeaf here instead of adding another else statement
		QuadTreeNode result = new WhiteLeaf();

		int halfWidth = width / 2;

		for (int i = 0; i < width; i++) {
			for (int j = 0; j < width; j++) {
				if (bitmap.getBit(i, j) != bitmap.getBit(i + 1, y + 1)) {
					QuadTreeNode bitmap2q1 = bitmap2QTree(x, y, halfWidth, bitmap);
					QuadTreeNode bitmap2q2 = bitmap2QTree(x + halfWidth, y, halfWidth, bitmap);
					QuadTreeNode bitmap2q3 = bitmap2QTree(x + halfWidth, y + halfWidth, halfWidth, bitmap);
					QuadTreeNode bitmap2q4 = bitmap2QTree(x, y + halfWidth, halfWidth, bitmap);

					QuadTreeNode[] innerNode = new QuadTreeNode[] { bitmap2q1, bitmap2q2, bitmap2q3, bitmap2q4 };

					result = new GreyNode(innerNode);
				}
			}
		}

		if (bitmap.getBit(x, y)) {
			result = new BlackLeaf();
		}

		return result;
	}

}
