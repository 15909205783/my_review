package com.yangfan.neo.spi.impl;

import com.yangfan.neo.spi.api.Robot;

public class Bumblebee implements Robot {
    @Override
    public void sayHello() {
        System.out.println("Hello, I am Bumblebee.");
    }
}
