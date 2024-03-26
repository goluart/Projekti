# Luo uusi tapahtumat
Tämä dokumentaatio kuvaa, miten järjestelmään voi luoda uuden tapahtuman

## API Endpoint
Luo uusi tapahtuma

**URL**: /tapahtumat

**Metodi**: `POST`

**Autentikointi vaaditaan**: Kyllä

**Käyttäjäroolit**: `hallinto`

## Pyyntö

```Json
{
    "tapahtumaNimi": "Sirkus Finlandia",
    "alkaaPvm": "2025-02-25T20:00:00.000Z",
    "paattyyPvm": "2025-02-26T23:00:00.000Z",
    "kuvaus": "Tämä on uuden tapahtuman kuvaus.",
    "perushinta": 20.0,
    "tapahtumapaikka": {
        "tapaikkaId": 1
    },
    "jarjestaja": {
        "jarjestajaId": 2
    },
    "lipputyypit": [
        {"lipputyyppiId": 1},
        {"lipputyyppiId": 2}
    ],
    "max_lippuja": 750
}
```

## Onnistunut Vastaus

**Ehto**: Jos uusi tapahtuma on tallennettu onnistuneesti

**Koodi**: `201 OK`

**Sisällön esimerkki**
```json
{
    "timestamp": "2024-03-25T16:07:37.337+00:00",
    "status": 201,
    "error": "Created",
    "message": "Uusi tapahtuma luotu",
    "path": "/tapahtumat"
}
```
## Virhevastaukset

**Ehto**: Autentikointi epäonnistui

**Koodi**: `401 Unauthorized`

**Sisältö**:

### Tai

**Ehto**: Jos auktorisointi epäonnistui

**Koodi**: `403 Forbidden`

**Sisältö**:
```json
{
    "timestamp": "2024-03-25T16:32:51.618+00:00",
    "status": 403,
    "error": "Forbidden",
    "message": "Forbidden",
    "path": "/tapahtumat"
}
```

### Tai

**Ehto**: Pyynnön sisältö oli viallinen.

**Koodi**: `400 Bad Request`

**Sisältö**:
```json
{
    "paattyyPvm": "Tapahtumia voi luoda vain tulevaisuuteen",
    "max_lippuja": "Myytäviä lippuja on oltava enemmän kuin 0",
    "alkaaPvm": "Tapahtumia voi luoda vain tulevaisuuten"
}
```

## Huomautukset
Varmista, että käytät oikeita attribuuttien arvoja tapahtuman luomisessa.