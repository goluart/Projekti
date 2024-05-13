# Näytä yksittäinen käyttäjä tai kaikki käyttäjät
Tämä dokumentaatio kuvaa, miten voit hakea tietoja kaikista käyttäjistä tai yksittäisestä käyttäjästä.

## API Endpoint
Hae käyttäjän tai käyttäjien tiedot.

**Yksittäisen käyttäjän tiedot**

**URL**: /kayttajat/{id}

**Kaikkien käyttäjien tiedot**

**URL**: /kayttajat

**URL-polku**: {id} = hloId = [integer], missä hloId on palvelimella olevan käyttäjän generoitu yksilöllinen tunniste.

**Metodi**: `GET`

**Autentikointi vaaditaan**: Kyllä

**Käyttäjärooli**: `hallinto`

## Pyyntö
Pyynnön runkoa ei vaadita, koska data haetaan URL-polun avulla.

## Onnistunut vastaus
**Ehto**: Kaikki käyttäjät löytyvät tai vaihtoehtoisesti yksi id:n mukainen käyttäjä löytyy.

**Koodi**: `200 OK`

**Sisällön esimerkki**
```json

{
    "hloId": 1,
    "tunnus": "myyja",
    "snimi": "Mäkinen",
    "enimi": "Matti",
    "lisatiedot": "Myyntialue",
    "rooliNimi": "myyja"
}
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
    "timestamp": "2024-05-10T08:29:45.248+00:00",
    "status": 404,
    "error": "Not Found",
    "message": "Käyttäjää 10 ei löytynyt.",
    "path": "/kayttajat/10"
}
```

## Huomautukset
Varmista, että käytät oikeaa id-arvoa käyttäjän tietojen hakemiseen. GET-metodi palauttaa vain käyttäjän julkiset tiedot. Osa käyttäjän tiedoista on piilotettu tietoturvasyistä. Rajapinta palauttaa myös käyttäjän roolin. 