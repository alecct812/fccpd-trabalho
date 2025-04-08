# Sistema de Gerenciamento de Eventos com RabbitMQ

Este projeto é um sistema distribuído de gerenciamento de eventos que utiliza RabbitMQ para filas de mensagens. Ele consiste em dois componentes principais: um produtor (Python) e consumidores (Java Spring Boot) para diferentes gêneros musicais.

## Colaboradores

<p><a href="https://github.com/alecct812">Alec Theotônio</a> 
<p><a href="https://github.com/lizandravieira">Lizandra Vieira</a> 
<p><a href="https://github.com/Ferraz27">Lucas Ferraz</a> 

## Visão Geral do Projeto

O sistema permite:
- Envio de notificações de eventos (novidades)
- Envio de alertas de eventos (alertas)
- Envio de alterações de eventos (mudanças)
- Auditoria de todas as mensagens

### Componentes

1. **Produtor (Python)**
   - Localizado no diretório `produtor`
   - Contém o script principal:
     - `ProdutoProjetoDeprecated.py`: Script unificado para enviar todos os tipos de mensagens

2. **Consumidores (Java Spring Boot)**
   - Localizado no diretório `ConsApplication`
   - Consumidores separados para diferentes gêneros musicais:
     - Consumidor Pop
     - Consumidor Rap
     - Consumidor Rock
   - Consumidor de Auditoria para rastreamento de todas as mensagens

## Pré-requisitos

- Java 17 ou superior
- Python 3.x
- Servidor RabbitMQ
- Maven
- pip (gerenciador de pacotes Python)

## Configuração e Instalação

1. **Configuração do RabbitMQ**
   - Instale o servidor RabbitMQ
   - Crie uma conta CloudAMQP ou use RabbitMQ local
   - Atualize os detalhes de conexão do RabbitMQ em `ConsApplication/src/main/resources/application.properties`

2. **Dependências Python**
   ```bash
   cd produtor
   pip install pika
   ```

3. **Dependências Java**
   ```bash
   cd ConsApplication
   mvn clean install
   ```

## Executando a Aplicação

### Iniciando os Consumidores

1. Navegue até o diretório ConsApplication:
   ```bash
   cd ConsApplication
   ```

2. Execute a aplicação ConsumeApplication:
   ```bash
      mvn spring-boot:run
   ```

3. Escolha um gênero musical quando solicitado:
   - 1 para Pop
   - 2 para Rap
   - 3 para Rock

### Executando o Produtor

1. Navegue até o diretório do produtor:
   ```bash
   cd produtor
   ```

2. Execute o script principal do produtor:
   ```bash
   python produtorrojetoDeprecated.py
   ```

## Tipos de Mensagens e Roteamento

- **Novidades**: Enviadas para todos os consumidores
- **Alertas**: Enviados para consumidores específicos de gênero
- **Mudanças**: Enviadas para consumidores específicos de gênero
- **Auditoria**: Todas as mensagens são registradas para auditoria

## Configuração

Atualize os detalhes de conexão do RabbitMQ em:
- `ConsApplication/src/main/resources/application.properties`
- `produtor/rabbitmq_config.py`

## Licença

Este projeto está licenciado sob os termos especificados no arquivo LICENSE.
