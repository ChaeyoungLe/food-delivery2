package fooddelivery.domain;

import fooddelivery.domain.*;
import fooddelivery.infra.AbstractEvent;
import lombok.*;
import java.util.*;
@Data
@ToString
public class CouponPublished extends AbstractEvent {

    private Long id;
    private String customerId;
    private String couponId;
}


