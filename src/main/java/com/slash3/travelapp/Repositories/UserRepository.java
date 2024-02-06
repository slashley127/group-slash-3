package com.slash3.travelapp.Repositories;

import com.slash3.travelapp.Models.AppUser;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<AppUser, Integer> {

}
