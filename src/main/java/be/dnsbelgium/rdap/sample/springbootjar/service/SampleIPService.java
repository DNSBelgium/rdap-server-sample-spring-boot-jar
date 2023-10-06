package be.dnsbelgium.rdap.sample.springbootjar.service;

import be.dnsbelgium.core.CIDR;
import be.dnsbelgium.rdap.core.IPNetwork;
import be.dnsbelgium.rdap.core.RDAPError;
import be.dnsbelgium.rdap.service.IPService;

public class SampleIPService implements IPService {
  @Override
  public IPNetwork getIPNetwork(CIDR cidr) throws RDAPError {
    // example of an unexpected error
    throw new NullPointerException("oops");
  }
}
