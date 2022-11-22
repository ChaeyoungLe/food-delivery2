package fooddelivery.domain;

import fooddelivery.domain.*;
import fooddelivery.infra.AbstractEvent;
import java.util.*;
import lombok.*;

@Data
@ToString
public class StartDeliverly extends AbstractEvent {

    private Long id;
    private String orderId;
    private String address;

    public StartDeliverly(DeliveItem aggregate){
        super(aggregate);
    }
    public StartDeliverly(){
        super();
    }
}
