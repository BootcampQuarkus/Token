package com.quarkus.bootcamp.nttdata.domain;

import com.quarkus.bootcamp.nttdata.infraestructure.Value;
import io.quarkus.redis.datasource.ReactiveRedisDataSource;
import io.quarkus.redis.datasource.RedisDataSource;
import io.quarkus.redis.datasource.keys.ReactiveKeyCommands;
import io.quarkus.redis.datasource.value.ValueCommands;
import io.smallrye.mutiny.Uni;
import jakarta.enterprise.context.ApplicationScoped;

import java.util.List;
@ApplicationScoped
public class TokenService {
  private ReactiveKeyCommands<String> keyCommands;
  private ValueCommands<String, Value> countCommands;

  public TokenService(RedisDataSource ds, ReactiveRedisDataSource reactive) {
    countCommands = ds.value(Value.class);
    keyCommands = reactive.key();

  }

  public Value get(String key) {
    Value value = countCommands.get(key);
    if (value == null) {
      return new Value();
    }
    return value;
  }

  public void set(String key, Value value) {
    countCommands.set(key, value);
  }

  public void update(String key, Value value) {
    countCommands.set(key, value);
  }

  public Uni<Void> del(String key) {
    return keyCommands.del(key)
          .replaceWithVoid();
  }

  public Uni<List<String>> keys() {
    return keyCommands.keys("*");
  }
}
