# Luo uusi lipputyyppi
Tämä dokumentaatio kuvaa, miten järjestelmään voi luoda uusia lippuja

## API Endpoint
Luo uusi lippu

**URL-polku**: /lippu

**Metodi**: `POST`

**Autentikointi vaaditaan**: Kyllä

**Käyttäjärooli**: `myyja`, `hallinto`

## Pyyntö

```json
{
    "ostoPvm": "2024-05-13T15:30:00",
    "tarkistuskoodi": "Testi koodi",
    "hinta": 44.00,
    "tapahtuma": {
        "tapahtumaId": 1
    },
    "lipputyyppi": {
        "lipputyyppiId": 3
    },
    "myyntitapahtuma": {
        "myyntitapahtumaId": 1
    },
    "kayttoPvm": null
}
```

## Onnistunut vastaus

**Koodi**: `201 Created`

**Sisällön esimerkki**
```json
{
    "lippuId": 7,
    "ostoPvm": "2024-05-13T15:30:00",
    "tarkistuskoodi": "Testi koodi",
    "hinta": 44.0,
    "tapahtuma": {
        "tapahtumaId": 1,
        "tapahtumaNimi": null,
        "luontiPvm": "2024-05-13T14:52:05.0115129+03:00",
        "alkaaPvm": null,
        "paattyyPvm": null,
        "kuvaus": null,
        "max_lippuja": 0,
        "perushinta": 0.0,
        "tapahtumapaikka": null,
        "jarjestaja": null,
        "lipputyypit": [],
        "lippujaJaljella": 0
    },
    "lipputyyppi": {
        "lipputyyppiId": 3,
        "nimi": null,
        "hintakerroin": 0.0,
        "asiakasryhma": null
    },
    "myyntitapahtuma": {
        "myyntitapahtumaId": 1,
        "myyntitapahtumaPvm": null,
        "loppusumma": 0.0
    },
    "kayttoPvm": null
}
```
## Virhevastaukset

**Ehto**: Autentikointi epäonnistui

**Koodi**: `401 Unauthorized`

## Huomatukset
Varmista, että käytät lipun luonnin yhteydessä oikeita attribuutien arvoja. Pidä huoli myös, että pyynnön runko on samanlainen kuin dokumentaatiossa.