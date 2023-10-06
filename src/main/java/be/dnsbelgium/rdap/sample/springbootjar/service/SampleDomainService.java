package be.dnsbelgium.rdap.sample.springbootjar.service;

import be.dnsbelgium.core.DomainName;
import be.dnsbelgium.rdap.core.Domain;
import be.dnsbelgium.rdap.core.Event;
import be.dnsbelgium.rdap.service.impl.DefaultDomainService;
import org.joda.time.DateTime;

import java.util.Collections;
import java.util.List;

public class SampleDomainService extends DefaultDomainService {

  public Domain getDomainImpl(DomainName domainName) {
    Event dummyCreate = new Event(Event.Action.Default.REGISTRATION, null, new DateTime(), null);
    Domain domain = new Domain(null, null, null, null,
        List.of(dummyCreate), null, null,
        null, domainName.toLDH(), domainName.toUnicode(), null,
        null, null, null, null, null);

    return domain;
  }
}
