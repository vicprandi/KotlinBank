package bank.account

import bank.model.Customer
import bank.transaction.Transaction
import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonInclude
import jakarta.persistence.*
import java.math.BigDecimal
import java.time.LocalDate

@Entity
@Table(name = "account")
@JsonInclude(JsonInclude.Include.NON_NULL)
data class Account(
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        var id: Long? = null,

        @Column(name = "account_number", length = 50, nullable = false)
        var accountNumber: Long? = null,

        @JoinColumn(name = "customer_id", foreignKey = ForeignKey(name = "fk_account_customer"))
        @OneToOne
        @JsonIgnoreProperties(*["id", "cpf", "createdData", "postalCode", "street"])
        var customer: Customer? = null,

        @OneToMany(targetEntity = Transaction::class, mappedBy = "originAccount")
        var accountTransaction: List<Transaction>? = null,

        @Column(name = "balance_money", nullable = false)
        var balanceMoney: BigDecimal = BigDecimal.ZERO,

        @Column(name = "created_data")
        var createdData: LocalDate = LocalDate.now()
)
