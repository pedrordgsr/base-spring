Esta é uma API desenvolvida utilizando Java Spring e Spring Data JPA, permitindo a integração com um banco de dados PostgreSQL. Seu principal objetivo é gerenciar usuários por meio de operações CRUD.

### **Base URL**
`/api/usuarios`
### **Endpoints CRUD**
1. **Criar um Usuário**
    - **Método**: `POST`
    - **URL**: `/api/usuarios`
    - **Corpo da Requisição**:
``` json
     {
       "nome": "Pedro",
       "email": "pedro@example.com"
     }
```
- **Resposta**:
``` json
     {
       "id": 1,
       "nome": "Pedro",
       "email": "pedro@example.com"
     }
```
- **Descrição**: Cria um novo usuário e retorna o recurso criado.

1. **Listar Usuários**
    - **Método**: `GET`
    - **URL**: `/api/usuarios`
    - **Resposta**:
``` json
     [
       {
         "id": 1,
         "nome": "Pedro",
         "email": "pedro@example.com"
       },
       {
         "id": 2,
         "nome": "João",
         "email": "joao@example.com"
       }
     ]
```
- **Descrição**: Retorna uma lista de todos os usuários cadastrados.

1. **Buscar Usuário por ID**
    - **Método**: `GET`
    - **URL**: `/api/usuarios/{id}`
    - **Parâmetros de Caminho**:
        - `id`: ID do usuário.

    - **Resposta**:
``` json
     {
       "id": 1,
       "nome": "Pedro",
       "email": "pedro@example.com"
     }
```
- **Descrição**: Retorna os detalhes de um usuário específico por ID.

1. **Atualizar Usuário**
    - **Método**: `PUT`
    - **URL**: `/api/usuarios/{id}`
    - **Parâmetros de Caminho**:
        - `id`: ID do usuário a ser atualizado.

    - **Corpo da Requisição**:
``` json
     {
       "nome": "Pedro Atualizado",
       "email": "pedro_atualizado@example.com"
     }
```
- **Resposta**:
``` json
     {
       "id": 1,
       "nome": "Pedro Atualizado",
       "email": "pedro_atualizado@example.com"
     }
```
- **Descrição**: Atualiza os dados de um usuário específico pelo ID.

1. **Deletar Usuário**
    - **Método**: `DELETE`
    - **URL**: `/api/usuarios/{id}`
    - **Parâmetros de Caminho**:
        - `id`: ID do usuário a ser deletado.

    - **Resposta**:
        - **Status**:
            - `204 No Content` (em caso de sucesso).

    - **Descrição**: Remove um usuário do cadastro.
