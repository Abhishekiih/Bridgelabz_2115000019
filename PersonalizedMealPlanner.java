import java.util.ArrayList;
import java.util.List;

interface MealPlan {
    String getMealType();
}

class VegetarianMeal implements MealPlan {
    public String getMealType() {
        return "Vegetarian";
    }
}

class VeganMeal implements MealPlan {
    public String getMealType() {
        return "Vegan";
    }
}

class KetoMeal implements MealPlan {
    public String getMealType() {
        return "Keto";
    }
}

class HighProteinMeal implements MealPlan {
    public String getMealType() {
        return "High-Protein";
    }
}

class Meal<T extends MealPlan> {
    private String mealName;
    private T mealType;

    public Meal(String mealName, T mealType) {
        this.mealName = mealName;
        this.mealType = mealType;
    }

    public String getMealName() {
        return mealName;
    }

    public T getMealType() {
        return mealType;
    }

    @Override
    public String toString() {
        return mealName + " - " + mealType.getMealType();
    }
}

class MealPlanGenerator {
    private List<Meal<? extends MealPlan>> mealPlans = new ArrayList<>();

    public void addMeal(Meal<? extends MealPlan> meal) {
        mealPlans.add(meal);
    }

    public void displayMeals() {
        System.out.println("\nPersonalized Meal Plan:");
        for (Meal<? extends MealPlan> meal : mealPlans) {
            System.out.println(meal);
        }
    }

    public static <T extends MealPlan> void generateMealPlan(Meal<T> meal) {
        System.out.println("Meal Plan Generated: " + meal);
    }
}

public class PersonalizedMealPlanner {
    public static void main(String[] args) {
        VegetarianMeal vegetarianMeal = new VegetarianMeal();
        VeganMeal veganMeal = new VeganMeal();
        KetoMeal ketoMeal = new KetoMeal();
        HighProteinMeal highProteinMeal = new HighProteinMeal();

        Meal<VegetarianMeal> vegDish = new Meal<>("Grilled Veggie Bowl", vegetarianMeal);
        Meal<VeganMeal> veganDish = new Meal<>("Tofu Stir Fry", veganMeal);
        Meal<KetoMeal> ketoDish = new Meal<>("Avocado Chicken Salad", ketoMeal);
        Meal<HighProteinMeal> proteinDish = new Meal<>("Grilled Salmon", highProteinMeal);

        MealPlanGenerator generator = new MealPlanGenerator();
        generator.addMeal(vegDish);
        generator.addMeal(veganDish);
        generator.addMeal(ketoDish);
        generator.addMeal(proteinDish);

        generator.displayMeals();

        MealPlanGenerator.generateMealPlan(vegDish);
        MealPlanGenerator.generateMealPlan(veganDish);
        MealPlanGenerator.generateMealPlan(ketoDish);
        MealPlanGenerator.generateMealPlan(proteinDish);
    }
}
