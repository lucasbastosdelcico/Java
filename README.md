# Sistema de Gerenciamento de Funcionários

Este é um projeto em Java que permite gerenciar diferentes tipos de funcionários em uma empresa. O projeto consiste em uma classe abstrata `Funcionario` que abriga informações genéricas para todos os tipos de funcionários, e quatro classes filhas (`Estagiario`, `Secretaria`, `Gerente` e `Presidente`) que herdam dessa classe e implementam detalhes específicos para cada tipo de funcionário.

## Estrutura do Projeto

- `Funcionario.java`: Classe abstrata que define informações genéricas sobre os funcionários.
- `Estagiario.java`, `Secretaria.java`, `Gerente.java`, `Presidente.java`: Classes filhas que herdam de `Funcionario` e implementam detalhes específicos.
- `Empresa.java`: Classe responsável por gerenciar os funcionários, incluindo métodos para adicionar, calcular salários, aumentar salários e gerar relatórios.
- `Main.java`: Classe principal onde se instancia a classe `Empresa` e se acessa os métodos para interagir com os funcionários.

## Utilização

Para utilizar o projeto, siga os passos abaixo:

1. Clone o repositório para sua máquina local:

```bash
git clone https://github.com/lucasbastosdelcico/Java.git
