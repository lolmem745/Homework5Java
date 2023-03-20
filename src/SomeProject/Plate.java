package SomeProject;

public class Plate {

    private int food;
    private final int plateCapacity;

    public Plate(int food) {
        this.food = food;
        this.plateCapacity = food;
    }

    public int decreaseFood(int foodToDecrease) {
        if (this.food >= foodToDecrease) {
            this.food -= foodToDecrease;
            return foodToDecrease;
        }
        return 0;
    }

    @Override
    public String toString() {
        return "Plate[" + this.food + "]";
    }

    public int getFoodStat() {
        return this.food;
    }

    public int increaseFood(int foodToIncrease) {
        if (foodToIncrease > 0) {
            if (this.food <= this.plateCapacity - foodToIncrease) {
                this.food += foodToIncrease;
                return foodToIncrease;
            } else if (this.food < this.plateCapacity) {
                foodToIncrease = this.plateCapacity - this.food;
                this.food = this.plateCapacity;
                return foodToIncrease;
            }
        }
        return -1;
    }


}