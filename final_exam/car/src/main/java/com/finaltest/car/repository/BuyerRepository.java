package com.finaltest.car.repository;

import com.finaltest.car.domain.Buyer;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Alone Demon on 18/06/2017.
 */
public interface BuyerRepository extends JpaRepository<Buyer,Long> {
}
