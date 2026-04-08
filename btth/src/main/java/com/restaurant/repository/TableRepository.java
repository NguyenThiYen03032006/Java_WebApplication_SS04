package com.restaurant.repository;

import com.restaurant.model.RestaurantTable;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class TableRepository {
    private List<RestaurantTable> tables = new ArrayList<>();

    public TableRepository() {
        tables.add(new RestaurantTable(1, 4, "Trống"));
        tables.add(new RestaurantTable(2, 2, "Đang sử dụng"));
        tables.add(new RestaurantTable(3, 6, "Trống"));
        tables.add(new RestaurantTable(4, 8, "Đang sử dụng"));
    }

    public List<RestaurantTable> findAll() {
        return tables;
    }

    public List<RestaurantTable> findByCapacity(int minCapacity) {
        return tables.stream().filter(t -> t.getCapacity() >= minCapacity).collect(Collectors.toList());
    }

    public RestaurantTable findById(int id) {
        return tables.stream().filter(t -> t.getId() == id).findFirst().orElse(null);
    }

    public void updateStatus(int id, String status) {
        RestaurantTable table = findById(id);
        if (table != null) {
            table.setStatus(status);
        }
    }

    public void delete(int id) {
        tables.removeIf(t -> t.getId() == id);
    }
}
