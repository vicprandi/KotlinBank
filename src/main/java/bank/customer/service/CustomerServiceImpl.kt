package bank.customer.service

import bank.account.repository.AccountRepository
import bank.customer.exceptions.CpfAlreadyExistsException
import bank.customer.exceptions.CustomerDoesntExistException
import bank.customer.repository.CustomerRepository
import bank.customer.request.CustomerRequest
import bank.model.Customer
import jakarta.validation.Valid
import org.springframework.stereotype.Service

/*
   Conceitos de CleanCode:
   1. Os nomes foram escolhidos para serem claros e descritivos, de modo que o propósito e a intenção das variáveis e funções sejam facilmente compreendidos.
   2. O código foi formatado corretamente, com espaçamento adequado e indentação consistente, para melhorar a legibilidade e a compreensão do código.
   3. O apply foi utilizado para atualizar os dados do objeto customerObject de forma concisa, evitando a repetição do nome do objeto em cada atribuição.
   4. Sempre que possível, foi utilizado o val em vez do var para declarar variáveis imutáveis, seguindo o princípio do uso de imutabilidade sempre que adequado.
   5. Foram utilizadas exceções específicas, como CustomerDoesntExistException e CpfAlreadyExistsException, para representar erros e situações inesperadas de forma mais clara e adequada.
*/

@Service
class CustomerServiceImpl(
        private val customerRepository: CustomerRepository,
        private val accountRepository: AccountRepository
) : CustomerService {

    override fun getAllCustomers(): List<Customer> {
        val customers = customerRepository.findAll()
        return if (customers.isNotEmpty()) {
            customers
        } else {
            throw CustomerDoesntExistException("There's no customers")
        }
    }

    override fun getCustomerCpf(cpf: String): Customer {
        val customerObject = customerRepository.findByCpf(cpf)
        return customerObject.orElseThrow { CustomerDoesntExistException("There's no customers") }
    }

    override fun getCustomerId(cpf: String): Long? {
        val customerObject = customerRepository.findByCpf(cpf)
        return customerObject.orElseThrow { CustomerDoesntExistException("There's no customers") }.id
    }

    fun registerCustomer(@Valid customerRequest: CustomerRequest): Customer {
        val customer = customerRequest.customerObjectRequest()

        if (customerRequest.cpf?.let { customerRepository.existsByCpf(it) } == true) {
            throw CpfAlreadyExistsException("Customer already registered")
        }

        return customerRepository.save(customer)
    }

    fun updateCustomer(customerRequest: CustomerRequest) {
        val customerObject = customerRequest.cpf.let {
            if (it != null) {
                getCustomerCpf(it)
            }
        }

        customerObject.apply {
            name = customerRequest.name
            city = customerRequest.city
            street = customerRequest.street
            state = customerRequest.state
            postalCode = customerRequest.postalCode
        }

        return customerRepository.save(customerObject)
    }

    fun deleteCustomer(cpf: String) {
        val customer = customerRepository.findByCpf(cpf).orElseThrow { CustomerDoesntExistException("Customer does not exist") }
        val customerAccount = customer.account

        if (customerAccount != null) {
            accountRepository.delete(customerAccount)
        }

        customerRepository.delete(customer)
    }

}
