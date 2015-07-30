package kz.traningEpam16.coffeevan.wagon;


import kz.traningEpam16.coffeevan.coffee.GetCoffee;
import kz.traningEpam16.coffeevan.coffee.ICoffee;

import java.util.ArrayList;

/**
 * Описанеие фургона
 */
public class Wagon {
    private int volumeOfWagon;
    private double costOfWagon;
    private ArrayList<ICoffee> coffees = new ArrayList<>();

    private void swap(int j, int i) {
        ICoffee swap = coffees.get(j);
        coffees.set(j, coffees.get(i));
        coffees.set(i, swap);
    }

    private void sortByVolume() {
        for (int i = 0; i < coffees.size() - 1; i++) {
            for (int j = 0; j < coffees.size() - 1; j++) {
                if (coffees.get(j).getVolume() > coffees.get(j + 1).getVolume())
                    swap(j, j + 1);
            }
        }
    }

    private void sortByCost() {
        for (int i = 0; i < coffees.size() - 1; i++) {
            for (int j = 0; j < coffees.size() - 1; j++) {
                if (coffees.get(j).getCost() > coffees.get(j + 1).getCost())
                    swap(j, j + 1);
            }
        }
    }

    private void sortByWrap() {
        for (int i = 0; i < coffees.size() - 1; i++) {
            for (int j = 0; j < coffees.size() - 1; j++) {
                if (coffees.get(j).getWrapOfCoffee()
                        .compareTo(coffees.get(j + 1).getWrapOfCoffee()) >= 0)
                    swap(j, j + 1);
            }
        }
    }

    private void sortByType() {
        for (int i = 0; i < coffees.size() - 1; i++) {
            for (int j = 0; j < coffees.size() - 1; j++) {
                if (coffees.get(j).getTypeOfCoffee()
                        .compareTo(coffees.get(j + 1).getTypeOfCoffee()) >= 0)
                    swap(j, j + 1);
            }
        }
    }

    private void sortByName() {
        for (int i = 0; i < coffees.size() - 1; i++) {
            for (int j = 0; j < coffees.size() - 1; j++) {
                if (coffees.get(j).getClass().getSimpleName()
                        .compareTo(coffees.get(j + 1).getClass().
                                getSimpleName()) >= 0)
                    swap(j, j + 1);
            }
        }
    }

    private double getItemsCost(ArrayList<ICoffee> coffees) {
        double result = 0;
        for (ICoffee coffee : coffees) {
            result += coffee.getCost();
        }
        return result;
    }

    private double getItemsCost() {
        return this.getItemsCost(this.coffees);
    }

    private int getItemsVolume(ArrayList<ICoffee> coffees) {
        int result = 0;
        for (ICoffee coffee : coffees) {
            result += coffee.getVolume();
        }
        return result;
    }

    private int getItemsVolume() {
        return this.getItemsVolume(this.coffees);
    }

    private boolean isMoneyEnded(double itemCost) {
        return getItemsCost()
                + itemCost > this.costOfWagon;
    }

    private boolean isVolumeEnded(int itemVolume) {
        return getItemsVolume()
                + itemVolume > this.volumeOfWagon;
    }

    private boolean addItem(ICoffee coffee) {
        if (!isMoneyEnded(coffee.getCost())
                && !isVolumeEnded(coffee.getVolume())) {
            this.coffees.add(coffee);
            return true;
        } else {
            return false;
        }
    }

    public Wagon(int volumeOfWagon, double costOfWagon) {
        this.volumeOfWagon = volumeOfWagon;
        this.costOfWagon = costOfWagon;
    }

    public void loading() {
        GetCoffee getCoffee = new GetCoffee();
        while (true) {
            if (!addItem(getCoffee.getRandomCoffee())) break;
        }
    }

    public void sort(String sortBy) {
        if ("name".equals(sortBy.toLowerCase())) sortByName();
        else if ("type".equals(sortBy.toLowerCase())) sortByType();
        else if ("wrap".equals(sortBy.toLowerCase())) sortByWrap();
        else if ("cost".equals(sortBy.toLowerCase())) sortByCost();
        else if ("volume".equals(sortBy.toLowerCase())) sortByVolume();
    }

    public String findByCost(double startCost, double endCost) {
        ArrayList<ICoffee> foundCoffees = new ArrayList<>();
        for (ICoffee coffee : coffees) {
            if (coffee.getCost() >= startCost
                    && coffee.getCost() <= endCost)
                foundCoffees.add(coffee);
        }
        return this.toString(foundCoffees);
    }

    public String findByVolume(int startVolume, double endVolume) {
        ArrayList<ICoffee> foundCoffees = new ArrayList<>();
        for (ICoffee coffee : coffees) {
            if (coffee.getVolume() >= startVolume
                    && coffee.getVolume() <= endVolume)
                foundCoffees.add(coffee);
        }
        return this.toString(foundCoffees);
    }

    public String toString() {
        return this.toString(this.coffees);
    }

    public String toString(ArrayList<ICoffee> coffees) {
        StringBuilder result = new StringBuilder();
        for (ICoffee coffee : coffees) {
            result.append("(").append(coffee.getClass().getSimpleName())
                    .append(" / ").append(coffee.getTypeOfCoffee()).append(" / ")
                    .append(coffee.getWrapOfCoffee()).append(" / Volume: ")
                    .append(coffee.getVolume()).append(" / Volume of Coffee ")
                    .append(coffee.getVolumeWOWrap()).append(" / Cost: ")
                    .append(coffee.getCost()).append(")\n");
        }
        result.append("\n").append("Total cost: ").append(getItemsCost(coffees))
                .append("\nTotal volume: ").append(getItemsVolume(coffees)).append("\n");
        return result.toString();
    }

}
