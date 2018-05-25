package com.helloworld.exception;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@ConfigurationProperties(prefix = "errorMessages")
@Component
public class ErrorProperty {

}
