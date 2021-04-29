package com.namruslan.taskmanager.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TaskClass {

    private int id;
    private String taskName;
    private String owner;
    private int priority;

}
