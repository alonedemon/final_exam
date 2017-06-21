package com.finaltest.car.service;

import com.finaltest.car.domain.RegistryCarSold;
import com.finaltest.car.domain.Seller;
import com.finaltest.car.repository.BuyerRepository;
import com.finaltest.car.repository.CarRepository;
import com.finaltest.car.repository.RegistryCarSoldRepository;
import com.finaltest.car.repository.SellerRepository;
import com.finaltest.car.web.RegistryCarSoldController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Alone Demon on 18/06/2017.
 */
@Service
public class RegistryCarSoldService {
    @Autowired
    private RegistryCarSoldRepository registryCarSoldRepository;

    @Autowired
    private SellerRepository sellerRepository;

    @Autowired
    private BuyerRepository buyerRepository;

    @Autowired
    private CarRepository carRepository;

    public List<RegistryCarSold> getAllRegistryCarSold(){
        return registryCarSoldRepository.findAll();
    }

    public void addRegistryCarSold(RegistryCarSoldController.RegistryCarSoldRequestDTO registryCarSold){
        Seller seller=sellerRepository.findOne(registryCarSold.getIdSeller());
        seller.setSolds_cars(seller.getSolds_cars()+1);
        sellerRepository.save(seller);
        RegistryCarSold registryCarSold1=new RegistryCarSold();
        registryCarSold1.setBuyer(buyerRepository.findOne(registryCarSold.getIdBuyer()));
        registryCarSold1.setCar(carRepository.findOne(registryCarSold.getIdCar()));
        registryCarSold1.setSeller(seller);
        registryCarSold1.setSell_date(registryCarSold.getSell_date());
        registryCarSoldRepository.save(registryCarSold1);
    }

    public void update(RegistryCarSoldController.RegistryCarSoldRequestDTO registryCarSold,long id){
        RegistryCarSold registryCarSold1=registryCarSoldRepository.findOne(id);
        Seller before=registryCarSold1.getSeller();
        registryCarSold1.setBuyer(buyerRepository.findOne(registryCarSold.getIdBuyer()));
        registryCarSold1.setCar(carRepository.findOne(registryCarSold.getIdCar()));
        registryCarSold1.setSeller(sellerRepository.findOne(registryCarSold.getIdSeller()));
        registryCarSold1.setSell_date(registryCarSold.getSell_date());
        Seller update=registryCarSold1.getSeller();
        update.setSolds_cars(getCarsSoldBySeller(update.getId()).getSolds_cars());
        registryCarSoldRepository.save(registryCarSold1);
        updateSeller(before);
        updateSeller(update);
    }

    public void delete(long id){
        RegistryCarSold registryCarSold=registryCarSoldRepository.findOne(id);
        registryCarSoldRepository.delete(id);
        updateSeller(registryCarSold.getSeller());
    }

    private void updateSeller(Seller seller){
        seller.setSolds_cars(getCarsSoldBySeller(seller.getId()).getSolds_cars());
        sellerRepository.save(seller);
    }

    public Seller getCarsSoldBySeller(long id){
        Seller seller=sellerRepository.findOne(id);
        seller.setSolds_cars(registryCarSoldRepository.getCarSoldBySeller(id));
        return seller;
    }
}
