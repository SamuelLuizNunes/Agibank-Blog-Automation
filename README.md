# Projeto de Automação de Testes para o Agibank Blog

**Este projeto é uma automação de testes para um blog utilizando a linguagem Java com Selenium WebDriver, JUnit, Cucumber e o padrão Page Object.**

## Tecnologias Utilizadas

- **Java**: Linguagem principal utilizada.
- **Selenium WebDriver**: Para automação de testes de interface web.
- **JUnit**: Framework para execução de testes.
- **Cucumber**: Para execução de testes baseados em comportamento (BDD).
- **Maven**: Gerenciamento de dependências e build do projeto.
- **Page Object Model (POM)**: Padrão utilizado para melhorar a manutenção e reutilização de código nos testes.

## Como Utilizar

### 1. Baixar o Projeto

Clone o repositório utilizando o Git:

```bash
git clone https://github.com/SamuelLuizNunes/Agibank-Blog-Automation.git

2. Configurar a Máquina
Certifique-se de ter as seguintes ferramentas instaladas:

JDK (Java Development Kit): Pode ser baixado do site oficial da Oracle ou utilizando uma distribuição OpenJDK.
Maven: O Maven pode ser baixado do site oficial do Apache Maven.

3. Configurar o Ambiente de Desenvolvimento
Abra o projeto em sua IDE preferida (IntelliJ IDEA, Eclipse, etc.).

Certifique-se de que as configurações do projeto e as dependências do Maven estão corretamente configuradas.
Se necessário, execute o comando abaixo para garantir que todas as dependências sejam baixadas corretamente:

mvn clean install
4. Executar Testes Via Linha de Comando com Maven

Navegue até o diretório do projeto no terminal:
cd caminho/para/Agibank-Blog-Automation

Execute os testes com Maven:
mvn test
Este comando irá compilar o projeto, baixar as dependências e executar todos os testes automatizados definidos no projeto.

Padrão Page Object Model (POM)
O projeto segue o padrão Page Object Model (POM) para uma maior organização e reutilização de código. Isso facilita a manutenção dos testes, separando a lógica de interação com a interface da lógica de execução dos testes.

Testes com Cucumber
O Cucumber é utilizado para testes baseados em comportamento (BDD), permitindo que os testes sejam descritos em uma linguagem natural, mais fácil de entender por todos os membros da equipe. O Cucumber é integrado ao JUnit para execução dos testes.
