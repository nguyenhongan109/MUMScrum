package edu.mum.se.mumscrum.repository;

import edu.mum.se.mumscrum.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Min Gaung on 11/11/2016.
 */
@Repository("employeeRepository")
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    Employee findByEmail(String email);
    Employee findByEid(int eid);
    @Transactional
    Long deleteByEid(int eid);
    List<Employee> findByRole(String role);
}
