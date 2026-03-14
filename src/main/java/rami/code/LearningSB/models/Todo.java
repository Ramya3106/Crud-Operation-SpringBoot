package rami.code.LearningSB.models;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
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
    @Schema(name= "title", example="Complete Spring Boot")
    String title;
    Boolean isCompleted;
}