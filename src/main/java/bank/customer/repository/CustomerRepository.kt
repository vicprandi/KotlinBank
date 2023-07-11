package bank.customer.repository

import bank.model.Customer
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.util.*

/*
   Conceitos de CleanCode:
   1. Em Kotlin, podemos usar uma interface para definir o repositório usando a interface JpaRepository do Spring Data. Isso permite que o código seja mais conciso e legível.
   2. Os nomes das funções foram escolhidos para serem descritivos e expressar a intenção do que cada função faz. Isso melhora a legibilidade e compreensão do código.
   3. Os tipos de retorno das funções foram especificados explicitamente. Isso ajuda a deixar o código mais claro e evita ambiguidades.
   4. A anotação @Repository foi aplicada para indicar que a interface representa um repositório. Isso segue as convenções e boas práticas do Spring Framework.
*/

@Repository
interface CustomerRepository : JpaRepository<Customer, Long> {

    fun existsByCpf(cpf: String): Boolean

    override fun findById(id: Long): Optional<Customer>

    fun findByCpf(cpf: String): Optional<Customer>
}
