package com.finaltest.car.web;

import com.finaltest.car.domain.Car;
import com.finaltest.car.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by Alone Demon on 18/06/2017.
 */
@RestController
@RequestMapping(value = "/cars")
public class CarController {
    @Autowired
    private CarService carService;

    @RequestMapping(method = RequestMethod.GET)
    public List<Car> getAllCars(){
        return carService.getAllCars();
    }

    @RequestMapping(method = RequestMethod.POST)
    public void addCar(@RequestBody CarRequestDTO car){
        carService.addCar(car);
    }

    @RequestMapping(value ="{id}" ,method = RequestMethod.PUT)
    public void updateCar(@RequestBody CarRequestDTO car,@PathVariable long id){
        carService.update(car,id);
    }

    @RequestMapping(value ="{id}" ,method = RequestMethod.DELETE)
    public void deleteCar(@PathVariable long id){
        carService.delete(id);
    }

    public static class CarRequestDTO{
        private String model;
        private String year;
        private String brand;
        private String color;
        private String image;

        public String getModel() {
            return model;
        }

        public String getYear() {
            return year;
        }

        public String getBrand() {
            return brand;
        }

        public String getColor() {
            return color;
        }

        public String getImage() {
            return image;
        }
    }
}
