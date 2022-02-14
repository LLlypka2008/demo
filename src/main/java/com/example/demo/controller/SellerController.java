package com.example.demo.controller;

import com.example.demo.models.Seller;
import com.example.demo.models.TemporaryModelStorage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/seller")
public class SellerController {

  @Autowired
  private TemporaryModelStorage temporaryModelStorage;

  @GetMapping("/choiceSeller")
  public String choiceSeller() {
    return "/seller/choiceSeller";
  }

  @GetMapping("/naturalSeller/new")
  public String seller(@ModelAttribute("seller") Seller seller) {
    return "/seller/naturalSeller";
  }

  @GetMapping("/legalSeller/new")
  public String legalSeller(@ModelAttribute("seller") Seller seller) {
    return "/seller/legalSeller";
  }

  @PostMapping
  public String createSeller(@ModelAttribute("seller") Seller seller) {
    temporaryModelStorage.setSeller(seller);
    return "redirect:/bid/new";
  }
}