package com.finaltest.car.repository;

import com.finaltest.car.domain.Car;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Alone Demon on 18/06/2017.
 */
public interface CarRepository extends JpaRepository<Car,Long>{
}
