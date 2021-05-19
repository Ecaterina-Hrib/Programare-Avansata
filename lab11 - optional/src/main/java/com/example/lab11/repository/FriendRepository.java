package com.example.lab11.repository;

import com.example.lab11.entity.FriendEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Repository
public interface FriendRepository extends JpaRepository<FriendEntity, Integer> {
    List<FriendEntity> findAll();

   List <FriendEntity> getFriendEntitiesById1(long id1);

    List <FriendEntity>  getFriendEntitiesById2(long id2);

    long count();

    <Friend extends FriendEntity> Friend save(Friend entity);

    void deleteFriendEntityById1AndId2(long id1, long id2);
}
