package com.finaltest.car.service;

import com.finaltest.car.domain.Seller;
import com.finaltest.car.repository.SellerRepository;
import com.finaltest.car.web.SellerController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Alone Demon on 18/06/2017.
 */
@Service
public class SellerService {
    @Autowired
    private SellerRepository sellerRepository;

    public List<Seller> getAllSellers(){
        return sellerRepository.findAll();
    }

    public void addSeller(SellerController.SellerRequestDTO seller){
        Seller seller1=new Seller();
        seller1.setCi(seller.getCi());
        seller1.setFirstname(seller.getFirstname());
        seller1.setLastname(seller.getLastname());
        seller1.setAge(seller.getAge());
        seller1.setSolds_cars(0);
        sellerRepository.save(seller1);
    }

    public void update(SellerController.SellerRequestDTOUpdate seller,long id){
        Seller seller1=sellerRepository.findOne(id);
        seller1.setCi(seller.getCi());
        seller1.setFirstname(seller.getFirstname());
        seller1.setLastname(seller.getLastname());
        seller1.setAge(seller.getAge());
        sellerRepository.save(seller1);
    }

    public void delete(long id){
        sellerRepository.delete(id);
    }
}
