package be.dnsbelgium.rdap.sample.springbootjar.controlleradvice;

import be.dnsbelgium.rdap.core.RDAPError;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import jakarta.servlet.http.HttpServletResponse;

/**
 *
 */
@RestControllerAdvice
public class SampleControllerAdvice extends ResponseEntityExceptionHandler {
  @ExceptionHandler(value = RDAPError.class)
  public RDAPError handleRdapError(RDAPError error, HttpServletResponse response) {
    response.setStatus(error.getErrorCode());

    return error;
  }

}
