# Luo uusi tapahtumat
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

**Ehto**: Jos tarkistuskoodilla ei löydy lippua tai lippu on jo käytetty

**Koodi**: `200 OK`

**Sisällön esimerkki**
```json
{
    "response": false
}
```

## Huomautukset
Varmista, että käytät oikeita attribuuttien arvoja lipun tarkistuksessa. Lippu on validi silloin kuin tarkistus palauttaa `true`. Lippua ei voi enää tämän jälkeen käyttää ja kyselyn vastaus on `false`.