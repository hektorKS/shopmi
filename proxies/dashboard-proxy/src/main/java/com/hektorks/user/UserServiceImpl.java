/*
 * Copyright (c) 2019 Konrad Szymański. All rights reserved.
 *
 */

package com.hektorks.user;

import com.hektorks.dashboard.signin.SignInRequest;
import com.hektorks.dashboard.signup.SignUpRequest;
import com.hektorks.dashboard.usernameavailability.UsernameAvailabilityRequest;
import com.hektorks.user.dto.CreateUserDto;
import com.hektorks.user.dto.GetUserByIdDto;
import com.hektorks.user.dto.UserAuthenticationDto;
import com.hektorks.user.dto.UsernameAvailabilityDto;
import com.hektorks.user.dto.mappers.CreateUserDtoMapper;
import com.hektorks.user.dto.mappers.GetUserDtoMapper;
import com.hektorks.user.dto.mappers.UserAuthenticationDtoMapper;
import com.hektorks.user.dto.mappers.UsernameAvailabilityDtoMapper;
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

  private static final String USER_SERVICE = "user-service";

  private Optional<URI> serviceUrl() {
    return discoveryClient.getInstances(USER_SERVICE)
        .stream()
        .map(ServiceInstance::getUri)
        .findFirst();
  }

  @Override
  public UserAuthenticationDto userAuthentication(SignInRequest signInRequest) {
    try {
      URI serviceURI = serviceUrl()
          .map(service -> service.resolve("/v1/user/authentication"))
          .orElseThrow(ServiceUnavailableException::new);
      ResponseEntity<String> responseEntity = restTemplate.postForEntity(serviceURI, signInRequest, String.class);
      return UserAuthenticationDtoMapper.fromJson(responseEntity.getBody());
    } catch (ServiceUnavailableException exception) {
      log.warn("Communication with user service failed.", exception);
      throw new UserServiceException(exception);
    }
  }

  @Override
  public UsernameAvailabilityDto checkUsernameAvailability(UsernameAvailabilityRequest usernameAvailabilityRequest) {
    try {
      URI serviceURI = serviceUrl()
          .map(service -> service.resolve("/v1/user/username/availability"))
          .orElseThrow(ServiceUnavailableException::new);
      ResponseEntity<String> responseEntity = restTemplate.postForEntity(serviceURI, usernameAvailabilityRequest, String.class);
      return UsernameAvailabilityDtoMapper.fromJson(responseEntity.getBody());
    } catch (ServiceUnavailableException exception) {
      log.warn("Communication with user service failed.", exception);
      throw new UserServiceException(exception);
    }
  }

  @Override
  public CreateUserDto createUser(SignUpRequest signUpRequest) {
    try {
      URI serviceURI = serviceUrl()
          .map(service -> service.resolve("/v1/user"))
          .orElseThrow(ServiceUnavailableException::new);
      ResponseEntity<String> responseEntity = restTemplate.postForEntity(
          serviceURI,
          signUpRequest,
          String.class
      );
      return CreateUserDtoMapper.fromJson(responseEntity.getBody());
    } catch (ServiceUnavailableException exception) {
      log.warn("Communication with user service failed.", exception);
      throw new UserServiceException(exception);
    }
  }

  @Override
  public GetUserByIdDto getUserById(Integer userId) {
    try {
      String path = "/v1/user/" + userId.toString();
      URI serviceURI = serviceUrl()
          .map(service -> service.resolve(path))
          .orElseThrow(ServiceUnavailableException::new);
      ResponseEntity<String> responseEntity = restTemplate.getForEntity(serviceURI, String.class);
      return GetUserDtoMapper.fromJson(responseEntity.getBody());
    } catch (ServiceUnavailableException exception) {
      log.warn("Communication with user service failed.", exception);
      throw new UserServiceException(exception);
    }
  }
}