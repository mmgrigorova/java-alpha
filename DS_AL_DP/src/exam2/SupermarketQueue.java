package exam2;

import java.io.*;
import java.util.*;

public class SupermarketQueue {
    private static final String OKAY = "OK\n";
    private static final String ERROR = "Error\n";
    private static List<String> queue = new ArrayList<>();
    private static Map<String, Integer> peopleCountByName = new HashMap<>();
    private static StringBuilder result = new StringBuilder();

    public static void main(String[] args) {
        fakeInput();
        InputReader in = new InputReader();
        OutputWriter out = new OutputWriter();

        while (true) {
            String command[] = in.readLine().split(" ");
            if (command[0].equals("End")) {
                break;
            }
            switch (command[0]) {
                case ("Append"):
                    String newPerson = command[1];
                    appendToQ(newPerson);
                    break;
                case ("Insert"):
                    int position = Integer.parseInt(command[1]);
                    String person = command[2];
                    insertInQ(position, person);
                    break;
                case ("Find"):
                    String name = command[1];
                    findPerson(name);
                    break;
                case ("Serve"):
                    int count = Integer.parseInt(command[1]);
                    servePeople(count);
                    break;
            }
        }

        out.printLine(result);
        out.close();

    }

    private static void servePeople(int count) {
        int n = queue.size();
        if (count > n){
            result.append(ERROR);
            return;
        }
        for (int i = 0; i < count; i++) {
            String served = queue.get(i);
            result.append(served);
            result.append(" ");
            peopleCountByName.merge(served, -1, Integer::sum);
        }
        queue = new ArrayList<String>(queue.subList(count, queue.size()));
        result.append("\n");
    }

    private static void findPerson(String name) {
        if(peopleCountByName.containsKey(name) && peopleCountByName.get(name)>0){
            result.append(peopleCountByName.get(name));
        } else {
            result.append(0);
        }
        result.append("\n");
    }

    private static void insertInQ(int position, String person) {
        int n = queue.size();
        if (position > n || position < 0) {
            result.append(ERROR);
            return;
        }
        queue.add(position, person);
        peopleCountByName.merge(person, 1, Integer::sum);
        result.append(OKAY);
    }

    private static void appendToQ(String newPerson) {
        queue.add(newPerson);
        peopleCountByName.merge(newPerson, 1, Integer::sum);
        result.append(OKAY);
    }

    private static void fakeInput() {

        String test = "Append Nakov\n" +
                "Serve 1\n" +
                "Find Ina\n" +
                "Append Mike\n" +
                "Insert 0 Peter\n" +
                "Append Penka\n" +
                "Insert 3 Doncho\n" +
                "Serve 5\n" +
                "Append Asya\n" +
                "Insert 4 Nakov\n" +
                "Append Nakov\n" +
                "Find Asya\n" +
                "Find Nakov\n" +
                "Serve 3\n" +
                "Find Peter\n" +
                "Serve 4\n" +
                "Find Nakov\n" +
                "Insert 1 Ina\n" +
                "End";
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
