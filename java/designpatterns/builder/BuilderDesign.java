package designpatterns.builder;

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

    // TODO: Write getter methods for each course

    // TODO: Write setter methods for each course
}

interface Builder {
    void addStarter();
    void addMainCourse();
    void addDessert();
    void addDrink();
}

class VeganMealBuilder implements Builder {
    private Meal meal;

    public VeganMealBuilder() {
        //TODO: Write your code here
    }

    @Override
    public void addStarter() {
        //TODO: Write your code here
    }

    @Override
    public void addMainCourse() {
        //TODO: Write your code here
    }

    @Override
    public void addDessert() {
        //TODO: Write your code here
    }

    @Override
    public void addDrink() {
        //TODO: Write your code here
    }

    Meal build() {
        // Return the completed meal
        return null; // placeholder
    }
}

class HealthyMealBuilder implements Builder {
    private Meal meal;

    public HealthyMealBuilder() {
        //TODO: Write your code here
    }

    @Override
    public void addStarter() {
        //TODO: Write your code here
    }

    @Override
    public void addMainCourse() {
        //TODO: Write your code here
    }

    @Override
    public void addDessert() {
        //TODO: Write your code here
    }

    @Override
    public void addDrink() {
        //TODO: Write your code here
    }

    Meal build() {
        return null; // placeholder
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
