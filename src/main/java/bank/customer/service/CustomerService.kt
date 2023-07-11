package bank.customer.service

import bank.model.Customer

interface CustomerService {
    fun getAllCustomers(): List<Customer>
    fun getCustomerCpf(cpf: String): Customer?
    fun getCustomerId(cpf: String): Long?
}
