package com.journal.journalspring.models;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

import java.sql.Timestamp;

@Entity(name = "entry")
@Table(name = "entry", schema = "public")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Entry {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="entryid")
    private Long entryId;

    @Column(name="text")
    private String text;

    @Column(name="whencreated", columnDefinition="TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private Timestamp whenCreated;

    public Long getId() {
        return this.entryId;
    }

    public void setId(Long entryId) {
        this.entryId = entryId;
    }

    public String getText() {
        return this.text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Timestamp getWhenCreate() { return this.whenCreated; }

    public void setWhenCreated(Timestamp whenCreated) { this.whenCreated = whenCreated; }

    public Entry() {
    }
}
