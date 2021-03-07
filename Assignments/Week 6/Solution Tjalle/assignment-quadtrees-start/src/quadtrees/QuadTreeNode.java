
package quadtrees;

import java.io.IOException;
import java.io.Writer;

public interface QuadTreeNode {
	
	public void fillBitmap(int x, int y, int width, Bitmap bitmap);

	public void writeNode(Writer out) throws IOException;
	

}
