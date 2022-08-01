package got.houses.exceptions

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestControllerAdvice
import javax.validation.ConstraintViolationException

@RestControllerAdvice
class ExceptionHandler {

    @ExceptionHandler(ConstraintViolationException::class)
    fun handleMethodArgumentNotValid(exception: ConstraintViolationException): ResponseEntity<Any> {
        val body: MutableMap<String, List<String>> = mutableMapOf()

        val errors = exception.constraintViolations.map { "${it.propertyPath} : ${it.message}" }

        body["errors"] = errors

        return ResponseEntity(body, HttpStatus.BAD_REQUEST)
    }

}