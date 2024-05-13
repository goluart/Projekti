# Hae lipputyypit
Tämä dokumentaatio kuvaa, miten lippujen tiedot haetaan.

## API Endpoint
Hae lippu tai liput.

**Yksittäisen lipun tiedot**

**URL**: /lippu/{id}

**Kaikkien lipputyyppien tiedot**

**URL**: /lippu

**Metodi**: `GET`

**Autentikointi vaaditaan**: Kyllä

**Käyttäjäroolit**: `lipuntarkastaja`, `myyja`, `hallinto`

## Pyyntö
Pyynnön runkoa ei vaadita, sillä tieto haetaan URL:n avulla.

## Onnistunut Vastaus

**Ehto**: Kaikki lipputyypit löytyvät tai vaihtoehtoisesti yksi id:n mukainen lipputyyppi löytyy.

**Koodi**: `200 OK`

**Sisällön esimerkki /lippu/{id}**
```json
{
    "tapahtumaId": "1",
    "tapahtumanNimi": "Rock Festivaali",
    "tapahtumaAika": "2025-03-22T19:00+02:00",
    "tapahtumaPaikka": "Kulttuuritalo",
    "lipputyyppiId": "1",
    "lipputyyppi": "Aikuinen",
    "hinta": "60,00",
    "tarkistuskoodi": "25880729-ae4b-49a4-abc6-f4cb7beb50a1"
}
```

**Sisällön esimerkki /lippu**
```json
[
    {
        "tapahtumaId": "1",
        "tapahtumanNimi": "Rock Festivaali",
        "tapahtumaAika": "2025-03-22T19:00+02:00",
        "tapahtumaPaikka": "Kulttuuritalo",
        "lipputyyppiId": "1",
        "lipputyyppi": "Aikuinen",
        "hinta": "60,00",
        "tarkistuskoodi": "25880729-ae4b-49a4-abc6-f4cb7beb50a1"
    },
    {
        "tapahtumaId": "1",
        "tapahtumanNimi": "Rock Festivaali",
        "tapahtumaAika": "2025-03-22T19:00+02:00",
        "tapahtumaPaikka": "Kulttuuritalo",
        "lipputyyppiId": "2",
        "lipputyyppi": "Lapsi",
        "hinta": "30,00",
        "tarkistuskoodi": "8de3a2cb-ea51-4adb-980f-d57a67e32f05"
    },
    {
        "tapahtumaId": "1",
        "tapahtumanNimi": "Rock Festivaali",
        "tapahtumaAika": "2025-03-22T19:00+02:00",
        "tapahtumaPaikka": "Kulttuuritalo",
        "lipputyyppiId": "3",
        "lipputyyppi": "Eläkeläinen",
        "hinta": "45,00",
        "tarkistuskoodi": "866c3601-b093-4144-b20f-7d2a0b15d5c5"
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
    "timestamp": "2024-05-13T11:38:41.813+00:00",
    "status": 404,
    "error": "Not Found",
    "message": "Lippua 6 ei löytynyt.",
    "path": "/lippu/6"
}
```
