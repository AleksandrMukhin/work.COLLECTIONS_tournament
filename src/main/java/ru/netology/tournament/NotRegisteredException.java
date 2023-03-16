package ru.netology.tournament;

public class NotRegisteredException extends RuntimeException {

    public NotRegisteredException(String playerName) {
        super("Игрок с именем " + playerName + " не найден");
    }
}
