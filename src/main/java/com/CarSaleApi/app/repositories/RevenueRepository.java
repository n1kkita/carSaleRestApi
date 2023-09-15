package com.CarSaleApi.app.repositories;

import com.CarSaleApi.app.entity.Revenue;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;
import java.util.Optional;
@Repository
public interface RevenueRepository extends JpaRepository< Revenue,Long > {
    Optional<Revenue> findByRevenueDate(Date date);

    @Query("select r from Revenue r where r.revenueDate between ?1 and ?2")
    List<Revenue> findByWeek(Date date1, Date date2);
    @Query("select r from Revenue r " +
            "where EXTRACT(month from r.revenueDate) = CAST(?1 as INTEGER) and" +
            " EXTRACT(year from r.revenueDate) = CAST(?2 as INTEGER)")
    List<Revenue> findByMonth(String month,String year);




}
