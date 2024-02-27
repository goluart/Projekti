# Luo uusi tapahtumat
Tämä dokumentaatio kuvaa, miten järjestelmästä voi poistaa tapahtuman.

## API Endpoint
Poista olemassa oleva tapahtuma

**URL**: /tapahtumat/{id}

**Metodi**: DELETE

**Autentikointi vaaditaan**: Ei

## Pyyntö
Pyynnön runkoa ei vaadita, sillä tieto haetaan URL-parametrin avulla.

## Onnistunut Vastaus
**Ehto**: Jos tapahtuma on poistettu onnistuneesti, eikä sitä löydy enää listauksesta.

**Koodi**: 200 OK

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
**Ehto**: Pyynnön sisältö oli viallinen tai pyynnössä ei ollut olemassa olevaa id:tä.

**Koodi**: 404 Not Found

**Sisältö**: null

### Tai
**Ehto**: Jos tapahtuman haku epäonnistuu muusta syystä.

**Koodi**: 500 Sisäinen palvelinvirhe

**Sisältö**: 

## Huomautukset
Varmista, että käytät oikeaa id-numeroa poistettavan tapahtuman valinnassa.
Tämä metodi poistaa kaikki tapahtuman tiedot pysyvästi.