package Homeworks.Homework5.service;

import Homeworks.Homework5.model.Player;
import Homeworks.Homework5.model.Pokemon;
import Homeworks.Homework5.model.WeatherEnum;


import java.util.ArrayList;

public class GameService {

    LoadService loadService = new LoadService();
    ArrayList<Pokemon> pokemonList = loadService.loadPokemons();
    WeatherService weatherService = new WeatherService();

    /*
    "attack" methodu içerisinde saldıran oyuncunun pokemonunun gücü normal saldırı, pokemon özel saldırısı,
    karakter özel saldırısı ve hava durumu koşulları gibi farklı durumlara göre ayarlandı. Yapılan saldırının
    gücü savunma durumunda olan pokemonun canından eksiltildi.
     */


    public void attack(Player attacker, Player defender, boolean isPokeSpecialAttack, boolean isCharSpecialAttack) {
        Pokemon attackingPokemon = attacker.getCharacter().getPokemonList().get(0);
        Pokemon defendingPokemon = defender.getCharacter().getPokemonList().get(0);


        boolean specialAttack = false;
        if (isPokeSpecialAttack && isCharSpecialAttack) {
            specialAttack = attackingPokemon.getSpecialPower().getRemainingRights() > 0
                    && attacker.getCharacter().getSpecialPower().getRemainingRights() > 0;
        } else if (isPokeSpecialAttack) {
            specialAttack = attackingPokemon.getSpecialPower().getRemainingRights() > 0;
        } else if (isCharSpecialAttack) {
            specialAttack = attacker.getCharacter().getSpecialPower().getRemainingRights() > 0;
        }

        int charRemainingRights = attacker.getCharacter().getSpecialPower().getRemainingRights();

        WeatherEnum randomWeather = weatherService.randomWeather();

        int damage = weatherService.weatherEffect(randomWeather,attacker);
        if (specialAttack) {
            if (isPokeSpecialAttack && isCharSpecialAttack) {
                damage += attackingPokemon.specialAttack();
                damage += attacker.getCharacter().getSpecialPower().getExtraDamage();
                attacker.getCharacter().getSpecialPower().setRemainingRights(charRemainingRights - 1);
                System.out.println(attacker.getName()+"'s "+ attackingPokemon.getName()+ " hit " + damage);
            } else if (isPokeSpecialAttack) {
                damage += attackingPokemon.specialAttack();
                System.out.println(attacker.getName()+"'s "+ attackingPokemon.getName()+ " hit " + damage);
            } else {
                damage += attackingPokemon.getDamage();
                damage += attacker.getCharacter().getSpecialPower().getExtraDamage();
                attacker.getCharacter().getSpecialPower().setRemainingRights(charRemainingRights - 1);
                System.out.println(attacker.getName()+"'s "+ attackingPokemon.getName()+ " hit " + damage);
            }
        } else {
            if (isPokeSpecialAttack || isCharSpecialAttack) {
                System.out.println(attacker.getName()+"'s "+ attackingPokemon.getName()+ " hit " + 0);
                System.out.println("You don't have special power anymore");
            } else {
                damage += attackingPokemon.getDamage();
                System.out.println(attacker.getName()+"'s "+ attackingPokemon.getName()+ " hit " + damage);
            }
        }

        defendingPokemon.setHealth(defendingPokemon.getHealth() - damage);
        System.out.println(defender.getName()+"'s " + defendingPokemon.getName()+ " health is " + defendingPokemon.getHealth());
    }

    /*
    Savaş sırasında bir pokemonun ölme durumu "healthCheck" methodu ile kontrol edildi.
     */

    public boolean healthCheck(Player player){

        boolean isWin = true;
        if (player.getCharacter().getPokemonList().get(0).getHealth() > 0){

            System.out.println("Game continues.");
            return isWin;
        }else {
            System.out.println(player.getName()+"'s " +player.getCharacter().getPokemonList().get(0).getName()+" died.");
            isWin = false;
            return isWin;
        }
    }

    /*
    Saldırı gücü en düşük pokemonu bulmak için "addLowestDamagePokemon" methodu kullanıldı.
     */

    public void addLowestDamagePokemon(Player player){

        Pokemon lowestDamage = pokemonList.get(0);

        for (Pokemon pokemon:pokemonList
             ) {if (pokemon.getDamage() < lowestDamage.getDamage()){
                 lowestDamage = pokemon;
        }
        }
        player.getCharacter().getPokemonList().add(lowestDamage);
    }

     /*
     Birinci raundu kaybeden oyuncuya pokemon listesinden saldırı gücü en düşük pokemon ikinci rauntta kulanması için
     eklendi.
     Birinci raundun kazananına kaybedenin pokemonu eklendi.
    */

    public void findWinner(Player player1, Player player2){

        if (player1.getCharacter().getPokemonList().get(0).getHealth() <= 0){

            player2.getCharacter().getPokemonList().add(player1.getCharacter().getPokemonList().get(0));
            player2.getCharacter().getPokemonList().get(1).setHealth(100);

            addLowestDamagePokemon(player1);
            player1.getCharacter().getPokemonList().remove(0);
        }else {
            player1.getCharacter().getPokemonList().add(player2.getCharacter().getPokemonList().get(0));
            player1.getCharacter().getPokemonList().get(1).setHealth(100);

            addLowestDamagePokemon(player2);
            player2.getCharacter().getPokemonList().remove(0);
        }
    }

}
