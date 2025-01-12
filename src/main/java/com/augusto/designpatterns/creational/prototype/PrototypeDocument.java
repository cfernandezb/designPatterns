package com.augusto.designpatterns.creational.prototype;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

//TODO: 2/4/2023 - Inmplementar lombok
public class PrototypeDocument implements Cloneable {

    private String type;
    private String title;
    private String Client;
    private List<String> details;

    public PrototypeDocument(String type, String title, String client, List<String> details) {
        this.type = type;
        this.title = title;
        Client = client;
        this.details = details;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getClient() {
        return Client;
    }

    public void setClient(String client) {
        Client = client;
    }

    public List<String> getDetails() {
        return details;
    }

    public void setDetails(List<String> details) {
        this.details = details;
    }

    @Override
    public PrototypeDocument clone() throws CloneNotSupportedException {
        PrototypeDocument copy = (PrototypeDocument) super.clone();
        copy.details = new ArrayList<>(this.details);
        return copy;
    }

    @Override
    public String toString() {
        return "PrototypeDocument{" +
                "type='" + type + '\'' +
                ", title='" + title + '\'' +
                ", Client='" + Client + '\'' +
                ", details=" + details +
                '}';
    }
    
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PrototypeDocument that = (PrototypeDocument) o;
        return Objects.equals(type, that.type) &&
               Objects.equals(title, that.title) &&
               Objects.equals(Client, that.Client) &&
               Objects.equals(details, that.details);
    }

    @Override
    public int hashCode() {
        return Objects.hash(type, title, Client, details);
    }

}
