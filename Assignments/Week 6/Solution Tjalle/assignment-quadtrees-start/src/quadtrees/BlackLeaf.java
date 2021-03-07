package quadtrees;

import java.io.IOException;
import java.io.Writer;

public class BlackLeaf implements QuadTreeNode {

    @Override
    public void fillBitmap(int x, int y, int width, Bitmap bitmap) {

        bitmap.fillArea(x, y, width, false);

    }

    @Override
    public void writeNode(Writer out) throws IOException {

        try {
            out.append("00");
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }

    }

}
