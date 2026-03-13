package rami.code.LearningSB.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.NonNull;
import org.antlr.v4.runtime.misc.NotNull;
import org.hibernate.annotations.NotFound;

@Entity
@Data
public class Todo {
    @Id
    @GeneratedValue
Long id;
    @NotNull
    @NotBlank
String title;
    @NotNull
    @NotBlank
String description;
Boolean isCompleted;
@Email
String email;
}
