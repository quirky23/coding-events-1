package org.launchcode.codingevents.models;

import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.*;
import java.util.Date;
import java.util.Objects;

public class Event {

    private int id;
    private static int nextId = 1;

    @NotBlank(message= "Cannot be blank!")
    @Size(min=3, max=50, message = "Must be between 3 and 50 characters")
    private String name;

    @Size(max = 500, message = "Description is longer than 500 characters.")
    private String description;

    @NotBlank(message = "Email is required")
    @Email(message = "Invalid Email.")
    private String contactEmail;

    @NotNull(message = "Enter valid location")
    @NotBlank(message = "Location can not be blank")
    private String eventLocation;

    @AssertTrue(message = "All events require registration.")
    private Boolean registrationRequired;

    @Positive(message = "At least one guest must attend.")
    private int numberOfGuests;


    @DateTimeFormat
    private Date date;

    private EventType type;

    public Event(String name, String description, String contactEmail, String eventLocation,
                 Boolean registrationRequired, int numberOfGuests, Date date, EventType type) {
        this();
        this.name = name;
        this.description = description;
        this.contactEmail = contactEmail;
        this.eventLocation = eventLocation;
        this.numberOfGuests = numberOfGuests;
        this.date= date;
        this.type = type;
        this.registrationRequired = true;
    }

    public Event() {
        this.id = nextId;
        nextId++;
    }

    public int getId() {
        return id;
    }

    public String getName() { return name; }

    public void setName(String name) {
        this.name = name;
    }

    public EventType getType() {
        return type;
    }

    public void setType(EventType type) {
        this.type = type;
    }

    public Date getDate() { return date; }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getContactEmail() {
        return contactEmail;
    }

    public void setContactEmail(String contactEmail) {
        this.contactEmail = contactEmail;
    }

    public String getEventLocation() {
        return eventLocation;
    }

    public void setEventLocation(String eventLocation) {
        this.eventLocation = eventLocation;
    }

    public Boolean getRegistrationRequired() {
        return registrationRequired;
    }

    public void setRegistrationRequired(Boolean registrationRequired) {
        this.registrationRequired = registrationRequired;
    }

    public int getNumberOfGuests() {
        return numberOfGuests;
    }

    public void setNumberOfGuests(int numberOfGuests) {
        this.numberOfGuests = numberOfGuests;
    }

    @Override
    public String toString() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Event event = (Event) o;
        return id == event.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
