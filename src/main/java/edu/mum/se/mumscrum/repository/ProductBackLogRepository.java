package edu.mum.se.mumscrum.repository;

import edu.mum.se.mumscrum.model.ProductBackLog;
import edu.mum.se.mumscrum.model.Userstory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by Min Gaung on 11/11/2016.
 */
@Repository("productBackLogRepository")
public interface ProductBackLogRepository extends JpaRepository<ProductBackLog, Long> {

}
