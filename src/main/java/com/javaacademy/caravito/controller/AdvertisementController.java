package com.javaacademy.caravito.controller;

import com.javaacademy.caravito.advertisement.Advertisement;
import com.javaacademy.caravito.service.AdvertisementStorage;
import java.math.BigDecimal;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/advertisement")
public class AdvertisementController {

  private final AdvertisementStorage advertisementStorage;

  @PostMapping
  public void saveAdvertisement(@RequestBody Advertisement advertisement) {
    advertisementStorage.save(advertisement);
  }

  @GetMapping
  public List<Advertisement> getAllAdvertisement() {
    return advertisementStorage.getAllAdvertisement();
  }

  @GetMapping("/{id}")
  public Advertisement getAdvertisementById(@PathVariable Integer id) {
    return advertisementStorage.getAdvertisementById(id).orElseThrow();
  }

  @GetMapping("/search")
  public List<Advertisement> getAdvertisementByMultipleParameter(
      @RequestParam(required = false) String name,
      @RequestParam(required = false) String color,
      @RequestParam(required = false) BigDecimal price) {
    return advertisementStorage.getAdvertisementByMultipleParameter(name, color, price);
  }

  @DeleteMapping("/{id}")
  public boolean deleteAdvertisementById(@PathVariable Integer id) {
    return advertisementStorage.deleteById(id);
  }
}
