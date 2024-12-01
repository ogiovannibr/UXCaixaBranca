# Sistema de Autenticação de Usuários - Etapa 4

Este projeto consiste em uma implementação simples de autenticação de usuários utilizando Java e um banco de dados MySQL. Ele contém uma classe principal chamada `User`, que gerencia a conexão com o banco e valida as credenciais fornecidas.

---

## 📂 Estrutura do Projeto

O repositório contém uma única classe:

- **User**: Responsável por estabelecer a conexão com o banco de dados e verificar as informações de login e senha.

---

## 🔍 Visão Geral da Classe `User`

### Descrição
A classe `User` realiza a autenticação de usuários por meio de consultas SQL no banco de dados. Ela utiliza a API JDBC para gerenciar a comunicação com o banco.

### Componentes Principais

1. **Variáveis**:
   - `nome`: Armazena o nome do usuário após uma autenticação bem-sucedida.
   - `result`: Um valor booleano que indica se a autenticação foi bem-sucedida.

2. **Métodos**:
   - `conectarBD`: Estabelece uma conexão com o banco de dados.
   - `verificarUsuario`: Realiza a consulta ao banco de dados para verificar o login e a senha informados.

---

## 📄 Detalhes Técnicos

### Dependências
- **Java**: O projeto utiliza o JDK 8 ou superior.
- **MySQL Driver**: É necessário o driver JDBC para conexão ao banco de dados MySQL.

### Configurações
O método `conectarBD` contém as seguintes configurações para acessar o banco:
- **Host**: `127.0.0.1`
- **Usuário**: `lopes`
- **Senha**: `123`
- **Banco**: `test`

Certifique-se de ajustar essas configurações de acordo com o seu ambiente.

---

## 🛠️ Como Utilizar

1. Clone este repositório:
   ```bash
   git clone https://github.com/ogiovannibr/UXCaixaBranca/tree/main
