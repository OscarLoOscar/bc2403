package com.bootcamp.bc_forum.infra.util;

import org.springframework.util.MultiValueMap;
import org.springframework.web.util.UriComponentsBuilder;

public class ApiUtil {

  public static String uriBuilder(UriScheme scheme, String domain, String endpoint) {
    return UriComponentsBuilder.newInstance()
        .scheme(scheme.getProtocol())
        .host(domain)
        .path(endpoint)
        .toUriString();
  }
  public static String uriBuilder(UriScheme uriScheme,
      String domain, String path, String endpoint,
      MultiValueMap<String, String> queryParams, String... pathSegments) {
    return UriComponentsBuilder.newInstance()//
        .scheme(uriScheme.getProtocol())//
        .host(domain)//
        .pathSegment(pathSegments)//
        .path(path)//
        .path(endpoint)//
        .queryParams(queryParams)//
        .build(false)//
        .toUriString();
  }
}
