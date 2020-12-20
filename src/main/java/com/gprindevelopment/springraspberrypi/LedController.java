package com.gprindevelopment.springraspberrypi;

import com.pi4j.io.gpio.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Objects;

@RestController
public class LedController {

    private static GpioPinDigitalOutput pin;

    @GetMapping("/led")
    public String toggleLed() {
        if(Objects.isNull(pin)) {
            GpioController gpio = GpioFactory.getInstance();
            pin = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_01, "MyLED", PinState.LOW);
        }
        pin.toggle();
        return "OK";
    }
}
