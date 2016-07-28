package com.drartisan.uuid;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

/**
 * Created by summer on 16/4/7.
 */
public class UUIDGenerator {

    public static void main(String[] args){

        Date d1 = new Date();
        for (int i = 0; i < 100000 ; i++) {
            UUID uuid = UUID.randomUUID();
            System.out.println(uuid.toString().replace("-","").toUpperCase());
        }
        Date d2 = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:SSS");
        System.out.println(sdf.format(d1)+"\n\n"+sdf.format(d2));

    }
}
