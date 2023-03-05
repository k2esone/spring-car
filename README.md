## Spring Car Application

### Wstęp / Introduction
Aplikacja napisana w technologii Spring Boot. Aplikacja umożliwia zarządzanie obiektami Samochód (Car).

### Funkcjonalność / Features
Aplikacja zawiera technologie:
- JPA,
- Spring Boot,
- MySQL,
- REST API
- Thymeleaf

Aplikacja (REST) umożliwia:
- Dodawanie encji car
```http request
### Dodawanie samochodu -> należy wysłać obiekt CreateCarRequest
POST http://localhost:8080/rest/car
Content-Type: application/json

{
  "nrRejestracyjny": "GOTESLA",
  "dataPierwszejRejestracji": "2020-03-12",
  "iloscDrzwi": 5,
  "pojemnoscSilnika": 0.698
}
```
Oczekiwana odpowiedź:
```json
{
  "id": 2,
  "nrRejestracyjny": "GOTESLA",
  "dataPierwszejRejestracji": "2020-03-12",
  "iloscDrzwi": 5,
  "pojemnoscSilnika": 0.698
}
```

- Listowanie encji car
```http request
### Zapytanie o listę wszystkich dodanych samochodów
GET http://localhost:8080/rest/car
```
Oczekiwana odpowiedź:
```json
[
  {
    "id": 1,
    "nrRejestracyjny": null,
    "dataPierwszejRejestracji": null,
    "iloscDrzwi": null,
    "pojemnoscSilnika": null
  },
  {
    "id": 2,
    "nrRejestracyjny": "GOTESLA",
    "dataPierwszejRejestracji": "2020-03-12",
    "iloscDrzwi": 5,
    "pojemnoscSilnika": 0.698
  }
]
```

- Usuwanie encji car (po identyfikatorze)
```http request
### Zapytanie o usunięcie samochodu o identyfikatorze = 3 
DELETE http://localhost:8080/rest/car/3
```
Oczekiwana odpowiedź:
```json
```

- Edycje encji car
```http request
### Zapytanie o edytowanie samochodu o identyfikatorze = 3 
PATCH http://localhost:8080/rest/car/3
Content-Type: application/json

{
  "nrRejestracyjny": "GOGO TESLA",
  "iloscDrzwi": 3,
  "pojemnoscSilnika": 0.768
}
```
Oczekiwana odpowiedź:
```json
{
  "id": 2,
  "nrRejestracyjny": "GOGO TESLA",
  "dataPierwszejRejestracji": "2020-03-12",
  "iloscDrzwi": 3,
  "pojemnoscSilnika": 0.768
}
```

- Szukanie encji car po identyfikatorze:
    - PathVariable -> /rest/car/3
    - RequestParam -> /rest/car/byId?cid=3

Aplikacja (Thymeleaf) umożliwia:
- Dodawanie encji car (`http://localhost:8080/view/car/form`)
- Listowanie encji car (`http://localhost:8080/view/car`)

### Jak skonfigurować i uruchomić / How to configure and run
Aby skonfigurować aplikację, należy dostarczyć parametry do połączenia z bazą danych.
Parametry znajdują się w `/src/main/resources/application.yaml`. Należy wypełnić:

```yaml
spring:
  datasource:
    url: jdbc:mysql:// # wypełnij adres połączenia / fill connection string url
    password: # wypełnij hasło / fill password
    username: # wypełnij login / fill username
  jpa:
    hibernate:
      ddl-auto: update
```

Do uruchomienia aplikacji należy użyć komendy:
```shell
mvn spring-boot:run
```

### Autorzy / Authors
k2esone
