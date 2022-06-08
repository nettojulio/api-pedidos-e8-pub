# EQUIPE 8 - Bola 8 - Desafio Final iLab

## API de Pedidos

Uma aplicação para fazer pedidos de usuários. Atributos: id, usuario_id, valor total, descrição dos produtos,
data do pedido e status. Para utilizar esta API, esta aplicação deverá ser autenticada pela aplicação
de administradores, passando o token JWT.

Repositório do Front-end, clique aqui: https://github.com/equipe8-final-ilab/frontend-e8

Repositório da API de administradores: https://github.com/equipe8-final-ilab/api-administrador-e8

Repositório da API de usuários: https://github.com/equipe8-final-ilab/api-usuarios-e8

Link do Jira: https://grupo8ilab.atlassian.net/jira/software/projects/G8ILAB/boards/2/roadmap

## Variáveis de Ambiente

Para rodar esse projeto separadamente, você vai precisar adicionar as seguintes variáveis de ambiente no seu 
application.properties:

`RDS_HOSTNAME`, `RDS_USERNAME`, `RDS_PASSWORD`, `RDS_PORT`, `RDS_ORDER_DB_NAME`

## Instalação

Ou, dentro do diretório raiz do projeto, rodar no terminal o seguinte comando:

```
$ docker-compose up
```

para rodar os containers docker das três APIs conjuntamente, a partir das respectivas imagens no docker, uma vez já tendo o Docker previamente instalado e rodando na sua máquina.

## Autores

- [@JessieZan](https://www.github.com/JessieZan)
- [@nettojulio](https://www.github.com/nettojulio)
- [@Raphaella-leite](https://github.com/Raphaella-leite)
- [@queziabalonecker](https://github.com/queziabalonecker)
- [@Edvan-Jr](https://github.com/Edvan-Jr)

## Stack utilizada

**Front-end:** React.

**Back-end:** Java, SpringBoot, PostgreSQL, RDS.


## Documentação da API

### End-Points

### Cadastrar Pedidos

```http
  POST /pedidos
```

#### Dados Enviados

| Chave   | Tipo       | Descrição                           |
| :---------- | :--------- | :---------------------------------- |
| `usuarioId` | `Integer` | id do usuario **Obrigatório** |
| `valorTotal` | `Double` | O valor da soma dos preços de cada item do pedido **Obrigatório** |
| `dataPedido` | `LocalDateTime` | Dia e hora da solicitação do pedido **Obrigatório** |
| `descricao` | `String` | Lista com os nomes, quantidades e preços de cada item do pedido **Obrigatório** |
| `status` | `String` | Se o pedido está pedente ou concluído **Obrigatório** |


#### Body
```http
{
	"usuarioId": 4,
	"valorTotal": 21.00,
	"dataPedido": "2022-06-06T11:00:09",
	"descricao": "Marmite + Mini Refri",
	"status": "Pendente"
}
```

#### Dados Recebidos
```http
{
	"id": 3,
	"usuarioId": 4,
	"valorTotal": 21.0,
	"descricao": "Marmite + Mini Refri",
	"dataPedido": "2022-06-06T11:00:09",
	"status": "Pendente"
}
```

#### (201) Created ou Erro(400) Bad Request

---


### Listar Pedidos

```http
  GET /pedidos
```

#### Dados Enviados

| Chave   | Tipo       | Descrição                                   |
| :---------- | :--------- | :------------------------------------------ |
| `token` | `bearer` | token bearer de acesso do usuario **Obrigatório** |

#### Exemplo
```http
{
	"token": "Bearer eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJJdGFsb19Db3N0YSwyLGl0YWxvQGVtYWlsLmNvbSw3MTEyMzQ1Njc4OSIsImlzcyI6IkZvb2RMb3ZlcnMiLCJleHAiOjE2NDg3ODA4Nzl9.0UW7jMU8_S9VvluB3tMDvwRHAbp6ZcMoCoyFRrO6Udk"
}
```

#### No Body

#### Dados Recebidos

```http
[
  	{
		"id": 3,
		"nome": "Julio",
		"cpf": "12345678901",
		"email": "julio.neto@ifood.com.br",
		"telefone": "71996498435",
		"dataNascimento": "1988-11-09T00:00:00.000+00:00"
	},
	{
		"id": 4,
		"nome": "Edvan",
		"cpf": "11122233300",
		"email": "edvan.junior@ifood.com.br",
		"telefone": "48999952515",
		"dataNascimento": "1986-04-01T00:00:00.000+00:00"
	}
]
```

#### (200) OK ou Erro(401) Unauthorized

---


### Buscar Pedido por id do Pedido

```http
  GET /pedidos/{id}
```

#### Dados Enviados

| Variável   | Tipo       | Descrição                                   |
| :---------- | :--------- | :------------------------------------------ |
| `id`      | `Integer` | PathVariable identificadora do pedido a ser encontrado |

#### **No Body

#### Dados Recebidos

```http
{
	"id": 3,
	"usuarioId": 4,
	"valorTotal": 21.0,
	"descricao": "Marmite + Mini Refri",
	"dataPedido": "2022-06-06T11:00:09",
	"status": "Pendente"
}
```

#### (200) OK, Erro(401) Não Autorizado

---

### Buscar Pedido por id do Usuário

```http
  GET /pedidos/usuario/{id}
```

#### Dados Enviados

| Variável   | Tipo       | Descrição                                   |
| :---------- | :--------- | :------------------------------------------ |
| `id`      | `Integer` | PathVariable identificadora do usuario vinculado ao(s) pedido(s) a ser(em) encontrado(s) |

#### **No Body

#### Dados Recebidos

```http
[
	{
		"id": 1,
		"usuarioId": 1,
		"valorTotal": 12.99,
		"descricao": "Milk Shake2",
		"dataPedido": "2022-06-01T19:35:09",
		"status": "Pendente"
	},
	{
		"id": 4,
		"usuarioId": 1,
		"valorTotal": 20.54,
		"descricao": "Cachorro-quente",
		"dataPedido": "2022-06-07T15:58:18.276477",
		"status": "Pendente"
	}
]
```

#### (200) OK, Erro(401) Não Autorizado

---

### Alterar Pedido

```http
  PUT /pedidos/{usuarioId}
```

---

### Deletar Pedido

```http
 DELETE /pedidos/{id}
```
