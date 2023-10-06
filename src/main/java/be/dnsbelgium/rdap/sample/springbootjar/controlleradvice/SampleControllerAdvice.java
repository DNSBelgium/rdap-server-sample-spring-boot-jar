package be.dnsbelgium.rdap.sample.springbootjar.controlleradvice;

import be.dnsbelgium.rdap.core.RDAPError;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.servlet.http.HttpServletResponse;

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
