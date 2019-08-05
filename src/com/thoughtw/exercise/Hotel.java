package com.thoughtw.exercise;

import java.util.*;

public class Hotel {
    private String name;
    private int rating;
    
    String rewardKey;
    String[] fareKeys;
    private Map<String, Integer> fares;
    
    @Override
    public String toString() {
        return this.name;
    }

    public Hotel(String name, int rating, String rewardKey, String[] fareKeys, Map fares) {
        this.name = name;
        this.rating = rating;
        this.rewardKey = rewardKey;
        this.fareKeys = fareKeys;
        this.fares = fares;
    }
    
    public Reservation generateReservation(String type, Calendar date) {
        int price = 0;
        boolean weekday = Arrays.asList(2, 3, 4, 5, 6).contains(date.get(Calendar.DAY_OF_WEEK));
        
        if(!type.equals(rewardKey)) {
            price = fares.get(weekday ? fareKeys[0] : fareKeys[1]);
        } else {
            price = fares.get(weekday ? fareKeys[2] : fareKeys[3]);
        }
        
        return new Reservation(name, rating, date, price);
    }
}