import java.util.ArrayList;
import java.util.List;

public class Problem
{
    private int number;

    private Vertex start;

    private Vertex finish;

    private List<Path> paths = new ArrayList<>();

    private Path resultPath = null;

    public Problem(int number, Vertex start, Vertex finish)
    {
        this.number = number;
        this.start = start;
        this.finish = finish;
    }

    public Vertex getStart()
    {
        return start;
    }

    public Vertex getFinish()
    {
        return finish;
    }

    public int getNumber()
    {
        return number;
    }

    public List<Path> getPaths()
    {
        return paths;
    }

    public Path getResultPath()
    {
        return resultPath;
    }

    public void setResultPath(Path resultPath)
    {
        this.resultPath = resultPath;
    }

    public boolean hasResultPath()
    {
        return getResultPath() != null;
    }

    public boolean isInPaths(Vertex v)
    {
        return VertexUtils.isInPaths(getPaths(), v);
    }
}
