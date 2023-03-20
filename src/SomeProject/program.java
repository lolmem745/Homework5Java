package SomeProject;

import java.util.Random;

public class program {

    public static void main(String[] args) throws InterruptedException {

        int catsNumber = 10;
        int maxCatAppetite = 10;
        int minCatAppetite = maxCatAppetite;
        int plateCapacity = 100;
        int maxFoodToPutInPlate = 30;

        Plate plate = new Plate(plateCapacity);
        Cat[] cats = new Cat[catsNumber];
        Random random = new Random();

        System.out.println("Program start");
        System.out.println("________________________");

        for (int i = 0; i < catsNumber; i++) {
            int catAppetite = random.nextInt(maxCatAppetite) + 1;
            cats[i] = new Cat("Cat" + (i + 1), catAppetite);
            if (minCatAppetite > catAppetite) {
                minCatAppetite = catAppetite;
            }
        }

        while (plate.getFoodStat() >= minCatAppetite) {
            for (Cat cat : cats) {
                cat.eat(plate);
            }
            System.out.println(plate);
            System.out.println();

            if (random.nextInt(6) > 3) {
                System.out.println(
                        plate.increaseFood(random.nextInt(maxFoodToPutInPlate) + 1) + " food put on the plate.");
            } else {
                System.out.println("Nothing was put on the plate.");
            }
            System.out.println(plate);

            System.out.println();
            Thread.sleep(1000);
        }
    }
}