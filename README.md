# Estrutura da Aplicação

## Estrutura de Pastas

A seguir está uma descrição detalhada das pastas da aplicação, seguindo a arquitetura hexagonal.

### `config`
Nesta pasta, você encontrará as classes de configuração do aplicativo. Isso inclui configurações de framework, como o Spring, configurações de segurança, definições de beans e quaisquer outras configurações necessárias para o funcionamento da aplicação.

### `controller`
Aqui estão localizadas as classes responsáveis pelo controle do fluxo da aplicação. Os controladores lidam com as requisições HTTP, processam as entradas e encaminham para os serviços apropriados. Esta camada atua como a interface entre a camada de apresentação e a lógica de negócios.

### `domain`
A pasta `domain` contém as classes que representam o núcleo do domínio da aplicação. Aqui, você encontrará as regras de negócio e a lógica que governa o comportamento do sistema. Essa camada é independente de qualquer tecnologia externa ou framework.

### `dto`
Os objetos de transferência de dados (DTOs) são encontrados nesta pasta. Eles são usados para transferir dados entre as camadas da aplicação, especialmente entre a camada de apresentação e a camada de serviço. Os DTOs ajudam a desacoplar a estrutura interna da aplicação das representações usadas nas interfaces externas.

### `entities`
A pasta `entities` é onde estão localizadas as classes que representam as entidades do domínio que serão persistidas. Essas classes geralmente contêm as propriedades e métodos necessários para definir o estado e o comportamento das entidades em seu domínio.

### `exceptions`
Aqui estão definidas as exceções personalizadas da aplicação. Esta pasta é utilizada para gerenciar os diferentes tipos de exceções que podem ocorrer durante a execução do aplicativo, permitindo um tratamento de erros mais eficiente e legível.

### `mapper`
A pasta `mapper` contém as classes responsáveis pela conversão entre DTOs e entidades. Esses mapeadores são fundamentais para assegurar que as informações sejam transferidas de forma correta e eficiente entre as várias camadas da aplicação.

### `ports` (in e out)
- **in**: Contém as interfaces que definem as operações de entrada da aplicação, ou seja, como os serviços podem ser invocados. Isso estabelece um contrato para a lógica de negócios e permite uma maior flexibilidade na implementação.
- **out**: Esta pasta inclui as interfaces que definem as operações de saída. Isso geralmente envolve a comunicação com sistemas externos, como bancos de dados ou serviços de terceiros, permitindo que a aplicação interaja com o mundo exterior.

### `repositories`
Na pasta `repositories`, você encontrará as interfaces de repositório que definem os métodos de acesso aos dados. Elas são responsáveis por encapsular a lógica de acesso a dados e interação com a camada de persistência, permitindo a manipulação das entidades no banco de dados.

### `services`
A pasta `services` é onde estão localizadas as classes de serviço que contêm a lógica de negócios. Esses serviços são responsáveis por processar dados, aplicar regras de negócio e orquestrar chamadas para repositórios, controladores e outros serviços conforme necessário.

## Conclusão
Essa estrutura de pastas é fundamental para garantir que a aplicação siga os princípios da arquitetura hexagonal, promovendo a separação de preocupações e a facilidade de manutenção e teste da aplicação.