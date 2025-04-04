# SpringTodo API

API RESTful de gerenciamento de tarefas (Todo) em Spring Boot.

## Funcionalidades
- CRUD de tarefas.
- Atualização de status (`TODO`, `IN_PROGRESS`, `DONE`).
- Tratamento de erros customizado.

## Tecnologias
- Java 17
- Spring Boot 3.x
- H2 Database (em memória)
- JPA/Hibernate

## Como Executar
```bash
./gradlew bootRun
```

## Endpoints
- `GET /tasks/all` → Lista todas as tarefas.
- `GET /tasks/{id}` → Busca a tarefa pelo ID.
- `POST /tasks/save` → Cria uma nova tarefa.
- `PUT /tasks/update/{id}` → Atualiza uma tarefa pelo ID.
- `DELETE /tasks/delete/{id}` → Deleta uma tarefa pelo ID.
- `POST /tasks/{id}/status` → Atualiza o status de uma tarefa pelo ID. Precisa do envio do status.
