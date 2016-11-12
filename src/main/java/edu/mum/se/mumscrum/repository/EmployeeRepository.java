package edu.mum.se.mumscrum.repository;

import edu.mum.se.mumscrum.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Min Gaung on 11/11/2016.
 */
@Repository("employeeRepository")
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    @Query("select e from Employee e")
    List<Employee> getAllEmployee();

    @Query("select e from Employee e where e.email = :email")
    Employee findByEmployeeEmail(@Param("email") String email);

    @Query("select e from Employee e where e.eid = :eid")
    Employee findByEmployeeID(@Param("eid") String eid);
}
