package be.dnsbelgium.rdap.sample.springbootjar.config;

import be.dnsbelgium.rdap.jackson.CustomObjectMapper;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.List;

@Configuration
@ComponentScan(basePackages = {"be.dnsbelgium.rdap.controller"})
public class WebMvcConfig implements WebMvcConfigurer {

  @Override
  public void extendMessageConverters(List<HttpMessageConverter<?>> converters) {
    System.out.println(converters);
  }

  @Bean
  public ObjectMapper getObjectMapper() {
    return new CustomObjectMapper();
  }

/*  @Override
  public void addResourceHandlers(ResourceHandlerRegistry registry) {
    registry.hasMappingForPattern("/robots.txt");
    registry.addResourceHandler("/robots.txt").addResourceLocations("classpath:/static/");
  }

  @Bean
  public MappingJackson2HttpMessageConverter converter(ObjectMapper mapper) {
    MappingJackson2HttpMessageConverter converter = new MappingJackson2HttpMessageConverter();
    converter.setObjectMapper(mapper);
    return converter;
  }



  @Bean
  public ObjectMapper getObjectMapper() {
    return new CustomObjectMapper();
  }

  @Override
  public void configurePathMatch(PathMatchConfigurer configurer) {
    UrlPathHelper urlPathHelper = new UrlPathHelper();
    urlPathHelper.setUrlDecode(false);
    configurer.setUrlPathHelper(urlPathHelper);
  }*/

}
