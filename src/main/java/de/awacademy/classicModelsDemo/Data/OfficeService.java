package de.awacademy.classicModelsDemo.Data;

import de.awacademy.classicModelsDemo.Models.Employee;
import de.awacademy.classicModelsDemo.Models.Office;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class OfficeService {

    @Autowired
    OfficeRepository repository;

    public List<Office> getAllOffices() {
        List<Office> officeList = repository.findAll();

        if(officeList.size() > 0) {
            return officeList;
        } else {
            return new ArrayList<>();
        }
    }

    public Office getOfficeById(String officeCode) throws RuntimeException {
        Optional<Office> office = repository.findById(officeCode);

        if(office.isPresent()) {
            return office.get();
        } else {
            throw new RuntimeException();
        }
    }

    // TODO More convenience methods for INSERT, UPDATE and DELETE
}
