import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.geom.Path2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Graph
{
    private Grid grid;

    public Graph(Grid grid)
    {
        this.grid = grid;
    }

    private int scale(int i)
    {
        return i * 50;
    }

    public void graph()
    {
        final BufferedImage image = new BufferedImage(scale(24), scale(24), BufferedImage.TYPE_INT_RGB);

        Graphics2D g = image.createGraphics();
        g.setColor(Color.WHITE);
        g.fillRect(0, 0, scale(24), scale(24));

        for (Triangle triangle : grid.getTriangles()) {

            Polygon polygon = new Polygon();

            Vertex v1 = triangle.getV1();
            polygon.addPoint(scale(v1.get_x()), scale(v1.get_y()));

            Vertex v2 = triangle.getV2();
            polygon.addPoint(scale(v2.get_x()), scale(v2.get_y()));

            Vertex v3 = triangle.getV3();
            polygon.addPoint(scale(v3.get_x()), scale(v3.get_y()));

            g.setColor(Color.BLACK);
            g.draw(polygon);

            g.setColor(Color.ORANGE);
            g.fill(polygon);
        }

        for (Problem problem : grid.getProblems()) {

            Path resultPath = problem.getResultPath();

            Path2D polyline = new Path2D.Double();

            for (int i = 0; i < resultPath.getVertexes().size(); i++) {
                Vertex v = resultPath.getVertexes().get(i);

                if (i == 0) {
                    polyline.moveTo(scale(v.get_x()), scale(v.get_y()));
                } else {
                    polyline.lineTo(scale(v.get_x()), scale(v.get_y()));
                }
            }

            g.setStroke(new BasicStroke(5));
            g.setColor(randomColor());
            g.draw(polyline);
            g.setStroke(new BasicStroke(1));
        }

        g.drawImage(image, null, 0, 0);
        try {
            ImageIO.write(image, "JPEG", new File("graph.jpg"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private Color randomColor()
    {
        return new Color((int) (Math.random() * 0x1000000));
    }
}
