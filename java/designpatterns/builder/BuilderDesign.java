package designpatterns.builder;

/**
 * Enum food options for each meal course
 */
enum Starter {
    SALAD,
    SOUP,
    BRUSCHETTA,
    VEGGIE_STICKS,
    CHICKEN_WINGS,
}

enum Main {
    GRILLED_CHICKEN,
    PASTA,
    VEGGIE_STIR_FRY,
    FISH,
    PIZZA,
}

enum Dessert {
    FRUIT_SALAD,
    ICE_CREAM,
    CHOCOLATE_CAKE,
    VEGAN_PUDDING,
    CHEESECAKE,
}

enum Drink {
    WATER,
    VEGAN_SHAKE,
    SODA,
    FRUIT_JUICE,
}

class Meal {
    private Starter starter;
    private Main main;
    private Dessert dessert;
    private Drink drink;

    public Starter getStarter() {
        return this.starter;
    }

    public Main getMain() {
        return this.main;
    }

    public Dessert getDessert() {
        return this.dessert;
    }

    public Drink getDrink() {
        return this.drink;
    }

    public void setStarter(Starter starter) {
        this.starter = starter;
    }

    public void setMain(Main main) {
        this.main = main;
    }

    public void setDessert(Dessert dessert) {
        this.dessert = dessert;
    }

    public void setDrink(Drink drink) {
        this.drink = drink;
    }
}

/**
 * This Builder interface can be reused to build different types of meals, making it extendable
 */
interface Builder {
    void addStarter();
    void addMainCourse();
    void addDessert();
    void addDrink();
}

class VeganMealBuilder implements Builder {
    private Meal meal;

    public VeganMealBuilder() {
        this.meal = new Meal();
    }

    @Override
    public void addStarter() {
        meal.setStarter(Starter.VEGGIE_STICKS);
    }

    @Override
    public void addMainCourse() {
        meal.setMain(Main.VEGGIE_STIR_FRY);
    }

    @Override
    public void addDessert() {
        meal.setDessert(Dessert.VEGAN_PUDDING);
    }

    @Override
    public void addDrink() {
        meal.setDrink(Drink.VEGAN_SHAKE);
    }

    Meal build() {
        return meal;
    }
}

class HealthyMealBuilder implements Builder {
    private Meal meal;

    public HealthyMealBuilder() {
        this.meal = new Meal();
    }

    @Override
    public void addStarter() {
        meal.setStarter(Starter.SOUP);
    }

    @Override
    public void addMainCourse() {
        meal.setMain(Main.GRILLED_CHICKEN);
    }

    @Override
    public void addDessert() {
        meal.setDessert(Dessert.FRUIT_SALAD);
    }

    @Override
    public void addDrink() {
        meal.setDrink(Drink.FRUIT_JUICE);
    }

    Meal build() {
        return meal;
    }
}

class Director {
    void constructVeganMeal(Builder builder) {
        builder.addStarter();
        builder.addMainCourse();
        builder.addDessert();
        builder.addDrink();
    }

    void constructHealthyMeal(Builder builder) {
        builder.addStarter();
        builder.addMainCourse();
        builder.addDessert();
        builder.addDrink();
    }
}

/**
 * The Builder pattern is a creational pattern that separates the construction of a complex object
 * from its representation. This way, the same construction process can be used to create different
 * representations of the product.
 *
 * This pattern hides the implementation of each meal away from the `main()` client. It keeps the
 * repetitive, manual object configuration (e.g. setters) away from the main code.
 */
public class BuilderDesign {
    public static void main(String[] args) {

        Director director = new Director();
        VeganMealBuilder builder = new VeganMealBuilder();
        director.constructVeganMeal(builder);

        Meal veganMeal = builder.build();

        System.out.println("Meal constructed: ");
        System.out.println("Starter: " + veganMeal.getStarter());
        System.out.println("Main: " + veganMeal.getMain());
        System.out.println("Dessert: " + veganMeal.getDessert());
        System.out.println("Drink: " + veganMeal.getDrink());

        System.out.println();

        HealthyMealBuilder builder2 = new HealthyMealBuilder();
        director.constructHealthyMeal(builder2);
        Meal healthyMeal = builder2.build();

        System.out.println("Meal constructed: ");
        System.out.println("Starter: " + healthyMeal.getStarter());
        System.out.println("Main: " + healthyMeal.getMain());
        System.out.println("Dessert: " + healthyMeal.getDessert());
        System.out.println("Drink: " + healthyMeal.getDrink());
    }
}
