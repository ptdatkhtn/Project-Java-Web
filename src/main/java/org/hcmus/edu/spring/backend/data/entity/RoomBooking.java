package org.hcmus.edu.spring.backend.data.entity;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalTime;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table(name = "room_booking")
public class RoomBooking extends AbstractEntity {

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "room_id")
    @JsonProperty("room_id")
    private Room room;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    @JsonProperty("user_id")
    private User user;

    private LocalTime fromTime;
    private LocalTime toTime;
    private LocalDate date;
    private String title;
    private Integer approval;
    private Timestamp created;

    public RoomBooking() {
        created =new Timestamp(System.currentTimeMillis());
    }

    public Room getRoom() {
        return room;
    }

    public RoomBooking setRoom(Room room) {
        this.room = room;
        return this;
    }

    public User getUser() {
        return user;
    }

    public RoomBooking setUser(User user) {
        this.user = user;
        return this;
    }

    public LocalTime getFromTime() {
        return fromTime;
    }

    public RoomBooking setFromTime(LocalTime fromTime) {
        this.fromTime = fromTime;
        return this;
    }

    public LocalTime getToTime() {
        return toTime;
    }

    public RoomBooking setToTime(LocalTime toTime) {
        this.toTime = toTime;
        return this;
    }

    public LocalDate getDate() {
        return date;
    }

    public RoomBooking setDate(LocalDate date) {
        this.date = date;
        return this;
    }

    public String getTitle() {
        return title;
    }

    public RoomBooking setTitle(String title) {
        this.title = title;
        return this;
    }

    public Integer getApproval() {
        return approval;
    }

    public RoomBooking setApproval(Integer approval) {
        this.approval = approval;
        return this;
    }

    public Timestamp getCreated() {
        return created;
    }

    public void setCreated(Timestamp created) {
        this.created = created;
    }
}
