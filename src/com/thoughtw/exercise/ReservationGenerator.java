package com.thoughtw.exercise;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

class ReservationGenerator {
    Calendar[] parseDate(String userInput) throws ParseException{
        String[] values = userInput.replace(":", ",").split(", ");
        
        Calendar[] cal = new Calendar[] {
            Calendar.getInstance(),
            Calendar.getInstance(),
            Calendar.getInstance()
        };
        
        for (int i = 1; i < values.length; i++) {
            cal[i-1].setTime(
                new SimpleDateFormat("ddMMMyyyy", Locale.ENGLISH).parse(values[i].substring(0, 9))
            );
        }
        
        return cal;
    }
    
    Calendar[] parseDateArray(String[] userInput) throws ParseException {
        return new Calendar[]{Calendar.getInstance()};
    }
}
