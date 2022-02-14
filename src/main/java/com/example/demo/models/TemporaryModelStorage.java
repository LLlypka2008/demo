package com.example.demo.models;

import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
public class TemporaryModelStorage {

  private Buyer buyer;

  private Seller seller;

  private Bid bid;
}
