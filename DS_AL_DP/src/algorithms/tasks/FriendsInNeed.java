package algorithms.tasks;

import java.io.ByteArrayInputStream;
import java.util.*;

/**
 * Friends in need
 * http://judge.telerikacademy.com/problem/02friendsinneed
 */

public class FriendsInNeed {
    private static Map<Integer, Map<Integer, Integer>> city = new HashMap<>();
    private static Set<Integer> hospitals = new HashSet<>();
    private static int vertexCount;

    public static void main(String[] args) {
        fakeInput();
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        vertexCount = n;
        int streetsCnt = in.nextInt();
        int hospCnt = in.nextInt();

        for (int i = 0; i < hospCnt; i++) {
            hospitals.add(in.nextInt());
        }

        fillMap(in, streetsCnt);

        int minDistance = findMinDistance();

        System.out.println(minDistance);

    }

    private static int findMinDistance() {
        int minDistance = Integer.MAX_VALUE;

        for (Integer hospital : hospitals) {
            int[][] distances = runDijkstraForSource(hospital);
            int hospitalDistance = 0;
            for (int i = 0; i < distances[0].length; i++) {
                if (!hospitals.contains(distances[0][i])) {
                    hospitalDistance += distances[1][i];
                }
            }
            minDistance = Math.min(minDistance, hospitalDistance);
        }
        return minDistance;
    }

    private static int[][] runDijkstraForSource(Integer hospital) {
        //nodes , distances
        int[][] distances = new int[2][vertexCount];
        Map<Integer, Integer> indexMap = new HashMap<>();

        int i = 0;
        for (Integer item : city.keySet()) {
            indexMap.put(item, i);
            distances[0][i] = item;
            distances[1][i] = Integer.MAX_VALUE;
            if (item.equals(hospital)) {
                distances[1][i] = 0;
            }
            i++;
        }

        boolean hasNext = true;
        Set<Integer> visited = new HashSet<>();

        while (hasNext) {
            int shortestKnownDistance = Integer.MAX_VALUE;
            int currentNode = -1;
            for (int j = 0; j < distances[0].length; j++) {
                int cDist = distances[1][j];
                if (cDist < shortestKnownDistance) {
                    if (!visited.contains(distances[0][j])) {
                        shortestKnownDistance = cDist;
                        currentNode = distances[0][j];
                        hasNext = true;
                    } else {
                        if (currentNode == -1) {
                            hasNext = false;
                        }
                    }
                }

            }
            visited.add(currentNode);

            HashMap<Integer, Integer> neighbours = (HashMap<Integer, Integer>) city.get(currentNode);
            if (neighbours == null) {
                continue;
            }
            for (Integer neighbour : neighbours.keySet()) {
                int neighIdx = indexMap.get(neighbour);
                int currIdx = indexMap.get(currentNode);
                int previousDistance = distances[1][neighIdx];
                if ((previousDistance < 0)) {
                    previousDistance = Integer.MAX_VALUE;
                }
                int distanceToNeighbour = city.get(currentNode).get(neighbour);
                int newDistance = distances[1][currIdx] + distanceToNeighbour;

                if (previousDistance > newDistance) {
                    distances[1][neighIdx] = newDistance;
                }
            }

        }
        return distances;
    }

    private static void fillMap(Scanner in, int streetsCnt) {
        for (int i = 0; i < streetsCnt; i++) {
            int node1 = in.nextInt();
            int node2 = in.nextInt();
            int distance = in.nextInt();

            if (!city.containsKey(node1)) {
                city.put(node1, new HashMap<>());
            }
            if (!city.containsKey(node2)) {
                city.put(node2, new HashMap<>());
            }

            city.get(node1).put(node2, distance);
            city.get(node2).put(node1, distance);
        }
    }

    private static void fakeInput() {
        String test = "10 25 5\n" +
                "9 8 1 4 3\n" +
                "1 2 6\n" +
                "1 3 10\n" +
                "1 4 7\n" +
                "1 5 9\n" +
                "1 6 5\n" +
                "1 7 14\n" +
                "1 8 7\n" +
                "1 9 14\n" +
                "1 10 2\n" +
                "2 8 19\n" +
                "2 5 12\n" +
                "5 8 11\n" +
                "4 5 1\n" +
                "5 10 2\n" +
                "8 10 14\n" +
                "3 10 8\n" +
                "4 10 13\n" +
                "7 10 10\n" +
                "5 7 19\n" +
                "7 8 9\n" +
                "6 7 7\n" +
                "2 7 2\n" +
                "2 3 12\n" +
                "2 6 9\n" +
                "3 6 7";
        System.setIn(new ByteArrayInputStream(test.getBytes()));
    }
}
