package quadtrees;

import java.io.IOException;
import java.io.Writer;

public class GreyNode implements QuadTreeNode {

    // Array for all children
    private QuadTreeNode[] c;

    public GreyNode(QuadTreeNode[] c) {
        this.c = c;
    }

    @Override
    public void fillBitmap(int x, int y, int width, Bitmap bitmap) {
        int halfWidth = width / 2;
        c[0].fillBitmap(x, y, halfWidth, bitmap);
        c[1].fillBitmap(x + halfWidth, y, halfWidth, bitmap);
        c[2].fillBitmap(x + halfWidth, y + halfWidth, halfWidth, bitmap);
        c[3].fillBitmap(x, y + halfWidth, halfWidth, bitmap);
    }

    @Override
    public void writeNode(Writer out) throws IOException {

        try {
            out.append('1');

            for (int i = 0; i < c.length; i++) {
                c[i].writeNode(out);
            }
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }

    }

}
