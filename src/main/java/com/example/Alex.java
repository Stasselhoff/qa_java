package com.example;

import java.util.ArrayList;

public class Alex extends Lion {

    public Alex(IFeline feline) throws Exception {
        super("Самец", feline);

    }
    public String getPlaceOfLiving() {
        return "Нью-Йоркский зоопарк";
    }
    public ArrayList<String> getFriends() {

        ArrayList<String> friends = new ArrayList<>();
        friends.add("Марти");
        friends.add("Глория");
        friends.add("Мелман");

        return friends;
    }

}
