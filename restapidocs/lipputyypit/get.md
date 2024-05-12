# Hae lipputyypit
Tämä dokumentaatio kuvaa, miten lipputyyppien tiedot haetaan.

## API Endpoint


**URL**: /lipputyyppi

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


## Huomautukset
