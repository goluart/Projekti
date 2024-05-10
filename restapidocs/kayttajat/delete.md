# Luo uusi tapahtumat
Tämä dokumentaatio kuvaa, miten järjestelmästä voi poistaa käyttäjä.

## API Endpoint
Poista olemassa oleva käyttäjä

**URL**: /tapahtumat/{id}

**Metodi**: `DELETE`

**Autentikointi vaaditaan**: Kyllä

**Käyttäjäroolit**: `hallinto`

## Pyyntö
Pyynnön runkoa ei vaadita, sillä tieto haetaan URL-polun avulla.

## Onnistunut vastaus

**Ehto**: Jos käyttäjä on poistettu onnistuneesti, eikä sitä löydy enää listauksesta.

**Koodi**: `200 OK`

**Sisältä**:

## Virhevastaukset

**Ehto**: Jos autentikointi epäonnistuu.

**Koodi**: `401 Unauthorized`

**Sisältö**:

### Tai

**Ehto**: Jos tapahtumaa ei löydy

**Koodi**: `404 Not Found`

**Sisältö**:
```json
{
    "timestamp": "2024-05-10T11:24:33.615+00:00",
    "status": 404,
    "error": "Not Found",
    "message": "Käyttäjää 5 ei löytynyt",
    "path": "/kayttajat/5"
}
```
## Huomautukset
Poistettaessa on käytettävä poistettavan kohteen id-numeroa.
Tämä metodi poistaa kaikki käyttäjän tiedot pysyvästi tietokannasta.