package com.myfirstwebsocketapp.app.repositories;

import com.myfirstwebsocketapp.app.entity.Orders;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrdersRepository extends JpaRepository< Orders ,Long> {
}
