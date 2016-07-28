package com.drartisan.activemq; /**
 * Created by summer on 16/3/29.
 */
import javax.jms.*;

public class Listener implements MessageListener {
    public void onMessage(Message message) {
        try {
            MapMessage map = (MapMessage) message;
            System.out.println(map.getString("tes"));
        }catch (Exception e){
           e.printStackTrace();
        }



    }
}
