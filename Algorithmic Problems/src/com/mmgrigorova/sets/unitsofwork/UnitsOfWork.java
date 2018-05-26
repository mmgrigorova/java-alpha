package com.mmgrigorova.sets.unitsofwork;

import java.io.ByteArrayInputStream;
import java.util.*;
import java.util.stream.Collectors;

public class UnitsOfWork {
    public static Map<String, Unit> unitsOfWork;

    static {
        unitsOfWork = new HashMap<>();
    }

    public static void addUnit(String name, String type, String attack) {
        int attackInt = Integer.parseInt(attack);
        if (!unitsOfWork.containsKey(name)) {
            Unit newUnit = new Unit(name, type, attackInt);
            unitsOfWork.put(name, newUnit);
            System.out.printf("SUCCESS: %s added!\n", name);
        } else {
            System.out.printf("FAIL: %s already exists!\n", name);
        }

    }

    public static void main(String[] args) {
        fakeInput();
        Scanner in = new Scanner(System.in);



        while (true) {
            String[] c = in.nextLine().split(" ");
            String command = c[0];
            if (command.equals("end")){
                break;
            }
            switch (command) {
                case "add":
                    addUnit(c[1], c[2], c[3]);
                    break;
                case "find":
                    findUnitsOfType(c[1]);
                    break;
                case "remove":
                    removeUnit(c[1]);
                    break;
                case "power":
                    powerUnit(c[1]);
                    break;
            }
        }


    }

    private static void powerUnit(String limit) {
        int limitNum = Integer.parseInt(limit);
        System.out.print("RESULT: ");
        String powerUnits = unitsOfWork.values().stream()
                .sorted()
                .limit(limitNum)
                .map(Unit::toString)
                .collect(Collectors.joining(", "));
        System.out.println(powerUnits);
    }

    private static void findUnitsOfType(String unitType) {
        System.out.print("RESULT: ");
        String unitsOfType = unitsOfWork.values().stream()
                .sorted()
                .limit(10)
                .filter(x -> x.getType().equals(unitType))
                .map(Unit::toString)
                .collect(Collectors.joining(", "));
        System.out.println(unitsOfType);
    }

    private static void removeUnit(String unitToRemoveName) {
        if (unitsOfWork.containsKey(unitToRemoveName)) {
            unitsOfWork.remove(unitToRemoveName);
            System.out.printf("SUCCESS: %s removed!\n", unitToRemoveName);
        } else {
            System.out.printf("FAIL: %s could not be found!\n", unitToRemoveName);
        }
    }

    static void fakeInput() {
        String test = "add TheMightyThor God 100\n" +
                "add Artanis Protoss 250\n" +
                "add Fenix Protoss 200\n" +
                "add Spiderman MutatedHuman 180\n" +
                "add XelNaga God 500\n" +
                "add Wolverine MutatedHuman 200\n" +
                "add Zeratul Protoss 300\n" +
                "add Spiderman MutatedHuman 180\n" +
                "power 3\n" +
                "find Protoss\n" +
                "find God\n" +
                "remove Kerrigan\n" +
                "remove XelNaga\n" +
                "power 3\n" +
                "find Kerrigan\n" +
                "find God\n" +
                "end";
        System.setIn(new ByteArrayInputStream(test.getBytes()));
    }


}



