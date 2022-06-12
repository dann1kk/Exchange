## Requirements:
- Determinați atributele (Id, Code, etc.) și relațiile (1:n, n:m) necesare pentru entități.
 (In my case I have 6 tables: Numerar, Valuta, Operator, Filiala, SchimbValutar and CursValutar.
- Definiți constrângerile pentru schema bazei de date (chei primare, chei externe, constrângeri de unicitate).

- Utilizând limbajul SQL,
 - creați tabelele bazei de date; (create-tables.sql)
 - populați tabelele cu date de test. (seed.sql)

- Scrieți un program în Java (partea backend) care va utiliza Spring Boot, Gradle, Lombook, R2DBC, Reactive programing (WebFlux), Flyway s.a. şi v-a avea următorul funcţional:

- Metoda POST care inserează ratele cursului valutar în tabela CursValutar la data curentă
 ```json
      (exemplu parametrii de intrare

          {codValuta: "EUR", rata: 1, curs: 19.70}  sau

          {codValuta: "KZT", rata: 10, curs: 0.40}  sau

          {codValuta: "JPY", rata: 100, curs: 16.00} )
  ```

- Metoda GET care întoarce cursul valutar la data curentă după o anumita valută (de ex. EUR)
 ```json
      (exemplu parametrii de ieșire

          {codValuta: "EUR", rata: 1, curs: 19.70,  dataCurs: "2021-02-12"} )
 ```

- Metoda POST care reproduce cumpărare valută străina şi inserează date în tabela SchimbValutar
 ```json
      (exemplu parametrii de intrare

          {codValuta: "EUR", cursSchimb: 19.70, sumaPrimita: 100, sumaEliberata: (100*19,70), utilizator: "oper1"} )
 ```

- Metoda PUT ce corectează o suma pe valute în tabela Numerar
 ```json
      (exemplu parametrii de intrare

          {utilizator: "oper1", codValuta: "EUR", suma: 1450, data: "2021-02-12"} )
 ```

## How to run it:
- 1.Have docker installed
- 2.To run application use command:
```shell
./gradlew bootRun
```

In order to access database details use [pgadmin4](http://localhost:5050) email: _admin@admin.com_, parola: _password1_

To test functionalities use swagger:
[http://localhost:8080/swagger-ui/#/](http://localhost:8080/swagger-ui/#/)
 