# Luo uusi rooli
Tämä dokumentaatio kuvaa, miten järjestelmään voi luoda uusia rooleja

## API Endpoint
Luo uusi rooli

**URL-polku**: /roolit

**Metodi**: `POST`

**Autentikointi vaaditaan**: Kyllä

**Käyttäjärooli**: `hallinto`

## Pyyntö
```json
{
    "rooliNimi": "apulainen"
}
```

## Onnistunut vastaus

**Ehto**: Uusi rooli on luotu ja tallennettu onnistuneesti

**Koodi**: `201 Created`

**Sisällön esimerkki**
```json
{
    "timestamp": "2024-05-10T11:48:27.387+00:00",
    "status": 201,
    "error": "Created",
    "message": "Uusi rooli luotu",
    "path": "/roolit"
}
```

## Virhevastaukset

**Ehto**: Autentikointi epäonnistui

**Koodi**: `401 Unauthorized`

**Sisältö**:

### Tai

**Ehto**: Pyynnön runko on viallinen

**Koodi**: `400 Bad Request`

**Sisältö**:
```json
{
    "rooliNimi": "Roolin nimi ei voi olla tyhjä"
}
```
## Huomautukset
Varmista, että käytät roolin luomisen yhteydessä oikeita arvoja. Pidä huoli myös, että pyynnön runko on samanlainen kuin dokumentaatiossa.