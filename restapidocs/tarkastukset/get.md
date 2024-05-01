# Merkitse lippu käytetyksi
Tämä dokumentaatio kuvaa, miten lippu tarkistetaan.

## API Endpoint
Merkitse lippu käytetyksi

**URL**: /liput?tarkistuskoodi=:tarkistuskoodi

**URL-parametrit**: tarkistuskoodi=[String], missä `tarkistuskoodi` on lipun yksilöllinen tunniste.

**Metodi**: `GET`

**Autentikointi vaaditaan**: Kyllä

**Käyttäjäroolit**: `myyja`, `lipuntarkastaja`, `hallinto`


## Onnistunut Vastaus

**Ehto**: Jos tarkistuskoodi löytyy tietokannasta ja lipun käyttöpvm on `null`

**Koodi**: `200 OK`

**Sisällön esimerkki**
```json
{
    "tapahtumaId": "1",
    "tapahtumanNimi": "Rock Festivaali",
    "tapahtumaAika": "2025-03-22T17:00Z",
    "tapahtumaPaikka": "Kulttuuritalo",
    "lipputyyppiId": "1",
    "lipputyyppi": "Aikuinen",
    "hinta": "60.00",
    "tarkistuskoodi": "49c47d62-f016-4669-b521-b76c9378adf7"
}
```
### TAI

**Ehto**: Jos tarkistuskoodilla ei löydy lippua

**Koodi**: `404 Not found`

**Sisällön esimerkki**
```json
{
    "timestamp": "2024-05-01T14:27:59.955+00:00",
    "status": 404,
    "error": "Not Found",
    "message": "Lippua ei löytynyt.",
    "path": "/liput"
}
```

## Huomautukset
Varmista, että käytät oikeita attribuuttien arvoja lipun tarkistuksessa. Tämä metodi tarkistaa vain, että kyseisellä tarkistuskoodilla löytyy lippu.