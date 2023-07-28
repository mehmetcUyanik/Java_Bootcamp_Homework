package Homeworks.Homework5.service;

import Homeworks.Homework5.model.Character;
import Homeworks.Homework5.model.Player;

public class PlayerService {

    public Player createPlayer(String name, Character character) {
        return new Player(name, character);
    }



}
