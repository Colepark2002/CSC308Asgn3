import java.awt.*;

public class Marker
{
    private final int index;
    private final Color c;

    public Marker(int index, Color c) {
        this.index = index;
        this.c = c;
    }

    public int getIndex() {
        return index;
    }

    public Color getC() {
        return c;
    }
}
