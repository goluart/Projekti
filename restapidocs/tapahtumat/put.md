# Luo uusi tapahtumat
Tämä dokumentaatio kuvaa, miten olemassa olevaa tapahtumaa voi muokata.

## API Endpoint
Muokkaa olemassa olevaa tapahtumaa.

**URL**: /tapahtumat/{id}

**Metodi**: `PUT`

**Autentikointi vaaditaan**: Kyllä

**Käyttäjäroolit**: `hallinto`

## Pyyntö
Pyynnön runkoa ei vaadita, sillä tieto haetaan URL-parametrin avulla.

## Onnistunut vastaus
**Ehto**: Jos olemassa olevan tapahtuman teidot on muokattu ja tallennettu onnistuneesti.

**Koodi**: `200 OK`

**Sisällön esimerkki**
```json
{
    "tapahtumaId": 1,
    "tapahtumaNimi": "Rock Festivaali",
    "luontiPvm": null,
    "alkaaPvm": "2024-03-07T19:21:22.702451+02:00",
    "paattyyPvm": "2024-03-08T00:21:22.702451+02:00",
    "kuvaus": "Suurin rock tapahtuma vuonna",
    "perushinta": 50.0,
    "tapahtumapaikka": {
        "tapaikkaId": 1,
        "paikkaNimi": "Kulttuuritalo",
        "osoite": "Sturenkatu 4, Helsinki",
        "kuvaus": "Kulttuuritapahtumien keskus",
        "ytunnus": "1234567-8",
        "sposti": "info@kulttuuritalo.fi",
        "lisatiedot": "Esteetön pääsy",
        "postitoimipaikka": {
            "postinumeroId": 1,
            "postinumero": "00100",
            "kaupunki": "Helsinki"
        }
    },
    "jarjestaja": {
        "jarjestajaId": 1,
        "nimi": "Musiikki Oy",
        "ytunnus": "1234567-8",
        "osoite": "Mannerheimintie 13",
        "yhteyshenkilo": {
            "yhtHloId": 1,
            "etunimi": "Matti",
            "sukunimi": "Meikäläinen",
            "sahkoposti": "matti@example.com",
            "puhelin": "0401234567",
            "lisatieto": "Markkinointipäällikkö"
        },
        "postitoimipaikka": {
            "postinumeroId": 1,
            "postinumero": "00100",
            "kaupunki": "Helsinki"
        }
    }
}
```
## Virhevastaukset
**Ehto**: Pyynnön sisältö oli viallinen. Pyynnöstä puuttu pakollisia attribuutteja tai ne eivät vastaa pyydettyä muotoa.

**Koodi**: 400 Bad Request

**Sisältö**: null

## Huomautukset
Varmista, että käytät oikeita attribuuttien arvoja tapahtuman muokkauksessa.