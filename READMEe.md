## Requisito 6 individual: Yago

Neste requisito escolhi adicionar um sistema de fidelidade, de forma que as classes de fidelidades pudessem ser inseridas e atualizadas de maneira dinamica através de um endpoint.

Foi adicionado ao Buyer uma informação de pontos para calcular a classe de fidelidade e um id respectivo.

Por fim ao finalizar uma compra um endpoint para oferecer um desconto ao usuário baseado no nível de fidelidade, e metade do valor da compra é adicionado ao progresso dos benefícios.
### <center> 💡 Features 💡</center> 
- Implementa um buyer com fidelidade.
- Implementa as diferentes classes de fidelidade.
- Adiciona pontos para progresso de fidelidade do buyer.
- Retorna um valor com desconto baseado no nível de fidelidade.
- Atualiza todos os buyers caso exista uma possibilidade de promoção, que também funciona caso uma nova fidelidade seja inserida no futuro.
<br>
<br>

### <center> 🛣️ Fidelity Routes 🛣️</center>
-  ⬅️ Get: getAllFidelity()
-  📪 Post: createFidelity()
<br>
<br>

|  HTTP  | URL MODEL                                | DESCRIPTION                                                                     |    US-CODE     |
|:------:|:-----------------------------------------|:--------------------------------------------------------------------------------|:--------------:|
| `POST` | /api/v1/fresh-products/fidelity/insert   | This route insert a new Fidelity                                    | ml-fidelity-06 |
| `GET`  | /api/v1/fresh-products/fidelity/listAll  | This route returns a list of all created Fidelity classes           | ml-fidelity-06 |

### <center> 🛣️ Buyer Routes 🛣️</center>
-  ⬅️ Get: getAllBuyer()
-  📪 Post: createBuyer()
-  ➡️ Put: levelUpFidelity()


|  HTTP  | URL MODEL                                | DESCRIPTION                                                                     |    US-CODE     |
|:------:|:-----------------------------------------|:--------------------------------------------------------------------------------|:--------------:|
| `POST` | /api/v1/fresh-products/buyer/insert   | This route insert a new Buyer                                                   | ml-fidelity-06 |
| `GET`  | /api/v1/fresh-products/buyer/listAll  | This route returns a list of all created Buyers                                 | ml-fidelity-06 |
| `PUT`  | /api/v1/fresh-products/buyer/levelUp     | This route updates all buyers that reached a threshold for the next avaiable Fidelity level          | ml-e-wallet-06 |


### <center> 🛣️ Cart Routes 🛣️</center>
-  ➡️ Put: updateDiscountStatus()


|  HTTP  | URL MODEL                                | DESCRIPTION                                                                     |    US-CODE     |
|:------:|:-----------------------------------------|:--------------------------------------------------------------------------------|:--------------:|
| `PUT`  | /api/v1/fresh-products/purchases/insert     | This Route sets the provided cart as finished and subtracts the quantities from the specific batchStock. It also adds the discounted total price according to the Fidelity discount and increases the Buyer score        | ml-Fidelity-06 |


### <center>⚗️ Cobertura de testes ⚗️ </center>
<center> - Faltou tempo para aplicar os testes no requisito individual </center>
<br>
<br>

###<center>Anexos </center>
[Rotas do Postman](https://www.getpostman.com/collections/3fdb0720a8daa648e47a)

###Modelo de EER do requisito
![alt text](https://cdn.discordapp.com/attachments/994271189616840765/1009238930375315576/scriptRequisitoYago.png)
<br>
<br>


<br>
<br>

