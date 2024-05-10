# Näytä yksittäinen käyttäjä tai kaikki käyttäjät
Tämä dokumentaatio kuvaa, miten voit hakea tietoja kaikista käyttäjistä tai yksittäisestä käyttäjästä.

## API Endpoint
Hae käyttäjän tai käyttäjien tiedot.

**Yksittäisen käyttäjän tiedot**

**URL**: /kayttajat/{id}

**Kaikkien käyttäjien tiedot**

**URL**: /käyttäjät

**URL-polku**: hloId = [integer], missä hloId on palvelimella olevan käyttäjän generoitu yksilöllinen tunniste.

**Metodi**: `GET`

**Autentikointi vaaditaan**: Kyllä

**Käyttäjäroolit**: `hallinto`

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