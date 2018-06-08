package exam2;

import java.io.ByteArrayInputStream;
import java.util.*;

public class SupermarketQueue {
    private static final String OKAY = "OK\n";
    private static final String ERROR = "Error\n";
    private static Queue<String> queue = new LinkedList<>();
    private static Map<String, Integer> peopleCountByName = new HashMap<>();
    private static StringBuilder result = new StringBuilder();

    public static void main(String[] args) {
        fakeInput();
        Scanner in = new Scanner(System.in);

        while (true) {
            String command[] = in.nextLine().split(" ");
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

        System.out.println(result);

    }

    private static void servePeople(int count) {
        int n = queue.size();
        if (count > n){
            result.append(ERROR);
            return;
        }
        for (int i = 0; i < count; i++) {
            String served = queue.poll();
            result.append(served);
            result.append(" ");
            peopleCountByName.merge(served, -1, Integer::sum);


        }
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
        LinkedList<String> queueAsList = (LinkedList<String>) queue;
        queueAsList.add(position, person);
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
}
