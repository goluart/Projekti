# Muokkaa käyttäjän tietoja
Tämä dokumentaatio kuvaa, miten olemassa olevan lipputyypin tietoja voi muokata.

## API Endpoint
Muokkaa olemassa olevaa lipputyyppiä.

**URL**: /lipputyyppi/{id}

**URL-polku**: {id} = lipputyyppiId = [integer], missä lipputyyppiId on palvelimella olevan lipputyypin generoitu yksilöllinen tunniste.

**Metodi**: `PUT`

**Autentikointi vaaditaan**: Kyllä

**Käyttäjärooli**: `hallinto`

## Pyyntö
Pyynnön runkoa ei vaadita, sillä tieto haetaan URL-polun avulla.

## Onnistunut vastaus

**Ehto**: Jos olemassa olevan lipputyypin tiedot on muokattu ja tallennettu onnistuneesti.

**Koodi**: `200 OK`

**Sisällön esimerkki**
```json
{
    "nimi": "VIP Lippu",
    "hintakerroin": 2.5,
    "asiakasryhma": {
        "nimi": "Elakelainen",
        "kuvaus": "Eläkkeellä olevat henkilöt",
        "id": 3
    }
}
```
## Virhevastaukset

**Ehto**: Pyyntö on viallinen. Pyynnöstä puuttu attribuutteja tai ne eivät ovat vaaditussa muodossa.

**Koodi**: `400 Bad Request`

**Sisältö**:
```json
{
    "timestamp": "2024-05-12T11:57:25.664+00:00",
    "status": 400,
    "error": "Bad Request",
    "message": "Pyynnön sisältö on virheellinen",
    "path": "/lipputyyppi/6"
}
```

## Huomautukset
Pyynnön rungon on oltava dokumentaatiota vastaava. Varmista myös, että käytät attribuuteissa oikeita arvoja.
