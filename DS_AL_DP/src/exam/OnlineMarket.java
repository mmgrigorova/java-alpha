package exam;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class OnlineMarket {
    public static Set<Products> products;
    public static HashMap<String, Products> productNames;
    public static HashMap<String, TreeSet<Products>> productType;

    private static StringBuilder result = new StringBuilder();

    static {
        products = new TreeSet<>();
        productNames = new HashMap<>();
        productType = new HashMap<>();
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

            String minPrice = "";
            String maxPrice = "";
            if (c[0].equals("filter") && c[1].equals("by") && c[2].equals("name")) {
                command = "filterByName";
            } else if (c[0].equals("filter") && c[1].equals("by") && c[2].equals("type")) {
                command = "filterByType";
            } else if (c[0].equals("filter") && c[1].equals("by") && c[2].equals("price") && c[3].equals("from")) {
                command = "filterByPrice";
                if (c.length == 7) {  //from to case
                    minPrice = c[4];
                    maxPrice = c[6];
                } else {
                    minPrice = c[4];
                    maxPrice = String.valueOf(Integer.MAX_VALUE);
                }
            } else if (c[0].equals("filter") && c[1].equals("by") && c[2].equals("price") && c[3].equals("to")) {
                command = "filterByPrice";
                minPrice = "0";
                maxPrice = c[4];
            }
            switch (command) {
                case "add":
                    addPorduct(c[1], c[2], c[3]);
                    break;
                case "filterByType":
                    productsOfType(c[3]);
                    break;
                case "filterByPrice":
                    filter(minPrice, maxPrice);
                    break;
            }
        }
        System.out.println(result);
    }

    private static void filter(String minPrice, String maxPrice) {
        double minPr = Double.parseDouble(minPrice);
        double maxPr = Double.parseDouble(maxPrice);

        result.append(String.format("Ok: "));
//        StringJoiner toPrint = new StringJoiner(", ");
        StringJoiner joiner = new StringJoiner(", ");
        int counter = 0;
        for (Products x : products) {
            if (x.getPrice() > minPr) {
                if (x.getPrice() < maxPr) {
                    joiner.add(x.toString());
                    counter += 1;
                }
            }
            if (counter == 10){
                break;
            }
        }
        String pr = joiner.toString();
        result.append(pr);
        result.append("\n");
    }

    public static void addPorduct(String name, String price, String type) {
        if (!productNames.keySet().contains(name)) {
            Products product = new Products(name, type, price);
            productNames.put(name, product);
            products.add(product);
            if (!productType.containsKey(type)) {
                TreeSet<Products> prTypes = new TreeSet<>();
                prTypes.add(product);
                productType.put(type, prTypes);
            } else {
                TreeSet<Products> prTypes = productType.get(type);
                prTypes.add(product);
            }
            result.append(String.format("Ok: Product %s added successfully\n", name));
        } else {
            result.append(String.format("Error: Product %s already exists\n", name));
        }
    }


    private static void productsOfType(String prodType) {
        if (!productType.keySet().contains(prodType)) {
            result.append(String.format("Error: Type %s does not exists\n", prodType));
        } else {
            result.append(String.format("Ok: "));
            StringJoiner toPrint = new StringJoiner(", ");
            if (OnlineMarket.productType.containsKey(prodType)) {
                Set<Products> productsTypes = OnlineMarket.productType.get(prodType);
                int counter = 0;
                for (Products products : productsTypes) {
                    toPrint.add(products.toString());
                    counter++;
                    if (counter == 10) {
                        break;
                    }
                }
            }
            result.append(toPrint);
            result.append("\n");

        }

    }

    static void fakeInput() {
        String test2 = "add Milk 1.90 dairy\n" +
                "add Yogurt 1.90 dairy\n" +
                "add Notebook 1111.90 technology\n" +
                "add Orbit 0.90 food\n" +
                "add Rakia 11.90 drinks\n" +
                "add Dress 121.90 clothes\n" +
                "add Jacket 49.90 clothes\n" +
                "add Milk 1.90 dairy\n" +
                "add Socks 2.90 clothes\n" +
                "filter by type dairy\n" +
                "filter by price from 1.00 to 2.00\n" +
                "filter by price from 1.50\n" +
                "filter by price to 2.00\n" +
                "filter by type clothes\n" +
                "end";
        String test1 = "add MacBookPro 1700.1234 technology\n"
                + "end";

        String test = "add Milk 1.90 dairy\n" +
                "add Yogurt 1.90 dairy\n" +
                "add Notebook 1111.90 technology\n" +
                "add Orbit 0.90 food\n" +
                "add Rakia 11.90 drinks\n" +
                "add Dress 121.90 clothes\n" +
                "add Jacket 49.90 clothes\n" +
                "add Milk 1.90 dairy\n" +
                "add Eggs 2.34 food\n" +
                "add Cheese 5.55 dairy\n" +
                "filter by type clothes\n" +
                "filter by price from 1.00 to 2.00\n" +
                "add CappyOrange 1.99 juice \n" +
                "add Nestey 2.7 juice \n" +
                "filter by price from 1200\n" +
                "add Socks 2.90 clothes\n" +
                "filter by type fruits\n" +
                "add MacBookPro 1700.1234 technology\n" +
                "filter by price from 1200\n" +
                "filter by price from 1.50\n" +
                "filter by price to 2.00\n" +
                "filter by type clothes\n" +
                "end";
        System.setIn(new ByteArrayInputStream(test.getBytes()));
    }
}


class Products implements Comparable<Products> {
    private String name;
    private String type;
    private double price;

    public Products(String name, String type, String price) {
        double priceT = Double.parseDouble(price);
        this.name = name;
        this.type = type;
        this.price = priceT;
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

    public double getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public int compareTo(Products productsToCompare) {
        Double thisPrice = (Double) getPrice();
        Double productPrice = (Double) productsToCompare.getPrice();
        int compare = thisPrice.compareTo(productPrice);
        if (compare == 0) {
            compare = this.getName().compareTo(productsToCompare.getName());
        }
        if (compare == 0) {
            compare = this.getType().compareTo(productsToCompare.getType());
        }
        return compare;
    }

    @Override
    public String toString() {
        String priceD = fmt(price);
        return String.format("%s(%s)", name, priceD);
    }

    public static String fmt(double d) {
        if (d == (long) d)
            return String.format("%d", (long) d);
        else
            return String.format("%s", d);
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Products products = (Products) o;
        return price == products.price &&
                Objects.equals(name, products.name) &&
                Objects.equals(type, products.type)
                && this.hashCode() == o.hashCode();
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, type, price);
    }
}
