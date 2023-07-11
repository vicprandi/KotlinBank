package bank.customer.exceptions.details

class CpfAlreadyExistsExceptionDetails private constructor() {
    var title: String? = null
    var details: String? = null

    companion object {
        fun newBuilder(): Builder {
            return Builder()
        }
    }

    class Builder {
        private val exceptionDetails: CpfAlreadyExistsExceptionDetails = CpfAlreadyExistsExceptionDetails()

        fun title(title: String): Builder {
            exceptionDetails.title = title
            return this
        }

        fun details(details: String): Builder {
            exceptionDetails.details = details
            return this
        }

        fun build(): CpfAlreadyExistsExceptionDetails {
            return exceptionDetails
        }
    }
}
