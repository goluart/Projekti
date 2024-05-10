# Näytä yksittäinen rooli tai kaikki roolit
Tämä dokumentaatio kuvaa, miten voit hakea tietoja kaikista rooleista tai yksittäisestä roolista.

## API Endpoint
Hae roolin tai roolien tiedot.

**Yksittäisen roolin tiedot**

**URL**: /roolit/{id}

**Kaikkien roolien tiedot**

**URL**: /roolit

**URL-polku**: {id} = rooliId = [integer], missä hloId on palvelimella olevan käyttäjän generoitu yksilöllinen tunniste.

**Metodi**: `GET`

**Autentikointi vaaditaan**: Kyllä

**Käyttäjärooli**: `hallinto`

## Pyyntö
Pyynnön runkoa ei vaadita, koska data haetaan URL-polun avulla.

## Onnistunut vastaus
**Ehto**: Kaikki roolit löytyvät tai vaihtoehtoisesti yksi id:n mukainen käyttäjä löytyy.

**Koodi**: `200 OK`

**Sisällön esimerkki**
```json
{
    "rooliId": 1,
    "rooliNimi": "myyja",
    "kayttajat": [
        {
            "hloId": 1,
            "enimi": "Matti",
            "snimi": "Mäkinen"
        },
        {
            "hloId": 4,
            "enimi": "Liisa",
            "snimi": "Testaaja"
        }
    ]
}
```

## Virhevastaukset

**Ehto**
Autentikointi on virheellinen

**Koodi**: `401 Unauthorized`

**Sisältö**:

## Tai

**Ehto**: Jos järjestelmä on tyhjä tai annetulla id:llä ei löydy roolia.

**Koodi**: `404 Not Found`

**Sisältö**:
```json
{
    "timestamp": "2024-05-10T11:41:23.945+00:00",
    "status": 404,
    "error": "Not Found",
    "message": "Roolia 10 ei löytynyt.",
    "path": "/roolit/10"
}
```

## Huomatukset
Varmista, että käytät oikeaa id-arvoa yksittäisen roolin hakemiseen. Rajapinta palauttaa myös käyttäjät, joilla on pyydetyn roolin käyttöoikeudet.

