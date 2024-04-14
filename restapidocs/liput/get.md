# Luo uusi tapahtumat
Tämä dokumentaatio kuvaa, miten lippu tarkistetaan.

## API Endpoint
Merkitse lippu käytetyksi

**URL**: /liput/:tarkistuskoodi

**URL-parametrit**: tarkistuskoodi=[String], missä `tarkistuskoodi` on lipun yksilöllinen tunniste.

**Metodi**: `GET`

**Autentikointi vaaditaan**: Kyllä

**Käyttäjäroolit**: `myyja`, `lipuntarkastaja`


## Onnistunut Vastaus

**Ehto**: Jos tarkistuskoodi löytyy tietokannasta

**Koodi**: `200 OK`

**Sisällön esimerkki**
```json
{
    "tapahtumaId": "1",
    "tapahtumanNimi": "Rock Festivaali",
    "tapahtumaAika": "2025-03-22T19:00+02:00",
    "tapahtumaPaikka": "Kulttuuritalo",
    "lipputyyppiId": "1",
    "lipputyyppi": "Aikuinen",
    "hinta": "60,00",
    "tarkistuskoodi": "2399fd1d-a044-497b-89de-d33e5b98c7ce"
}
```
### TAI

**Ehto**: Jos tarkistuskoodilla ei löydy lippua 

**Koodi**: `404 Not Found`

**Sisällön esimerkki**
```json
{
    "timestamp": "2024-04-14T13:58:10.992+00:00",
    "status": 404,
    "error": "Not Found",
    "message": "Lippua ei löytynyt.",
    "path": "/liput"
}
```

## Huomautukset
