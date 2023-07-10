package bank.model

import bank.account.Account
import com.fasterxml.jackson.annotation.JsonIgnore
import jakarta.persistence.*
import java.time.LocalDate

@Entity
@Table(name = "customer")
data class Customer(
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        var id: Long? = null,

        @Column(name = "name", length = 100, nullable = false)
        var name: String? = null,

        @Column(name = "cpf", length = 11, nullable = false)
        @field:jakarta.validation.constraints.Pattern(regexp = "^[0-9]{11}$", message = "Cpf deve conter somente números e ser exatamente 11.")
        var cpf: String? = null,

        @Column(name = "postal_code", length = 50, nullable = false)
        @field:jakarta.validation.constraints.Pattern(regexp = "^[0-9]{8}$", message = "CEP deve conter somente números e ter tamanho exato de 8.")
        var postalCode: String? = null,

        @Column(name = "street", length = 100, nullable = false)
        @field:jakarta.validation.constraints.Pattern(regexp = "^[\\p{L}\\-]+(?: [\\p{L}\\-]+)*$", message = "Deve conter somente letras, caracteres especiais e o caractere '-'")
        var street: String? = null,

        @Column(name = "state", length = 50, nullable = false)
        @field:jakarta.validation.constraints.Pattern(regexp = "^[\\p{L}\\-]+(?: [\\p{L}\\-]+)*$", message = "Deve conter somente letras, caracteres especiais e o caractere '-'")
        var state: String? = null,

        @Column(name = "city", length = 50, nullable = false)
        @field:jakarta.validation.constraints.Pattern(regexp = "^[\\p{L}\\-]+(?: [\\p{L}\\-]+)*$", message = "Deve conter somente letras, caracteres especiais e o caractere '-'")
        var city: String? = null,

        @Column(name = "created_data")
        var createdData: LocalDate = LocalDate.now(),

        @OneToOne(mappedBy = "customer")
        @JsonIgnore
        var account: Account? = null
)
