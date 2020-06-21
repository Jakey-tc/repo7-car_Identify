package com.jakey.car.caridentify;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Jakey on 2020/6/18.
 * desc:
 */
@RestController
public class CarController {

    @RequestMapping("/getCar")
    public String getCar(String path){

        return CarDestroy.car(path);
    }
}