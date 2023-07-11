package bank.customer.request

import bank.model.Customer
import jakarta.validation.constraints.NotNull
import jakarta.validation.constraints.Pattern


/*
   Conceitos de CleanCode:
   1. Data class é usada para representar classes de dados simples. Ele gera automaticamente getters e ‘setters’, equals, hashCode e toString. Também permite uma inicialização mais concisa das propriedades.
   2.As propriedades foram declaradas como val, tornando-as imutáveis após a inicialização. Além disso, a anotação @NotNull foi adicionada para garantir que os valores não sejam nulos.
   3. A função customerObjectRequest() foi criada para converter um objeto CustomerRequest em um objeto Customer. Ela retorna diretamente uma instância de Customer usando a inicialização concisa com os parâmetros da classe.
*/


data class CustomerRequest(
        @NotNull(message = "{validation.field_required")
        val name: String? = null,

        @NotNull(message = "{validation.field_required")
        @Pattern(regexp = "^[0-9]{11}$", message = "Cpf deve conter somente números e ser exatamente 11.")
        val cpf: String? = null,

        @NotNull(message = "{validation.field_required")
        @Pattern(regexp = "^[0-9]{8}$", message = "CEP deve conter somente numeros e ser de tamanho exato de 8")
        val postalCode: String? = null,

        @NotNull(message = "{validation.field_required")
        @Pattern(regexp = "^[\\p{L}\\-]+(?: [\\p{L}\\-]+)*$", message = "Deve conter somente letras, caracteres especiais e o caractere '-'")
        val street: String? = null,

        @NotNull(message = "{validation.field_required")
        @Pattern(regexp = "^[\\p{L}\\-]+(?: [\\p{L}\\-]+)*$", message = "Deve conter somente letras, caracteres especiais e o caractere '-'")
        val state: String? = null,

        @NotNull(message = "{validation.field_required")
        @Pattern(regexp = "^[\\p{L}\\-]+(?: [\\p{L}\\-]+)*$", message = "Deve conter somente letras, caracteres especiais e o caractere '-'")
        val city: String? = null
) {
    fun customerObjectRequest(): Customer {
        return Customer(name = name, cpf = cpf, postalCode = postalCode, street = street, state = state, city = city)
    }
}
