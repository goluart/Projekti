# Muokkaa yhteyshenkilön tietoja
Tämä dokumentaatio kuvaa, miten olemassa olevan järjestäjän tietoja voi muokata.

## API Endpoint
Muokkaa olemassa olevaa järjestäjää.

**URL**: /yhteyshenkilot/{id}

**URL-polku**: {id} = yhtHloId = [integer], missä yhtHloId on palvelimella olevan yhteyshenkilön generoitu yksilöllinen tunniste.

**Metodi**: `PUT`

**Autentikointi vaaditaan**: Kyllä

**Käyttäjärooli**: `hallinto`

## Pyyntö
```json
{
    "tapaikkaId": 1,
    "etunimi": "Etunimi",
    "sukunimi": "Sukunimi",
    "sahkoposti": "sahkoposti@sahkoposti.com",
    "puhelin": "0401234567",
    "lisatieto": "assari"
}
```

```json
{
    "jarjestajaId": 1,
    "etunimi": "Etunimi",
    "sukunimi": "Sukunimi",
    "sahkoposti": "sahkoposti@sahkoposti.com",
    "puhelin": "0401234567",
    "lisatieto": "assari"
}
```

## Onnistunut vastaus

**Ehto**: Jos olemassa olevan käyttäjän tiedot on muokattu ja tallennettu onnistuneesti.

**Koodi**: `200 OK`

**Sisällön esimerkki**
```json
 {
    "jarjestajaId": 2,
    "nimi": "Yritys tmi",
    "ytunnus": "3234567-8",
    "osoite": "Fredrikinkatu 15",
    "postinumero": "00600",
    "kaupunki": "Helsinki",
    "yhteyshenkilot": [
        {
            "yhtHloId": 2,
            "etunimi": "Liisa",
            "sukunimi": "Laaksonen",
            "sahkoposti": "liisa@example.com",
            "puhelin": "0501234567",
            "lisatieto": "Tuotantopäällikkö"
        }
    ]
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
Yhteyshenkilö lisätään järjestäjän tai tapahtumapaikan tietoihin lisäämällä pyyntöön järjestäjän id (jarjestajaId) tai tapahtumapaikan id (tapaikkaId). Jos yhteyshenkilöllä on jo järjestäjä tai tapahtumapaikka liitettynä, tämä tieto päivitetään.

