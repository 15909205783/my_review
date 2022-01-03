package com.yangfan.neo.spi.impl;

import com.yangfan.neo.spi.api.CarInterface;

public class RedCar implements CarInterface {

    @Override
    public void hello() {
        System.out.println("Red");
    }
}
