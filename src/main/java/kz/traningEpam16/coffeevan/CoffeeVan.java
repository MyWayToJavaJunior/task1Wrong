package kz.traningEpam16.coffeevan;

import kz.traningEpam16.coffeevan.wagon.Wagon;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Точка входа
 */
public class CoffeeVan {
    private static int volumeOfVan;
    private static double costOfVan;
    private static String typeOfSort;
    private static String typeOfFind;
    private static double startOfFind;
    private static double endOfFind;

    private static void checkArgs(String[] args) {
        if (args.length < 6 ||
                !checkSort(args[2], new String[]{
                        "volume", "cost", "wrap", "type", "name"}) ||
                !checkSort(args[3], new String[]{
                "volume", "cost"}))  {
            showMsgAndBrake();
        }
        try {
            volumeOfVan = Integer.valueOf(args[0]);
            costOfVan = Double.valueOf(args[1]);
            typeOfSort = args[2];
            typeOfFind = args[3];
            startOfFind = Double.valueOf(args[4]);
            endOfFind = Double.valueOf(args[5]);
        } catch (NumberFormatException e) {
            showMsgAndBrake();
        }
    }

    private static boolean checkSort(String arg, String[] args) {
        Set<String> setOfSorts = new HashSet<>(
                Arrays.asList(args));
        return setOfSorts.contains(arg);
    }

    private static void showMsgAndBrake() {
        System.out.println("use: coffeevan-v1 volume " +
                "cost sort(volume/cost/wrap/type/name)" +
                " found(volume/cost) startValue endValue");
        System.exit(0);
    }

    public static void main(String[] args) {
        checkArgs(args);
        Wagon wagon = new Wagon(volumeOfVan, costOfVan);
        wagon.loading();
        System.out.println("Van after loading:");
        System.out.println(wagon);
        System.out.println("Van after sorting by " + typeOfSort + ":");
        wagon.sort(typeOfSort);
        System.out.println(wagon);
        System.out.println("Van found by " + typeOfFind + "["
                + startOfFind + " - " + endOfFind + "]");
        if ("cost".equals(typeOfFind))
            System.out.println(wagon.findByCost(startOfFind, endOfFind));
        else System.out.println(wagon.findByVolume((int) startOfFind,
                endOfFind));
    }

}
