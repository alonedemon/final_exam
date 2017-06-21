package com.finaltest.car.service;

import com.finaltest.car.domain.Car;
import com.finaltest.car.repository.CarRepository;
import com.finaltest.car.web.CarController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Alone Demon on 18/06/2017.
 */
@Service
public class CarService {
    @Autowired
    private CarRepository carRepository;

    public List<Car> getAllCars(){
        return carRepository.findAll();
    }

    public void addCar(CarController.CarRequestDTO newCar){
        Car car=new Car();
        car.setBrand(newCar.getBrand());
        car.setColor(newCar.getColor());
        car.setImage(newCar.getImage());
        car.setModel(newCar.getModel());
        car.setYear(newCar.getYear());
        carRepository.save(car);
    }
    public void update(CarController.CarRequestDTO car,long id){
        Car car1=carRepository.findOne(id);
        car1.setBrand(car.getBrand());
        car1.setColor(car.getColor());
        car1.setImage(car.getImage());
        car1.setModel(car.getModel());
        car1.setYear(car.getYear());
        carRepository.save(car1);
    }
    public void delete(long id){
        carRepository.delete(id);
    }
}
