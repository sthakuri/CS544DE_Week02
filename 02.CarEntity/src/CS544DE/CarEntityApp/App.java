/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CS544DE.CarEntityApp;

import CS544DE.Model.Car;
import CS544DE.Model.Color;
import CS544DE.EntityManager.CarEntityManager;
import CS544DE.EntityManager.DBContext;
import javax.persistence.EntityManager;

/**
 *
 * @author 500Course
 */
public class App {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        System.out.println("Application Started.");
        
        DBContext dbContext = new DBContext();
        System.out.println("Database Contex Created");
        
        CarEntityManager carEntityManager = new CarEntityManager(dbContext.getEntityManager());
        System.out.println("Car Entity Manager Created.");
        
        //Car info
        Car car = new Car();
        car.setMake("Tesla");
        car.setModel("CS544DE");
        car.setYear(2016);
        car.setMiles(1200);
        car.setColor(Color.Silver);

        if (!carEntityManager.exist(car)) {
            carEntityManager.save(car);
            System.out.println("Success: New car model has been successfully added.");
        } else {
            System.out.print("Already Exist: The car model you are trying to add, already exist in the system.");
        }
        dbContext.end();
    }

}
