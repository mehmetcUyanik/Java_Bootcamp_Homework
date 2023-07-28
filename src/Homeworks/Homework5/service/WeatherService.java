package Homeworks.Homework5.service;

import Homeworks.Homework5.model.Player;
import Homeworks.Homework5.model.Pokemon;
import Homeworks.Homework5.model.WeatherEnum;

import java.util.Random;

public class WeatherService {

    /*
    Rastgele hava durumu oluşturmak için "randomWeather" methodu kullanıldı.
     */

    public WeatherEnum randomWeather(){
        Random rand = new Random();
        int intRand = rand.nextInt(3);
        switch (intRand){
            case 0:
                return WeatherEnum.SUNNY;
            case 1:
                return WeatherEnum.RAINY;
            case 2:
                return WeatherEnum.STORMY;
        }
        return null;
    }

    /*
    Rastgele belirlenecek hava durumu için pokemonların elementlerine göre saldırılarının güçlenmesi,zayıflaması veya
    etkilenmemesi koşulları "weatherEffect" methodu ile sağlandı.
     */

    public int weatherEffect(WeatherEnum weatherEnum, Player player){

        Pokemon pokemon = player.getCharacter().getPokemonList().get(0);
        int damage = 0;
        if (weatherEnum.equals(WeatherEnum.SUNNY)){
            System.out.println("Weather is sunny");
            if(pokemon.getType().toString().equals("FIRE")){
                System.out.println(pokemon.getName()+" damage increased +3");
                damage = 3;
            }else if (pokemon.getType().toString().equals("WATER")){
                System.out.println(pokemon.getName()+" damage decreased -3");
                damage = -3;
            }else {
                System.out.println(pokemon.getName()+" not affected by the weather.");
            }

        }else if (weatherEnum.equals(WeatherEnum.RAINY)){
            System.out.println("Weather is rainy");
            if(pokemon.getType().toString().equals("WATER")){
                System.out.println(pokemon.getName()+" damage increased +3");
                damage = 3;
            }else if (pokemon.getType().toString().equals("FIRE")){
                System.out.println(pokemon.getName()+" damage decreased -3");
                damage = -3;
            }else {
                System.out.println(pokemon.getName()+" not affected by the weather.");
            }
        }
        else if (weatherEnum.equals(WeatherEnum.STORMY)){
            System.out.println("Weather is stormy");
            if(pokemon.getType().toString().equals("ELECTRICITY")){
                System.out.println(pokemon.getName()+" damage increased +3");
                damage = 3;
            }else if (pokemon.getType().toString().equals("EARTH")){
                System.out.println(pokemon.getName()+" damage decreased -3");
                damage = -3;
            }else {
                System.out.println(pokemon.getName()+" not affected by the weather.");
            }
        }
        return damage;
    }
}
