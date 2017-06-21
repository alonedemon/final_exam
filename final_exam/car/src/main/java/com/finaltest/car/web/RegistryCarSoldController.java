package com.finaltest.car.web;

import com.finaltest.car.domain.Buyer;
import com.finaltest.car.domain.Car;
import com.finaltest.car.domain.RegistryCarSold;
import com.finaltest.car.domain.Seller;
import com.finaltest.car.service.RegistryCarSoldService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.persistence.ManyToOne;
import java.util.Date;
import java.util.List;

/**
 * Created by Alone Demon on 18/06/2017.
 */
@RestController
@RequestMapping(value = "/registries")
public class RegistryCarSoldController {

    @Autowired
    private RegistryCarSoldService registryCarSoldService;

    @RequestMapping(method = RequestMethod.GET)
    public List<RegistryCarSold> getAllRegistryCarSolds(){
        return  registryCarSoldService.getAllRegistryCarSold();
    }

    @RequestMapping(method = RequestMethod.POST)
    public void addRegistryCarSold(@RequestBody RegistryCarSoldRequestDTO registryCarSold){
        registryCarSoldService.addRegistryCarSold(registryCarSold);
    }

    @RequestMapping(value ="{id}" ,method = RequestMethod.PUT)
    public void updateRegistryCarSold(@RequestBody RegistryCarSoldRequestDTO registryCarSold,@PathVariable long id){
        registryCarSoldService.update(registryCarSold,id);
    }

    @RequestMapping(value ="{id}" ,method = RequestMethod.DELETE)
    public void deleteRegistryCarSold(@PathVariable long id){
        registryCarSoldService.delete(id);
    }

    @RequestMapping(value = "canCarsSoldBySeller/{id}",method = RequestMethod.GET)
    public Seller canCarsSoldBySeller(@PathVariable long id){
        return registryCarSoldService.getCarsSoldBySeller(id);
    }

    public static class RegistryCarSoldRequestDTO{
        private Date sell_date;
        private long idSeller;
        private long idBuyer;
        private long idCar;

        public Date getSell_date() {
            return sell_date;
        }

        public long getIdSeller() {
            return idSeller;
        }

        public long getIdBuyer() {
            return idBuyer;
        }

        public long getIdCar() {
            return idCar;
        }
    }
}
