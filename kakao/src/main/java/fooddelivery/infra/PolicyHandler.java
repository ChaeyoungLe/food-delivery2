package fooddelivery.infra;

import javax.naming.NameParser;

import javax.naming.NameParser;
import javax.transaction.Transactional;

import fooddelivery.config.kafka.KafkaProcessor;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;
import fooddelivery.domain.*;


@Service
@Transactional
public class PolicyHandler{
    @Autowired NotificationLogRepository notificationLogRepository;
    
    @StreamListener(KafkaProcessor.INPUT)
    public void whatever(@Payload String eventString){}

    @StreamListener(value=KafkaProcessor.INPUT, condition="headers['type']=='Rejected'")
    public void wheneverRejected_AlertMessage(@Payload Rejected rejected){

        Rejected event = rejected;
        System.out.println("\n\n##### listener AlertMessage : " + rejected + "\n\n");


        

        // Sample Logic //
        NotificationLog.alertMessage(event);
        

        

    }
    @StreamListener(value=KafkaProcessor.INPUT, condition="headers['type']=='Accepted'")
    public void wheneverAccepted_AlertMessage(@Payload Accepted accepted){

        Accepted event = accepted;
        System.out.println("\n\n##### listener AlertMessage : " + accepted + "\n\n");


        

        // Sample Logic //
        NotificationLog.alertMessage(event);
        

        

    }
    @StreamListener(value=KafkaProcessor.INPUT, condition="headers['type']=='Cooked'")
    public void wheneverCooked_AlertMessage(@Payload Cooked cooked){

        Cooked event = cooked;
        System.out.println("\n\n##### listener AlertMessage : " + cooked + "\n\n");


        

        // Sample Logic //
        NotificationLog.alertMessage(event);
        

        

    }
    @StreamListener(value=KafkaProcessor.INPUT, condition="headers['type']=='StartDeliverly'")
    public void wheneverStartDeliverly_AlertMessage(@Payload StartDeliverly startDeliverly){

        StartDeliverly event = startDeliverly;
        System.out.println("\n\n##### listener AlertMessage : " + startDeliverly + "\n\n");


        

        // Sample Logic //
        NotificationLog.alertMessage(event);
        

        

    }
    @StreamListener(value=KafkaProcessor.INPUT, condition="headers['type']=='EndDeliverly'")
    public void wheneverEndDeliverly_AlertMessage(@Payload EndDeliverly endDeliverly){

        EndDeliverly event = endDeliverly;
        System.out.println("\n\n##### listener AlertMessage : " + endDeliverly + "\n\n");


        

        // Sample Logic //
        NotificationLog.alertMessage(event);
        

        

    }
    @StreamListener(value=KafkaProcessor.INPUT, condition="headers['type']=='CouponPublished'")
    public void wheneverCouponPublished_AlertMessage(@Payload CouponPublished couponPublished){

        CouponPublished event = couponPublished;
        System.out.println("\n\n##### listener AlertMessage : " + couponPublished + "\n\n");


        

        // Sample Logic //
        NotificationLog.alertMessage(event);
        

        

    }

}


