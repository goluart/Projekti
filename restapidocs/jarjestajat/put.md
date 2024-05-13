# Muokkaa järjestäjän tietoja
Tämä dokumentaatio kuvaa, miten olemassa olevan järjestäjän tietoja voi muokata.

## API Endpoint
Muokkaa olemassa olevaa järjestäjää.

**URL**: /jarjestajat/{id}

**URL-polku**: {id} = jarjestajaId = [integer], missä jarjestajaId on palvelimella olevan järjestäjän generoitu yksilöllinen tunniste.

**Metodi**: `PUT`

**Autentikointi vaaditaan**: Kyllä

**Käyttäjärooli**: `hallinto`

## Pyyntö
```json
{
    "nimi": "Yritys tmi",
    "ytunnus": "3234567-8",
    "osoite": "Fredrikinkatu 15",
    "postinumero": "00600",
    "kaupunki": "Helsinki"
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
Yhteyshenkilöiden lisääminen ei ole pakollista. Jos yhteyshenkilön tiedot jätetään pois, poistetaan mahdollisen yhteyshenkilön linkitys järjestäjään. Jos yhteyshenkilot lisätään, kaikki pyynnön yhteyshenkilo-parametrit ovat pakollisia, paitsi yhtHloId. Jos yhtHloId puuttuu, luodaan uusi yhteyshenkilo, muussa tapauksessa päivitetään olemassa olevan yhteyshenkilön tietoja.

