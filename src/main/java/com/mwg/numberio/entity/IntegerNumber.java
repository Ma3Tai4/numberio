package com.mwg.numberio.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Data
public class IntegerNumber {
    @Id
    @GeneratedValue
    Long id;
    Integer value;
}
