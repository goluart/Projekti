# Lisää yhteyshenkilö
Tämä dokumentaatio kuvaa, miten yhteyshenkilo lisätään tietokantaan.

## API Endpoint

**URL**: /yhteyshenkilot

**Metodi**: `POST`

**Autentikointi vaaditaan**: Kyllä

**Käyttäjäroolit**: `hallinto`

## Pyyntö

```Json
{   
    "yhtHloId": 4,
    "tapaikkaId": 1,
    "etunimi": "Mia",
    "sukunimi": "Kääk",
    "sahkoposti": "mia@sposti.com",
    "puhelin": "04004004",
    "lisatieto": "assari"
}
```

## Onnistunut Vastaus

**Ehto**: Tallennus onnistuu

**Koodi**: `200 OK`

**Sisällön esimerkki**
```json
{
    "yhtHloId": 4,
    "etunimi": "Mia",
    "sukunimi": "Kääk",
    "sahkoposti": "mia@sposti.com",
    "puhelin": "04004004",
    "lisatieto": "assari",
    "jarjestajat": null,
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
    }
}
```
## Huomautukset
