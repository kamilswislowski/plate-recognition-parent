# Plate Recognition REST API
Application which enables recognition of license plates from a photo. The server-side application (back-end) is providing REST API for the client application in the form of an application on Android. The license plate recognition algorithm uses an external API to provide such functionality from https://platerecognizer.com/.

## Back-end application technologies used:
- Spring Framework (MVC, Thymeleaf, Data JPA),
- Hibernate,
- PostgreSQL, H2Database,
- Heroku Cloud Application Platform,
- Gradle, IntelliJ, Postman,
- git,
- JUnit5.

## Application end-point:
**POST** : ```/plate-recognition/recognize```

Request Params :
```
multipart/form-data
key: upload
value: file
```

Response Body :
```json
{
    "id": 200,
    "location": null,
    "locationLabel": "Województwo śląskie Bielsko-Biała",
    "registrationNumber": "sb8903r",
    "fileName": "1410_zxQOX_fiat-tablice.jpg",
    "content": null
}
``` 