package com.example.demo.controller;

import com.example.demo.models.Buyer;
import com.example.demo.models.TemporaryModelStorage;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/buyer")
public class BuyerController {

  @Autowired
  private TemporaryModelStorage temporaryModelStorage;

  @GetMapping("/new")
  public String getBuyerForm(@ModelAttribute("buyer") Buyer buyer) {
    return "/buyer/buyer";
  }

  @PostMapping
  public String createBuyer(@ModelAttribute("buyer") @Valid Buyer buyer,
      BindingResult bindingResult) {
    if (bindingResult.hasErrors()) {
      return "/buyer/buyer";
    }
    temporaryModelStorage.setBuyer(buyer);
    return "redirect:/seller/choiceSeller";

  }
}