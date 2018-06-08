package exam2;


import java.io.ByteArrayInputStream;
import java.util.*;
import java.util.stream.Collectors;

public class Cheaters {
    private static Map<String, Map> dependenciesBySubject = new HashMap<>();
    private static Stack<String> result = new Stack<>();

    public static void main(String[] args) {
        fakeInput();
        Scanner in = new Scanner(System.in);
// Read data
        int n = in.nextInt();
        in.nextLine();
        for (int i = 0; i < n; i++) {
            String[] line = in.nextLine().split(" ");
            String personX = line[0];
            String personY = line[1];
            String[] subjectArray = Arrays.copyOfRange(line, 2, line.length);
            String subject = Arrays.stream(subjectArray)
                    .collect(Collectors.joining(" "));


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
        int m = in.nextInt();
        in.nextLine();

        for (int i = 0; i < m; i++) {
            String[] command = in.nextLine().split(" ");
            String personX = command[0];
            String[] subjectArray = Arrays.copyOfRange(command, 1, command.length);
            String subject = Arrays.stream(subjectArray)
                    .collect(Collectors.joining(" "));
            Map<String, Set> dependencyMapForSubject = dependenciesBySubject.get(subject);
            result.push(personX);
            findDependencies(personX, dependencyMapForSubject, new HashSet<>());

            StringBuilder res = new StringBuilder();
            while (!result.empty()){
                res.append(result.pop());
                if(result.size()>0){
                    res.append(", ");
                }
            }
            System.out.println(res);
        }
    }

    private static void findDependencies(String personX,
                                         Map<String, Set> dependencyMapForSubject,
                                         Set<String> visited) {
        Set<String> prerequisites = dependencyMapForSubject.get(personX);
        visited.add(personX);
        if (prerequisites == null){
            return;
        }
        for (String prerequisite : prerequisites) {
            if (!visited.contains(prerequisite)){
                visited.add(prerequisite);
               result.push(prerequisite);
            }
            findDependencies(prerequisite, dependencyMapForSubject, visited);
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
}
