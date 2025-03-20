package com.garsa.corp.respository;

import com.garsa.corp.model.UserModel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public interface UserRepository extends CrudRepository<UserModel, Long> {

    public abstract ArrayList<UserModel> findByPriority(Integer priority);
}
