package Spring.REST.API.Exceptions;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class CourseException extends Exception {

    public CourseException(String msg) {
        super(msg);
    }

}
