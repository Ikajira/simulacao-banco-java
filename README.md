# 🏦 Proa Bank — Sistema Bancário em Java

**Simulação de um sistema bancário simples em Java**, com operações como consulta de saldo, saque, depósito, empréstimo e cartão de crédito via menu interativo no console.  
Projeto focado em lógica de programação e Programação Orientada a Objetos (POO) básica, ideal para estudo e prática de Java.

---

## 📌 Funcionalidades

O sistema permite ao usuário:

✔️ Verificar saldo da conta  
✔️ Realizar saques com validação de saldo  
✔️ Efetuar depósitos (com valor mínimo)  
✔️ Solicitar empréstimos (mediante saldo mínimo)  
✔️ Consultar aprovação de cartão de crédito  
✔️ Navegar por um menu interativo simples  

Todas as operações são feitas através do console via menu de opções.

---

## 📁 Estrutura do Projeto

O código principal está no package `rotina_bancaria`, contendo as classes que representam a lógica do banco, incluindo:

- **ContaBancaria.java** – classe que encapsula os dados e métodos da conta  
- **BancoPrincipal.java** – classe com o método `main` que inicia o sistema  
- Outros utilitários para entrada de dados e geração de ID de conta

---

## 🚀 Como Executar (Passo a Passo)

### 1. Clone o repositório
```bash
git clone https://github.com/Ikajira/simulacao-banco-java.git
javac rotina_bancaria/*.java
java rotina_bancaria.BancoPrincipal
