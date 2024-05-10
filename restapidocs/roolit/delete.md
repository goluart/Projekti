# Poista rooli
Tämä dokumentaatio kuvaa, miten järjestelmästä voi poistaa roolin.

## API Endpoint
Poista olemassa oleva rooli

**URL**: /roolit/{id}

**URL-polku**: {id} = rooliId = [integer], missä rooliId on palvelimella olevan roolin generoitu yksilöllinen tunniste.

**Metodi**: `DELETE`

**Autentikointi vaaditaan**: Kyllä

**Käyttäjärooli**: `hallinto`

## Pyyntö
Pyynnön runkoa ei tarvita, sillä tieto haetaan URL-polun avulla.

## Onnistunut vastaus

**Ehto**: Jos rooli on poistettu onnistuneesti, eikä sitä löydy enää listauksesta.

**Koodi**: `200 OK`

**Sisältö**:

## Virhevastaukset

**Ehto**: Jos autentikointi epäonnistuu.

**Koodi**: `401 Unauthorized`

**Sisältö**:

### Tai

**Ehto**: Jos tapahtumaa ei löydy.

**Koodi**: `404 Not Found`

**Sisältö**:
```json
{
    "timestamp": "2024-05-10T12:25:48.097+00:00",
    "status": 404,
    "error": "Not Found",
    "message": "Roolia 5 ei voi muokata, koska sitä ei löytynyt",
    "path": "/roolit/5"
}
```
## Huomautukset
Poistettaessa on käytettävä poistettavan kohteen id-numeroa.
Tämä metodi poistaa kaikki käyttäjän tiedot pysyvästi tietokannasta.