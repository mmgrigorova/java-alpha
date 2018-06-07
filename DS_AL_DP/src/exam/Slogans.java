package exam;

import java.io.*;
import java.util.*;

public class Slogans {
    public static StringBuilder result = new StringBuilder();

    public static void main(String[] args) {
        fakeInput();
        InputReader in = new InputReader();
        OutputWriter out = new OutputWriter();

        int n = in.readInt();

        String read = "";
        List<Set<String>> allWords = new ArrayList<>();
        List<String> allSlogans = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String[] inp = in.readLine().split(" ");
            Set<String> words = new HashSet<>(Arrays.asList(inp));
            allWords.add(words);
            read = in.readLine();
            allSlogans.add(read);
        }


        for (int i = 0; i < n; i++) {
            if (allWords.get(i).isEmpty() || allSlogans.get(i).length() == 0) {
                result.append("NOT VALID");
                continue;
            }
            Stack<String> stack = new Stack<>();
            boolean isPossible = findSlogans(allWords.get(i), allSlogans.get(i), stack, new HashSet<>());
            if (isPossible) {
                while (!stack.empty()) {
                    System.out.printf("%s ", stack.pop());
                }
            } else {
                System.out.println("NOT VALID");
            }
            System.out.println();
        }

        out.printLine(result.toString());
        out.close();
    }

    private static boolean findSlogans(Set<String> words, String slogan,
                                       Stack<String> localResult, Set<String> invalid) {
        if (slogan.length() == 0) {
            return true;
        }

        for (String word : words) {
            if (slogan.startsWith(word) && !invalid.contains(slogan)) {
                String newSlogan = slogan.substring(word.length());
                if (findSlogans(words, newSlogan , localResult, invalid)) {
                    localResult.push(word);
                    return true;
                } else {
                    invalid.add(newSlogan);
                }
            }
        }

        return false;
    }

    private static void fakeInput() {

        String test = "2\n" +
                "test it here now\n" +
                "testhere\n" +
                "hello world my\n" +
                "hellomyworldhello";

        String test1 = "1\n" +
                "we are telerik academy\n" +
                "wearenottelerikacademy";
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
