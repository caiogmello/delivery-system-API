package com.caiogmello.deliveryAPI.domain.service;

import com.caiogmello.deliveryAPI.Customer;
import com.caiogmello.deliveryAPI.domain.exception.EnterpriseException;
import com.caiogmello.deliveryAPI.domain.repository.CustomerRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class CustomerCRUDService {

    private CustomerRepository customerRepository;

    @Transactional
    public Customer save(Customer customer) {
        boolean emailInUsage = customerRepository.findByEmail(customer.getEmail())
                .stream()
                .anyMatch(customer1 -> !customer1.equals(customer));

        if(emailInUsage) {
            throw new EnterpriseException("Already exists an customer registered with that e-mail.");
        }

        return customerRepository.save(customer);
    }

    @Transactional
    public void delete(Long customerId) {
        customerRepository.deleteById(customerId);
    }
}
