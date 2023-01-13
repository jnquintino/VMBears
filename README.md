## Como rodar o projeto

Teremos duas opções para executar o projeto, primeiramente devemos ter os seguintes SDKs:

* Java 11+
* Angular 12+
* Docker
* Docker Compose
* NodeJS 16+
* Maven 3.6.3
* IDE boa para Java e Javascript tipo IntelliJ

Agora para subir de forma trivial, sem o uso do Docker podemos seguir os seguintes passos:

1) Abra o projeto da api na IDE de sua escolha, quando ele questionar que é um projeto Maven, deve aceitar a sugestão que ele irá efetuar a abertura do projeto como Maven e assim poderemos atuar sobre o projeto.

2) Depois de aberta a api, iremos executar um **mvn clean Install** aguardaremos o Maven efetuar o download de todas as dependencias para que possa proceder com a execução do mesmo.

3) Projeto com as dependencias carregadas, iremos localizar a classe de inicialização do Spring Boot como podem ver na imagem abaixo.


   ![image-20230112220217053](/Users/quintino/Library/Application Support/typora-user-images/image-20230112220217053.png)

4) Cliquem com o botão direito do mouse sobre a classe e mande executar.

Resolvemos já a nossa api, agora iremos cuidar do projeto web, vamos na pasta respectiva e iremos seguir os seguintes passos:

1) Primeiramente iremos executar o comando **npm install** para baixar as depdencias do projeto web e aguardaremos a conclusão como podem ver na imagem abaixo.
   

   ![image-20230112220334541](/Users/quintino/Library/Application Support/typora-user-images/image-20230112220334541.png)
   
2) Feito isso poderemos iniciar a aplicação com o seguinte comando **npm start** como podem verificar na imagem logo abaixo.
   

   ![image-20230112220427344](/Users/quintino/Library/Application Support/typora-user-images/image-20230112220427344.png)
   
3) Podemos agora rodar o nosso projeto no endereço **http://localhost:4200** e verão uma página similar a esta.
   

   ![image-20230112220521615](/Users/quintino/Library/Application Support/typora-user-images/image-20230112220521615.png)
   
4) Basta informar os arquivos e efetuar o upload.


------


Agora caso queiram de uma forma mais autonatizada podemos usar o Docker Compose, basta ficar na pasta do projeto, onde iremos ver as pastas api e web, como podem ver na imagem logo abaixo.

![image-20230112220631686](/Users/quintino/Library/Application Support/typora-user-images/image-20230112220631686.png)

Para executar o Docker Compose, antes de mais nada vamos precisar do Docker inicializado na máquina, feito isso iremos rodar o Docker Compose da seguinte forma: **docker-compose up**

Vamos aguardar a montagem do container e ao termino da execução, podemos ir no seguinte endereço: 

=> **http://localhost**

Sem a porta mesmo, pois na configuração empregada no Docker o nosso projeto web exporta o projeto do Angular para a porta externa 80 e as páginas apresentadas serão as mesmas demonstradas acima.
