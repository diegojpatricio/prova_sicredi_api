# RELATÓRIO DE BUG’S - DiegoPatrício

## Consultar uma restrição pelo CPF
•	A mensagem de retorno do status 200 não está correspondendo a documentação enviada. A mensagem de retorno deveria ser “O CPF 999999999 possui restrição”, ao invés de “O CPF 999999999 tem problema”.
•	O retorno da API com status 204 não está apresentando a mensagem “Não possui restrição”.

## Criar uma simulação
•	Após realizar testes foi identificado que ao cadastrar um CPF duplicado o status retornado é 400 com a mensagem "CPF duplicado", na qual deveria ser status 409 com mensagem “CPF já existente.

## Remover uma simulação
•	A descrição na documentação do Swagger informação informa que a remoção é atráves do cpf, porém o mesmo é feito através do ID.
•	Após realizar a request DELETE foi identificado que o status de sucesso retornado é 200 e não 204 como estabelecido na documentação.
•	A API está retornando o status 200 quando passado um ID inexistente. Deveria ser retornado o status 404 com a mensagem “Simulação não encontrata”, conformea regra de negócio.
