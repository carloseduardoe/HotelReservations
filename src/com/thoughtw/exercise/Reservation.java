package com.thoughtw.exercise;

import java.util.Calendar;

public class Reservation implements Comparable {
    private String hotel;
    private int hotelRating;
    private Calendar date;
    private int price;

    public Reservation(String hotel, int hotelRating, Calendar date, int price) {
        this.hotel = hotel;
        this.hotelRating = hotelRating;
        this.date = date;
        this.price = price;
    }
    
    @Override
    public String toString() {
        String day = "- ";
        
        switch(date.get(Calendar.DAY_OF_WEEK)) {
            case 2: case 3: case 4: case 5: case 6:
                day = "day";
                break;
            case 1: case 7:
                day = "end";
                break;
        }
        
        return hotel + "\t" + date.get(Calendar.DAY_OF_WEEK) + " (" + day + "):\t" + this.price;
    }

    @Override
    public int compareTo(Object o) {
        Reservation item = (Reservation) o;
        if(this.price == item.price)
            return this.hotelRating - item.hotelRating;
        else
            return this.price - item.price;
    }
    
    public String getHotel() {
        return this.hotel;
    }

    public int getPrice() {
        return price;
    }
}
