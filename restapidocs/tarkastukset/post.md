# Merkitse lippu käytetyksi
Tämä dokumentaatio kuvaa, miten lippu tarkistetaan.

## API Endpoint
Merkitse lippu käytetyksi

**URL**: /tarkastukset

**Metodi**: `POST`

**Autentikointi vaaditaan**: Kyllä

**Käyttäjäroolit**: `myyja`, `lipuntarkastaja`

## Pyyntö

```Json
{
  "tarkistuskoodi": "a47d8b64-c937-4f3a-8fa5-b6d7bdef94b4",
  "tapahtumaNimi": "Rock Festivaali"
}
```

## Onnistunut Vastaus

**Ehto**: Jos tarkistuskoodi ja tapahtumaNimi vastaavat lipun tietoja ja lipun käyttöpvm on `null`

**Koodi**: `200 OK`

**Sisällön esimerkki**
```json
{
    "response": true
}
```
### TAI

**Ehto**: Jos tarkistuskoodilla ei löydy lippua

**Koodi**: `404 Not Found`

**Sisällön esimerkki**
```json
{
    "response": false,
    "reason": "lippua ei löytynyt"
}
```

### TAI

**Ehto**: Jos lippu on jo käytetty eli kayttoPvm on muu kuin null

**Koodi**: `400 Bad Request`

**Sisällön esimerkki**
```json
{
    "response": false,
    "reason": "lippu on jo käytetty"
}
```

## Huomautukset
Varmista, että käytät oikeita attribuuttien arvoja lipun tarkistuksessa. Lippu on validi silloin kuin tarkistus palauttaa `true`. Lippua ei voi enää tämän jälkeen käyttää ja kyselyn vastaus on `false`.