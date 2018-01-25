import java.util.LinkedList;
import java.util.stream.Collectors;

public class Path
{
    private LinkedList<Vertex> vertexes = new LinkedList<>();

    public Path()
    {
    }

    public Path(Vertex start)
    {
        add(start);
    }

    public void add(Vertex v)
    {
        vertexes.add(v);
    }

    @Override
    public String toString()
    {
        return vertexes.stream()
                .map(Vertex::toString)
                .collect(Collectors.joining(" "));
    }

    public LinkedList<Vertex> getVertexes()
    {
        return vertexes;
    }

    public Path clone()
    {
        Path newPath = new Path();

        getVertexes().forEach(newPath::add);

        return newPath;
    }

    public Vertex getLast()
    {
        return getVertexes().getLast();
    }
}
