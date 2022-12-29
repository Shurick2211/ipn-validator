package com.nimko.shppmentorpracktic6.services;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy = CheckIpnService.class)
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface ValidateIpn {
    String message() default "IPN is not valid!";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
