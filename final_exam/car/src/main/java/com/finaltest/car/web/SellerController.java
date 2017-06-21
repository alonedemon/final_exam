package com.finaltest.car.web;

import com.finaltest.car.domain.Seller;
import com.finaltest.car.service.SellerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by Alone Demon on 18/06/2017.
 */
@RestController
@RequestMapping(value = "/sellers")
public class SellerController {

    @Autowired
    private SellerService sellerService;

    @RequestMapping(method = RequestMethod.GET)
    public List<Seller> getAllSellers(){
        return sellerService.getAllSellers();
    }

    @RequestMapping(method = RequestMethod.POST)
    public void addSeller(@RequestBody SellerRequestDTO seller){
        sellerService.addSeller(seller);
    }

    @RequestMapping(value ="{id}" ,method = RequestMethod.PUT)
    public void updateSeller(@RequestBody SellerRequestDTO seller,@PathVariable long id){
        sellerService.update(seller,id);
    }

    @RequestMapping(value ="{id}" ,method = RequestMethod.DELETE)
    public void deleteSeller(@PathVariable long id){
        sellerService.delete(id);
    }

    public static class SellerRequestDTO{
        private int age;
        private String firstname;
        private String lastname;
        private int ci;

        public int getAge() {
            return age;
        }

        public String getFirstname() {
            return firstname;
        }

        public String getLastname() {
            return lastname;
        }

        public int getCi() {
            return ci;
        }
    }
}
