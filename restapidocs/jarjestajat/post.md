# Lisää järjestäjä
Tämä dokumentaatio kuvaa, miten järjestäjä lisätään tietokantaan.

## API Endpoint

**URL**: /jarjestajat

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

**Koodi**: `201 Created`

**Sisällön esimerkki**
```json
{
    "nimi": "WOW Oy",
    "ytunnus": "3234567-1",
    "osoite": "Fredrikinkatu 15",
    "postinumero": "00600",
    "kaupunki": "Helsinki"
}
```
## Huomautukset
