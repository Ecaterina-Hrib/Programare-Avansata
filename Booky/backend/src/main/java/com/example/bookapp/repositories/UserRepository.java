package com.example.bookapp.repositories;

import com.example.bookapp.entities.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Repository
public interface UserRepository extends JpaRepository<UserEntity, Integer> {

    List<UserEntity> findAll();

    <User extends UserEntity> User save(User entity);

    UserEntity getUserByIdUser(long idUser);
    boolean existsByName(String name);
    UserEntity getByName(String name);
    void deleteUserByIdUser(long idUser);

}
