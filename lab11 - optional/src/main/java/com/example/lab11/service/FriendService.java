package com.example.lab11.service;

import com.example.lab11.controller.ControlExceptionHandler;
import com.example.lab11.entity.FriendEntity;
import com.example.lab11.entity.UserEntity;
import com.example.lab11.repository.FriendRepository;
import com.example.lab11.repository.UserRepository;
import com.sun.source.tree.Tree;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;


@Service
public class FriendService {
    @Autowired
    private FriendRepository friendRepository;
    @Autowired
    private UserService userService;
//    @Autowired
//    private ControlExceptionHandler exceptionHandler;

    public List<FriendEntity> getAllById2(long id2) {
        return friendRepository.getFriendEntitiesById2(id2);
    }

    public List<FriendEntity> getAllById1(long id1) {
        return friendRepository.getFriendEntitiesById1(id1);
    }

    public FriendEntity addFriend(FriendEntity friend) {
        friendRepository.save(friend);
        return friend;
    }

    public List<FriendEntity> getAllRelations() {
        return friendRepository.findAll();
    }


    public void deleteFriendship(long id1, long id2) {
        friendRepository.deleteFriendEntityById1AndId2(id1, id2);

    }

    public static <T> Set<T> mergeSet(Set<T> a, Set<T> b) {
        return new HashSet<T>() {
            {
                addAll(a);
                addAll(b);
            }
        };
    }

    public int countFriendship(long id) {
        List<FriendEntity> numberOfFriendsList1 = friendRepository.getFriendEntitiesById1(id);
        List<FriendEntity> numberOfFriendsList2 = friendRepository.getFriendEntitiesById2(id);
        Set<FriendEntity> numberOfFriends1 = Collections.emptySet();
        Set<FriendEntity> numberOfFriends2 = Collections.emptySet();
        Set<FriendEntity> mergeFriends;
        if (numberOfFriendsList1.size() != 0) {
            numberOfFriends1 = new HashSet<>(numberOfFriendsList1);
        }
        if (numberOfFriendsList2.size() != 0) {
            numberOfFriends2 = new HashSet<>(numberOfFriendsList2);
        }
        if (numberOfFriends1.size() != 0 && numberOfFriends2.size() != 0) {
            mergeFriends = mergeSet(numberOfFriends1, numberOfFriends2);
        } else if (numberOfFriends1.size() != 0) {
            mergeFriends = numberOfFriends1;
        } else if (numberOfFriends2.size() != 0) {
            mergeFriends = numberOfFriends2;
        } else {
            return 0;
        }
        return mergeFriends.size();
    }

    public List<UserEntity> leastFamous(int k) {
        Map<UserEntity, Integer> countFriends = new HashMap<>();
        if (k > userService.getAllUsers().size()) {
            return null;
        } else {
            for (UserEntity user : userService.getAllUsers()) {
                countFriends.put(user, countFriendship(user.getIdUser()));
            }
            countFriends = countFriends.entrySet().stream()
                    .sorted(Map.Entry.comparingByValue())
                    .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,
                            (e1, e2) -> e1, LinkedHashMap::new));

        }
        List<UserEntity> resultList = new ArrayList<>();
        resultList.addAll(countFriends.entrySet().stream().limit(k).map(Map.Entry::getKey).collect(Collectors.toList()));

        return resultList;
    }

    public List<UserEntity> mostFamous(int k) {
        if (k > userService.getAllUsers().size()) {
           // return  exceptionHandler.notEnoughResources();
            return null;
        } else {
            List<UserEntity> resultList = new ArrayList<>(leastFamous(userService.getAllUsers().size()));
            Collections.reverse(resultList);
            resultList = resultList.stream().limit(k).collect(Collectors.toList());
            return resultList;
        }
    }

}
