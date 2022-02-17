package edu.ncsu.csc326.coffeemaker;


import static org.junit.Assert.assertEquals;
import edu.ncsu.csc326.coffeemaker.exceptions.RecipeException;
import org.junit.Before;
import org.junit.Test;


public class RecipeTests {

    private Recipe recipe1;

    @Before
    public void setUp() throws Exception {

        recipe1 = new Recipe();
    }

    @Test
    public void testSetRecipeName() {

        recipe1.setName("Americano");
        assertEquals("Recipe name didn't match",
                recipe1.getName(),"Americano");
    }

    @Test
    public void testSetRecipeAmtChocolate() throws RecipeException {

        recipe1.setAmtChocolate("0");
        assertEquals("Recipe chocolate amount didn't match",
                recipe1.getAmtChocolate(),0);
    }

    @Test
    public void testSetRecipeCoffee() throws RecipeException {

        recipe1.setAmtCoffee("10");
        assertEquals("Recipe coffee amount did not match",
               recipe1.getAmtCoffee(),10);
    }

    @Test
    public void testSetRecipeAmtMilk() throws RecipeException {

        recipe1.setAmtMilk("1");
        assertEquals("Recipe milk amount didn't match",
                recipe1.getAmtMilk(),1);
    }

    @Test
    public void testSetRecipeAmtSugar() throws RecipeException {

        recipe1.setAmtSugar("6");
        assertEquals("Recipe sugar amount didn't match",
                recipe1.getAmtSugar(),6);
    }

    @Test
    public void testSetRecipePrice() throws RecipeException {

        recipe1.setPrice("30");
        assertEquals("Recipe price didn't match",
               recipe1.getPrice(),30);
    }

}
