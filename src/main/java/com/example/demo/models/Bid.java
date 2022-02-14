package com.example.demo.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import lombok.Data;


@Entity
@Data
@Table(name = "BID")
public class Bid {


  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name = "id", nullable = false)
  private Long id;

  @Column(name = "credit_amount", nullable = false)
  @Pattern(regexp = "[0-9]{5,9}")
  @Size(max = 9)
  private Long creditAmount;

  @Column(name = "initial_fee", nullable = false)
  @Pattern(regexp = "[0-9]{1,9}")
  @Size(max = 9)
  private Long initialFee;

  @Column(name = "address", nullable = false)
  @Max(value = 100, message = "Колличество символов не должно превышать 100.")
  private String address;

  @ManyToOne
  @JoinColumn(name = "buyer_id")
  private Buyer buyer;

  @ManyToOne
  @JoinColumn(name = "seller_id")
  private Seller seller;

}