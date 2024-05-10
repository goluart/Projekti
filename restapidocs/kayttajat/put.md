# Muokkaa käyttäjän tietoja
Tämä dokumentaatio kuvaa, miten olemassa olevaa käyttäjän tietoja voi muokata.

## API Endpoint
Muokkaa olemassa olevaa käyttäjää.

**URL**: /kayttajat/{id}

**URL-polku**: {id} = hloId = [integer], missä hloId on palvelimella olevan käyttäjän generoitu yksilöllinen tunniste.

**Metodi**: `PUT`

**Autentikointi vaaditaan**: Kyllä

**Käyttäjärooli**: `hallinto`

## Pyyntö
Pyynnön runkoa ei vaadita, sillä tieto haetaan URL-polun avulla.

## Onnistunut vastaus

**Ehto**: Jos olemassa olevan käyttäjän tiedot on muokattu ja tallennettu onnistuneesti.

**Koodi**: `200 OK`

**Sisällön esimerkki**
```json
    {
    "hloId": 5,
    "tunnus": "maija123",
    "salasana": "hyvasalasana",
    "snimi": "Myyjänen",
    "enimi": "Maija",
    "lisatiedot": "Myyntialue",
    "rooli": 
    {
        "rooliId": 1,
        "rooliNimi": "myyja"
    }
}
```
## Virhevastaukset

**Ehto**: Pyyntö on viallinen. Pyynnöstä puuttu attribuutteja tai ne eivät ovat vaaditussa muodossa.

**Koodi**: `400 Bad Request`

**Sisältö**:
```json
{
    "timestamp": "2024-05-10T11:11:02.957+00:00",
    "status": 400,
    "error": "Bad Request",
    "message": "Pyynnön sisältö on virheellinen",
    "path": "/kayttajat/5"
}
```

### Tai

**Ehto**: Haettavaa id:tä ei ole olemassa.

**Koodi**: `404 Not Found`

**Sisältö**
```json
{
    "timestamp": "2024-05-10T12:19:31.461+00:00",
    "status": 404,
    "error": "Not Found",
    "message": "Henkiöä 5 ei voi muokata, koska häntä ei ole olemassa.",
    "path": "/kayttajat/5"
}
```
## Huomautukset
Pyynnön rungon on oltava dokumentaatiota vastaava. Varmista myös, että käytät attribuuteissa oikeita arvoja.
