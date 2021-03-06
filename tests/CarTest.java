import org.junit.Test;

import java.awt.*;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import static org.junit.Assert.*;

public class CarTest {

/*
    @Test
    public void getNrDoors() {
        Vehicle testVolvo = new Volvo240();
        Vehicle testSaab = new Saab95();
        assertEquals(4, testVolvo.getBody().getNrDoors());
        assertEquals(2, testSaab.getBody().getNrDoors());
    }

    @Test
    public void maxSpeedVolvo(){
        Vehicle testVolvo = new Volvo240();
        for(int i =0; i<= testVolvo.getEngine().getEnginePower(); i++){
            testVolvo.gas(1);
        }
        assertEquals(testVolvo.getEngine().getCurrentSpeed(), testVolvo.getEngine().getEnginePower(), 0);
    }

    @Test
    public void maxSpeedSaab(){
        Vehicle testSaab = new Saab95();
        for (int i = 0; i < testSaab.getEngine().getEnginePower(); i++) {
            testSaab.gas(1);
        }
        assertEquals(testSaab.getEngine().enginePower, testSaab.getEngine().getEnginePower(), 0);
    }


    @Test
    public void testBrakesDoesntGoBelowZero(){
        Vehicle testVolvo = new Volvo240();
        int testSpeed = 50;
        testVolvo.getEngine().currentSpeed = testSpeed;
        for (int i = 0; i <= testSpeed+1; i++) {
            testVolvo.brake(1);
        }
        assertEquals(0, testVolvo.getEngine().getCurrentSpeed(),0);
    }

    @Test
    public void testBrakeLowersSpeed(){
        Vehicle testVolvo = new Volvo240();
        int testSpeed = 50;
        testVolvo.getEngine().currentSpeed = testSpeed;
        testVolvo.brake(1);
        assertTrue(testSpeed>testVolvo.getEngine().getCurrentSpeed());
    }


    @Test
    public void colorTest(){
        Vehicle testSaab = new Saab95();
        assertEquals(Color.black, testSaab.getBody().getColor());

        Vehicle coloredSaab = new Saab95(Color.RED);
        assertEquals(Color.red, coloredSaab.getBody().getColor());
    }


    @Test
    public void testCarMovement(){
        Vehicle testCar = new Saab95();
        int randomNumber = ThreadLocalRandom.current().nextInt();
        testCar.getEngine().setCurrentSpeed(randomNumber);
        testCar.move();
        assertEquals(randomNumber, testCar.getPosition().getY(),0);
    }

    @Test
    public void testCarLeftTurnDirection(){
        Vehicle testCar = new Volvo240();
        List<Direction> directionList = Arrays.asList(Direction.EAST, Direction.NORTH, Direction.WEST, Direction.SOUTH);
        for (int i = 0; i < directionList.size(); i++) {
            testCar.turnLeft();
            assertTrue(directionList.get(i).equals(testCar.getDirection()));
        }
    }
/*
    @Test
    public void testFILO(){
        CarCargo carCargo = new CarCargo();
        carCargo.cars.push(new Volvo240());
        carCargo.cars.push(new Saab95(Color.CYAN));
        carCargo.cars.push(new Saab95(Color.YELLOW));
        System.out.println(carCargo.cars.pop().getColor());
    }
*/


    @Test
    public void testScaniaColor(){
        Scania scania = new Scania(Color.CYAN);
        assertTrue(scania.getBody().getColor().equals(Color.CYAN));
    }

    @Test
    public void raiseCargoWhileDriving(){
        Scania scania = new Scania();
        scania.getEngine().startEngine();
        scania.gas(1);
        scania.raiseCargo(50);
        //scania.gas(1);
        //System.out.println(scania.getEngine().getCurrentSpeed());
    }

    @Test
    public void lowerCargoWhileDriving(){
        Scania scania = new Scania();
        scania.getEngine().startEngine();
        scania.lowerCargo(20);
    }

    @Test
    public void maximumCargoAngle(){
        Scania scania = new Scania();
        scania.raiseCargo(150);
        assertEquals(RegularCargo.UPPER_LIMIT, scania.getCargo().getCurrentAngle(),0);
    }

    @Test
    public void minimumCargoAngle(){
        Scania scania = new Scania();
        scania.lowerCargo(50);
        assertEquals(RegularCargo.LOWER_LIMIT, scania.getCargo().getCurrentAngle(),0);
    }

    @Test
    public void engineTest(){
        Saab95 saab95 = new Saab95();
        saab95.gas(1);
        System.out.println(saab95.getEngine().getCurrentSpeed());
    }

    @Test
    public void loadTruckOntoTruck(){
        SemiTruck semiTruck = new SemiTruck();
        semiTruck.loadCargo(semiTruck);
    }

    @Test
    public void drivingWithCargoDown(){
        SemiTruck semiTruck = new SemiTruck();
        semiTruck.lowerCargo();
        semiTruck.getEngine().startEngine();
        semiTruck.move();
    }

    @Test
    public void tryingToLowerCargoWhileDriving(){
        SemiTruck semiTruck = new SemiTruck();
        semiTruck.getEngine().startEngine();
        semiTruck.gas(1);
        semiTruck.lowerCargo();
    }

    @Test
    public void tryingToLoadCarOutOfRange(){
        Saab95 saab95 = new Saab95();
        saab95.gas(1);
        for (int i = 0; i < 5; i++) {
            saab95.move();
        }
        System.out.println(saab95.getPosition());

        SemiTruck semiTruck = new SemiTruck();
        semiTruck.gas(1);
        for (int i = 0; i < 2; i++) {
            semiTruck.move();
        }
        System.out.println(semiTruck.getPosition());
        semiTruck.getEngine().stopEngine();
        semiTruck.lowerCargo();
        semiTruck.loadCargo(saab95);
    }
}