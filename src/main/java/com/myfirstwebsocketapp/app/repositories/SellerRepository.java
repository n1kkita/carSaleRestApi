package com.myfirstwebsocketapp.app.repositories;

import com.myfirstwebsocketapp.app.entity.Seller;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SellerRepository extends JpaRepository< Seller,Long > {

}
