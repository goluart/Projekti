# Luo uusi tapahtumat
Tämä dokumentaatio kuvaa, miten lippu tarkistetaan.

## API Endpoint
Merkitse lippu käytetyksi

**URL**: /tarkastukset/:tarkistuskoodi

**URL-parametrit**: tarkistuskoodi=[String], missä `tarkistuskoodi` on lipun yksilöllinen tunniste.

**Metodi**: `GET`

**Autentikointi vaaditaan**: Kyllä

**Käyttäjäroolit**: `myyja`, `lipuntarkastaja`


## Onnistunut Vastaus

**Ehto**: Jos tarkistuskoodi löytyy tietokannasta ja lipun käyttöpvm on `null`

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
Varmista, että käytät oikeita attribuuttien arvoja lipun tarkistuksessa. Tämä metodi tarkistaa vain, että kyseisellä tarkistuskoodilla löytyy käyttämätön lippu. Se ei tarkista, mihin tapahtumaan lippu käytetään. Lippu on validi silloin kuin tarkistus palauttaa `true`. Lippua ei voi enää tämän jälkeen käyttää ja kyselyn vastaus on `false`.