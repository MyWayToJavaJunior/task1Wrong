package kz.traningEpam16.coffeevan.coffee;

import kz.traningEpam16.coffeevan.coffee.type.TypeOfCoffee;
import kz.traningEpam16.coffeevan.coffee.wrap.WrapOfCoffee;

import java.util.Random;

/**
 * Получение единицы кофе.
 */
public class GetCoffee {
    private Random random = new Random();

    private ICoffee getArabica(WrapOfCoffee wrapOfCoffee,
                               TypeOfCoffee typeOfCoffee) {
        return new Arabica(wrapOfCoffee, typeOfCoffee);
    }

    private ICoffee getRobusta(WrapOfCoffee wrapOfCoffee,
                               TypeOfCoffee typeOfCoffee) {
        return new Robusta(wrapOfCoffee, typeOfCoffee);
    }

    private ICoffee getLiberica(WrapOfCoffee wrapOfCoffee,
                                TypeOfCoffee typeOfCoffee) {
        return new Liberica(wrapOfCoffee, typeOfCoffee);
    }

    public ICoffee getRandomCoffee() {
        WrapOfCoffee wrapOfCoffee = WrapOfCoffee.values()[
                random.nextInt(WrapOfCoffee.values().length)];
        TypeOfCoffee typeOfCoffee = TypeOfCoffee.values()[
                random.nextInt(TypeOfCoffee.values().length)];
        String choiceOfSort = String.valueOf(random.nextInt(3));
        if ("2".equals(choiceOfSort)) return getArabica(wrapOfCoffee, typeOfCoffee);
        else if ("1".equals(choiceOfSort)) return getRobusta(wrapOfCoffee, typeOfCoffee);
        return getLiberica(wrapOfCoffee, typeOfCoffee);
    }

}
