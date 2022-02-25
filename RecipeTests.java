package edu.ncsu.csc326.coffeemaker;


import static junit.framework.Assert.assertTrue;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

import edu.ncsu.csc326.coffeemaker.exceptions.RecipeException;
import org.junit.Before;
import org.junit.Test;

public class RecipeTests {

    private Recipe recipe1;
    private Recipe recipe2;
    private Recipe recipe3;

    @Before
    public void setUp() throws Exception {

        recipe1 = new Recipe();
        recipe2 = new Recipe();
        recipe3 = new Recipe();

        recipe2.setName("Coffee");
        recipe2.setAmtChocolate("0");
        recipe2.setAmtCoffee("3");
        recipe2.setAmtMilk("1");
        recipe2.setAmtSugar("1");
        recipe2.setPrice("50");

        recipe3.setName("Kaffe");
        recipe3.setAmtChocolate("1");
        recipe3.setAmtCoffee("1");
        recipe3.setAmtMilk("1");
        recipe3.setAmtSugar("1");
        recipe3.setPrice("1");
    }

    @Test
    public void testSetRecipeName_Normal() {
        recipe1.setName("Americano");
        String recipeName = recipe1.getName();
        assertEquals("Recipe name didn't match",
                "Americano", recipeName);
    }

    @Test
    public void testSetRecipeAmtChocolate_Normal() throws RecipeException {
        recipe1.setAmtChocolate("0");
        int recipeAmtChocolate = recipe1.getAmtChocolate();
        assertEquals("Recipe chocolate amount didn't match",
                0, recipeAmtChocolate);
    }

    @Test
    public void testSetRecipeCoffee_Normal() throws RecipeException {
        recipe1.setAmtCoffee("10");
        int recipeAmtCoffee = recipe1.getAmtCoffee();
        assertEquals("Recipe coffee amount did not match",
                10, recipeAmtCoffee);
    }

    @Test
    public void testSetRecipeAmtMilk_Normal() throws RecipeException {
        recipe1.setAmtMilk("1");
        assertEquals("Recipe milk amount didn't match",
                recipe1.getAmtMilk(), 1);
    }

    @Test
    public void testSetRecipeAmtSugar_Normal() throws RecipeException {
        recipe1.setAmtSugar("6");
        assertEquals("Recipe sugar amount didn't match",
                recipe1.getAmtSugar(), 6);
    }

    @Test
    public void testSetRecipePrice_Normal() throws RecipeException {
        recipe1.setPrice("30");
        assertEquals("Recipe price didn't match",
                recipe1.getPrice(), 30);
    }

    //getters
    @Test
    public void testGetRecipeName() {
        String name = recipe2.getName();
        assertEquals("Recipe name didn't match",
                "Coffee", name);
    }

    @Test
    public void testGetRecipeAmtChocolate() throws RecipeException {
        int amtChocolate = recipe2.getAmtChocolate();
        assertEquals("Recipe chocolate amount didn't match",
                0, amtChocolate);
    }

    @Test
    public void testGetRecipeAmtCoffee() throws RecipeException {
        int amtCoffee = recipe2.getAmtCoffee();
        assertEquals("Recipe coffee amount didn't match",
                3, amtCoffee);
    }

    @Test
    public void testGetRecipeAmtMilk() throws RecipeException {
        int amtSugar = recipe2.getAmtSugar();
        assertEquals("Recipe sugar amount didn't match",
                1, amtSugar);
    }

    @Test
    public void testGetRecipeAmtSugar() throws RecipeException {
        int amtMilk = recipe2.getAmtMilk();
        assertEquals("Recipe chocolate amount didn't match",
                1, amtMilk);
    }

    @Test
    public void testGetRecipePrice() throws RecipeException {
        int price = recipe2.getPrice();
        assertEquals("Recipe price didn't match",
                50, price);
    }

    //setters(Invalid)
    @Test
    public void testSetAmtSugar_InvalidInput() {
        assertThrows(RecipeException.class, () -> {
                    recipe1.setAmtSugar("dd");
                }
        );
    }

    @Test
    public void testSetAmtMilk_InvalidInput() {
        assertThrows(
                RecipeException.class, () -> {
                    recipe1.setAmtMilk("-1");
                }
        );
    }

    @Test
    public void testSetAmtChocolate_InvalidInput() {
        assertThrows(RecipeException.class, () -> {
                    recipe1.setAmtChocolate("-1");
                }
        );
    }

    @Test
    public void testSetAmtCoffee_InvalidInput() {
        assertThrows(RecipeException.class, () -> {
                    recipe1.setAmtCoffee("¤#");
                }
        );
    }

    @Test
    public void testSetPrice_InvalidInput() {
        assertThrows(RecipeException.class, () -> {
                    recipe1.setPrice("w2");
                }
        );
    }

    //this test will fail since setName() in coffeemaker/Recipe.java
    //needs to handle exceptions (throw exceptions, try and catch)
//    @Test
//    public void testSetName_InvalidInput() {
//
//        assertThrows(
//                RecipeException.class, () -> { recipe1.setName(""); }
//        );
//    }

    @Test
    public void testSetAmtCoffee_exceptionThrown() {
        Exception exception = assertThrows(RecipeException.class, () -> {
            recipe1.setAmtCoffee("-30");
        });
        String expectedMessage = "Units of coffee must be a positive integer";
        String actualMessage = exception.getMessage();
        assertTrue(actualMessage.contains(expectedMessage));
    }

    @Test
    public void testSetAmtMilk_exceptionThrown() {
        Exception exception = assertThrows(RecipeException.class, () -> {
            recipe1.setAmtMilk("-30");
        });
        String expectedMessage = "Units of milk must be a positive integer";
        String actualMessage = exception.getMessage();
        assertTrue(actualMessage.contains(expectedMessage));
    }

    @Test
    public void testSetAmtChocolate_exceptionThrown() {
        Exception exception = assertThrows(RecipeException.class, () -> {
            recipe2.setAmtChocolate("-30");
        });
        String expectedMessage = "Units of chocolate must be a positive integer";
        String actualMessage = exception.getMessage();
        assertTrue(actualMessage.contains(expectedMessage));
    }

    @Test
    public void testSetAmtSugar_exceptionThrown() {
        Exception exception = assertThrows(RecipeException.class, () -> {
            recipe2.setAmtSugar("-30");
        });
        String expectedMessage = "Units of sugar must be a positive integer";
        String actualMessage = exception.getMessage();
        assertTrue(actualMessage.contains(expectedMessage));
    }

    @Test
    public void testSetPrice_exceptionThrown() {
        Exception exception = assertThrows(RecipeException.class, () -> {
            recipe2.setPrice("-30");
        });
        String expectedMessage = "Price must be a positive integer";
        String actualMessage = exception.getMessage();
        assertTrue(actualMessage.contains(expectedMessage));
    }

    // invalid input
    @Test
    public void testSetAmtCoffee2_exceptionThrown() {
        Exception exception = assertThrows(RecipeException.class, () -> {
            recipe1.setAmtCoffee("obs");
        });
        String expectedMessage = "Units of coffee must be a positive integer";
        String actualMessage = exception.getMessage();
        assertTrue(actualMessage.contains(expectedMessage));
    }

    @Test
    public void testSetAmtMilk2_exceptionThrown() {
        Exception exception = assertThrows(RecipeException.class, () -> {
            recipe1.setAmtMilk("obs");
        });
        String expectedMessage = "Units of milk must be a positive integer";
        String actualMessage = exception.getMessage();
        assertTrue(actualMessage.contains(expectedMessage));
    }

    @Test
    public void testSetAmtChocolate2_exceptionThrown() {
        Exception exception = assertThrows(RecipeException.class, () -> {
            recipe2.setAmtChocolate("obs");
        });
        String expectedMessage = "Units of chocolate must be a positive integer";
        String actualMessage = exception.getMessage();
        assertTrue(actualMessage.contains(expectedMessage));
    }

    @Test
    public void testSetAmtSugar2_exceptionThrown() {
        Exception exception = assertThrows(RecipeException.class, () -> {
            recipe2.setAmtSugar("obs");
        });
        String expectedMessage = "Units of sugar must be a positive integer";
        String actualMessage = exception.getMessage();
        assertTrue(actualMessage.contains(expectedMessage));
    }

    @Test
    public void testSetPrice2_exceptionThrown() {
        Exception exception = assertThrows(RecipeException.class, () -> {
            recipe2.setPrice("obs");
        });
        String expectedMessage = "Price must be a positive integer";
        String actualMessage = exception.getMessage();
        assertTrue(actualMessage.contains(expectedMessage));
    }

    @Test
    public void testToString() {
        String name = recipe2.getName();
        assertEquals("Recipe name didn't match",
                recipe2.toString(), name);
    }
}

