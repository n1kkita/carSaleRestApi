package com.CarSaleApi.app.repositories;

import com.CarSaleApi.app.entity.CarShowroom;
import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class CustomRepositoryImpl implements CustomRepository {

    private final EntityManager entityManager;
    @Override
    @Transactional
    public Optional< CarShowroom > findCarShowroomFetchCarsAndSellersById(Long id) {
        var carShowroom = entityManager.createQuery(
                "select chr from CarShowroom chr left join fetch chr.cars where chr.id=?1", CarShowroom.class)
                .setParameter(1,id)
                .getSingleResult();

        carShowroom = entityManager.createQuery(
                "select chr from CarShowroom  chr left join fetch chr.sellers where chr.id=?1", CarShowroom.class)
                .setParameter(1,carShowroom.getId())
                .getSingleResult();

        carShowroom = entityManager.createQuery(
                        "select chr from CarShowroom  chr left join fetch chr.revenues where chr.id=?1", CarShowroom.class)
                .setParameter(1,carShowroom.getId())
                .getSingleResult();

        return Optional.of(carShowroom);
    }
}
