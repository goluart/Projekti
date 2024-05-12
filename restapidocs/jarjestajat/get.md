# Hae järjestäjät
Tämä dokumentaatio kuvaa, miten järjestäjän tiedot haetaan.

## API Endpoint

**Yksittäisen järjestäjän tiedot**

**URL**: /jarjestajat/{id}

**Kaikkien käyttäjien tiedot**

**URL**: /jarjestajat

**URL-polku**: {id} = jarjestajaId = [integer], missä jarjestajaId on palvelimella olevan järjestäjän generoitu yksilöllinen tunniste.

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
    "jarjestajaId": 1,
    "nimi": "Musiikki Oy",
    "ytunnus": "1234567-8",
    "osoite": "Mannerheimintie 13",
    "postinumero": "00100",
    "kaupunki": "Helsinki"
}
```

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

## Virhevastaukset

**Ehto**: Autentikointi epäonnistui

**Koodi**: `401 Unauthorized`

**Sisältö**:

### Tai

**Ehto**: Järjestäjää ei löydy id:llä

**Koodi**: `404 Not Found`

**Sisältö**:
```json
{
    "timestamp": "2024-05-12T19:12:44.301+00:00",
    "status": 404,
    "error": "Not Found",
    "message": "Järjestäjää 20 ei löytynyt",
    "path": "/jarjestajat/20"
}
```
## Huomautukset
