package Models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;

@Entity
public class User {
    @Column(name="User_Name")
    private String name;

}
