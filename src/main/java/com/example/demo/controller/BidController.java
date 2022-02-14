package com.example.demo.controller;

import com.example.demo.models.Bid;
import com.example.demo.services.ConservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/bid")
public class BidController {

  @Autowired
  private ConservationService conservationService;

  @GetMapping("/new")
  public String bid(@ModelAttribute("bid") Bid bid) {
    return "/bid/bid";
  }

  @PostMapping
  public String createBid(@ModelAttribute("bid") Bid bid) {
    conservationService.getTemporaryModelStorage().setBid(bid);
    conservationService.bidInstConnections();
    conservationService.bidConservation();
    return "redirect:/successfully";
  }
}
