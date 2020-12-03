
package com.hospitalautomation.Entities;

import com.hospitalautomation.Infrastructure.IEntity;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Positions")
public class Position  implements IEntity{
    @Id
    @Column(name = "Id")
    private int Id;
    @Column(name = "Name")
    private String Name;

    public Position(String Name) {
        this.Name = Name;
    }
    public Position(int Id, String Name) {
        this.Id = Id;
        this.Name = Name;
    }
    public Position() {
    }

    public int getId() {
        return Id;
    }

    public void setId(int Id) {
        this.Id = Id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }
    
    
    
    
}
