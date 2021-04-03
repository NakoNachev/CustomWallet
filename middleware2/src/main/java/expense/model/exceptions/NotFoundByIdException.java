package expense.model.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class NotFoundByIdException extends RuntimeException {

    private Integer id;

    public NotFoundByIdException(Integer id){
        this.id = id;
    }

    @Override
    public String getMessage(){
        return String.format("Entity with id %s not found", this.id);
    }
}
