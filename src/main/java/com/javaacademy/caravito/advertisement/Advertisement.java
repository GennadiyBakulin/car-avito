package com.javaacademy.caravito.advertisement;

import java.math.BigDecimal;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(of = "id")
public class Advertisement {

  private Integer id;
  private String name;
  private String color;
  private BigDecimal price;

}
