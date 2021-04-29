package com.namruslan.taskmanager.entity;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
@Table(name = "owner_table")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Owner implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "owner_name")
    private String ownerName;

    @OneToMany(mappedBy = "owner")
    private Set<TaskHibernate> tasks;

    @Override
    public String toString() {
        return "Owner{" +
                "id=" + id +
                ", ownerName='" + ownerName +
                '}';
    }
}
