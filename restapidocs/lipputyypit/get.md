# Hae lipputyypit
Tämä dokumentaatio kuvaa, miten lipputyyppien tiedot haetaan.

## API Endpoint
Hae lipputyyppi tai lipputyypit.

**Yksittäisen lipputyypin tiedot**

**URL**: /lipputyyppi/{id}

**Kaikkien lipputyyppien tiedot**

**URL**: /lipputyyppi

**Metodi**: `GET`

**Autentikointi vaaditaan**: Kyllä

**Käyttäjäroolit**: `myyja`, `hallinto`

## Pyyntö
Pyynnön runkoa ei vaadita, sillä tieto haetaan URL:n avulla.

## Onnistunut Vastaus

**Ehto**: Kaikki lipputyypit löytyvät tai vaihtoehtoisesti yksi id:n mukainen lipputyyppi löytyy.

**Koodi**: `200 OK`

**Sisällön esimerkki /lipputyyppi/{id}**
```json
{
    "lipputyyppiId": 1,
    "lipputyyppiNimi": "Aikuinen",
    "asiakasryhma": "Aikuinen",
    "hintakerroin": 0.5
}
```

**Sisällön esimerkki /lipputyyppi**
```json
[
    {
        "lipputyyppiId": 1,
        "lipputyyppiNimi": "Aikuinen",
        "asiakasryhma": "Aikuinen",
        "hintakerroin": 0.5
    },
    {
        "lipputyyppiId": 2,
        "lipputyyppiNimi": "Lapsi",
        "asiakasryhma": "Lapsi",
        "hintakerroin": 0.5
    },
    {
        "lipputyyppiId": 3,
        "lipputyyppiNimi": "Eläkeläinen",
        "asiakasryhma": "Elakelainen",
        "hintakerroin": 0.7
    }
]
```
## Virhevastaukset

**Ehto**: Jos autentikointi on virheellinen

**Koodi**: `401 Unauthorized`

**Sisältö**: 

## Tai 

**Ehto**: Jos järjestelmä on tyhjä tai annetulla id:llä ei löydy käyttäjää.

**Koodi**: `404 Not Found`

**Sisältö**:
```json
{
    "timestamp": "2024-05-12T11:14:42.202+00:00",
    "status": 404,
    "error": "Not Found",
    "message": "Lipputyyppiä 6 ei löytynyt.",
    "path": "/lipputyyppi/6"
}
```
