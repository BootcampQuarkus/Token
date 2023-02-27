package com.quarkus.bootcamp.nttdata.infraestructure;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Association {
  protected String key;
  protected Value value;
}
