package com.bootcamp.bc_forum.config;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.web.client.RestTemplate;
import com.bootcamp.bc_forum.infra.util.ApiUtil;
import com.bootcamp.bc_forum.infra.util.UriScheme;
import com.fasterxml.jackson.databind.ObjectMapper;

@Configuration
public class AppConfig {
  @Value(value = "${api.jsonplaceholder.domain}")
  private String domain;

  @Value(value = "${api.jsonplaceholder.user.endpoint}")
  private String userEndpoint;

  @Value(value = "${api.jsonplaceholder.post.endpoint}")
  private String postEndpoint;

  @Value(value = "${api.jsonplaceholder.comment.endpoint}")
  private String commentEndpoint;


  @Bean
  public String userUrl() {
    return ApiUtil.uriBuilder(UriScheme.HTTPS, domain, userEndpoint);
  }

  @Bean
  public String postUrl() {
    return ApiUtil.uriBuilder(UriScheme.HTTPS, domain, postEndpoint);
  }

  @Bean
  public String commentUrl() {
    return ApiUtil.uriBuilder(UriScheme.HTTPS, domain, commentEndpoint);
  }


  @Bean
  ModelMapper modelMapper() {
    return new ModelMapper();
  }

  @Bean
  RestTemplate restTemplate() {
    return new RestTemplate();
  }

  @Bean
  ObjectMapper objectMapper() {
    return new ObjectMapper();
  }

  @Bean
  public RedisTemplate<String, Object> redisTemplate(
      RedisConnectionFactory factory, ObjectMapper redisObjectMapper) {
    RedisTemplate<String, Object> redisTemplate = new RedisTemplate<>();
    redisTemplate.setConnectionFactory(factory);
    redisTemplate.setKeySerializer(new StringRedisSerializer());
    redisTemplate.setValueSerializer(
        new GenericJackson2JsonRedisSerializer(redisObjectMapper));
    redisTemplate.afterPropertiesSet();
    return redisTemplate;
  }
}
