
# INSTRU��ES

##Para compilar, buildar e executar o programa:

1. Crie um projeto no Eclipse ou em sua IDE preferida.
2. Adicione os arquivos da pasta simple-project ao projeto.
3. No caso do Eclipse, exporte seu projeto para o formato "runnamble jar" (jar execut�vel).
4. Coloque o arquivo log.txt na pasta do jar.
5. Execute o programa da seguinte forma

```shellscript
$ java -jar <nome_do_arquivo_jar>.jar <nome_do_arquivo_de_log>.txt
```

# COMENT�RIOS

* A proposta do programa � relativamente simples. Assim sendo, busquei n�o complicar. Utilizei a metodologia TDD, criando primeiro os testes, que ao serem executados, falharam por n�o ter as classes implementadas. Depois criei a classe para fazer o teste passar.

* Embora eu tenha visto a branch de dev, n�o vi instru��es para fazer os commits nesta branch. N�o vi instru��es se dev�amos usar GitLab flow ou semelhante. Ent�o busquei fazer da forma mais simples.

* Sei que o melhor para se fazer s�o commits at�micos. Todavia, como s� consegui mexer no c�digo hoje, apenas quis demonstrar o conceito neste teste. Num projeto real eu faria um commit por funcionalidade nova, segundo recomendado na bibliografia �gil.

* N�o fiz o b�nus de marcar a hora porque se trata apenas de uma repeti��o dos conceitos j� utilizados no c�digo.

* Comitei tamb�m uma pasta chamada EXECUT�VEL. Sei que colocar execut�veis no git � CONCEITUALMENTE ERRADO. O reposit�rio � apenas um reposit�rio de C�DIGO. Entretanto, para facilitar o trabalho de voc�s ao executar o c�digo, podem fazer download daquele jar e executar apenas a linha de comando especificada.
