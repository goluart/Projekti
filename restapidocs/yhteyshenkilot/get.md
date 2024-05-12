# Hae yhteyshenkilot
Tämä dokumentaatio kuvaa, miten yhteyshenkilon tiedot haetaan.

## API Endpoint

**Yksittäisen yhteyshenkilön tiedot**

**URL**: /yhteyshenkilot/{id}

**Kaikkien yhteyshenkilöiden tiedot**

**URL**: /yhteyshenkilot

**URL-polku**: {id} = yhtHloId = [integer], missä yhtHloId on palvelimella olevan yhteyshenkilön generoitu yksilöllinen tunniste.

**Metodi**: `GET`

**Autentikointi vaaditaan**: Kyllä

**Käyttäjäroolit**: `myyja`, `hallinto`

## Pyyntö
Pyynnön runkoa ei vaadita, sillä tieto haetaan URL:n avulla.

## Onnistunut Vastaus

**Ehto**: 

**Koodi**: `200 OK`

**Sisällön esimerkki**
```json
{
    "yhtHloId": 2,
    "etunimi": "Liisa",
    "sukunimi": "Laaksonen",
    "sahkoposti": "liisa@example.com",
    "puhelin": "0501234567",
    "lisatieto": "Tuotantopäällikkö",
    "jarjestaja": {
        "jarjestajaId": 2,
        "jarjestajaNimi": "Festivaali Oy"
    },
    "tapahtumapaikka": null
}
```

```json
[
    {
        "yhtHloId": 1,
        "etunimi": "Matti",
        "sukunimi": "Meikäläinen",
        "sahkoposti": "matti@example.com",
        "puhelin": "0401234567",
        "lisatieto": "Markkinointipäällikkö",
        "jarjestaja": {
            "jarjestajaId": 1,
            "jarjestajaNimi": "Musiikki Oy"
        },
        "tapahtumapaikka": null
    },
    {
        "yhtHloId": 2,
        "etunimi": "Liisa",
        "sukunimi": "Laaksonen",
        "sahkoposti": "liisa@example.com",
        "puhelin": "0501234567",
        "lisatieto": "Tuotantopäällikkö",
        "jarjestaja": {
            "jarjestajaId": 2,
            "jarjestajaNimi": "Festivaali Oy"
        },
        "tapahtumapaikka": null
    },
    {
        "yhtHloId": 3,
        "etunimi": "Jukka",
        "sukunimi": "Järvinen",
        "sahkoposti": "jukka@example.com",
        "puhelin": "0451234567",
        "lisatieto": "Tapahtumakoordinaattori",
        "jarjestaja": null,
        "tapahtumapaikka": {
            "tapahtumapaikkaId": 3,
            "tapahtumapaikkaNimi": "Linnanmäki",
            "tapahtumapaikkaOsoite": "Tivolikuja 1, Helsinki",
            "tapahtumapaikkaKaupunki": "Helsinki"
        }
    }
]
```
## Huomautukset
Yhteyshenkilo voi olla liitettynä (tapahtuma)järjestäjään tai tapahtumapaikkaan. 
