package Homeworks.Homework5.model;

import java.util.ArrayList;

public class Misty extends Character {

    public Misty(String name, SpecialPower specialPower, ArrayList<Pokemon> pokemonList) {
        super(name, specialPower, pokemonList);
    }

    public Misty(String name, SpecialPower specialPower) {
        super(name, specialPower);
    }

    @Override
    public String toString() {
        return "Misty{}";
    }
}
