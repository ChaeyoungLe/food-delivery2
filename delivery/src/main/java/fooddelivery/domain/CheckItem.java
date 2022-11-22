package fooddelivery.domain;

import javax.persistence.*;
import java.util.List;
import java.util.Date;
import lombok.Data;

@Entity
@Table(name="CheckItem_table")
@Data
public class CheckItem {

        @Id
        //@GeneratedValue(strategy=GenerationType.AUTO)
        private Long id;


}