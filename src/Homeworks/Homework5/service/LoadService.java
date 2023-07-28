package Homeworks.Homework5.service;

import Homeworks.Homework5.model.*;
import Homeworks.Homework5.model.Character;

import java.util.ArrayList;

public class LoadService {
    public ArrayList<Character> loadCharacters(){
        SpecialPower strategy1 = new Strategy("Strategy", 4, 1);
        SpecialPower strategy2 = new Strategy("Strategy II", 3, 1);
        SpecialPower strategy3 = new Strategy("Strategy3",5,1);

        Character ash = new Ash("Ash", strategy1);
        Character brooke = new Brooke("Brooke", strategy2);
        Character misty = new Misty("Misty",strategy3);

        ArrayList<Character> characterList = new ArrayList<>();
        characterList.add(ash);
        characterList.add(brooke);
        characterList.add(misty);
        return characterList;
    }

    public ArrayList<Pokemon> loadPokemons(){
        SpecialPower electricity = new Electricity("Electricity", 3, 1);
        SpecialPower water = new Water("Water", 3, 1);
        SpecialPower fire = new Fire("Fire", 5, 1);
        SpecialPower earth = new Earth("Earth", 4, 1);

        Pokemon pokemon1 = new Pikachu("Pikachu", 100, 20, TypeEnum.ELECTRICITY, electricity);
        Pokemon pokemon2 = new Sqiurtle("Squirtle", 100, 18, TypeEnum.WATER, water);
        Pokemon pokemon3 = new Charmander("Charmender", 100, 24, TypeEnum.FIRE, fire);
        Pokemon pokemon4 = new Balbausar("Balbausar", 100, 17, TypeEnum.EARTH, earth);

        ArrayList<Pokemon> pokemonList = new ArrayList<>();
        pokemonList.add(pokemon1);
        pokemonList.add(pokemon2);
        pokemonList.add(pokemon3);
        pokemonList.add(pokemon4);

        return pokemonList;
    }
}
