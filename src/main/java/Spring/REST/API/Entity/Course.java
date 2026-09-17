package Spring.REST.API.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer courseId;

    @NotNull(message = "Course name cannot be null!")
    @NotBlank(message = "Course name cannot be blank!")
    private String courseName;

    @NotNull(message = "Course type cannot be null!")
    @NotBlank(message = "Course type cannot be blank!")
    private String courseType;

    @NotNull(message = "Course description cannot be null!")
    @NotBlank(message = "Course description cannot be blank!")
    private String description;

    @NotNull(message = "Course duration cannot be null!")
    @NotBlank(message = "Course duration cannot be blank!")
    private String courseDuration;

    @NotNull(message = "Topic cannot be null!")
    @NotBlank(message = "Topic cannot be blank!")
    private String topic;

    @JsonIgnore
    @ManyToMany(mappedBy = "courses")
    private List<Student> students = new ArrayList<>();

}