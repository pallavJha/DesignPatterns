package pl.hfdp.factory.stage1;

import java.util.Collections;
import java.util.List;

/**
 * MilkShake is the base class for the types of the milk shakes.
 */
public abstract class MilkShake {
    /**
     * ingredients is list of the items that'll be used for preparing the milk shake.
     */
    List<String> ingredients = Collections.singletonList("Milk");

    /**
     * addMilk starts the preparation by adding the milk
     */
    public void addMilk() {
        System.out.println("Adding the milk...");
    }

    /**
     * addIngredients is the next step after adding the milk.
     */
    public void addIngredients() {
        System.out.println("Adding the ingredients... " + ingredients.toString());
    }

    /**
     * blends the shake. Our final step.
     */
    public void blend() {
        System.out.println("Blending... " + ingredients.toString());
    }

    public String toString() {
        return "MilkShake{" +
                "ingredients=" + ingredients +
                '}';
    }
}
