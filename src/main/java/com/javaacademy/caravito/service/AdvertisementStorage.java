package com.javaacademy.caravito.service;

import com.javaacademy.caravito.advertisement.Advertisement;
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

  public List<Advertisement> getAllAdvertisementByName(String name) {
    return advertisementStorage.values().stream()
        .filter(advertisement -> Objects.equals(advertisement.getName(), name))
        .toList();
  }

  public Optional<Advertisement> getAdvertisementById(Integer id) {
    return Optional.ofNullable(advertisementStorage.get(id));
  }

  public boolean deleteById(Integer id) {
    return advertisementStorage.remove(id) != null;
  }
}
