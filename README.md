Projeto de transações bancárias


Projeto dividido em 3 microserviços:
ClientAPI: Esse microserviço cadastra um cliente e envia os dados para uma fila do RabbitMQ.
Desenvolvido em .NET, para sua execução é necessário compilar o projeto .dotnet e instalar os componentes .net SDK e .net RUNTIME.
Transaction-app: Esse microserviço consome a mensagem do ClientAPI via messageria (RabbitMQ) e o propósito seria armazenar o cliente com o saldo zerado. Salva e envia transações (INCOME/EXPENSE) via messageria para o microserviço balance-app/consumidor consumir e fazer o balanço de saldo.
Desenvolvido em Java 11 utilizando o framework Spring boot. Necessário a instalação do JDK 11 ou superior. 
Consumidor: Esse microserviço receberia de forma assincrona a mensagem enviada pelo Transaction-app, faria o balanço e salvaria o saldo bancário.
Desenvolvido em Node.js, necessita a instalação do Node.js para a execução.
Balance-app: Outra tentativa que receberia de forma assincrona a mensagem enviada pelo Transaction-app, faria o balanço e salvaria o saldo bancário.
Desenvolvido com Java 11 utilizando o framework Spring boot.
Todos utilizam o banco de dados Postgres.
