package com.thoughtw.exercise;

import java.util.Calendar;
import java.util.HashMap;
import org.junit.Test;
import static org.junit.Assert.*;

public class HotelTest {
    @Test
    public void testGenerateReservation() {
        System.out.println("generateReservation");
        String name = "Yaddayaddawood";
        String type = "reg";
        String[] keys = new String[]{"day", "end", "rday", "rend"};
        
        Hotel instance = new Hotel(name, 3, type, keys, new HashMap<String, Integer>() {{
                put(keys[0], 110);
                put(keys[1], 90);
                put(keys[2], 80);
                put(keys[3], 80);
            }}
        );
        
        Reservation res = instance.generateReservation(type, Calendar.getInstance());
        
        assertEquals(res.getHotel(), name);
    }
}
