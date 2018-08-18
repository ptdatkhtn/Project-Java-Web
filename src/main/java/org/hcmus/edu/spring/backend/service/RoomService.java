package org.hcmus.edu.spring.backend.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.hcmus.edu.spring.backend.data.entity.Room;
import org.hcmus.edu.spring.backend.repositories.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoomService {

    RoomRepository roomRepository;

    @Autowired
    public RoomService(RoomRepository roomRepository) {
        this.roomRepository = roomRepository;
    }

    public List<Room> findAll() {
        return roomRepository.findAll();
    }

    public List<Room> findAllWithoutBooking() {
        List<Room> result = findAll();
        result.forEach(r -> {
            r.setRoomBookings(new ArrayList<>());
        });
        return result;
    }

    public Optional<Room> findById(Integer id) {
        return roomRepository.findById(id);
    }

    public Room save(Room room) {
        return roomRepository.saveAndFlush(room);
    }
}
