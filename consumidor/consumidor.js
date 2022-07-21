const amqp = require('amqplib')

const fila = 'transaction'

amqp.connect({ 
    host: 'localhost',
    port: '5672',
    username: 'ADMIN',
    password: 123456
}) .then((conexao) => {
     conexao.createChannel()
         .then( (canal) => {

            canal.consume(fila, (mensagem) => {
                console.log(mensagem.content.toString())
            })
         })
         .catch((erro) => console.log(erro))

   })
  .catch((erro) => console.log(erro))