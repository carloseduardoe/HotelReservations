package com.thoughtw.exercise;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.*;

public class MainClass {
    final static String filePath = System.getProperty("user.dir") + "/source.txt";
    final static Charset charset = StandardCharsets.UTF_8;
    final static String rewardKey = "Rewards";
    final static String[] fareKeys = new String[]{
        "weekday", "weekend", "rwWeekday", "rwWeekend"
    };
    
    final static Hotel[] hotels = new Hotel[] {
        new Hotel("Lakewood", 3, rewardKey, fareKeys, new HashMap<String, Integer>() {{
                put(fareKeys[0], 110);
                put(fareKeys[1], 90);
                put(fareKeys[2], 80);
                put(fareKeys[3], 80);
            }}
        ),
        new Hotel("Bridgewood", 4, rewardKey, fareKeys, new HashMap<String, Integer>() {{
                put(fareKeys[0], 160);
                put(fareKeys[1], 60);
                put(fareKeys[2], 110);
                put(fareKeys[3], 50);
            }}
        ),
        new Hotel("Ridgewood", 5, rewardKey, fareKeys, new HashMap<String, Integer>() {{
                put(fareKeys[0], 220);
                put(fareKeys[1], 150);
                put(fareKeys[2], 100);
                put(fareKeys[3], 40);
            }}
        )
    };
    
    public static void main(String[] args) {
        MainClass instance = new MainClass();
        String divider = ", ";
        String replace = ": ";
        
        try {
            List<String> lines = instance.readFile(filePath, charset);
            String[] values;
            ArrayList<Reservation> reserv;
            
            for(String line : lines) {
                values = line.replace(replace, divider).split(divider);
                
                System.out.println(line);
                reserv = new ArrayList<>();
                for (int i = 1; i < values.length; i++) {
                    reserv.add(
                        hotels[i - 1].generateReservation(values[0], parseDate(values[i]))
                    );
                }
                
                Collections.sort(reserv);
                System.out.println(reserv.get(0).getHotel());
            }
            
        } catch (Exception e) {
            System.err.println(e.getClass() + ":\t" + e.getMessage());
        }
    }

    static List<String> readFile(String filePath, Charset charset) throws Exception {
        return Files.readAllLines(Paths.get(filePath), charset);
    }
    
    static Calendar parseDate(String date) throws Exception {
        Calendar cal = Calendar.getInstance();
        cal.setTime(
            new SimpleDateFormat("ddMMMyyyy", Locale.ENGLISH)
                .parse(date.substring(0, 9))
        );
        return cal;
    }
}
