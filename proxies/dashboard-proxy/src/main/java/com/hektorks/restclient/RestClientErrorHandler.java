/*
 * Copyright (c) 2019 Konrad Szymański. All rights reserved.
 *
 */

package com.hektorks.restclient;

import static org.springframework.http.HttpStatus.Series.CLIENT_ERROR;
import static org.springframework.http.HttpStatus.Series.SERVER_ERROR;

import com.hektorks.exceptionhandling.BusinessValidationExceptionMapper;
import com.hektorks.exceptionhandling.RequestValidationErrors;
import com.hektorks.exceptionhandling.RequestValidationException;
import com.hektorks.exceptionhandling.ResourceNotFoundException;
import com.hektorks.exceptionhandling.RestClientProxyException;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.web.client.ResponseErrorHandler;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.stream.Collectors;

public class RestClientErrorHandler implements ResponseErrorHandler {

  @Override
  public boolean hasError(ClientHttpResponse response) throws IOException {
    return (response.getStatusCode().series() == CLIENT_ERROR || response.getStatusCode().series() == SERVER_ERROR);
  }

  @Override
  public void handleError(ClientHttpResponse response) throws IOException {
    switch (response.getStatusCode()) {
      case BAD_REQUEST:
        throw new RequestValidationException(RequestValidationErrors.fromJson(readBody(response.getBody())));
      case NOT_FOUND:
        throw new ResourceNotFoundException();
      case UNPROCESSABLE_ENTITY:
        throw BusinessValidationExceptionMapper.fromJson(readBody(response.getBody()));
      default:
        throw new RestClientProxyException(response.getStatusCode(), readBody(response.getBody()));
    }
  }

  private String readBody(InputStream inputStream) throws IOException {
    try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, StandardCharsets.UTF_8.name()))) {
      return bufferedReader.lines().collect(Collectors.joining(System.lineSeparator()));
    }
  }
}