public class Main
{
    public static void main(String[] args)
    {
        Grid grid = new Grid(24, 24);

        grid.addTriangle(new Triangle(new Vertex(11, 0), new Vertex(13, 1), new Vertex(18, 5)));
        grid.addTriangle(new Triangle(new Vertex(5, 4), new Vertex(7, 9), new Vertex(5, 8)));
        grid.addTriangle(new Triangle(new Vertex(2, 3), new Vertex(4, 11), new Vertex(2, 6)));
        grid.addTriangle(new Triangle(new Vertex(13, 7), new Vertex(14, 9), new Vertex(17, 10)));
        grid.addTriangle(new Triangle(new Vertex(4, 9), new Vertex(11, 16), new Vertex(9, 11)));
        grid.addTriangle(new Triangle(new Vertex(11, 3), new Vertex(19, 7), new Vertex(18, 10)));
        grid.addTriangle(new Triangle(new Vertex(14, 10), new Vertex(17, 12), new Vertex(22, 11)));
        grid.addTriangle(new Triangle(new Vertex(3, 1), new Vertex(12, 9), new Vertex(6, 9)));
        grid.addTriangle(new Triangle(new Vertex(9, 11), new Vertex(14, 12), new Vertex(14, 19)));
        grid.addTriangle(new Triangle(new Vertex(12, 2), new Vertex(18, 7), new Vertex(20, 8)));
        grid.addTriangle(new Triangle(new Vertex(3, 3), new Vertex(10, 6), new Vertex(12, 8)));
        grid.addTriangle(new Triangle(new Vertex(9, 15), new Vertex(16, 19), new Vertex(14, 15)));
        grid.addTriangle(new Triangle(new Vertex(11, 2), new Vertex(18, 6), new Vertex(11, 3)));
        grid.addTriangle(new Triangle(new Vertex(11, 11), new Vertex(20, 12), new Vertex(13, 17)));
        grid.addTriangle(new Triangle(new Vertex(1, 13), new Vertex(2, 13), new Vertex(5, 20)));
        grid.addTriangle(new Triangle(new Vertex(13, 16), new Vertex(17, 19), new Vertex(14, 20)));

        grid.addProblem(new Problem(0, new Vertex(12, 2), new Vertex(5, 20)));
        grid.addProblem(new Problem(1, new Vertex(5, 8), new Vertex(19, 7)));
        grid.addProblem(new Problem(2, new Vertex(11, 0), new Vertex(5, 20)));
        grid.addProblem(new Problem(3, new Vertex(12, 8), new Vertex(14, 20)));
        grid.addProblem(new Problem(4, new Vertex(2, 3), new Vertex(19, 7)));
        grid.addProblem(new Problem(5, new Vertex(1, 13), new Vertex(19, 7)));
        grid.addProblem(new Problem(6, new Vertex(4, 11), new Vertex(18, 5)));
        grid.addProblem(new Problem(7, new Vertex(10, 6), new Vertex(14, 20)));
        grid.addProblem(new Problem(8, new Vertex(19, 7), new Vertex(5, 20)));
        grid.addProblem(new Problem(9, new Vertex(14, 20), new Vertex(18, 6)));
        grid.addProblem(new Problem(10, new Vertex(2, 13), new Vertex(19, 7)));
        grid.addProblem(new Problem(11, new Vertex(5, 20), new Vertex(19, 7)));

        grid.solve();

        grid.exportSolutions();
        grid.exportTriangles();
    }
}
