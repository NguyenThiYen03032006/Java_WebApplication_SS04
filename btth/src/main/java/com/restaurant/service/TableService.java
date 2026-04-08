package com.restaurant.service;

import com.restaurant.model.RestaurantTable;
import com.restaurant.repository.TableRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TableService {
    @Autowired
    private TableRepository tableRepository;

    public List<RestaurantTable> getAllTables() {
        return tableRepository.findAll();
    }

    public List<RestaurantTable> getTablesByCapacity(int capacity) {
        return tableRepository.findByCapacity(capacity);
    }

    public RestaurantTable getTableById(int id) {
        return tableRepository.findById(id);
    }

    public void updateStatus(int id, String status) {
        tableRepository.updateStatus(id, status);
    }

    public boolean deleteTable(int id) {
        RestaurantTable table = tableRepository.findById(id);
        if (table != null && "Trống".equals(table.getStatus())) {
            tableRepository.delete(id);
            return true;
        }
        return false;
    }
}
