package bank.customer.exceptions

import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.ResponseStatus

@ResponseStatus(HttpStatus.CONFLICT)
class CpfAlreadyExistsException(message: String) : RuntimeException(message)
