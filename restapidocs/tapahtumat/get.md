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
{
    "tapahtumaId": 1,
    "tapahtumaNimi": "Rock Festivaali",
    "luontiPvm": "2024-03-03T22:38:16.443598+02:00",
    "alkaaPvm": "2024-03-22T19:00:00+02:00",
    "paattyyPvm": "2024-03-23T01:00:00+02:00",
    "kuvaus": "Suurin rock tapahtuma vuonna 2024",
    "max_lippuja": 15000,
    "perushinta": 50.0,
    "tapahtumapaikka": {
        "tapaikkaId": 1,
        "paikkaNimi": "Kulttuuritalo",
        "osoite": "Sturenkatu 4, Helsinki",
        "kuvaus": "Kulttuuritapahtumien keskus",
        "ytunnus": "1234567-8",
        "sposti": "info@kulttuuritalo.fi",
        "lisatiedot": "Esteetön pääsy",
        "yhteyshenkilo": [],
        "postitoimipaikka": {
            "postinumeroId": 1,
            "postinumero": "00100",
            "kaupunki": "Helsinki"
        }
    },
    "jarjestaja": {
        "jarjestajaId": 1,
        "nimi": "Musiikki Oy",
        "ytunnus": "1234567-8",
        "osoite": "Mannerheimintie 13",
        "yhteyshenkilo": {
            "yhtHloId": 1,
            "etunimi": "Matti",
            "sukunimi": "Meikäläinen",
            "sahkoposti": "matti@example.com",
            "puhelin": "0401234567",
            "lisatieto": "Markkinointipäällikkö",
            "tapahtumapaikka": null
        },
        "postitoimipaikka": {
            "postinumeroId": 1,
            "postinumero": "00100",
            "kaupunki": "Helsinki"
        }
    },
    "lipputyypit": [
        {
            "lipputyyppiId": 1,
            "nimi": "Aikuinen",
            "hintakerroin": 1.0,
            "asiakasryhma": {
                "nimi": "Aikuinen",
                "kuvaus": "Yli 18-vuotiaat",
                "id": 1
            }
        },
        {
            "lipputyyppiId": 3,
            "nimi": "Eläkeläinen",
            "hintakerroin": 0.7,
            "asiakasryhma": {
                "nimi": "Elakelainen",
                "kuvaus": "Eläkkeellä olevat henkilöt",
                "id": 3
            }
        },
        {
            "lipputyyppiId": 2,
            "nimi": "Lapsi",
            "hintakerroin": 0.5,
            "asiakasryhma": {
                "nimi": "Lapsi",
                "kuvaus": "Alle 18-vuotiaat",
                "id": 2
            }
        }
    ],
    "lippujaJaljella": 15000
}
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