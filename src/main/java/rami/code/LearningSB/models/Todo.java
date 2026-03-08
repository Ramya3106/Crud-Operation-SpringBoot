package rami.code.LearningSB.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Todo {
    @Id
    @GeneratedValue
long id;
String title;
String description;
Boolean isCompleted;
}
