package com.mmgrigorova.sets.unitsofwork;


import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class UnitsOfWork {
    private static Set<Unit> unitsOfWork;
    private static HashMap<String, Unit> unitNames;
    private static HashMap<String, TreeSet<Unit>> unitsOfType;
    private static StringBuilder result = new StringBuilder();

    static {
        unitsOfWork = new TreeSet<>();
        unitNames = new HashMap<>();
        unitsOfType = new HashMap<>();
    }


    public static void main(String[] args) throws IOException {
        fakeInput();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            String[] c = reader.readLine().split(" ");
            String command = c[0];
            if (command.equals("end")) {
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
                    break;q
                case "power":
                    powerUnit(c[1]);
                    break;
            }
        }
        System.out.println(result);
    }

    public static void addUnit(String name, String type, String attack) {
        if (!unitNames.keySet().contains(name)) {
            Unit unit = new Unit(name, type, attack);
            unitNames.put(name, unit);
            unitsOfWork.add(unit);
            if (!unitsOfType.containsKey(type)) {
                TreeSet<Unit> typeUnits = new TreeSet<>();
                typeUnits.add(unit);
                unitsOfType.put(type, typeUnits);
            } else {
                TreeSet<Unit> typeUnits = unitsOfType.get(type);
                typeUnits.add(unit);
            }
            result.append(String.format("SUCCESS: %s added!\n", name));
        } else {
            result.append(String.format("FAIL: %s already exists!\n", name));
        }
    }

    private static void powerUnit(String limit) {
        int limitNum = Integer.parseInt(limit);

        result.append(String.format("RESULT: "));
        StringJoiner toPrint = new StringJoiner(", ");
        int counter = 0;
        for (Unit unit : unitsOfWork) {
            toPrint.add(unit.toString());
            counter++;
            if (counter == limitNum) {
                break;
            }
        }

        result.append(toPrint);
        result.append("\n");
    }

    private static void findUnitsOfType(String unitType) {
        result.append(String.format("RESULT: "));
        StringJoiner toPrint = new StringJoiner(", ");
        if (unitsOfType.containsKey(unitType)) {
            Set<Unit> unitTypes = unitsOfType.get(unitType);
            int counter = 0;
            for (Unit unit : unitTypes) {
                toPrint.add(unit.toString());
                counter++;
                if (counter == 10) {
                    break;
                }
            }
        }
        result.append(toPrint);
        result.append("\n");
}

    private static void removeUnit(String unitToRemoveName) {
        Unit toRemove = null;
        if (unitNames.keySet().contains(unitToRemoveName)) {
            for (Unit unit : unitsOfWork) {
                if (unit.getName().equals(unitToRemoveName)) {
                    toRemove = unit;
                    unitsOfWork.remove(toRemove);
                    break;
                }
            }

            for (Unit unit : unitsOfType.get(toRemove.getType())) {
                if (unit.getName().equals(unitToRemoveName)) {
                    unitsOfType.get(toRemove.getType()).remove(unit);
                    break;
                }
            }

            unitNames.remove(unitToRemoveName);

            result.append(String.format("SUCCESS: %s removed!\n", unitToRemoveName));
        } else {
            result.append(String.format("FAIL: %s could not be found!\n", unitToRemoveName));
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
//        String test = "add TheMightyThor God 100\n" +
//                "find God\n" +
//                "remove Kerrigan\n" +
//                "remove XelNaga\n" +
//                "power 3\n" +
//                "find Kerrigan\n" +
//                "find God\n" +
//                "end";
        System.setIn(new ByteArrayInputStream(test.getBytes()));
    }
}


class Unit implements Comparable<Unit> {
    private String name;
    private String type;
    private int attack;

    public Unit(String name, String type, String attack) {
        int attackInt = Integer.parseInt(attack);
        this.name = name;
        this.type = type;
        this.attack = attackInt;
    }

    public String getName() {
        return name;
    }


    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getAttack() {
        return attack;
    }

    public void setAttack(int attack) {
        this.attack = attack;
    }


    @Override
    public int compareTo(Unit unitToCompare) {
        int attackComp = unitToCompare.getAttack() - this.getAttack();
        if (attackComp == 0) {
            return this.getName().compareTo(unitToCompare.getName());
        } else {
            return attackComp;
        }
    }

    @Override
    public String toString() {
        return String.format("%s[%s](%d)", name, type, attack);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Unit unit = (Unit) o;
        return attack == unit.attack &&
                Objects.equals(name, unit.name) &&
                Objects.equals(type, unit.type);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, type, attack);
    }
}


