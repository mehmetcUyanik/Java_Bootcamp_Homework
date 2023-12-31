package Homeworks.Homework3.service;

import Homeworks.Homework3.model.Accident;
import Homeworks.Homework3.model.ColorTypeEnum;
import Homeworks.Homework3.model.Vehicle;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class VehicleService {

    /*
    Vehicle sınıfı için service oluşturuldu. vehicle objesini oluşturmak ve fieldları doldurmak için
    "createVehicle" ve "addAccidentToVehicle" methodu oluşturuldu.
     */

    public Vehicle createVehicle(String brand, String model, String plate, String chassisNumber,
                                 int modelYear, ColorTypeEnum color){

        Vehicle vehicle = new Vehicle();

        vehicle.setBrand(brand);
        vehicle.setModel(model);
        vehicle.setPlate(plate);
        vehicle.setChassisNumber(chassisNumber);
        vehicle.setModelYear(modelYear);
        vehicle.setColor(color);

        return vehicle;
    }

    public void addAccidentToVehicle(Vehicle vehicle, Accident accident){

        if (vehicle.getAccidentList() != null){
            vehicle.getAccidentList().add(accident);
        }else {
            ArrayList<Accident> accidentList = new ArrayList<>();
            accidentList.add(accident);
            vehicle.setAccidentList(accidentList);
        }
    }

    public BigDecimal totalOfAccidentDamagePrice(Vehicle vehicle){

        BigDecimal total = BigDecimal.ZERO;

        if (vehicle.getAccidentList() != null){
            for (Accident accident: vehicle.getAccidentList()){
                total = total.add(accident.getDamagePrice());
            }

        }

        return total;
    }
}
