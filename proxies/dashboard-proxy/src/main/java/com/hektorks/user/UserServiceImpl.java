/*
 * Copyright (c) 2019 Konrad Szymański. All rights reserved.
 *
 */

package com.hektorks.user;

import com.hektorks.dashboard.common.AuthenticationCredentials;
import com.hektorks.user.dto.GetUserByIdResponse;
import com.hektorks.user.dto.UserAuthenticationResponse;
import com.hektorks.user.dto.mappers.GetUserResponseMapper;
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
class UserServiceImpl implements UserService {
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
  public UserAuthenticationResponse userAuthentication(AuthenticationCredentials authenticationCredentials) {
    try {
      URI serviceURI = serviceUrl()
          .map(service -> service.resolve("/v1/user/authentication"))
          .orElseThrow(ServiceUnavailableException::new);
      ResponseEntity<String> responseEntity = restTemplate.postForEntity(serviceURI, authenticationCredentials, String.class);
      return UserAuthenticationResponseMapper.fromJson(responseEntity.getBody());
    } catch (ServiceUnavailableException exception) {
      log.warn("Communication with user service failed.", exception);
      throw new UserServiceException(exception);
    }
  }

  @Override
  public GetUserByIdResponse getUserById(Integer userId) {
    try {
      String path = "/v1/user/" + userId.toString();
      URI serviceURI = serviceUrl()
          .map(service -> service.resolve(path))
          .orElseThrow(ServiceUnavailableException::new);
      ResponseEntity<String> responseEntity = restTemplate.getForEntity(serviceURI, String.class);
      return GetUserResponseMapper.fromJson(responseEntity.getBody());
    } catch (ServiceUnavailableException exception) {
      log.warn("Communication with user service failed.", exception);
      throw new UserServiceException(exception);
    }
  }


}
