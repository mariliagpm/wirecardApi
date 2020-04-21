#language: pt
Funcionalidade: Incluindo um usuario

  Esquema do Cenario: Testar a criacao de um usuario
    Dado que eu fiz a leitura do meu arquivo json com o nome "<nomeArquivo>" 
    Quando faco a requisicao para criar o usuario
    Entao o codigo de retorno deve ser <codigo>
    E verifico o body da reposta de criacao de usuario
    Exemplos: 
      | codigo   |    nomeArquivo		  	|
      |      201 |	pessoa.json	  |

     	
     	
     	