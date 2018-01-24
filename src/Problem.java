public class Problem
{
    private int number;

    private Vertex start;

    private Vertex finish;

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
}
