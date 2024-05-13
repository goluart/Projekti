# Poista käyttäjä
Tämä dokumentaatio kuvaa, miten järjestelmästä voi poistaa lipun.

## API Endpoint
Poista olemassa oleva lippu

**URL**: /lippu/{id}

**URL-polku**: {id} = lippuId = [integer], missä lippuiId on palvelimella olevan lipun generoitu yksilöllinen tunniste.

**Metodi**: `DELETE`

**Autentikointi vaaditaan**: Kyllä

**Käyttäjärooli**: `hallinto`

## Pyyntö
Pyynnön runkoa ei vaadita, sillä tieto haetaan URL-polun avulla.

## Onnistunut vastaus

**Ehto**: Jos lippu on poistettu onnistuneesti, eikä sitä löydy enää listauksesta.

**Koodi**: `200 OK`

## Virhevastaukset

**Ehto**: Jos autentikointi epäonnistuu.

**Koodi**: `401 Unauthorized`

**Sisältö**:

### Tai

**Ehto**: Jos lippua ei löydy.

**Koodi**: `404 Not Found`

**Sisältö**:
```json
{
    "timestamp": "2024-05-13T14:27:17.030+00:00",
    "status": 404,
    "error": "Not Found",
    "message": "Lippua 3 ei löytynt",
    "path": "/lippu/3"
}
```
## Huomautukset
Poistettaessa on käytettävä poistettavan kohteen id-numeroa.
Tämä metodi poistaa kaikki lipun tiedot pysyvästi tietokannasta.