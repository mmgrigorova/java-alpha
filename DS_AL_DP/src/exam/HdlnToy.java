package exam;

import java.io.*;
import java.util.*;

public class HdlnToy {
//    private static Queue<String> input = new ArrayDeque<>();
    private static List<String> input = new ArrayList<>();

    public static void main(String[] args) {
        fakeInput();
        InputReader in = new InputReader();
        OutputWriter out = new OutputWriter();


        int n = in.readInt();

        for (int i = 0; i < n; i++) {
            input.add(in.readLine());
        }

        StringBuilder result = new StringBuilder();

        result = buildPage();

        out.printLine(result.toString());
//        out.printLine(openingTag("check", 3));
//        System.out.println(openingTag("check", 3));
        out.close();
    }

    private static StringBuilder buildPage() {
        StringBuilder result = new StringBuilder();
        Stack<String> opened = new Stack<>();
        Stack<Integer> whiteStack = new Stack<>();

        for (int i = 0; i < input.size(); i++) {
            String tag = input.get(i);
            if (opened.empty()) {
                opened.push(tag);
                whiteStack.push(0);
                String openingTag = openingTag(tag, 0);
                result.append(openingTag);
                result.append("\n");

            }else {
                while (!opened.isEmpty()) {
                    if (tagIndent(tag) >= tagIndent(opened.peek()) || opened.isEmpty()) {
                        int w = whiteStack.peek();
                        opened.push(tag);
                        String openingTag = openingTag(tag, w + 1);
                        result.append(openingTag);
                        result.append("\n");
                        whiteStack.push(w + 1);
                        break;
                    }
                    if (tagIndent(tag) < tagIndent(opened.peek())) {
                        int w = whiteStack.pop();
                        String closedTag = opened.pop();
                        String closingTag = closingTag(closedTag, w);
                        result.append(closingTag);
                        result.append("\n");
                    }
                    if(i == input.size()-1) {
                        opened.push(tag);
                        whiteStack.push(0);
                    }
                }
            }
        }

        while (!opened.isEmpty()) {
                String tag = opened.pop();
                int w = whiteStack.pop();
                String closingTag = closingTag(tag, w);
                result.append(closingTag);
                result.append("\n");

        }

        return result;
    }

    private static int tagIndent(String tag) {
        return Integer.parseInt(String.valueOf(tag.charAt(1)));
    }

    private static String openingTag(String tag, int whitespaces) {
        StringBuilder spaces = new StringBuilder();
        for (int i = 0; i < whitespaces; i++) {
            spaces.append(" ");
        }
        return String.format("%s" + "<" + "%s" + ">", spaces, tag);
    }

    private static String closingTag(String tag, int whitespaces) {
        StringBuilder spaces = new StringBuilder();
        for (int i = 0; i < whitespaces; i++) {
            spaces.append(" ");
        }
        return String.format("%s" + "</" + "%s" + ">", spaces, tag);
    }

    private static void fakeInput() {

        String test1 = "9\n" +
                "a1\n" +
                "b2\n" +
                "c3\n" +
                "d3\n" +
                "e2\n" +
                "f3\n" +
                "g2\n" +
                "h1\n" +
                "i2";

        String test = "4\n" +
                "h1\n" +
                "r5\n" +
                "d2\n" +
                "a0";
        System.setIn(new ByteArrayInputStream(test.getBytes()));
    }


    static class InputReader {
        private InputStream stream;
        private byte[] buf = new byte[1024];
        private int curChar;
        private int numChars;

        InputReader() {
            this.stream = System.in;
        }

        int read() {
            if (numChars == -1)
                throw new InputMismatchException();
            if (curChar >= numChars) {
                curChar = 0;
                try {
                    numChars = stream.read(buf);
                } catch (IOException e) {
                    throw new InputMismatchException();
                }
                if (numChars <= 0)
                    return -1;
            }
            return buf[curChar++];
        }

        int readInt() {
            int c = read();
            while (isSpaceChar(c)) {
                c = read();
            }
            int sgn = 1;
            if (c == '-') {
                sgn = -1;
                c = read();
            }
            int res = 0;
            do {
                if (c < '0' || c > '9') {
                    throw new InputMismatchException();
                }
                res *= 10;
                res += c - '0';
                c = read();
            } while (!isSpaceChar(c));
            return res * sgn;
        }

        long readLong() {
            int c = read();
            while (isSpaceChar(c)) {
                c = read();
            }
            int sgn = 1;
            if (c == '-') {
                sgn = -1;
                c = read();
            }
            long res = 0;
            do {
                if (c < '0' || c > '9') {
                    throw new InputMismatchException();
                }
                res *= 10;
                res += c - '0';
                c = read();
            } while (!isSpaceChar(c));
            return res * sgn;
        }

        double readDouble() {
            int c = read();
            while (isSpaceChar(c)) {
                c = read();
            }
            int sgn = 1;
            if (c == '-') {
                sgn = -1;
                c = read();
            }
            double res = 0;
            while (!isSpaceChar(c) && c != '.' && c != ',') {
                if (c == 'e' || c == 'E') {
                    return res * Math.pow(10, readInt());
                }
                if (c < '0' || c > '9') {
                    throw new InputMismatchException();
                }
                res *= 10;
                res += c - '0';
                c = read();
            }
            if (c == '.' || c == ',') {
                c = read();
                double m = 1;
                while (!isSpaceChar(c)) {
                    if (c == 'e' || c == 'E') {
                        return res * Math.pow(10, readInt());
                    }
                    if (c < '0' || c > '9') {
                        throw new InputMismatchException();
                    }
                    m /= 10;
                    res += (c - '0') * m;
                    c = read();
                }
            }
            return res * sgn;
        }

        String readLine() {
            int c = read();
            while (isSpaceChar(c))
                c = read();
            StringBuilder res = new StringBuilder();
            do {
                res.appendCodePoint(c);
                c = read();
            } while (!isSpaceChar(c));
            return res.toString();
        }

        boolean isSpaceChar(int c) {
            return c == '\n' || c == '\r' || c == '\t' || c == -1;
        }
    }

    static class OutputWriter {
        private final PrintWriter writer;

        OutputWriter() {
            writer = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        }

        void print(Object... objects) {
            for (int i = 0; i < objects.length; i++) {
                if (i != 0)
                    writer.print(' ');
                writer.print(objects[i]);
            }
        }

        void printLine(Object... objects) {
            print(objects);
            writer.println();
        }

        void close() {
            writer.close();
        }
    }
}
