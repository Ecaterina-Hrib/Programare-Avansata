package com.example.lab11.controller;

import com.example.lab11.entity.FriendEntity;
import com.example.lab11.entity.UserEntity;
import com.example.lab11.service.FriendService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/friends")
public class FriendController {
    @Autowired
    private FriendService friendService;

    @RequestMapping(method = RequestMethod.GET, value = "/")
    public List<FriendEntity> getFriendList() {
        return friendService.getAllRelations();
    }

    @RequestMapping(method = RequestMethod.POST, value = "/")
    public FriendEntity createFriendship(@RequestBody FriendEntity user) {
        return friendService.addFriend(user);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/{id1}/{id2}")
    public void deleteFriendship(@PathVariable long id1, @PathVariable long id2) {
        friendService.deleteFriendship(id1, id2);
    }
    @RequestMapping(method = RequestMethod.GET, value = "/searchByID1/{id1}")
    public List<FriendEntity> getById1(@PathVariable long id1) {
        return friendService.getAllById1(id1);
    }
    @RequestMapping(method = RequestMethod.GET, value = "/searchByID2/{id2}")
    public List<FriendEntity> getById2(@PathVariable long id2) {
        return friendService.getAllById2(id2);
    }
    @RequestMapping(method = RequestMethod.GET, value = "/numberOfFriendships/{id}")
    public int searchFriendship(@PathVariable long id) {
        return friendService.countFriendship(id);
    }
    @RequestMapping(method = RequestMethod.GET, value = "/leastFamous/{k}")
    public List<UserEntity> leastPopular(@PathVariable int k) {
        return friendService.leastFamous(k);
    }
    @RequestMapping(method = RequestMethod.GET, value = "/mostFamous/{k}")
    public List<UserEntity> mostPopular(@PathVariable int k) {
        return friendService.mostFamous(k);
    }
}
