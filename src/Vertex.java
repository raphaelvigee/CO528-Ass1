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

    public int getX()
    {
        return x;
    }

    public int getY()
    {
        return y;
    }

    public int compareTo(Vertex v)
    {
        if (v.getX() == getX()) {
            return v.getY() - getY();
        } else {
            return v.getX() - getX();
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
