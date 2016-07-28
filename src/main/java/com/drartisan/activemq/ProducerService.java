package com.drartisan.activemq;

import org.springframework.stereotype.Service;

import javax.jms.*;

/**
 * Created by summer on 16/3/29.
 */
@Service
public class ProducerService {

    private ConnectionFactory defaultConnectionFactory;

    public String sendMessage(String msg, Destination defaultSendQueue,Destination defaultReplyQueue)throws JMSException{
        Connection connection = null;
        Session session = null;
        String replyMsg = null;
        Message message;

        try {
            //创建连接
            connection = defaultConnectionFactory.createConnection();
            //启用连接
            connection.start();
            //创建会话
            session = connection.createSession(false,Session.AUTO_ACKNOWLEDGE);
            //生产者
            MessageProducer producer = session.createProducer(defaultSendQueue);
            //非持久化
            producer.setDeliveryMode(DeliveryMode.NON_PERSISTENT);
            //创建消息
            message = session.createTextMessage(msg);
            //设置接受消息返回列队
            message.setJMSReplyTo(defaultReplyQueue);
            //设置关联ID
            message.setJMSCorrelationID("0001");
            //发送消息
            producer.send(message);


            //设置接受回复信息的关联ID
            MessageConsumer consumer = session.createConsumer(defaultReplyQueue,"0001");
            //等待接受返回消息
            Message back = consumer.receive(10000);
            replyMsg = ((TextMessage)back).getText();
            System.out.println(replyMsg);



        }catch (Exception e){
            e.printStackTrace();
        }finally {
            if (session != null){
                session.close();
            }
            if (connection != null){
                connection.close();
            }
        }

        return replyMsg;
    }







}
