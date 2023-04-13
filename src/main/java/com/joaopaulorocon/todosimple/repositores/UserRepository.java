package com.joaopaulorocon.todosimple.repositores;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.joaopaulorocon.todosimple.models.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{
    
}
