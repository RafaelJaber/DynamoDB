[JAVA_BADGE]: https://img.shields.io/badge/java-%23ED8B00.svg?style=for-the-badge&logo=openjdk&logoColor=white
[SPRING_BADGE]: https://img.shields.io/badge/spring-%236DB33F.svg?style=for-the-badge&logo=spring&logoColor=white
[SWAGGER_BADGE]: https://img.shields.io/badge/-Swagger-%23Clojure?style=for-the-badge&logo=swagger&logoColor=white
[DYNAMODB_BADGE]: https://img.shields.io/badge/Amazon%20DynamoDB-4053D6?style=for-the-badge&logo=Amazon%20DynamoDB&logoColor=white

<h1 align="center" style="font-weight: bold;">DynamoDB - Player History</h1>

<div style="text-align: center;">

![java][JAVA_BADGE]
![spring][SPRING_BADGE]
![Swagger][SWAGGER_BADGE]
![DynamoDB][DYNAMODB_BADGE]

</div>

<p align="center">
 <a href="#tech">Tecnologias</a> • 
 <a href="#started">Getting Started</a> • 
 <a href="#routes">Endpoints da API</a> •
 <a href="#branches">Branches</a> •
 <a href="#colab">Colaboradores</a> • 
 <a href="#thanks">Agradecimentos</a>
</p>

O **Projeto DynamoDB - Player History** foi desenvolvido para aprimorar habilidades em **Java Spring Boot** e explorar a arquitetura Hexagonal e a comunicação com o DynamoDB. Este projeto tem como objetivo principal a implementação de uma arquitetura robusta para manipular processos distribuídos garantindo a consistência de dados.

## 💻 Tecnologias

Este projeto utiliza as seguintes tecnologias e frameworks:

- **Java 21**: Linguagem de programação utilizada para o desenvolvimento backend.
- **Spring Boot**: Framework que facilita a criação de aplicações Spring autônomas e de produção.
- **DynamoDB**: Banco de dados não relacional utilizado para persistência dos dados.
- **Lombok**: Biblioteca para reduzir a verbosidade do código Java.
- **MapStruct**: Biblioteca para criar o mapeamento de entidades.

<h2 id="started">🚀 Getting started</h2>

### Pré-requisitos

Antes de começar, certifique-se de ter os seguintes softwares instalados em sua máquina:

- **[Java 21](https://www.oracle.com/java/technologies/javase-jdk21-downloads.html)**: Linguagem de programação usada no backend do projeto.
- **[Git](https://git-scm.com/)**: Controle de versão para clonar o repositório do projeto.

### Adicionais

- **Um editor de texto** como IntelliJ IDEA para explorar e editar o código.
- **Postman** ou uma ferramenta similar para testar as APIs manualmente.
- **Conta AWS**: Uma conta na AWS para utilizar o DynamoDB.

### Configuração das Credenciais da AWS

É necessário configurar as credenciais da AWS nas variáveis de ambiente para que o Spring Boot possa acessá-las:

```yaml
spring:
  application:
    name: DynamoDB
jaber:
  aws:
    access-key: ${AWS_ACCESS_KEY}
    secret-key: ${AWS_SECRET_ACCESS_KEY}
```

Certifique-se de definir as seguintes variáveis de ambiente antes de iniciar o projeto:

```bash
export AWS_ACCESS_KEY=<sua_chave_de_acesso>
export AWS_SECRET_ACCESS_KEY=<sua_chave_secreta>
```

### Passo a Passo para Executar o Projeto

### 1. Clonar o Repositório

Abra um terminal e execute o comando para clonar o repositório:

```bash
git clone https://github.com/RafaelJaber/DynamoDB.git
```

### 2. Verificar Dependências

Certifique-se de que as seguintes ferramentas estão instaladas em seu sistema:

```bash
java -version
```

### 3. Configuração do Arquivo `application.yml`

Certifique-se de que as credenciais da AWS e as configurações do DynamoDB estejam definidas corretamente no arquivo `application.yml`:

```yaml
spring:
  application:
    name: DynamoDB
jaber:
  aws:
    access-key: ${AWS_ACCESS_KEY}
    secret-key: ${AWS_SECRET_ACCESS_KEY}
```

### 4. Criar a Tabela no DynamoDB

Execute o comando abaixo para criar a tabela `player_history_entity` no DynamoDB:

```text
PartitionKey: username
SortKey: game_id
```



### Acessos e Configurações

- **Swagger para a API**: [http://localhost:8080/swagger-ui/index.html](http://localhost:8080/swagger-ui/index.html#/)

<h2 id="routes">📍 Endpoints da API</h2>

| **Serviço**                 | **Endpoint**                                   | **Método** | **Descrição**                                                 |
|-----------------------------|------------------------------------------------|------------|---------------------------------------------------------------|
| `Find All Scores`           | `/v1/player-history/{username}`                | `GET`      | Buscar scores por jogador                                     |
| `Find Game Score By GameId` | `/v1/player-history/{username}/games/{gameId}` | `GET`      | Buscar um score pelo id do game e nome do jogador por jogador |
| `Create new Score`          | `/v1/player-history`                           | `POST`     | Cadastra um novo score                                        |
| `Update Score`              | `/v1/player-history/rafaeljaber`               | `PUT`      | Atualiza um score pelo ID do Game e nome do Jogador           |
| `Delete Score`              | `/v1/player-history/rafaeljaber`               | `DELETE`   | Deleta um score pelo ID do Game e nome do Jogador             |


<h2 id="colab">🤝 Colaboradores</h2>

<div style="display: flex; justify-content: space-around; align-items: center; margin-top: 20px;">

  <div style="text-align: center;">
    <a href="https://github.com/rafaeljaber" target="_blank">
      <img src="https://github.com/rafaeljaber.png" width="120px;" alt="Rafael Jáber Profile Picture" style="border-radius: 50%; border: 2px solid #ddd;"/>
      <br>
      <sub>
        <b>Rafael Jáber</b>
      </sub>
    </a>
    <p style="font-style: italic;">Desenvolvedor</p>
  </div>

</div>

<h2 id="thanks">🙏 Agradecimentos</h2>

Gostaria de expressar minha sincera gratidão a todos que contribuíram para a realização deste projeto:

- **Build & Run**: Pelos excelentes conteúdos no youtube e a instrução que foi usada como base para este projeto.
- **Comunidade Open Source**: Pelo desenvolvimento e manutenção das ferramentas e frameworks que possibilitaram a construção deste projeto.
- **Você, Leitor**: Agradeço por dedicar seu tempo para explorar este projeto. Espero que ele possa inspirar e auxiliar em seus próprios empreendimentos. Seu interesse e feedback são valiosos para mim.

Sua contribuição e suporte foram essenciais para o sucesso deste projeto. Muito obrigado!

**Obrigado por acompanhar e apoiar este trabalho!**