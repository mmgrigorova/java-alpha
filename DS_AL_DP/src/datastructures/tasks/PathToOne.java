package datastructures.tasks;


import java.io.ByteArrayInputStream;
import java.util.*;


public class PathToOne {
    public static void main(String[] args) {
        fakeInput();
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();

        int node = n;

        Queue<Integer> queue = new ArrayDeque<>();
        Queue<Integer> depth = new ArrayDeque<>();
        queue.add(node);
        depth.add(0);

        int pathLen = 0;

        while (true) {
            node = queue.poll();
            int nodeDepth = depth.poll();

            if (node % 2 != 0) {
                int nodeLeft = node + 1;
                int nodeRight = node - 1;
                depth.add(nodeDepth + 1);
                depth.add(nodeDepth + 1);

                queue.add(nodeLeft);
                queue.add(nodeRight);

            } else if (node % 2 == 0) {
                int nodeLeft = node / 2;
                depth.add(nodeDepth + 1);
                queue.add(nodeLeft);
            }

            if (node == 1) {
                pathLen = nodeDepth;
                break;
            }
        }

        System.out.println(pathLen);
    }

    static void fakeInput() {
        String test = "15";
        System.setIn(new ByteArrayInputStream(test.getBytes()));
    }
}
