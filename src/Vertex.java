import java.util.Objects;

public class Vertex implements Comparable<Vertex>
{
    private int x;

    private int y;

    Vertex(int x, int y)
    {
        this.x = x;
        this.y = y;
    }

    public int get_x()
    {
        return x;
    }

    public int get_y()
    {
        return y;
    }

    public int compareTo(Vertex v)
    {
        if (v.get_x() == get_x()) {
            return v.get_y() - get_y();
        } else {
            return v.get_x() - get_x();
        }
    }

    public String toString()
    {
        return "(" + x + ", " + y + ")";
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        Vertex vertex = (Vertex) o;
        return x == vertex.x &&
                y == vertex.y;
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(x, y);
    }
}
