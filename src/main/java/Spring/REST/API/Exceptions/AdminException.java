package Spring.REST.API.Exceptions;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class AdminException extends Exception{

    public AdminException(String message) {
        super(message);
    }
}
