package com.tokioschool.navigationpractica.data;

import com.tokioschool.navigationpractica.domain.CarItem;
import com.tokioschool.navigationpractica.domain.ResourcesCar;

import java.util.ArrayList;
import java.util.List;

public class RepositoryCar {
    public List<CarItem> getFakeCarList() {
        List<CarItem> list=new ArrayList<>();

        list.add(new CarItem(10.25f,"airplane",new ResourcesCar("airplane")));
        list.add(new CarItem(10.35f,"bus",new ResourcesCar("bus")));
        list.add(new CarItem(11,"electricCar",new ResourcesCar("electricCar")));
        list.add(new CarItem(12,"flyingCar",new ResourcesCar("flyingCar")));
        list.add(new CarItem(16,"motorHome",new ResourcesCar("motorHome")));
        list.add(new CarItem(18.15f,"pickUpCar",new ResourcesCar("pickUpCar")));
        list.add(new CarItem(30.15f,"sportCar",new ResourcesCar("sportCar")));
        list.add(new CarItem(6,"clasicCar",new ResourcesCar("clasicCar")));
        list.add(new CarItem(0,"desconocido",new ResourcesCar("desconocido")));

        return list;
    }
}
