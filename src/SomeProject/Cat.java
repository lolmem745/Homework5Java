package SomeProject;

public class Cat {

    private final String name;
    private final int appetite;
    private volatile int satiety = 0;
    public Cat(String name, int appetite) {
        this.name = name;
        this.appetite = appetite;

        Thread backgroundSatietyManagement = new Thread(() -> {
            while (true) {
                if (this.satiety > 0) {
                    this.satiety -= 1;
                }
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });
        backgroundSatietyManagement.setDaemon(true);
        backgroundSatietyManagement.start();
    }

    public void eat(Plate plate) {
        if (this.satiety == 0) {
            this.satiety = plate.decreaseFood(this.appetite);
            if (this.satiety == 0) {
                System.out.println(toString() + " didn`t ate anything, there is not ennought food left.");
            } else {
                System.out.println(toString() + " ate " + this.appetite + " food from the plate.");
            }
        } else {
            System.out.println(toString() + " isn`t hungry yet.");
        }

    }

    @Override
    public String toString() {
        return this.name + "{appetite=" + this.appetite + ", satiety=" + this.satiety + "}";
    }
}