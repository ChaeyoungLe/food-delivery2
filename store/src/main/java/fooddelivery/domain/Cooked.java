package fooddelivery.domain;

import fooddelivery.domain.*;
import fooddelivery.infra.AbstractEvent;
import java.util.*;
import lombok.*;

@Data
@ToString
public class Cooked extends AbstractEvent {

    private Long id;
    private String foodId;
    private String options;
    private String customerId;
    private String orderId;
    private String address;
    private String status;

    public Cooked(Order aggregate){
        super(aggregate);
    }
    public Cooked(){
        super();
    }
}
