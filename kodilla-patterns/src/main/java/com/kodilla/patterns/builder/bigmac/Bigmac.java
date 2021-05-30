package com.kodilla.patterns.builder.bigmac;


import java.util.ArrayList;
import java.util.List;

public final class Bigmac {

    private final String bun;
    private final int burgers;
    private final String sauce;
    private List<String> ingredients = new ArrayList<>();

    public static class BigmacBuilder {
        private String bun;
        private int burgers;
        private String sauce;
        private List<String> ingredients = new ArrayList<>();

        public BigmacBuilder bun(String bun) {
            this.bun = bun;
            return this;
        }

        public BigmacBuilder burgers(int burgers) {
            this.burgers = burgers;
            return this;
        }

        public BigmacBuilder sauce(String sauce) {
            this.sauce = sauce;
            return this;
        }

        public BigmacBuilder ingredient(String ingredient) {
            ingredients.add(ingredient);
            return this;
        }

        public Bigmac build() {

            List<String> possibleBun = new ArrayList<>();
            possibleBun.add("bun with sesame");
            possibleBun.add("bun without sesame");

            List<Integer> possibleBurgers = new ArrayList<>();
            possibleBurgers.add(1);
            possibleBurgers.add(2);
            possibleBurgers.add(3);

            List<String> possibleSauce = new ArrayList<>();
            possibleSauce.add("standard sauce");
            possibleSauce.add("BBQ sauce");
            possibleSauce.add("Thousand Island dressing");

            List<String> possibleIngredients = new ArrayList<>();
            possibleIngredients.add("lettuce");
            possibleIngredients.add("onion");
            possibleIngredients.add("beacon");
            possibleIngredients.add("cucumber");
            possibleIngredients.add("chilli pepper");
            possibleIngredients.add("mushrooms");
            possibleIngredients.add("prawns");
            possibleIngredients.add("cheese");

            Bigmac bigmacIngredients = new Bigmac(bun, burgers, sauce, ingredients);

            if (possibleBun.contains(bigmacIngredients.getBun()) &&
                    possibleBurgers.contains(bigmacIngredients.getBurgers()) &&
                    possibleSauce.contains(bigmacIngredients.getSauce()) &&
                    possibleIngredients.containsAll(bigmacIngredients.getIngredients())) {
                return bigmacIngredients;
            } else {
                throw new IllegalStateException ("You can order ingredients only from the menu... Choose bun, quantity, sauce and burger toppings!");
            }
        }
    }

    private Bigmac(final String bun, final int burgers, final String sauce, List<String> ingredients) {
        this.bun = bun;
        this.burgers = burgers;
        this.sauce = sauce;
        this.ingredients = new ArrayList<>(ingredients);
    }

    public String getBun() {
        return bun;
    }

    public int getBurgers() {
        return burgers;
    }

    public String getSauce() {
        return sauce;
    }

    public List<String> getIngredients() {
        return ingredients;
    }

    @Override
    public String toString() {
        return "Bigmac{" +
                "bun='" + bun + '\'' +
                ", burgers=" + burgers +
                ", sauce='" + sauce + '\'' +
                ", ingredients=" + ingredients +
                '}';
    }
}
