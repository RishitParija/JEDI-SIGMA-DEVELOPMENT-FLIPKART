package com.flipfit.dao;

import com.flipfit.bean.GymOwner;

public interface GymOwnerDAO {
    void registerGymOwner(GymOwner owner);

    boolean validateLogin(String username, String password);
}
