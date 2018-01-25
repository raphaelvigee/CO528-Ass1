import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class FormatChecker
{
    public static void main(String args[])
    {
        try (BufferedReader br = new BufferedReader(new FileReader(args[0]))) {
            StringBuilder sb = new StringBuilder();
            String line = br.readLine();

            while (line != null) {
                sb.append(line);
                sb.append(System.lineSeparator());
                line = br.readLine();
            }

            StringTokenizer st = new StringTokenizer(sb.toString());
            if (parse_opening_bracket(st))
                System.out.println("ok");
            else
                System.out.println("problem");
        } catch (IOException e) {
            System.err.println("Caught IOException: " + e.getMessage());
        }
    }

    public static boolean parse_opening_bracket(StringTokenizer st)
    {
        if (st.hasMoreTokens()) {
            String token = st.nextToken(" |0|1|2|3|4|5|6|7|8|9");
            if (token.equals("(")) {
                return parse_x(st);
            } else
                return false;
        } else
            return true;
    }

    public static boolean parse_x(StringTokenizer st)
    {
        if (st.hasMoreTokens()) {
            String token = st.nextToken(" |,");
            int x = Integer.parseInt(token);
            if (0 <= x && x < 24) {
                return parse_comma(st);
            } else
                return false;
        } else {
            return false;
        }
    }

    public static boolean parse_comma(StringTokenizer st)
    {
        if (st.hasMoreTokens()) {
            String token = st.nextToken(" |0|1|2|3|4|5|6|7|8|9");
            if (token.equals(",")) {
                return parse_y(st);
            } else
                return false;
        } else
            return false;
    }

    public static boolean parse_y(StringTokenizer st)
    {
        if (st.hasMoreTokens()) {
            String token = st.nextToken(" |)");
            int y = Integer.parseInt(token);
            if (0 <= y && y < 24) {
                return parse_closing_bracket(st);
            } else
                return false;
        } else
            return false;
    }

    public static boolean parse_closing_bracket(StringTokenizer st)
    {
        if (st.hasMoreTokens()) {
            String token = st.nextToken(" |\n");
            if (token.equals(")")) {
                return parse_opening_bracket(st);
            } else
                return false;
        } else
            return false;
    }

}
