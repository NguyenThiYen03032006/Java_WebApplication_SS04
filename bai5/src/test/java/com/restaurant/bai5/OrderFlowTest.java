package com.restaurant.bai5;

import com.restaurant.bai5.controller.OrderController;
import com.restaurant.bai5.repository.OrderRepository;
import com.restaurant.bai5.service.OrderService;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class OrderFlowTest {

    @Test
    void shouldHandleValidAndInvalidOrderId() {
        OrderController controller = new OrderController(new OrderService(new OrderRepository()));

        assertEquals("Hien thi don hang so: 5", controller.viewOrder("5"));
        assertEquals(
                "LOI: ID don hang phai la mot so hop le! Ban dang nhap chu 't' roi.",
                controller.viewOrder("t")
        );
    }

    @Test
    void shouldCreateAndDeleteOrder() {
        OrderController controller = new OrderController(new OrderService(new OrderRepository()));

        assertEquals("Da tao 1 don hang moi thanh cong!", controller.createOrder());
        assertEquals("Da huy don hang so: 7", controller.deleteOrder(7L));
    }
}

