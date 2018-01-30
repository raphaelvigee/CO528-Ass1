import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Grid
{
    private int width;

    private int height;

    private List<Triangle> triangles = new ArrayList<>();

    private List<Problem> problems = new ArrayList<>();

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

    public void solve()
    {
        int sum = 0;

        for (Problem problem : problems) {
            solve(problem);

            if (problem.hasResultPath()) {
                Path resultPath = problem.getResultPath();
                System.out.println(String.format("Problem %d solved (%d): %s", problem.getNumber(), resultPath.size(), resultPath));
                sum += resultPath.size() - 1;
            }
        }

        System.out.println();
        System.out.println("Total: " + sum);
    }

    private void solve(Problem problem)
    {
        Path root = new Path(problem.getStart());

        problem.getPaths().add(root);

        while (!problem.hasResultPath()) {
            if (!propagatePaths(problem)) {
                System.out.println(problem.getNumber() + ": Stuck");
                return;
            }
        }
    }

    private boolean propagatePaths(Problem problem)
    {
        List<Path> nextConfigs = nextConfigs(problem);

        for (Path nextConfig : nextConfigs) {
            if (nextConfig.getLast().equals(problem.getFinish())) {
                problem.setResultPath(nextConfig);
                problem.getPaths().clear();

                return true;
            }
        }

        problem.getPaths().addAll(nextConfigs);

        return !nextConfigs.isEmpty();
    }

    private List<Path> nextConfigs(Problem problem)
    {
        List<Path> nextPaths = new ArrayList<>();

        List<Path> currentPaths = new ArrayList<>(problem.getPaths());

        for (Path path : currentPaths) {
            for (int x = 0; x < width; x++) {
                for (int y = 0; y < height; y++) {
                    Vertex nextVertex = new Vertex(x, y);

                    if (path.getVertexes().contains(nextVertex)) {
                        continue;
                    }

                    if (VertexUtils.isInPaths(nextPaths, nextVertex)) {
                        continue;
                    }

                    if (!isValid(path.getLast(), nextVertex)) {
                        continue;
                    }

                    Path nextPath = path.clone();
                    nextPath.add(nextVertex);

                    nextPaths.add(nextPath);
                }
            }

            if (nextPaths.isEmpty()) {
                problem.getPaths().remove(path);
            }
        }

        return nextPaths;
    }

    private boolean isValid(Vertex last, Vertex next)
    {
        for (Triangle t : getTriangles()) {
            if (VertexUtils.linesIntersect(t.getV1(), t.getV2(), last, next)) {
                return false;
            }

            if (VertexUtils.linesIntersect(t.getV2(), t.getV3(), last, next)) {
                return false;
            }

            if (VertexUtils.linesIntersect(t.getV3(), t.getV1(), last, next)) {
                return false;
            }
        }

        return true;
    }

    public void exportSolutions()
    {
        for (Problem problem : getProblems()) {

            String content = problem.getResultPath().toString();
            String path = "./solutions/" + problem.getNumber() + ".txt";

            if (!FormatChecker.parse_opening_bracket(new StringTokenizer(content + System.lineSeparator()))) {
                throw new RuntimeException(String.format("Invalid format: \"%s\"", content));
            }

            new File(path).getParentFile().mkdirs();

            try {
                Files.write(Paths.get(path), content.getBytes());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void graph()
    {
        Graph g = new Graph(this);

        g.graph();
    }

    public int getWidth()
    {
        return width;
    }

    public int getHeight()
    {
        return height;
    }
}
