# Poista myyntitapahtuma
Tämä dokumentaatio kuvaa, miten myyntitapahtuman tiedot poistetaan tietokannasta.

## API Endpoint

**URL**: /myyntitapahtumat/{id}

**Metodi**: `DELETE`

**Autentikointi vaaditaan**: Kyllä

**Käyttäjäroolit**: `hallinto`, `myyja`

**URL-parametrit**: {id}= myyntitapahtumaId = [integer], missä `id` on palvelimella olevan myyntitapahtuman yksilöllinen tunniste.

### Pyyntö
Pyynnön runkoa ei vaadita, sillä tieto haetaan URL-parametrin avulla.


### Onnistunut Vastaus

**Ehto**: Jos ID:n avulla löytyy myyntitapahtuma, johon ei ole liitetty käytetyksi merkittyjä lippuja

**Koodi**: `204 No Content`

**Sisällön esimerkki**


### Epäonnistunut vastaus

**Ehto**: Jos myyntitapahtumaa ei löydy

**Koodi**: `404 Not Found`

**Sisällön esimerkki**: 
```json
{
    "timestamp": "2024-05-09T18:53:56.507+00:00",
    "status": 404,
    "error": "Not Found",
    "message": "Myyntitapahtumaa 5 ei löytynyt",
    "path": "/myyntitapahtumat/5"
}
```

#### TAI

**Ehto**: Jos myyntitapahtumaan on liitetty käytetyksi merkittyjä lippuja

**Koodi**: `409 Conflict`

**Sisällön esimerkki**: 
```json
{
    "timestamp": "2024-05-09T18:47:11.930+00:00",
    "status": 409,
    "error": "Conflict",
    "message": "Myyntitapahtumaa 1 ei voi poistaa käytettyjen lippujen takia",
    "path": "/myyntitapahtumat/1"
}
```

## Huomautukset
