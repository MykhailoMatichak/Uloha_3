package sk.ukf.demo.service;

import org.springframework.stereotype.Service;
import sk.ukf.demo.model.Employee;
import sk.ukf.demo.repository.EmployeeRepository;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {
    private final EmployeeRepository repository;

    public EmployeeService(EmployeeRepository repository) {
        this.repository = repository;
    }

    public List<Employee> getAll() {
        return repository.findAll();
    }

    public Optional<Employee> getById(Long id) {
        return repository.findById(id);
    }

    public Employee create(Employee employee) {
        return repository.save(employee);
    }

    public Employee update(Long id, Employee updatedEmployee) {
        return repository.findById(id)
                .map(employee -> {
                    employee.setFirstName(updatedEmployee.getFirstName());
                    employee.setLastName(updatedEmployee.getLastName());
                    employee.setEmail(updatedEmployee.getEmail());
                    employee.setPhone(updatedEmployee.getPhone());
                    employee.setJobTitle(updatedEmployee.getJobTitle());
                    employee.setSalary(updatedEmployee.getSalary());
                    employee.setBirthDate(updatedEmployee.getBirthDate());
                    employee.setFullTime(updatedEmployee.isFullTime());
                    return repository.save(employee);
                })
                .orElseThrow(() -> new RuntimeException("Employee not found"));
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }
}
