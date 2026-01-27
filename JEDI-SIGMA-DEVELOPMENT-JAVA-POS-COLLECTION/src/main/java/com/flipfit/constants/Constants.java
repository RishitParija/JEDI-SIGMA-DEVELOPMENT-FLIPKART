package com.flipfit.constants;

import com.flipfit.bean.*;
import com.flipfit.business.*;
import java.time.LocalDate;
import java.time.LocalTime;

public class Constants {
    public static void loadMockData() {
        // 1. Seed Gym Owner
        GymOwner owner = new GymOwner("owner-101", "owner1", "John Owner", "john@gym.com", "pass123", "ABCDE1234F");
        owner.setIsVerified(true);
        GymOwnerServiceImpl.gymOwnerList.add(owner);

        // 2. Seed Gym Centres
        GymCentre centre1 = new GymCentre();
        centre1.setCentreId("centre-201");
        centre1.setOwnerId("owner-101");
        centre1.setName("Elite Fitness North");
        centre1.setCity("Bangalore");
        centre1.setApproved(true);
        GymOwnerServiceImpl.gymCentreList.add(centre1);

        GymCentre centre2 = new GymCentre();
        centre2.setCentreId("centre-202");
        centre2.setOwnerId("owner-101");
        centre2.setName("Power Gym South");
        centre2.setCity("Bangalore");
        centre2.setApproved(true);
        GymOwnerServiceImpl.gymCentreList.add(centre2);

        // 3. Seed Slots
        Slot slot1 = new Slot("slot-301", "centre-201", LocalTime.of(6, 0), LocalTime.of(7, 0));
        Slot slot2 = new Slot("slot-302", "centre-201", LocalTime.of(7, 0), LocalTime.of(8, 0));
        Slot slot3 = new Slot("slot-303", "centre-202", LocalTime.of(18, 0), LocalTime.of(19, 0));

        GymOwnerServiceImpl.slotList.add(slot1);
        GymOwnerServiceImpl.slotList.add(slot2);
        GymOwnerServiceImpl.slotList.add(slot3);

        // 4. Seed Schedules for Today and Tomorrow
        LocalDate today = LocalDate.now();
        GymOwnerServiceImpl.scheduleList.add(new Schedule("sch-401", "slot-301", today, 5));
        GymOwnerServiceImpl.scheduleList.add(new Schedule("sch-402", "slot-302", today, 2));
        GymOwnerServiceImpl.scheduleList.add(new Schedule("sch-403", "slot-303", today, 10));

        // 5. Seed a Customer for easy login
        GymCustomer customer = new GymCustomer("cust-501", "user1", "Alice Customer", "alice@test.com", "pass123",
                1000.0);
        GymCustomerServiceImpl.customerList.add(customer);

        System.out.println("System initialized with mock data.");
    }
}
