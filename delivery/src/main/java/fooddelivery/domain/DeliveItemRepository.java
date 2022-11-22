package fooddelivery.domain;

import fooddelivery.domain.*;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel="deliveItems", path="deliveItems")
public interface DeliveItemRepository extends PagingAndSortingRepository<DeliveItem, Long>{

}
