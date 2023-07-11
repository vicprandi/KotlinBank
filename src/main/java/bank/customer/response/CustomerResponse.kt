package bank.customer.response


/*
   Conceitos de CleanCode:
   1. A propriedade name foi declarada como private, garantindo que ela não seja acessível externamente à classe. Isso segue o princípio de encapsulamento, mantendo os detalhes internos ocultos.
   2. O construtor da classe recebe o parâmetro name e atribui seu valor à propriedade name. A propriedade name é declarada como val, tornando-a imutável após a inicialização. Isso segue o princípio de imutabilidade, fornecendo objetos que não podem ser alterados após a criação.
   3.O  método getName() é fornecido para acessar o valor da propriedade name. Isso encapsula o acesso à propriedade e fornece um ponto de acesso consistente. Também permite que a implementação interna da classe seja alterada sem afetar o código externo que depende do método de acesso.
*/

data class CustomerResponse(val name: String)