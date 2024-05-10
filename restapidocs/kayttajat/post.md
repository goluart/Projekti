# Luo uusi käyttäjä
Tämä dokumentaatio kuvaa, miten järjestelmään voi luoda uusia käyttäjiä

## API Endpoint
Luo uusi käyttäjä

**URL-polku**: /kayttajat

**Metodi**: `POST`

**Autentikointi vaaditaan**: Kyllä

**Käyttäjärooli**: `hallinto`

## Pyyntö

```json
{
    "tunnus": "maija123",
    "salasana": "hyvasalasana",
    "snimi": "Myyjänen",
    "enimi": "Maija",
    "lisatiedot": "Myyntialue",
    "rooli": 
    {
        "rooliId": 1,
        "rooliNimi": "myyja"
    }
}
```

## Onnistunut vastaus

**Ehto**: Uusi käyttäjä on luotu onnistuneesti

**Koodi**: `201 Created`

**Sisällön esimerkki**
```json
{
    "timestamp": "2024-05-10T08:40:53.318+00:00",
    "status": 201,
    "error": "Created",
    "message": "Uusi käyttäjä luotu",
    "path": "/kayttajat"
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
    "snimi": "Sukunimi ei saa olla tyhjä",
    "enimi": "Etunimi ei saa olla tyhjä",
    "salasana": "Salasana ei saa olla tyhjä"
}
```
## Huomatukset
Varmista, että käytät käyttäjän luonnin yhteydessä oikeita attribuutien arvoja.