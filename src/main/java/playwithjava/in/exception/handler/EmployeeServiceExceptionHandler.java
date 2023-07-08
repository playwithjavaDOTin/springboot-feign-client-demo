package playwithjava.in.exception.handler;


import lombok.extern.slf4j.Slf4j;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;
import playwithjava.in.exception.DuplicateEntityException;
import playwithjava.in.exception.EntityNotFoundException;
import playwithjava.in.exception.ErrorBean;

@ControllerAdvice
@Slf4j
@Order(Ordered.HIGHEST_PRECEDENCE)
public class EmployeeServiceExceptionHandler {


    @ExceptionHandler(value = {EntityNotFoundException.class})
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ResponseEntity<ErrorBean> entityNotFound(EntityNotFoundException ex, WebRequest request) {
        ErrorBean errorBean=new ErrorBean();
        errorBean.setErrorMessage("Entity not found exception !!");
        errorBean.setErrorCode("PY001");
        errorBean.setMessage("Entity is not available in system");
        errorBean.setCode("404");
        return new ResponseEntity<ErrorBean>(errorBean, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(value = {DuplicateEntityException.class})
    @ResponseStatus(HttpStatus.CONFLICT)
    public ResponseEntity<ErrorBean> duplicateEntityException(DuplicateEntityException ex, WebRequest request) {
        ErrorBean errorBean=new ErrorBean();
        errorBean.setErrorMessage("Duplicate entity not allowed.");
        errorBean.setErrorCode("PY002");
        errorBean.setMessage("Constraints violation exception");
        errorBean.setCode("409");
        return new ResponseEntity<ErrorBean>(errorBean, HttpStatus.CONFLICT);
    }


   /* @ExceptionHandler(value = {Exception.class})
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ResponseEntity<ErrorBean> duplicateEntityException(Exception ex, WebRequest request) {
        ErrorBean errorBean=new ErrorBean();
        errorBean.setErrorMessage("Something went wrong.");
        errorBean.setErrorCode("PY002");
        errorBean.setMessage("please contact system admin.");
        errorBean.setCode("500");
        return new ResponseEntity<ErrorBean>(errorBean, HttpStatus.INTERNAL_SERVER_ERROR);
    }*/

}
