package com.flipfit.dao;

import com.flipfit.bean.GymCentre;
import com.flipfit.bean.GymOwner;
import java.util.List;

public interface AdminDAO {
    boolean validateLogin(String username, String password);

    void approveGymOwner(String ownerId);

    void approveGymCentre(String centreId);

    List<GymOwner> getPendingGymOwners();

    List<GymCentre> getPendingGymCentres();
}
