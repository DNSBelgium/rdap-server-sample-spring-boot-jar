package be.dnsbelgium.rdap.sample.springbootjar.config;

import be.dnsbelgium.rdap.DefaultServiceConfig;
import be.dnsbelgium.rdap.sample.springbootjar.service.SampleDomainService;
import be.dnsbelgium.rdap.sample.springbootjar.service.SampleEntityService;
import be.dnsbelgium.rdap.sample.springbootjar.service.SampleIPService;
import be.dnsbelgium.rdap.service.DomainService;
import be.dnsbelgium.rdap.service.EntityService;
import be.dnsbelgium.rdap.service.IPService;
import be.dnsbelgium.rdap.service.impl.DefaultEntityService;
import be.dnsbelgium.rdap.service.impl.DefaultIPService;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ServiceConfig extends DefaultServiceConfig {
  
  @Override
  public DomainService getDomainService() {
    return new SampleDomainService();
  }

  @Override
  public EntityService getEntityService() {
    return new SampleEntityService();
  }

  @Override
  public IPService getIPService() {
    return new SampleIPService();
  }
}
