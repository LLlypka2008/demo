package com.example.demo.services;

import com.example.demo.models.Bid;
import com.example.demo.models.TemporaryModelStorage;
import com.example.demo.repositoyes.BidRepository;
import com.example.demo.repositoyes.BuyerRepository;
import com.example.demo.repositoyes.SellerRepository;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Data
public class ConservationService {

  @Autowired
  private BidRepository bidRepository;

  @Autowired
  private BuyerRepository buyerRepository;

  @Autowired
  private SellerRepository sellerRepository;

  @Autowired
  private TemporaryModelStorage temporaryModelStorage;

  public void bidInstConnections(){
    Bid bid = temporaryModelStorage.getBid();
    bid.setBuyer(temporaryModelStorage.getBuyer());
    bid.setSeller(temporaryModelStorage.getSeller());
    temporaryModelStorage.setBid(bid);
  }

  public void bidConservation(){
    buyerRepository.save(temporaryModelStorage.getBuyer());
    sellerRepository.save(temporaryModelStorage.getSeller());
    bidRepository.save(temporaryModelStorage.getBid());
  }

}
