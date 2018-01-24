import java.util.ArrayList;
import java.util.List;

public class Grid
{
    private int width;

    private int height;

    private List<Triangle> triangles = new ArrayList<>();

    private List<Problem> problems = new ArrayList<>();

    private List<Path> paths = new ArrayList<>();

    public Grid(int width, int height)
    {
        this.width = width;
        this.height = height;
    }

    public void addTriangle(Triangle triangle)
    {
        triangles.add(triangle);
    }

    public List<Triangle> getTriangles()
    {
        return triangles;
    }

    public void addProblem(Problem problem)
    {
        problems.add(problem);
    }

    public List<Problem> getProblems()
    {
        return problems;
    }

    public boolean isInTriangle(Vertex v)
    {
        for (Triangle triangle : getTriangles()) {
            if (VertexUtils.vertexInterior(v, triangle)) {
                return true;
            }
        }

        return false;
    }

    public void solve()
    {

    }
}
