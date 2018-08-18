package org.hcmus.edu.spring.backend.service;

import java.util.List;

import org.hcmus.edu.spring.backend.data.entity.RoomBooking;
import org.hcmus.edu.spring.backend.repositories.RoomBookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoomBookingService {

    RoomBookingRepository roomBookingRepository;

    @Autowired
    public RoomBookingService(RoomBookingRepository roomBookingRepository) {
        this.roomBookingRepository = roomBookingRepository;
    }

    public List<RoomBooking> findByRoomId(Integer roomId) {
        return roomBookingRepository.findByRoomId(roomId);
    }

    public RoomBooking save(RoomBooking entity) {
        return roomBookingRepository.saveAndFlush(entity);
    }

    public void delete(RoomBooking entity){
        roomBookingRepository.delete(entity);
    }

    public RoomBooking findById(Integer id){
        return roomBookingRepository.findById(id).get();
    }

    public void deleteById(Integer id) {
        roomBookingRepository.deleteById(id);
    }
}
