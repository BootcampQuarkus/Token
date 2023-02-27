package com.quarkus.bootcamp.nttdata.infraestructure;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Value {
  protected String createAt;
  protected String userId;
}