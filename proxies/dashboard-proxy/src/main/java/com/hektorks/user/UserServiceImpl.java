/*
 * Copyright (c) 2019 Konrad Szymański. All rights reserved.
 *
 */

package com.hektorks.user;

import com.hektorks.user.dto.UserAuthenticationRequest;
import com.hektorks.user.dto.UserAuthenticationResponse;
import com.hektorks.user.dto.mappers.UserAuthenticationResponseMapper;
import com.hektorks.user.exceptions.UserServiceException;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.util.Optional;

import javax.naming.ServiceUnavailableException;

@Slf4j
@AllArgsConstructor
public class UserServiceImpl implements UserService {
  private final DiscoveryClient discoveryClient;
  private final RestTemplate restTemplate;

  private final static String USER_SERVICE = "user-service";

  private Optional<URI> serviceUrl() {
    return discoveryClient.getInstances(USER_SERVICE)
        .stream()
        .map(ServiceInstance::getUri)
        .findFirst();
  }

  @Override
  public UserAuthenticationResponse userAuthentication(UserAuthenticationRequest signInRequest) {
    try {
      URI serviceURI = serviceUrl()
          .map(service -> service.resolve("/v1/user/authentication"))
          .orElseThrow(ServiceUnavailableException::new);
      ResponseEntity<String> responseEntity = restTemplate.postForEntity(serviceURI, signInRequest, String.class);
      return UserAuthenticationResponseMapper.fromJson(responseEntity.getBody());
    } catch (ServiceUnavailableException exception) {
      log.warn("Communication with user service failed.", exception);
      throw new UserServiceException(exception);
    }
  }
}
