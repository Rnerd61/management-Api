package com.rnerd.code.models.PlanningTeam;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Document(collection = "planning")
public class Planning {
    @Id
    ObjectId id;
    private String taskName;
    private String description;
    private Date dueDate;
    // warehouse to be implemented later
    private String assignedTo;  // User or team assigned to the task
    private List<String> tags;  // Tags for categorizing tasks
    private boolean isCompleted;
    private List<Parts> parts;

    public Planning(String taskName, String description, Date dueDate, String assignedTo, List<String> tags) {
        this.taskName = taskName;
        this.description = description;
        this.dueDate = dueDate;
        this.assignedTo = assignedTo;
        this.tags = tags;
        this.isCompleted = false;  // Default value
    }
}