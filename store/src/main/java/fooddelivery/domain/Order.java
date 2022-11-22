package fooddelivery.domain;

import fooddelivery.domain.CouponPublished;
import fooddelivery.domain.Accepted;
import fooddelivery.domain.Cooked;
import fooddelivery.domain.Rejected;
import fooddelivery.StoreApplication;
import javax.persistence.*;
import java.util.List;
import lombok.Data;
import java.util.Date;

@Entity
@Table(name="Order_table")
@Data

public class Order  {

    
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    
    
    
    
    
    private Long id;
    
    
    
    
    
    private String foodId;
    
    
    
    
    
    private String options;
    
    
    
    
    
    private String customerId;
    
    
    
    
    
    private String orderId;
    
    
    
    
    
    private String address;
    
    
    
    
    
    private String status;
    
    
    
    
    
    private String count;

    @PostPersist
    public void onPostPersist(){


        CouponPublished couponPublished = new CouponPublished(this);
        couponPublished.publishAfterCommit();

    }
    @PrePersist
    public void onPrePersist(){


        Accepted accepted = new Accepted(this);
        accepted.publishAfterCommit();



        Cooked cooked = new Cooked(this);
        cooked.publishAfterCommit();



        Rejected rejected = new Rejected(this);
        rejected.publishAfterCommit();

    }

    public static OrderRepository repository(){
        OrderRepository orderRepository = StoreApplication.applicationContext.getBean(OrderRepository.class);
        return orderRepository;
    }




    public static void updateOrderList(Rejected rejected){

        /** Example 1:  new item 
        Order order = new Order();
        repository().save(order);

        */

        /** Example 2:  finding and process
        
        repository().findById(rejected.get???()).ifPresent(order->{
            
            order // do something
            repository().save(order);


         });
        */

        
    }
    public static void updateOrderList(Paid paid){

        /** Example 1:  new item 
        Order order = new Order();
        repository().save(order);

        */

        /** Example 2:  finding and process
        
        repository().findById(paid.get???()).ifPresent(order->{
            
            order // do something
            repository().save(order);


         });
        */

        
    }


}
