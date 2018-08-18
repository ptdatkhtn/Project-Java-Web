package org.hcmus.edu.spring.ui.entities;

public class EventCreateEntity {


    private Integer id;
    private String fromTime;
    private String toTime;
    private String date;
    private String title;
    private int approval;

    public EventCreateEntity() {
    }

    public EventCreateEntity(Integer id, String fromTime, String toTime,
            String date, String title, int approval) {
        this.id = id;
        this.fromTime = fromTime;
        this.toTime = toTime;
        this.date = date;
        this.title = title;
        this.approval = approval;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFromTime() {
        return fromTime;
    }

    public void setFromTime(String fromTime) {
        this.fromTime = fromTime;
    }

    public String getToTime() {
        return toTime;
    }

    public void setToTime(String toTime) {
        this.toTime = toTime;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getApproval() {
        return approval;
    }

    public void setApproval(int approval) {
        this.approval = approval;
    }
}
