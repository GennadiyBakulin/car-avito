package com.javaacademy.caravito.service;

import com.javaacademy.caravito.advertisement.Advertisement;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import org.springframework.stereotype.Component;

@Component
public class AdvertisementStorage {

  private final Map<Integer, Advertisement> advertisementStorage = new HashMap<>();
  private Integer count = 0;

  public void save(Advertisement advertisement) {
    advertisement.setId(++count);
    advertisementStorage.put(count, advertisement);
  }

  public List<Advertisement> getAllAdvertisement() {
    return advertisementStorage.values().stream().toList();
  }

  public Optional<Advertisement> getAdvertisementById(Integer id) {
    return Optional.ofNullable(advertisementStorage.get(id));
  }

  public boolean deleteById(Integer id) {
    return advertisementStorage.remove(id) != null;
  }

  public List<Advertisement> getAdvertisementByMultipleParameter(String name, String color,
      BigDecimal price) {

    if (Objects.isNull(name) && Objects.isNull(color) && Objects.isNull(price)) {
      return List.of();
    }

    List<Advertisement> advertisementList = advertisementStorage.values().stream().toList();

    if (Objects.nonNull(name)) {
      advertisementList = advertisementList.stream()
          .filter(advertisement -> Objects.equals(advertisement.getName(), name))
          .toList();
    }
    if (Objects.nonNull(color)) {
      advertisementList = advertisementList.stream()
          .filter(advertisement -> Objects.equals(advertisement.getColor(), color))
          .toList();
    }
    if (Objects.nonNull(price)) {
      advertisementList = advertisementList.stream()
          .filter(advertisement -> Objects.equals(advertisement.getPrice(), price))
          .toList();
    }

    return advertisementList;
  }
}
