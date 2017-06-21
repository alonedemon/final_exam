package com.finaltest.car.service;

import com.finaltest.car.domain.Buyer;
import com.finaltest.car.repository.BuyerRepository;
import com.finaltest.car.web.BuyerController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Alone Demon on 18/06/2017.
 */
@Service
public class BuyerService {
    @Autowired
    private BuyerRepository buyerRepository;

    public List<Buyer> getAllBuyers(){
        return buyerRepository.findAll();
    }
    public void addBuyer(BuyerController.BuyerRequestDTO newBuyer){
        Buyer buyer=new Buyer();
        buyer.setCelular(newBuyer.getCelular());
        buyer.setProffession(newBuyer.getProffession());
        buyer.setCi(newBuyer.getCi());
        buyer.setFirstname(newBuyer.getFirstname());
        buyer.setLastname(newBuyer.getLastname());
        System.out.println(newBuyer.getLastname()+"*********************");
        buyerRepository.save(buyer);
    }
    public void update(BuyerController.BuyerRequestDTO buyer,long id){
        Buyer buyer1=buyerRepository.findOne(id);
        buyer1.setProffession(buyer.getProffession());
        buyer1.setLastname(buyer.getLastname());
        buyer1.setCelular(buyer.getCelular());
        buyer1.setFirstname(buyer.getFirstname());
        buyer1.setCi(buyer.getCi());
        buyerRepository.save(buyer1);
    }
    public void delete(long id){
        buyerRepository.delete(id);
    }
}
