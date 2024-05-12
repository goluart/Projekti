# Hae yhteyshenkilot
Tämä dokumentaatio kuvaa, miten yhteyshenkilon tiedot haetaan.

## API Endpoint


**URL**: /yhteyshenkilot

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
[
    {
        "jarjestajaId": 1,
        "nimi": "Musiikki Oy",
        "ytunnus": "1234567-8",
        "osoite": "Mannerheimintie 13",
        "postinumero": "00100",
        "kaupunki": "Helsinki",
        "yhteystiedot": [
            {
                "yhtHloId": 1,
                "etunimi": "Matti",
                "sukunimi": "Meikäläinen",
                "sahkoposti": "matti@example.com",
                "puhelin": "0401234567",
                "lisatieto": "Markkinointipäällikkö"
            }
        ]
    },
    {
        "jarjestajaId": 2,
        "nimi": "Festivaali Oy",
        "ytunnus": "2234567-8",
        "osoite": "Bulevardi 14",
        "postinumero": "00100",
        "kaupunki": "Helsinki",
        "yhteystiedot": [
            {
                "yhtHloId": 2,
                "etunimi": "Liisa",
                "sukunimi": "Laaksonen",
                "sahkoposti": "liisa@example.com",
                "puhelin": "0501234567",
                "lisatieto": "Tuotantopäällikkö"
            }
        ]
    },
    {
        "jarjestajaId": 3,
        "nimi": "Konsertti Oy",
        "ytunnus": "3234567-8",
        "osoite": "Fredrikinkatu 15",
        "postinumero": "00600",
        "kaupunki": "Helsinki",
        "yhteystiedot": null
    }
]
```
## Huomautukset
