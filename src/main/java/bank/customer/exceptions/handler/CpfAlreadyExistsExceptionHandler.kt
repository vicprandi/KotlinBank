package bank.customer.exceptions.handler

import bank.customer.exceptions.CpfAlreadyExistsException
import bank.customer.exceptions.details.CpfAlreadyExistsExceptionDetails
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler

@ControllerAdvice
class CpfAlreadyExistsExceptionHandler {

    @ExceptionHandler(CpfAlreadyExistsException::class)
    fun handleCpfAlreadyExistsException(e: CpfAlreadyExistsException): ResponseEntity<CpfAlreadyExistsExceptionDetails> {
        val exceptionDetails = e.message?.let {
            CpfAlreadyExistsExceptionDetails.Builder()
                .details(it)
                .build()
        }
        return ResponseEntity(exceptionDetails, HttpStatus.CONFLICT)
    }
}
