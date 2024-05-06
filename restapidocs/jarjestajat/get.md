# Hae järjestäjät
Tämä dokumentaatio kuvaa, miten järjestäjän tiedot haetaan.

## API Endpoint


**URL**: /jarjestajat

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
        "kaupunki": "Helsinki"
    },
    {
        "jarjestajaId": 2,
        "nimi": "Festivaali Oy",
        "ytunnus": "2234567-8",
        "osoite": "Bulevardi 14",
        "postinumero": "00100",
        "kaupunki": "Helsinki"
    },
    {
        "jarjestajaId": 3,
        "nimi": "Konsertti Oy",
        "ytunnus": "3234567-8",
        "osoite": "Fredrikinkatu 15",
        "postinumero": "00600",
        "kaupunki": "Helsinki"
    }
]
```


## Huomautukset
