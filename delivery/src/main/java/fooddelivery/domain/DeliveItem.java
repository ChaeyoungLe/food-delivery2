package fooddelivery.domain;

import fooddelivery.domain.EndDeliverly;
import fooddelivery.domain.StartDeliverly;
import fooddelivery.DeliveryApplication;
import javax.persistence.*;
import java.util.List;
import lombok.Data;
import java.util.Date;

@Entity
@Table(name="DeliveItem_table")
@Data

public class DeliveItem  {

    
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    
    
    
    
    
    private Long id;
    
    
    
    
    
    private String orderId;
    
    
    
    
    
    private String address;

    @PostPersist
    public void onPostPersist(){


        EndDeliverly endDeliverly = new EndDeliverly(this);
        endDeliverly.publishAfterCommit();

    }
    @PrePersist
    public void onPrePersist(){


        StartDeliverly startDeliverly = new StartDeliverly(this);
        startDeliverly.publishAfterCommit();

    }

    public static DeliveItemRepository repository(){
        DeliveItemRepository deliveItemRepository = DeliveryApplication.applicationContext.getBean(DeliveItemRepository.class);
        return deliveItemRepository;
    }






}
