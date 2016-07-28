package com.drartisan.activemq;

import javax.jms.JMSException;

/**
 * Created by summer on 16/3/30.
 */
public class Test {


    public static void main(String[] args){
        ProducerService ps = new ProducerService();
        try {
            ps.sendMessage("aaa",null,null);
        }catch (JMSException e){
            e.printStackTrace();
        }

    }
}
