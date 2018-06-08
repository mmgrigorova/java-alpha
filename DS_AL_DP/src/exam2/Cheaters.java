package exam2;


import java.io.*;
import java.util.*;

public class Cheaters {
    private static Map<String, Map> dependenciesBySubject = new HashMap<>();
    private static Stack<String> result = new Stack<>();

    public static void main(String[] args) {
        fakeInput();
        InputReader in = new InputReader();
        OutputWriter out = new OutputWriter();
        // Read data
        int n = in.readInt();
        for (int i = 0; i < n; i++) {
            String[] line = in.readLine().split(" ");
            String personX = line[0];
            String personY = line[1];
            StringBuilder subjectB = new StringBuilder();
            for (int j = 2; j < line.length; j++) {
                subjectB.append(line[j]);
            }
            String subject = subjectB.toString();
            if (!dependenciesBySubject.containsKey(subject)) {
                Map<String, Set> dependBySubject = new HashMap<>();
                dependenciesBySubject.put(subject, dependBySubject);
            }

            Map<String, Set> personDependencyBySubject = dependenciesBySubject.get(subject);

            if (!personDependencyBySubject.containsKey(personX)) {
                Set<String> prerequisitePeople = new TreeSet<>();
                personDependencyBySubject.put(personX, prerequisitePeople);
            }

            personDependencyBySubject.get(personX).add(personY);
        }

        // Read commands
        int m = in.readInt();

        for (int i = 0; i < m; i++) {
            String[] command = in.readLine().split(" ");
            String personX = command[0];
            StringBuilder subjectB = new StringBuilder();
            for (int j = 1; j < command.length; j++) {
                subjectB.append(command[j]);
            }
            String subject = subjectB.toString();
            Map<String, Set> dependencyMapForSubject = dependenciesBySubject.get(subject);
            result.push(personX);
            findDependencies(personX, dependencyMapForSubject, new HashSet<>());

            StringBuilder res = new StringBuilder();
            while (!result.empty()) {
                res.append(result.pop());
                if (result.size() > 0) {
                    res.append(", ");
                }
            }
            out.printLine(res);
        }
        out.close();
    }

    private static void findDependencies(String personX,
                                         Map<String, Set> dependencyMapForSubject,
                                         Set<String> visited) {
        Set<String> prerequisites = dependencyMapForSubject.get(personX);
        visited.add(personX);
        if (prerequisites == null) {
            return;
        }
        for (String prerequisite : prerequisites) {
            if (!visited.contains(prerequisite)) {
                visited.add(prerequisite);
                result.push(prerequisite);
                findDependencies(prerequisite, dependencyMapForSubject, visited);
            }
        }

    }


    private static void fakeInput() {
        String test = "7\n" +
                "Coki Doncho Math\n" +
                "Doncho Coki Graphs\n" +
                "Doncho Yana Math\n" +
                "Stamat Coki Graphs\n" +
                "Doncho Stamat Math \n" +
                "Doncho Coki Dynamic Programming\n" +
                "Stamat Yana Math\n" +
                "6\n" +
                "Coki Math\n" +
                "Doncho Math\n" +
                "Stamat Math\n" +
                "Stamat Graphs\n" +
                "Doncho Dynamic Programming\n" +
                "Coki Dynamic Programming";
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
