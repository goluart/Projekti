# Näytä yksittäinen tapahtuma tai kaikki tapahtumat
Tämä dokumentaatio kuvaa, miten voit hakea tietoja kaikista tapahtumista tai yksittäisestä tapahtumasta.

## API Endpoint
Hae tietoja tapahtumista tai tapahtumasta

**Yksittäisen tapahtuman tiedot**

**URL**: /tapahtumat/{id}

**Kaikkien tapahtumien tiedot**

**URL**: /tapahtumat

**URL-parametrit**: tapahtumaId=[integer], missä tapahtumaId on palvelimella olevan tapahtuman yksilöllinen tunniste.

**Metodi**: `GET`

**Autentikointi vaaditaan**: Kyllä

**Käyttäjäroolit**: `myyja` `hallinto`

## Pyyntö
Pyynnön runkoa ei vaadita, sillä tieto haetaan URL-parametrin avulla.

## Onnistunut vastaus
**Ehto**: Kaikki tapahtumat löytyvät tai löytyy yksi tapahtuma annetulla id:llä

**Koodi**: `200 OK`

**Sisällön esimerkki**
```json
[
    {
        "tapahtumaId": 1,
        "tapahtumaNimi": "Rock Festivaali",
        "kuvaus": "Suurin rock tapahtuma vuonna 2025",
        "alkaaPvm": "2025-03-22T19:00:00+02:00",
        "loppuuPvm": "2025-03-23T01:00:00+02:00",
        "maxLippuja": 15000,
        "lippujaJaljella": 14997,
        "tapahtumapaikka": {
            "tapahtumapaikkaId": 1,
            "tapahtumapaikkaNimi": "Kulttuuritalo",
            "tapahtumapaikkaOsoite": "Sturenkatu 4, Helsinki",
            "tapahtumapaikkaKaupunki": "Helsinki"
        },
        "jarjestaja": {
            "jarjestajaId": 1,
            "jarjestajaNimi": "Musiikki Oy"
        },
        "perushinta": 50.0,
        "lipputyypit": [
            {
                "lipputyyppiId": 3,
                "lipputyyppiNimi": "Eläkeläinen",
                "asiakasryhma": "Elakelainen",
                "hintakerroin": 0.7
            },
            {
                "lipputyyppiId": 1,
                "lipputyyppiNimi": "Aikuinen",
                "asiakasryhma": "Aikuinen",
                "hintakerroin": 0.5
            }
        ]
    },
    {
        "tapahtumaId": 2,
        "tapahtumaNimi": "Jazz-ilta",
        "kuvaus": "Nauti rennosta jazz-musiikista",
        "alkaaPvm": "2025-04-20T21:30:00+03:00",
        "loppuuPvm": "2025-04-21T02:00:00+03:00",
        "maxLippuja": 70,
        "lippujaJaljella": 70,
        "tapahtumapaikka": {
            "tapahtumapaikkaId": 2,
            "tapahtumapaikkaNimi": "Messukeskus",
            "tapahtumapaikkaOsoite": "Messuaukio 1, Helsinki",
            "tapahtumapaikkaKaupunki": "Helsinki"
        },
        "jarjestaja": {
            "jarjestajaId": 2,
            "jarjestajaNimi": "Festivaali Oy"
        },
        "perushinta": 40.0,
        "lipputyypit": [
            {
                "lipputyyppiId": 3,
                "lipputyyppiNimi": "Eläkeläinen",
                "asiakasryhma": "Elakelainen",
                "hintakerroin": 0.7
            },
            {
                "lipputyyppiId": 1,
                "lipputyyppiNimi": "Aikuinen",
                "asiakasryhma": "Aikuinen",
                "hintakerroin": 0.5
            }
        ]
    }
]
```

## Virhevastaukset

**Ehto**: Jos autentikointi epäonnistui

**Koodi**: `401 Unauthorized`

**Sisältö**:

### Tai

**Ehto**: Jos auktorisointi epäonnistui

**Koodi**: `403 Forbidden`

**Sisältö**:
```json
{
    "timestamp": "2024-03-25T16:13:48.171+00:00",
    "status": 403,
    "error": "Forbidden",
    "message": "Forbidden",
    "path": "/tapahtumat/1"
}
```

### Tai

**Ehto**: Jos tapahtumaa ei löydy annetulla ID:llä tai järjestlmästä ei löydy yhtäkään tapahtumaa.

**Koodi**: `404 Not Found`

**Sisältö**: 
```json
{
    "timestamp": "2024-03-11T14:18:26.543+00:00",
    "status": 404,
    "error": "Not Found",
    "message": "Tapahtumaa 10 ei löytynyt.",
    "path": "/tapahtumat/10"
}
```

## Huomautukset
Varmista, että käytät oikeaa tapahtumaId-arvoa tapahtuman tietojen hakemiseen.
Tämä rajapinta palauttaa kaikki tapahtuman tiedot, mukaan lukien tapahtumapaikan ja järjestäjän tiedot.