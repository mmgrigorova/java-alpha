package exam2;


import java.io.*;
import java.util.*;

public class Cheaters {
    private static Map<String, Map<String, Set<String>>> dependenciesBySubject = new HashMap<>();
    private static List<String> result = new ArrayList<>();
    private static long inputTime = 0;
    private static long outputTime = 0;
    private static long readIn = 0;
    private static long putTime = 0;
    private static long inMethodTime = 0;


    public static void main(String[] args) {
//        long start = System.currentTimeMillis();

//        System.out.println("print");
//        for (int i = 0; i < 200000; i++) {
            readData();
//        }

        long end = System.currentTimeMillis();


//        System.out.println("Input: " + inputTime);
//        System.out.println("Input Overhead: " + inMethodTime);
//        System.out.println("Input In: " + readIn);
//        System.out.println("Input Put: " + putTime);
//        System.out.println("Output: " + outputTime);
//        System.out.println("End - start: " + (end - start));
    }

    private static void readData() {
        long start = System.currentTimeMillis();
        InputReader in = getInput();
        long end = System.currentTimeMillis();
        inputTime += end - start;

        start = System.currentTimeMillis();
        outputResult(in);
        end = System.currentTimeMillis();
        outputTime += end - start;

    }

    private static InputReader getInput() {

        long startInM = System.currentTimeMillis();

        fakeInput();
        InputReader in = new InputReader();
        long endInM = System.currentTimeMillis();
        inMethodTime += endInM - startInM;

        // Read data
        int n = in.readInt();
        for (int i = 0; i < n; i++) {
            long startIn = System.currentTimeMillis();
            String line = in.readLine();
            int space1Idx = line.indexOf(' ');
            int space2Idx = line.indexOf(' ', space1Idx + 1);
            String personX = line.substring(0,space1Idx);
            String personY = line.substring(space1Idx+1, space2Idx);
            String subject = line.substring(space2Idx+1);

            long endIn = System.currentTimeMillis();
            readIn += endIn - startIn;

            long startPut = System.currentTimeMillis();

            if (!dependenciesBySubject.containsKey(subject)) {
                Map<String, Set<String>> dependBySubject = new HashMap<>();
                dependenciesBySubject.put(subject, dependBySubject);
            }

            Map<String, Set<String>> personDependencyBySubject = dependenciesBySubject.get(subject);

//            if (!personDependencyBySubject.containsKey(personX)) {
//                Set<String> prerequisitePeople = new HashSet<>();
//                personDependencyBySubject.put(personX, prerequisitePeople);
//            }
//
//            personDependencyBySubject.get(personX).add(personY);



            Set<String> preqs = personDependencyBySubject.get(personX);
            if(preqs == null){
                preqs = new TreeSet<>();
                personDependencyBySubject.put(personX, preqs);
            }
            preqs.add(personY);

            long endPut = System.currentTimeMillis();
            putTime += endPut - startPut;
        }
        return in;
    }

    private static void findDependencies(String personX,
                                         Map<String, Set<String>> dependencyMapForSubject,
                                         Set<String> visited) {
        Set<String> prerequisites = dependencyMapForSubject.get(personX);
        visited.add(personX);
        if (prerequisites == null) {
            return;
        }
        for (String prerequisite : prerequisites) {
            if (!visited.contains(prerequisite)) {
                visited.add(prerequisite);
                result.add(prerequisite);
                findDependencies(prerequisite, dependencyMapForSubject, visited);
            }
        }
    }


    private static void outputResult(InputReader in) {
        OutputWriter out = new OutputWriter();

        // Read commands
        int m = in.readInt();

        for (int i = 0; i < m; i++) {
            result.clear();
            String command = in.readLine();
            int space1Idx = command.indexOf(' ');
            String personX = command.substring(0,space1Idx);
            String subject = command.substring(space1Idx+1);

            Map<String, Set<String>> dependencyMapForSubject = dependenciesBySubject.get(subject);
            result.add(personX);
            findDependencies(personX, dependencyMapForSubject, new HashSet<>());

            StringBuilder res = new StringBuilder();
//            while (!result.empty()) {
//                res.append(result.pop());
//                if (result.size() > 0) {
//                    res.append(", ");
//                }
//            }

            for (int j = result.size() - 1; j >= 0; j--) {
                res.append(result.get(j));

                if (j == 0) {
                    continue;
                }
                res.append(", ");
            }
            out.printLine(res);
//            System.out.println(res);
        }
        out.close();
    }


    private static void fakeInput() {
        String test = "7\n" +
                "Coki Doncho Math\n" +
                "Doncho Coki Graphs\n" +
                "Doncho Yana Math\n" +
                "Stamat Coki Graphs\n" +
                "Doncho Stamat Math\n" +
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
