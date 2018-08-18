package org.hcmus.edu.spring.backend.repositories;

import java.util.Optional;

import org.hcmus.edu.spring.backend.data.entity.Room;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoomRepository extends JpaRepository<Room, Integer> {
    Optional<Room> findById(Integer id);
}
