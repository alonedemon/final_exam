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
    public void updateSeller(@RequestBody SellerRequestDTOUpdate seller,@PathVariable long id){
        sellerService.update(seller,id);
    }

    @RequestMapping(value ="{id}" ,method = RequestMethod.DELETE)
    public void deleteSeller(@PathVariable long id){
        sellerService.delete(id);
    }

    public static class SellerRequestDTOUpdate{
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
    public static class SellerRequestDTO extends SellerRequestDTOUpdate{
        private int solds_cars;

        public int getSolds_cars() {
            return solds_cars;
        }

    }
}
