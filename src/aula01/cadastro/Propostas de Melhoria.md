## Análise e Propostas de Melhoria do Sistema de Cadastro

A primeira melhoria estrutural para o diagrama de classes seria a substituição do array primitivo 
na classe CadastroPessoas por uma Collection nativa do Java, como o ArrayList<Pessoa>. 
O uso de um array estático exige a definição prévia de um tamanho máximo e o controle manual do índice 
através da variável qtdAtual. Utilizando uma lista dinâmica, o sistema ganharia flexibilidade para crescer
sob demanda, e também obteria métodos nativos como add(), remove() e size(), o que simplificaria a manutenção do código, 
eliminando o risco de erros de estouro de vetor.

Outro ponto de melhoria é a tipagem dos dados financeiros e de datas. No diagrama é proposto o uso do tipo float 
para o salário. No Java, para lidar com valores monetários e evitar problemas de arredondamento em cálculos de ponto 
flutuante (como o cálculo de impostos), é uma boa prática utilizar a classe BigDecimal. 

Podemos citar também, que a criação de uma classe customizada Data (com inteiros para dia, mês e ano) é redundante nas versões 
modernas do Java. Assim, podemos esta substituindo ela por java.time.LocalDate, que ofereceria validações automáticas de anos 
bissextos e formatação nativa, reduzindo a complexidade do sistema.

Por fim, no diagrama UML falta informações de modificadores de acesso (representados por +, - ou # na notação UML). 
Para garantir o princípio do encapsulamento, os atributos de todas as classes deveriam ser privados (private), sendo 
acessados e modificados apenas através de métodos Getters e Setters. Isso protegeria o estado interno dos objetos, 
impedindo, por exemplo, que o salário de um funcionário fosse alterado diretamente sem passar por regras de validação 
da classe.