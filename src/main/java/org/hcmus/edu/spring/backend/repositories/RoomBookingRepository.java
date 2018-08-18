package org.hcmus.edu.spring.backend.repositories;

import java.util.List;
import java.util.Optional;

import org.hcmus.edu.spring.backend.data.entity.RoomBooking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoomBookingRepository
        extends JpaRepository<RoomBooking, Integer> {
    List<RoomBooking> findByRoomId(Integer roomId);

    Optional<RoomBooking> findById(Integer roomBookingId);

    void deleteById(Integer id);
}
