# Muokkaa käyttäjän tietoja
Tämä dokumentaatio kuvaa, miten olemassa olevan järjestäjän tietoja voi muokata.

## API Endpoint
Muokkaa olemassa olevaa järjestäjää.

**URL**: /jarjestajat/{id}

**URL-polku**: {id} = jarjestajaId = [integer], missä jarjestajaId on palvelimella olevan järjestäjän generoitu yksilöllinen tunniste.

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

**Ehto**: Haettavaa id:tä ei ole olemassa.

**Koodi**: `404 Not Found`

**Sisältö**
```json
{
    "timestamp": "2024-05-12T19:21:17.338+00:00",
    "status": 404,
    "error": "Not Found",
    "message": "Järjestäjää 4 ei löytynyt",
    "path": "/jarjestajat/4"
}
```
### Tai

**Ehto**: Pyynnön runko on viallinen

**Koodi**: `400 Bad Request`

**Sisältö**:

```json
{
    "path": "/jarjestajat",
    "error": "Bad Request",
    "message": "Nimi voi olla 50 merkkiä pitkä",
    "timestamp": "2024-05-12T22:02:15.545947400+03:00",
    "status": 400
}
```

```json
{
    "path": "/jarjestajat",
    "error": "Bad Request",
    "message": "Anna y-tunnus muodossa 1234567-8",
    "timestamp": "2024-05-12T22:09:15.140944700+03:00",
    "status": 400
}
```

```json
{
    "path": "/jarjestajat",
    "error": "Bad Request",
    "message": "Osoite voi olla 100 merkkiä pitkä",
    "timestamp": "2024-05-12T22:06:02.930087200+03:00",
    "status": 400
}
```

## Huomautukset
Yhteyshenkilöiden lisääminen ei ole pakollista.

