package com.krokotiles.krokompany.service;

import com.krokotiles.krokompany.model.EmployeeModel;
import com.krokotiles.krokompany.repository.EmployeeRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class EmployeeService {

    final EmployeeRepository employeeRepository; //instead of using @Autowired

   // @Transactional
    public EmployeeModel save(EmployeeModel employeeModel) {
        return employeeRepository.save(employeeModel);
    }

    public List<EmployeeModel> getEmployeeList() {
        return employeeRepository.findAll();
    }

    public List<EmployeeModel> findEmployeesByName(String name) {
        return employeeRepository.findByName(name);
    }

    public List<EmployeeModel> findEmployeesByRole(String role) {
        return employeeRepository.findByRole(role);
    }

    public List<EmployeeModel> findEmployeesByNameAndRole(String name, String role) {
        return employeeRepository.findByNameAndRole(name, role);
    }

    public Long getEmployeeCount() {
        return employeeRepository.count();
    }

    public Long getEmployeeCountByName(String name) {
        return employeeRepository.countByName(name);
    }

    public Long getEmployeeCountByRole(String role) {
        return employeeRepository.countByRole(role);
    }

    public Long getEmployeeCountByNameAndRole(String name, String role) {
        return employeeRepository.countByNameAndRole(name, role);
    }

    public EmployeeModel findById(Long id) {
        Optional<EmployeeModel> employeeOptional = employeeRepository.findById(id);
        return employeeOptional.orElse(null);
    }

    public void delete(Long id) {
        employeeRepository.deleteById(id);
    }

    public boolean existsById(Long id) {
        return employeeRepository.existsById(id);
    }
}
