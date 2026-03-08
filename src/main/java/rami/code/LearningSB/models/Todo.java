package rami.code.LearningSB.models;

import jakarta.persistence.Entity;

@Entity
public class Todo {
long id;
String title;
String description;
Boolean isCompleted;
}
