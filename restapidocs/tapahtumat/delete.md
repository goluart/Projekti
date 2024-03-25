# Luo uusi tapahtumat
Tämä dokumentaatio kuvaa, miten järjestelmästä voi poistaa tapahtuman.

## API Endpoint
Poista olemassa oleva tapahtuma

**URL**: /tapahtumat/{id}

**Metodi**: `DELETE`

**Autentikointi vaaditaan**: Kyllä

## Pyyntö
Pyynnön runkoa ei vaadita, sillä tieto haetaan URL-parametrin avulla.

## Onnistunut Vastaus

**Ehto**: Jos tapahtuma on poistettu onnistuneesti, eikä sitä löydy enää listauksesta.

**Koodi**: `204 No Content`

**Sisällön esimerkki**:

## Virhevastaukset

**Ehto**: Jos autentikointi ja/tai auktorisointi epäonnistuu.

**Koodi**: `401 Unauthorized`

**Sisältö**:

### Tai

**Ehto**: Jos tapahtumaan on myyty lippuja

**Koodi**: `400 Bad Request`

**Sisältö**:
```json
{
    "timestamp": "2024-03-25T16:22:54.431+00:00",
    "status": 400,
    "error": "Bad Request",
    "message": "Tapahtumaa 1 ei voi poistaa, koska tapahtumaan on myyty lippuja.",
    "path": "/tapahtumat/1"
}
```

### Tai

**Ehto**: Jos tapahtumaa ei löydy

**Koodi**: `404 Not Found`

**Sisältö**: 
```json
{
    "timestamp": "2024-03-25T16:25:09.495+00:00",
    "status": 404,
    "error": "Not Found",
    "message": "Tapahtumaa 10 ei löytynyt.",
    "path": "/tapahtumat/10"
}
```

## Huomautukset
Varmista, että käytät oikeaa id-numeroa poistettavan tapahtuman valinnassa.
Tämä metodi poistaa kaikki tapahtuman tiedot pysyvästi.