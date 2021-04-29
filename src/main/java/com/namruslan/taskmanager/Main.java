package com.namruslan.taskmanager;

import com.namruslan.taskmanager.entity.TaskHibernate;
import com.namruslan.taskmanager.util.TaskProcess;

public class Main {
    public static void main(String[] args) {
        TaskProcess taskProcess = new TaskProcess();

        for (TaskHibernate task : taskProcess.getAll()) {
            System.out.println(task);
        }

    }
}
