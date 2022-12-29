package com.nimko.shppmentorpracktic6.model;

import com.nimko.shppmentorpracktic6.services.ValidateIpn;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@ToString
@ValidateIpn
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @NotNull
    private String ipn;
    private String firstName;
    private String lastName;
    @NotNull
    private Sex sex;
}
