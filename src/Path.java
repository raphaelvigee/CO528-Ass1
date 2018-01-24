import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class Path
{
    private Set<Vertex> vertexes = new HashSet<>();

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

    public Set<Vertex> getVertexes()
    {
        return vertexes;
    }

    public Path clone()
    {
        Path newPath = new Path();

        getVertexes().forEach(newPath::add);

        return newPath;
    }
}
