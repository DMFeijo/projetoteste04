#language: pt
#encoding: iso-8859-1

Funcionalidade: Cadastrar Produto
como umusuario do sistema
eu quero cadstrar produto
para que eu possa gerenciar produtos

Cenário: Cadastrar produto com sucesso
Dado Acessar a pagina de cadastro deproduto
E Informar o nome do produto "Notebook"
E Informar o preco do produto "4000"
E Informar a quantidade do produto "10"
Quando Solicitar a realizacao do cadastro
Então Sistema exibe a mensagem "Produto cadastrado com sucesso."
