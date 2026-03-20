# 🛒 Ecommerce POO

> Sistema de E-Commerce desenvolvido em Java, aplicando os principais conceitos de Programação Orientada a Objetos (POO).

---

## 📋 Descrição

Projeto acadêmico de um sistema de e-commerce que implementa conceitos fundamentais de POO como **herança**, **polimorfismo**, **interface**, **encapsulamento**, **exceções customizadas** e o padrão de projeto **Fachada (Facade)**. O sistema permite que clientes comprem produtos, gerenciem seu perfil e tipo de cartão, além de possibilitar que o suporte gerencie o estoque.

---

## ✨ Funcionalidades

- 🛍️ **Compra de produtos** por nome ou código de barras
- 👤 **Gerenciamento de perfil** do cliente (consulta de saldo, fatura e dados pessoais)
- 💳 **Cartão Prata** — limite de 20% do salário
- 💎 **Cartão Black (VIP)** — limite de 50% do salário com 20% de desconto nas compras
- 🔐 **Área de Suporte** protegida por senha, com:
  - Adição, remoção e alteração de produtos no estoque
  - Importação de produtos via arquivo CSV

---

## 🏗️ Arquitetura do Projeto

```
Ecommerce_POO/
├── src/
│   ├── Dados/
│   │   ├── Cartao.java               # Classe abstrata base para cartões
│   │   ├── CartaoPrata.java          # Cartão padrão (20% do salário de limite)
│   │   ├── CartaoBlack.java          # Cartão VIP (50% do salário, 20% de desconto)
│   │   ├── Cliente.java              # Entidade cliente com carrinho de compras
│   │   ├── Produto.java              # Entidade produto
│   │   ├── InterfaceRepositorio.java # Interface do repositório de produtos
│   │   ├── Fachada.java              # Padrão Facade — ponto central de acesso
│   │   ├── produtos.csv              # Dados de produtos para importação
│   │   └── senha.txt                 # Senha de acesso ao painel de suporte
│   ├── Repositorio/
│   │   └── RepositorioProduto.java   # Implementação do repositório (CRUD de produtos)
│   ├── Excecoes/
│   │   ├── DuplicateProductCodeException.java          # Código de produto duplicado
│   │   ├── DuplicateProductInShoppingCartException.java # Produto já no carrinho
│   │   └── ProductNotFoundException.java               # Produto não encontrado
│   └── Teste/
│       ├── Main.java                 # Ponto de entrada da aplicação
│       └── Suporte.java              # Interface de gerenciamento do estoque
└── README.md
```

---

## 🚀 Como Executar

### Pré-requisitos

- [Java JDK 17+](https://www.oracle.com/java/technologies/downloads/)

### Compilação

Na raiz do projeto, compile todos os arquivos `.java`:

```bash
javac -d out -sourcepath src src/Teste/Main.java
```

### Execução

```bash
java -cp out Teste.Main
```

> **Importante:** Execute a partir da raiz do projeto para que os arquivos `src/Dados/senha.txt` e `src/Dados/produtos.csv` sejam encontrados corretamente.

---

## 🗂️ Conceitos de POO Aplicados

| Conceito | Onde é aplicado |
|---|---|
| **Herança** | `CartaoPrata` e `CartaoBlack` herdam de `Cartao` |
| **Polimorfismo** | Método `debitar()` sobrescrito em cada tipo de cartão |
| **Abstração** | Classe abstrata `Cartao` e interface `InterfaceRepositorio` |
| **Encapsulamento** | Atributos privados com getters/setters em todas as classes |
| **Exceções** | Classes customizadas em `src/Excecoes/` |
| **Facade** | Classe `Fachada` centralizando o acesso aos subsistemas |
| **CRUD** | `RepositorioProduto` implementando operações de Create, Read, Update e Delete |

---

## 📄 Documentação

Acesse o documento de especificação do projeto:
👉 [Documento no Google Docs](https://docs.google.com/document/d/1tKk3JV5HNEeMhhaFs6ITvjpN58FAf2Vy1Wtx1K8v8bM/edit?usp=sharing)

---

## 🛠️ Tecnologias

- **Java** — linguagem principal
- **Java Collections** — `HashMap`, `ArrayList`, `List`
- **Java IO** — leitura de arquivos CSV e TXT

---

*Projeto desenvolvido para a disciplina de Programação Orientada a Objetos.*
