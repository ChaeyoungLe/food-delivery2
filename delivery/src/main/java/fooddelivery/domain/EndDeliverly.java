package fooddelivery.domain;

import fooddelivery.domain.*;
import fooddelivery.infra.AbstractEvent;
import java.util.*;
import lombok.*;

@Data
@ToString
public class EndDeliverly extends AbstractEvent {

    private Long id;
    private String orderId;
    private String address;

    public EndDeliverly(DeliveItem aggregate){
        super(aggregate);
    }
    public EndDeliverly(){
        super();
    }
}
