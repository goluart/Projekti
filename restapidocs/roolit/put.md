# Muokkaa roolin tietoja
Tämä dokumentaatio kuvaa, miten olemassa olevaa roolin tietoja voi muokata.

## API Endpoint
Muokkaa olemassa olevaa roolia.

**URL**: /roolit/{id}

**URL-polku**: {id} = rooliId = [integer], missä rooliId on palvelimella olevan roolin generoitu yksilöllinen tunniste.

**Metodi**: `PUT`

**Autentikointi vaaditaan**: Kyllä

**Käyttäjärooli**: `hallinto`

## Pyyntö
Pyynnön runkoa ei vaadita, sillä tieto haetaan URL-polun avulla.

## Onnistunut vastaus

**Ehto**: Jos olemassa olevan roolin tiedot on muokattu ja tallennettu onnistuneesti

**Koodi**: `200 OK`

**Sisällön esimerkki**
```json
{
    "rooliId": 4,
    "rooliNimi": "Pomo",
    "kayttajat": []
}
```
## Virhevastaukset

**Ehto**: Pyyntö on viallinen. Pyynnöstä puuttu attribuutteja tai ne eivät ovat vaaditussa muodossa.

**Koodi**: `400 Bad Request`

**Sisältö**:
```json
{
    "timestamp": "2024-05-10T12:10:41.219+00:00",
    "status": 400,
    "error": "Bad Request",
    "message": "Pyynnön sisältö on virheellinen",
    "path": "/roolit/4"
}
```
### Tai

**Ehto**: Haettavaa id:tä ei ole olemassa.

**Koodi** `404 Not Found`

**Sisältö**
```json
{
    "timestamp": "2024-05-10T12:16:10.356+00:00",
    "status": 404,
    "error": "Not Found",
    "message": "Roolia 4 ei voi muokata, koska sitä ei löytynyt",
    "path": "/roolit/4"
}
```
## Huomautukset
Pyynnön rungon on oltava dokumentaatiota vastaava. Varmista myös, että käytät attribuuteissa oikeita arvoja.