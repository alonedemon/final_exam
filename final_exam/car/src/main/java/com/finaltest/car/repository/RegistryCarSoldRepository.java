package com.finaltest.car.repository;

import com.finaltest.car.domain.RegistryCarSold;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 * Created by Alone Demon on 18/06/2017.
 */
public interface RegistryCarSoldRepository extends JpaRepository<RegistryCarSold,Long> {
    @Query("select  count(r.seller.id) from RegistryCarSold r where r.seller.id=?1 group by r.seller.id")
    public int getCarSoldBySeller(long id);
}
