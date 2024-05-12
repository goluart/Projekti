# Poista käyttäjä
Tämä dokumentaatio kuvaa, miten järjestelmästä voi poistaa lipputyypin.

## API Endpoint
Poista olemassa oleva lipputyyppi

**URL**: /lipputyyppi/{id}

**URL-polku**: {id} = lipputyyppiId = [integer], missä lipputyyppiId on palvelimella olevan lipputyypin generoitu yksilöllinen tunniste.

**Metodi**: `DELETE`

**Autentikointi vaaditaan**: Kyllä

**Käyttäjärooli**: `hallinto`

## Pyyntö
Pyynnön runkoa ei vaadita, sillä tieto haetaan URL-polun avulla.

## Onnistunut vastaus

**Ehto**: Jos käyttäjä on poistettu onnistuneesti, eikä sitä löydy enää listauksesta.

**Koodi**: `200 OK`

## Virhevastaukset

**Ehto**: Jos autentikointi epäonnistuu.

**Koodi**: `401 Unauthorized`

**Sisältö**:

### Tai

**Ehto**: Jos lipputyyppiä ei löydy.

**Koodi**: `404 Not Found`

**Sisältö**:
```json
{
    "timestamp": "2024-05-12T12:11:25.382+00:00",
    "status": 404,
    "error": "Not Found",
    "message": "Lipputyyppiä 4 ei löytynt",
    "path": "/lipputyyppi/4"
}
```
## Huomautukset
Poistettaessa on käytettävä poistettavan kohteen id-numeroa.
Tämä metodi poistaa kaikki lipputyypin tiedot pysyvästi tietokannasta.