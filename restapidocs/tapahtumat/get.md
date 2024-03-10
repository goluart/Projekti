# Näytä yksittäinen tapahtuma tai kaikki tapahtumat
Tämä dokumentaatio kuvaa, miten voit hakea tietoja yksittäisestä tapahtumasta.

## API Endpoint
Hae tietoja yksittäisestä tapahtumasta.

**URL**: /tapahtumat/:tapahtumaId
**URL**: /tapahtumat

**URL-parametrit**: tapahtumaId=[integer], missä tapahtumaId on palvelimella olevan tapahtuman yksilöllinen tunniste.

**Metodi**: `GET`

**Autentikointi vaaditaan**: Ei

## Pyyntö
Pyynnön runkoa ei vaadita, sillä tieto haetaan URL-parametrin avulla.

## Onnistunut Vastaus
**Ehto**: Kaikki tapahtumat löytyvät tai löytyy yksi tapahtuma annetulla id:llä

**Koodi**: `200 OK`

**Sisällön esimerkki**
```json
[
    {
        "tapahtumaId": 1,
        "tapahtumaNimi": "Rock Festivaali",
        "kuvaus": "Suurin rock tapahtuma vuonna 2024",
        "alkaaPvm": "2024-03-22T19:00:00+02:00",
        "loppuuPvm": "2024-03-23T01:00:00+02:00",
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
                "lipputyyppiId": 2,
                "lipputyyppiNimi": "Lapsi",
                "asiakasryhma": "Lapsi",
                "hintakerroin": 0.5
            },
            {
                "lipputyyppiId": 1,
                "lipputyyppiNimi": "Aikuinen",
                "asiakasryhma": "Aikuinen",
                "hintakerroin": 1.0
            },
            {
                "lipputyyppiId": 3,
                "lipputyyppiNimi": "Eläkeläinen",
                "asiakasryhma": "Elakelainen",
                "hintakerroin": 0.7
            }
        ]
    },
    {
        "tapahtumaId": 2,
        "tapahtumaNimi": "Jazz-ilta",
        "kuvaus": "Nauti rennosta jazz-musiikista",
        "alkaaPvm": "2024-04-20T21:30:00+03:00",
        "loppuuPvm": "2024-04-21T02:00:00+03:00",
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
                "lipputyyppiId": 2,
                "lipputyyppiNimi": "Lapsi",
                "asiakasryhma": "Lapsi",
                "hintakerroin": 0.5
            },
            {
                "lipputyyppiId": 1,
                "lipputyyppiNimi": "Aikuinen",
                "asiakasryhma": "Aikuinen",
                "hintakerroin": 1.0
            },
            {
                "lipputyyppiId": 3,
                "lipputyyppiNimi": "Eläkeläinen",
                "asiakasryhma": "Elakelainen",
                "hintakerroin": 0.7
            }
        ]
    },
    {
        "tapahtumaId": 3,
        "tapahtumaNimi": "Stand-up show",
        "kuvaus": "Naurua koko illaksi",
        "alkaaPvm": "2024-05-15T18:00:00+03:00",
        "loppuuPvm": "2024-05-15T22:00:00+03:00",
        "maxLippuja": 150,
        "lippujaJaljella": 150,
        "tapahtumapaikka": {
            "tapahtumapaikkaId": 3,
            "tapahtumapaikkaNimi": "Linnanmäki",
            "tapahtumapaikkaOsoite": "Tivolikuja 1, Helsinki",
            "tapahtumapaikkaKaupunki": "Helsinki"
        },
        "jarjestaja": {
            "jarjestajaId": 3,
            "jarjestajaNimi": "Konsertti Oy"
        },
        "perushinta": 35.0,
        "lipputyypit": [
            {
                "lipputyyppiId": 2,
                "lipputyyppiNimi": "Lapsi",
                "asiakasryhma": "Lapsi",
                "hintakerroin": 0.5
            },
            {
                "lipputyyppiId": 1,
                "lipputyyppiNimi": "Aikuinen",
                "asiakasryhma": "Aikuinen",
                "hintakerroin": 1.0
            },
            {
                "lipputyyppiId": 3,
                "lipputyyppiNimi": "Eläkeläinen",
                "asiakasryhma": "Elakelainen",
                "hintakerroin": 0.7
            }
        ]
    }
]
```
## Virhevastaukset
**Ehto**: Jos tapahtumaa ei löydy annetulla ID:llä tai järjestlmästä ei löydy yhtäkään tapahtumaa.

**Koodi**: `404 Not Found`

**Sisältö**: null

### Tai
**Ehto**: Jos tapahtuman haku epäonnistuu muusta syystä.

**Koodi**: `500 Internal Server Error`

**Sisältö**: 

## Huomautukset
Varmista, että käytät oikeaa tapahtumaId-arvoa tapahtuman tietojen hakemiseen.
Tämä rajapinta palauttaa kaikki tapahtuman tiedot, mukaan lukien tapahtumapaikan ja järjestäjän tiedot.