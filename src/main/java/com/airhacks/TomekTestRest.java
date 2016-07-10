package com.airhacks;

import javax.annotation.Resource;
import javax.jms.*;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

@Path("/xxx/{arg}")
public class TomekTestRest {

    @Resource(mappedName="java:/ConnectionFactory")
    private ConnectionFactory connectionFactory;

    @Resource(mappedName="queue/test-queue")
    private static Queue queue;



    @GET
    public String xxx(@PathParam("arg") String arg) throws Exception{

        Connection connection = connectionFactory.createConnection();
        Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
        MessageProducer messageProducer = session.createProducer(queue);

        TextMessage message = session.createTextMessage();


            message.setText("This is message " + arg);
            System.out.println("Sending message: " + message.getText());
            messageProducer.send(message);
            connection.close();


        return "hejjjkkkkkka";
    }

}
