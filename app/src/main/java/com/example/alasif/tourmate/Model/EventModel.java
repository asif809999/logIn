package com.example.alasif.tourmate.Model;

/**
 * Created by asif on 2/23/17.
 */

public class EventModel {

    private int id;
    private int loggedInUserId;
    private String eventStartFrom,eventLocationName, eventStartDate, eventEndDate;

    public EventModel(int id, int loggedInUserId, String eventStartFrom, String eventLocationName, String eventStartDate, String eventEndDate) {
        this.id = id;
        this.loggedInUserId = loggedInUserId;
        this.eventStartFrom = eventStartFrom;
        this.eventLocationName = eventLocationName;
        this.eventStartDate = eventStartDate;
        this.eventEndDate = eventEndDate;
    }

    public EventModel(String eventEndDate, String eventStartDate, String eventLocationName, String eventStartFrom, int loggedInUserId) {
        this.eventEndDate = eventEndDate;
        this.eventStartDate = eventStartDate;
        this.eventLocationName = eventLocationName;
        this.eventStartFrom = eventStartFrom;
        this.loggedInUserId = loggedInUserId;
    }

    public EventModel(String eventStartFrom, String eventLocationName, String eventStartDate, String eventEndDate) {
        this.eventStartFrom = eventStartFrom;
        this.eventLocationName = eventLocationName;
        this.eventStartDate = eventStartDate;
        this.eventEndDate = eventEndDate;
    }

    public EventModel() {
    }

    public int getId() {
        return id;
    }

    public String getEventEndDate() {
        return eventEndDate;
    }

    public String getEventStartDate() {
        return eventStartDate;
    }

    public String getEventLocationName() {
        return eventLocationName;
    }

    public String getEventStartFrom() {
        return eventStartFrom;
    }

    public int getLoggedInUserId() {
        return loggedInUserId;
    }
}
