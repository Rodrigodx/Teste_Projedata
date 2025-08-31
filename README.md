## 📋 Descrição do Projeto

Este projeto foi desenvolvido como parte do processo seletivo da Projedata para a vaga de Desenvolvedor Java. A aplicação consite em gerenciamento de uma lista de funcionários, realizando diversas operações de inserção, remoção, atualização e consulta de dados.

## 💻 Sobre o Desafio

O objetivo era criar uma aplicação Java para manipular uma lista de funcionários, atendendo a uma série de requisitos específicos, como:
- Criação e herança de classes (`Pessoa` e `Funcionario`).
- Inserção de um conjunto predefinido de funcionários.
- Remoção de um funcionário específico.
- Aplicação de aumento salarial.
- Impressão de dados com formatação específica (datas e valores monetários).
- Agrupamento de funcionários por função.
- Consultas específicas (funcionário mais velho).
- Ordenação da lista por critério alfabético.
- Cálculos agregados (soma de salários) e individuais (quantidade de salários mínimos).

## 🛠️ Tecnologias Utilizadas
- **Java 17**
- **API Streams do Java 8+:** Utilizada extensivamente para manipulação de coleções 
- **Classes do pacote 'Java.Time':** `LocalDate`, `Period` e `DateTimeFormatter` para manipulação de datas.
- **`BigDecimal`:** Para garantir a precisão nos cálculos de salários e valores monetários.

  ## 🚀 Como executar o projeto

1.  **Pré-requisitos:**
    - Ter o JDK (Java Development Kit) na versão 11 (ou a sua versão) instalado.
    - Ter o Git instalado (opcional, para clonar o repositório).

2.  **Clonar o Repositório (Opcional):**
    ```bash
    git clone https://github.com/rodrigodx/Teste_Projedata
    cd Teste_Projedata
    ```

3.  **Compilar e Executar via Linha de Comando:**
    Navegue até a pasta `src` do projeto e execute os seguintes comandos:
    ```bash
    # Compilar as classes para a pasta 'out' (crie a pasta se não existir )
    javac -d ../out main/Pessoa.java main/Funcionario.java main/Main.java

    # Executar a classe principal
    java -cp ../out main.Main
    ```
    *(Observação: Ajuste os caminhos `main/` se a sua estrutura de pacotes for diferente)*

4.  **Executar via IDE:**
    - Importe o projeto na sua IDE de preferência (IntelliJ, Eclipse, etc.).
    - Localize a classe `Main.java`.
    - Clique com o botão direito e selecione "Run" ou "Executar".

## 🏛️ Arquitetura e Decisões de Design

- **Orientação a Objetos:** A estrutura foi baseada em duas classes principais, `Pessoa` e `Funcionario`, utilizando o conceito de **herança** para reutilizar os atributos comuns.
- **Imutabilidade e Precisão:** A classe `BigDecimal` foi escolhida para todos os atributos e cálculos monetários para evitar erros de arredondamento comuns em tipos `float` ou `double`. `LocalDate` foi usado para representar datas de forma robusta.
- **Programação Funcional com Streams:** A maioria das operações de manipulação de dados (filtros, mapas, ordenação, agrupamento e reduções) foi implementada utilizando a API de Streams do Java 8+. Essa abordagem resulta em um código mais conciso, legível e menos propenso a erros em comparação com laços `for` tradicionais.
- **Encapsulamento:** A lógica de formatação de dados para exibição (como no método `toString()`) foi encapsulada dentro da própria classe `Funcionario`, centralizando a responsabilidade de como um objeto deve ser representado.

## 📄 Licença
Este projeto foi desenvolvido para o processo seletivo da Projedata.

## ✒️ Autor

- **Rodrigo Barbosa Correia**
- **LinkedIn:** [https://www.linkedin.com/in/rodrigobcorreia/](https://www.linkedin.com/in/rodrigobcorreia/ )
- **GitHub:** [https://github.com/rodrigodx](https://github.com/rodrigodx)
