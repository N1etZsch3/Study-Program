package com.n1etzsch3.abstractdemo2;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public abstract class Animal {
    private String name;

    public abstract void cry();

}
