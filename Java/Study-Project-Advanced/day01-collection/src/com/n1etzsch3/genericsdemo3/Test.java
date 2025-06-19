package com.n1etzsch3.genericsdemo3;

import java.util.ArrayList;

public class Test {
    public static void main(String[] args) {
        ArrayList<XiaomiCar> xiaomiCars = new ArrayList<>();
        xiaomiCars.add(new XiaomiCar());
        xiaomiCars.add(new XiaomiCar());
        xiaomiCars.add(new XiaomiCar());
        transitCar(xiaomiCars);

        ArrayList<TeslaCar> teslaCars = new ArrayList<>();
        teslaCars.add(new TeslaCar());
        teslaCars.add(new TeslaCar());
        teslaCars.add(new TeslaCar());
        teslaCars.add(new TeslaCar());
        transitCar(teslaCars);

        ArrayList<VolvoCar> volvoCars = new ArrayList<>();
        volvoCars.add(new VolvoCar());
        volvoCars.add(new VolvoCar());
        volvoCars.add(new VolvoCar());
        volvoCars.add(new VolvoCar());
        volvoCars.add(new VolvoCar());
        transitCar(volvoCars);
    }

    public static void transitCar(ArrayList<? extends Car> cars){
        System.out.println("Transiting cars: " + cars.size());
    }
}

class Car{}

class XiaomiCar extends Car{}

class TeslaCar extends Car{}

class VolvoCar extends Car{}

