# Poista yhteyshenkilo
Tämä dokumentaatio kuvaa, miten yhteyshenkilon tiedot poistetaan tietokannasta.

## API Endpoint

**URL**: /yhteyshenkilot/{id}

**Metodi**: `DELETE`

**Autentikointi vaaditaan**: Kyllä

**Käyttäjäroolit**: `hallinto`

**URL-parametrit**: id=[integer], missä `id` on palvelimella olevan yhteyshenkilon yksilöllinen tunniste.

### Pyyntö
Pyynnön runkoa ei vaadita, sillä tieto haetaan URL-parametrin avulla.


### Onnistunut Vastaus

**Ehto**: Jos ID:n avulla löytyy yhteyshenkilö, jota ei ole kiinnitetty järjestäjään

**Koodi**: `200 OK`

**Sisällön esimerkki**
`Yhteyshenkilö 4 poistettu`

### Epäonnistunut vastaus

**Ehto**: Jos yhteyshenkilöä ei löydy

**Koodi**: `404 Not Found`

**Sisällön esimerkki**: 
```json
{
    "timestamp": "2024-05-05T09:48:39.995+00:00",
    "status": 404,
    "error": "Not Found",
    "message": "Yhteyshenkilöä 9 ei löytynyt",
    "path": "/yhteyshenkilot/9"
}
```

#### TAI

**Ehto**: Jos yhteyshenkilö on kiinnitetty järjestäjään

**Koodi**: `409 Conflict`

**Sisällön esimerkki**: 
```json
{
    "timestamp": "2024-05-05T09:57:46.826+00:00",
    "status": 409,
    "error": "Conflict",
    "message": "Yhteyshenkilöä 1 ei voi poistaa",
    "path": "/yhteyshenkilot/1"
}
```

## Huomautukset
