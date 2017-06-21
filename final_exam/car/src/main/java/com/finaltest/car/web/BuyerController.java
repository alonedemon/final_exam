package com.finaltest.car.web;

import com.finaltest.car.domain.Buyer;
import com.finaltest.car.domain.Person;
import com.finaltest.car.service.BuyerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by Alone Demon on 18/06/2017.
 */
@RestController
@RequestMapping(value = "/buyers")
public class BuyerController {
    @Autowired
    private BuyerService buyerService;

    @RequestMapping(method = RequestMethod.GET)
    public List<Buyer> getAllBuyers(){
        return buyerService.getAllBuyers();
    }

    @RequestMapping(method = RequestMethod.POST)
    public void addBuyer(@RequestBody BuyerRequestDTO buyer){
        buyerService.addBuyer(buyer);
    }

    @RequestMapping(value ="{id}" ,method = RequestMethod.PUT)
    public void updateBuyer(@RequestBody BuyerRequestDTO buyer,@PathVariable long id){
        buyerService.update(buyer,id);
    }

    @RequestMapping(value ="{id}" ,method = RequestMethod.DELETE)
    public void deleteBuyer(@PathVariable long id){
        buyerService.delete(id);
    }

    public static class BuyerRequestDTO extends Person{
        private String proffession;
        private int celular;

        public String getProffession() {
            return proffession;
        }

        public int getCelular() {
            return celular;
        }
    }
}
