# Projeto Pontos de Interesse

## Tecnologias utilizadas:

  * Java 1.8
  * Framework Spring
  * Apache Derby DB
  * Angular 6
  * JUnit  
	
## Pré-requisitos

  * Node >= v10.9.0
  * Java 1.8  

## Clonar o projeto:

	git clone https://github.com/thiagorizzo/xy-inc.git

## Executar Backend (Spring)

- No prompt de comando, executar na sequência:
	
	1) cd [caminho da pasta contendo o projeto clonado]\xy-inc\target
	2) java -jar PoiProject-0.0.1-SNAPSHOT.jar

- O servidor executará na porta 8080, portanto essa porta deve estar livre para que o servidor possa subir.

## Executar projeto WEB (Angular)

- No prompt de comando, executar na sequência:
	
	1) cd [caminho da pasta contendo o projeto clonado]\xy-inc\src\web
	2) npm install
  3) ng serve --port 4200

- Após iniciar o projeto web, o site estará executando na porta :4200, é importante que essa porta seja utilizada, pois há configuração de CORS para tal socket no servidor. 
- Agora é possível acessar o front-end no navegador através da URL:
	
	http://localhost:4200/

- Ao abrir a URL, será apresenta uma página que contém 3 abas:

  1) List (Lista todos pontos de interesse)
  2) Nearby (Busca pontos de interesse a partir de um ponto de referência e uma distância)
  3) Register (Registrar novo ponto de interesse)

# Testes

- É necessário incluir os registros na aba Register, tal como:

![image](https://user-images.githubusercontent.com/563700/44637783-95953f00-a989-11e8-8d1b-5b0429b449d6.png)

- Na aba List serão apresentados os pontos de interesses cadastrados:

![image](https://user-images.githubusercontent.com/563700/44637848-02103e00-a98a-11e8-887a-d14346b69052.png)

- Na aba Nearby pode-se buscar quais pontos de interesses estão na proximidade a partir de coordenadas e distância máxima.

![image](https://user-images.githubusercontent.com/563700/44637918-75b24b00-a98a-11e8-9ad6-4d2d8bd3cb7e.png)
	
# Testes Automatizados

- Também foram testes unitários no projeto de backend, contidos na classe:

  com.poiproject.PoiProjectApplicationTests
 
 ![image](https://user-images.githubusercontent.com/563700/44638046-30424d80-a98b-11e8-8603-c1f9adf3db02.png)
 
## Authors

* **Thiago Luiz Parrillo Rizzo**	
