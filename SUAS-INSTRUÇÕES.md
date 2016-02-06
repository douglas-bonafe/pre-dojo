
# INSTRUÇÕES

##Para compilar, buildar e executar o programa:

1. Crie um projeto no Eclipse ou em sua IDE preferida.
2. Adicione os arquivos da pasta simple-project ao projeto.
3. No caso do Eclipse, exporte seu projeto para o formato "runnamble jar" (jar executável).
4. Coloque o arquivo log.txt na pasta do jar.
5. Execute o programa da seguinte forma

```shellscript
$ java -jar <nome_do_arquivo_jar>.jar <nome_do_arquivo_de_log>.txt
```

# COMENTÁRIOS

* A proposta do programa é relativamente simples. Assim sendo, busquei não complicar. Utilizei a metodologia TDD, criando primeiro os testes, que ao serem executados, falharam por não ter as classes implementadas. Depois criei a classe para fazer o teste passar.

* Embora eu tenha visto a branch de dev, não vi instruções para fazer os commits nesta branch. Não vi instruções se devíamos usar GitLab flow ou semelhante. Então busquei fazer da forma mais simples.

* Sei que o melhor para se fazer são commits atômicos. Todavia, como só consegui mexer no código hoje, apenas quis demonstrar o conceito neste teste. Num projeto real eu faria um commit por funcionalidade nova, segundo recomendado na bibliografia Ágil.

* Não fiz o bônus de marcar a hora porque se trata apenas de uma repetição dos conceitos já utilizados no código.

* Comitei também uma pasta chamada EXECUTÁVEL. Sei que colocar executáveis no git é CONCEITUALMENTE ERRADO. O repositório é apenas um repositório de CÓDIGO. Entretanto, para facilitar o trabalho de vocês ao executar o código, podem fazer download daquele jar e executar apenas a linha de comando especificada.
