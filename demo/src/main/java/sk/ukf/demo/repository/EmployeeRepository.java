package sk.ukf.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sk.ukf.demo.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    void deleteById(Long id);
}
