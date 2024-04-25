# **A3-Gestao-de-Software**

Materia: Gestão e qualidade de software  
Equipe: Carlos Henrique Braga Bomfim (12723211573)  
Marcos Guilherme Silva da Crus (12723123780)  
Jailson Neiva ()

---
# **Tabela de conteúdos**

1. [Introdução](#introdução)
2. [Tecnologias Utilizadas](#tecnologias-utilizadas)
3. [Instalação](#instalação)
4. [Como Usar](#como-usar)
5. [Endpoints da API](#endpoints-da-api)
6. [Exemplos](#exemplos)
7. [Licença](#licença)

----
# **Introdução**

O projeto de integração contínua A3 é uma iniciativa no âmbito da disciplina de Gestão e Qualidade de Software, com o objetivo de explorar e implementar práticas de integração contínua em um ambiente de desenvolvimento de software. Este projeto busca aplicar conceitos e ferramentas que visam melhorar a eficiência, a qualidade e a confiabilidade do processo de desenvolvimento de software.

Neste contexto, o projeto se propõe a criar um sistema de integração contínua para automatizar o processo de construção, testes e implantação de um software fictício. Ao longo do desenvolvimento, serão utilizadas diversas técnicas e ferramentas para garantir a qualidade do código, identificar e corrigir problemas precocemente, e facilitar a colaboração entre os membros da equipe de desenvolvimento.

Este README fornecerá uma visão geral do projeto, incluindo sua finalidade, escopo, requisitos, tecnologias utilizadas, instruções de instalação e utilização, bem como informações adicionais sobre a equipe e o desenvolvimento do projeto

---
# **Tecnologias Utilizadas**
- **Java**: Linguagem de programação amplamente utilizada para o desenvolvimento de aplicativos backend. Oferece uma ampla gama de recursos e é altamente escalável.

- **Spring Boot**: Framework de aplicativo Java que simplifica o desenvolvimento de aplicativos Spring, fornecendo uma configuração pronta para uso para criar rapidamente aplicativos standalone.

- **Maven**: Ferramenta de gerenciamento de projetos de código aberto que lida com compilação, relatórios e documentação de projetos Java. Facilita o gerenciamento de dependências e a construção do projeto.

- **H2 Database**: Banco de dados relacional em memória escrito em Java. É uma excelente escolha para desenvolvimento e testes devido à sua natureza leve e capacidade de ser executado em memória, o que simplifica a configuração e a execução de testes automatizados.

- **Mockito**: Framework de teste para Java que permite a criação de mocks de objetos em testes unitários. Facilita a simulação de dependências e comportamentos de objetos, tornando os testes mais isolados e confiáveis.

- **Postman**: Ferramenta de colaboração para testar, desenvolver e documentar APIs. Permite enviar e receber solicitações HTTP de forma rápida e eficiente, facilitando o teste e a depuração de APIs durante o desenvolvimento.
---
# **Instalação**

1. Clone o repositório:  
`git clone https://github.com/seu-usuario/seu-repositorio.git`
2. Acesse o diretório do projeto:  
`   cd seu-repositorio`
3. Instale as dependências:  
`   mvn clean install`
4. Configure o banco de dados:   
O projeto utiliza um banco de dados H2 em memória por padrão. Não é necessário configurar nada além das dependências do maven
5. Inicie o aplicativo:  
`mvn spring-boot:run
`
---
# **Como usar**

**1. **Acesse a API**:**  
- **Após iniciar o aplicativo localmente, você pode acessar os endpoints da API em http://localhost:8080.**  
**2. **Enviar Requisições**:**
- **Utilize ferramentas como o Postman para enviar requisições HTTP para os endpoints da API.**
**3. **Endpoints Disponíveis:****
- **Consulte a seção de "Endpoints da API" para obter uma lista completa dos endpoints disponíveis e suas respectivas funcionalidades.**
**4. **Testar Funcionalidades**:**  
- **Explore os diferentes endpoints disponíveis para criar, atualizar, visualizar ou excluir recursos, dependendo das funcionalidades oferecidas pela API.**
**5. **Interpretar Respostas:****
- **Certifique-se de interpretar corretamente as respostas da API, incluindo códigos de status HTTP e possíveis mensagens de erro.**
**6. **Integrar com Outros Sistemas:****
- **Integre a API com outros sistemas conforme necessário para atender aos requisitos do seu projeto ou aplicação.**
**7. **Experimente Diferentes Casos de Uso:****
- **Teste a API em diferentes cenários e casos de uso para garantir que ela atenda aos requisitos e expectativas do seu projeto.**  
---
# **Endpoints da API**
1. **Cadastro de Usuário:**
- **POST /cadastro: Cria um novo usuário no sistema.**
- **GET /cadastro: Retorna a lista de todos os usuários cadastrados.**
  ****2. Calculadora IMC:****
- **GET /imcCalculator: Retorna a tabela de classificação do Índice de Massa Corporal (IMC).**
---
# **Testes**  






