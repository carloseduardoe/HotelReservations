package com.thoughtw.exercise;

import java.util.Calendar;
import org.junit.Test;
import static org.junit.Assert.*;

public class ReservationTest {
    @Test
    public void testCompareTo() {
        System.out.println("compareTo");
        Calendar date = Calendar.getInstance();
        
        Reservation instance = new Reservation("HotelName", 3, date, 100);
        int result = instance.compareTo(new Reservation("HotelName", 3, date, 100));
        
        assertEquals(result, 0);
    }

    @Test
    public void testGetHotel() {
        System.out.println("getHotel");
        String value = "hotelName";
        
        Reservation instance = new Reservation(value, 3, Calendar.getInstance(), 100);
        String result = instance.getHotel();
        
        assertEquals(value, result);
    }
    
}
