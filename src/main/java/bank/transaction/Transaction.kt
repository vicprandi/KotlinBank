package bank.transaction

import bank.account.Account
import bank.kafka.TransferStatus
import com.fasterxml.jackson.annotation.JsonIgnore
import com.fasterxml.jackson.annotation.JsonInclude
import jakarta.persistence.*
import jakarta.validation.constraints.DecimalMin
import java.math.BigDecimal

@Entity
@Table(name = "account_transactions")
@JsonInclude(JsonInclude.Include.NON_NULL)
data class Transaction(
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        var id: Long? = null,

        @ManyToOne
        @JsonIgnore
        @JoinColumn(name = "origin_account_id", foreignKey = ForeignKey(name = "fk_transaction_origin_account"))
        var originAccount: Account? = null,

        @JoinColumn(name = "destination_account_id", foreignKey = ForeignKey(name = "fk_transaction_destination_account"))
        @ManyToOne
        @JsonIgnore
        var destinationAccount: Account? = null,

        @Column(name = "value", nullable = false)
        @DecimalMin(value = "0.00", message = "Value must be positive")
        var value: BigDecimal? = null,

        @Column(name = "transaction_type", length = 50)
        @Enumerated(EnumType.STRING)
        var transactionType: TransactionEnum? = null,

        @Column(name = "status", length = 50)
        @Enumerated(EnumType.STRING)
        var status: TransferStatus? = null
) {
    enum class TransactionEnum {
        WITHDRAW,
        DEPOSIT,
        TRANSFER
    }
}
