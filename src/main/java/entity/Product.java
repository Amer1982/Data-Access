package entity;

import java.io.Serializable;
import java.sql.Date;

public class Product implements Serializable {
    private Integer actorId;
    private String firstName;
    private String lastName;
    private Date lastUpdate;


    public Date getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(Date lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

    public Product() {
        super();
    }

    public Integer getActorId() {
        return actorId;
    }

    public void setActorId(Integer actorId) {
        this.actorId = actorId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }


    @Override
    public String toString() {
        return "Product{" +
                "productId=" + actorId +
                ", first name='" + firstName + '\'' +
                ", last name=" + lastName +
                ", last update=" + lastUpdate.toLocalDate() +
                '}';
    }
}