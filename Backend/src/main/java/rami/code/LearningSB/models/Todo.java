package rami.code.LearningSB.models;

import com.fasterxml.jackson.annotation.JsonSetter;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
public class Todo {
    @Id
    @GeneratedValue
    private Long id;
    @NotBlank
    @Schema(name= "title", example="Complete Spring Boot")
    private String title;
    private Boolean isCompleted;

    @JsonSetter("isCompleted")
    public void setIsCompleted(Object value) {
        if (value instanceof Boolean boolValue) {
            this.isCompleted = boolValue;
            return;
        }
        if (value instanceof String strValue) {
            this.isCompleted = Boolean.parseBoolean(strValue);
            return;
        }
        this.isCompleted = false;
    }
}
