import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.geom.Line2D;
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
        final BufferedImage image = new BufferedImage(scale(grid.getWidth()), scale(grid.getHeight()), BufferedImage.TYPE_INT_RGB);

        Graphics2D g = image.createGraphics();
        g.setRenderingHint(RenderingHints.KEY_ALPHA_INTERPOLATION, RenderingHints.VALUE_ALPHA_INTERPOLATION_QUALITY);
        g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g.setRenderingHint(RenderingHints.KEY_COLOR_RENDERING, RenderingHints.VALUE_COLOR_RENDER_QUALITY);
        g.setRenderingHint(RenderingHints.KEY_DITHERING, RenderingHints.VALUE_DITHER_ENABLE);
        g.setRenderingHint(RenderingHints.KEY_FRACTIONALMETRICS, RenderingHints.VALUE_FRACTIONALMETRICS_ON);
        g.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
        g.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
        g.setRenderingHint(RenderingHints.KEY_STROKE_CONTROL, RenderingHints.VALUE_STROKE_PURE);

        g.setColor(Color.WHITE);
        g.fillRect(0, 0, scale(grid.getWidth()), scale(grid.getHeight()));

        for (int x = 0; x < grid.getWidth(); x++) {
            Line2D line = new Line2D.Double();
            line.setLine(scale(x), scale(0), scale(x), scale(grid.getHeight()));

            g.setColor(Color.LIGHT_GRAY);
            g.draw(line);
        }

        for (int y = 0; y < grid.getHeight(); y++) {
            Line2D line = new Line2D.Double();
            line.setLine(scale(0), scale(y), scale(grid.getWidth()), scale(y));

            g.setColor(Color.LIGHT_GRAY);
            g.draw(line);
        }

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

            g.setStroke(new BasicStroke(3));
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
