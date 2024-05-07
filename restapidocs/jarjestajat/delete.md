# Poista järjestäjä
Tämä dokumentaatio kuvaa, miten järjestäjän tiedot poistetaan tietokannasta.

## API Endpoint

**URL**: /jarjestajat/{id}

**Metodi**: `DELETE`

**Autentikointi vaaditaan**: Kyllä

**Käyttäjäroolit**: `hallinto`

**URL-parametrit**: id=[integer], missä `id` on palvelimella olevan järjestäjän yksilöllinen tunniste.

### Pyyntö
Pyynnön runkoa ei vaadita, sillä tieto haetaan URL-parametrin avulla.


### Onnistunut Vastaus

**Ehto**: Jos ID:n avulla löytyy järjestäjä, jolla ei ole liittyviä tietoja

**Koodi**: `204 No Content`

**Sisällön esimerkki**


### Epäonnistunut vastaus

**Ehto**: Jos järjestäjää ei löydy

**Koodi**: `404 Not Found`

**Sisällön esimerkki**: 
```json
{
    "timestamp": "2024-05-06T19:03:37.838+00:00",
    "status": 404,
    "error": "Not Found",
    "message": "Järjestäjää 10 ei löytynyt",
    "path": "/jarjestajat/10"
}
```

#### TAI

**Ehto**: Jos järjestäjällä on liittyviä tietoja

**Koodi**: `409 Conflict`

**Sisällön esimerkki**: 
```json
{
    "timestamp": "2024-05-06T19:03:16.141+00:00",
    "status": 409,
    "error": "Conflict",
    "message": "Järjestäjää ei voi poistaa",
    "path": "/jarjestajat/1"
}
```

## Huomautukset
