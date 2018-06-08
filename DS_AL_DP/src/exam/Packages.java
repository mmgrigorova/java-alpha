package exam;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class Packages {
    private static List<int[]> actions = new ArrayList<>();
    private static Set<Integer> prerequisites = new HashSet<>();
    private static Set<Integer> used = new HashSet<>();

    public static void main(String[] args) {
         fakeInput();
        InputReader in = new InputReader();
        OutputWriter out = new OutputWriter();

        int m = in.readInt();

        for (int i = 0; i < m; i++) {
            String[] actionStrings = in.readLine().split(" ");
            int[] action = new int[2];
            action[0] = Integer.parseInt(actionStrings[0]);
            action[1] = Integer.parseInt(actionStrings[1]);
            actions.add(action);
        }

        int k = in.readInt();
        int[] packages = new int[k];

        for (int i = 0; i < k; i++) {
            packages[i] = in.readInt();
        }

        StringBuilder result = new StringBuilder();
        for (int aPackage : packages) {
            String sequence = findSequence(aPackage);
            result.append(sequence);
            result.append("\n");
        }

        out.printLine(result);
        out.close();
    }

    private static String findSequence(int aPackage) {
        used.clear();
        prerequisites.add(aPackage);
        Set<Integer> result = new TreeSet<>();

        while (!prerequisites.isEmpty()){
            Iterator i = prerequisites.iterator();
            int dependant = 0;
            for (Integer prerequisite : prerequisites) {
                dependant = prerequisite;
                break;
            }
            findPrerequisites(dependant);
            prerequisites.remove(dependant);

            if (!used.contains(dependant)) {
                result.add(dependant);
                used.add(dependant);
            }
        }

        StringBuilder res = new StringBuilder();
        for (Integer integer : result) {
            res.append(integer);
            res.append(" ");
        }
        return res.toString();
    }

    private static void findPrerequisites(int dependant) {
        if(!used.contains(dependant)) {
            List<Integer> prs = new ArrayList<>();
            for (int[] action : actions) {
                if (action[0] == dependant) {
                    prs.add(action[1]);
                }
            }
            prerequisites.addAll(prs);
        }
    }


    private static void fakeInput() {

        String test = "3\n" +
                "4 2\n" +
                "3 1\n" +
                "5 7\n" +
                "6\n" +
                "1\n" +
                "2\n" +
                "3\n" +
                "4\n" +
                "5\n" +
                "7";
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