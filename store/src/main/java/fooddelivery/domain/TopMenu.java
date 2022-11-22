package fooddelivery.domain;

import javax.persistence.*;
import java.util.List;
import java.util.Date;
import lombok.Data;

@Entity
@Table(name="TopMenu_table")
@Data
public class TopMenu {

        @Id
        //@GeneratedValue(strategy=GenerationType.AUTO)
        private Long id;
        private String foodId;
        private String foodNm;


}