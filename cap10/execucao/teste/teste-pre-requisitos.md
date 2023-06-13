<h1>Pré-requisitos</h1>

## Objetivo 

Para conseguirmos testar a solução através da coleção do _Postman_, é necessário executar o passo a passo descrito na implementação (https://github.com/rpicanco/livro-eda/blob/main/cap10/execucao/implementacao/passo-a-passo.md).

As variáveis de ambiente definidas no _postman_ já estão de acordo com as portas definidas no `docker-compose.yml`. Por exemplo, para realizar/criar um pedido, o endpoint é `http:localhost:8085`.

### Simular o pagamento autorizado no mock do gateway de pagamento

O _Mockoon_ está configurado para retornar _pagamento autorizado_ ou _pagamento negado_ de acordo com o campo `payment.cardId` informado na requisição da criação do pedido.

| cardId                                | Resultado esperado   |
| ------------------------------------- | -------------------- |
| 1ec20487-0b63-4002-b486-3e583cef7707  | Pagamento autorizado |
| 92ff7af9-2028-4a0e-b25a-3bad64dde93c  | Pagamento negado     |

:point_right: Se informar um `payment.cardId` não configurado no _Mockoon_, o _mockoon_ retornará pagamento negado.