package edu.mum.se.mumscrum.repository;

import edu.mum.se.mumscrum.model.ProductBackLog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by tony on 11/14/16.
 */
@Repository("productBackLogRepository")
public interface ProductBackLogRepository extends JpaRepository<ProductBackLog, Long> {
    ProductBackLog findByPid(int pid);
    @Transactional
    Long deleteByPid(int pid);
}
