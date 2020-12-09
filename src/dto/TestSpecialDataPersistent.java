package dto;

import dao.Special;
import dao.Vehicle;

import java.text.SimpleDateFormat;
import java.util.*;

public class TestSpecialDataPersistent {
    public static void main(String[] args) throws Exception {
        DataPersistence dp = new DataPersistence();

        Special sp = new Special();
        sp.setStartDate(new SimpleDateFormat("dd/MM/yyyy").parse("08/12/2020"));
        sp.setEndDate(new SimpleDateFormat("dd/MM/yyyy").parse("31/12/2020"));
        sp.setDiscountValue(4500);
        sp.setTitle("Christmas");
        sp.setScopeParameter("someKindOfScope");
        List<Vehicle> allVehicles = dp.getAllVehicles();
        List<String> scopes = new ArrayList<>();
        for (Vehicle v : allVehicles) {
            scopes.add(v.getVehicleId());
        }
        sp.setScope(scopes);

        //dp.writeSpecials(sp);

        List<Special> allSpecialsRead = dp.getAllSpecials();
        for (Special s: allSpecialsRead) {
            System.out.println(s.getScope());
        }
//        System.out.println(allSpecialsRead.get(0).getTitle());
//        System.out.println(allSpecialsRead.get(1).getTitle());
//        System.out.println(allSpecialsRead.get(2).getTitle());

    }


}
