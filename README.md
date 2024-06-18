# **A3-Gestao-de-Software**

Materia: Gestão e qualidade de software  

Equipe: 
Carlos Henrique Braga Bomfim (12723211573)  
Marcos Guilherme Silva da Crus (12723123780)    
Jailson Rodrigues de Neiva (12722131344)  
Júlio César Souza (12723120855)  
Lucas Ribeiro Santiago Nunes (12722118292)  
Marcos Guilherme Silva da Cruz (12723213780)  
Vinícius Ariel Ribeiro dos Santos (1232318365)  
Davi dos Reis da Fonseca Ramos - 1272316509

Link da apresentação no YouTube: https://youtu.be/kwEp0FDoAZo
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
# **Estrutura dos Testes**
- **Framework de Testes:** Utilizamos JUnit 5 para estruturar os testes.
- **Simulação de Dependências:** Usamos Mockito para simular interações com o repositório ImcRepository.
---
# **Casos de Teste**
**1.** **Exibir Tabela IMC**
Propósito: Testar o método exibirTabelaImc, garantindo que ele retorna a lista de registros como objetos ImcTableDto.
Testes Realizados:
- **Caso 1**: Verificou se a tabela era exibida corretamente com valores simulados.
  
- **Caso 2**: Testou a exibição da tabela sem dados para garantir que o resultado seria uma lista vazia.
  
**2.** **Cálculo do IMC**
Propósito: Testar o método calculoImca, que calcula o IMC com base em peso e altura e retorna uma classificação correspondente.
Testes Realizados:
 - **Caso 1:** Testou a classificação do IMC no intervalo "Normal", garantindo que o método calculasse o valor do IMC e atribuísse a classificação correta.

 - **Caso 2:** Testou uma condição de "Baixo Peso", verificando se o método funcionava como esperado.

 - **Caso 3:** Testou uma condição de "Obesidade Grau I", garantindo a precisão do cálculo e a atribuição correta da classificação.
    
 - **Caso 4:** Testou uma condição fora do intervalo conhecido, garantindo que o método retornasse uma classificação nula para valores de IMC fora dos limites conhecidos.

**3.** **Testes para Criação de Usuários**
  
- **Teste de Criação de Usuário com Dados Válidos:** Este teste verificou a criação de um usuário com dados válidos. Confirmamos que o método novoUsuario chama o método save do repositório corretamente e que o UsuarioDTO retornado contém os dados esperados.
Incluímos verificações para cada campo do DTO, garantindo que os valores correspondem aos do objeto Usuario original.

- **Teste de Criação de Usuário com Dados Inválidos:** Este teste simulou a tentativa de criar um usuário com dados inválidos, como campos obrigatórios ausentes ou valores incorretos. O teste verificou como o sistema lida com campos como CPF, e-mail e outros valores importantes.

-  **Teste de Salvamento do Repositório:** Este teste verificou se o método save do repositório foi chamado com o objeto Usuario correto, garantindo que o repositório está sendo usado corretamente pelo serviço.

-  **Teste de Exceção ao Salvar no Repositório:** Este teste simulou uma exceção ao salvar no repositório para verificar como o serviço lida com falhas durante a persistência de dados.

 # **Conclusão**
Os testes realizados abordaram casos de teste importantes para o método calculoImca e para a exibição da tabela IMC. Durante o processo, problemas foram identificados e corrigidos, garantindo que os testes fossem executados com sucesso. Com esses testes, foi possível verificar a funcionalidade correta do serviço ImcCalculatorService, bem como a precisão e a robustez do cálculo do IMC.

