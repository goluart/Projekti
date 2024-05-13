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
    "nimi": "Yritys Oy",
    "ytunnus": "3234567-1",
    "osoite": "Fredrikinkatu 15",
    "postinumero": "00600",
    "kaupunki": "Helsinki",
    "yhteyshenkilot": [
        {
            "etunimi": "Etunimi", 
            "sukunimi": "Sukunimi",
            "sahkoposti": "sahkoposti@sahkoposti.com", 
            "puhelin": "09123456789", 
            "lisatieto": "esim. titteli"
        },
        {
            "etunimi": "Etunimi", 
            "sukunimi": "Sukunimi",
            "sahkoposti": "sahkoposti@sahkoposti.com", 
            "puhelin": "09123456789", 
            "lisatieto": "esim. titteli"
        }
    ]
}
```

## Onnistunut Vastaus

**Ehto**: Tallennus onnistuu

**Koodi**: `201 Created`

**Sisällön esimerkki**
```json
{
    "jarjestajaId": 5,
    "nimi": "Yritys Oy",
    "ytunnus": "3234567-1",
    "osoite": "Fredrikinkatu 15",
    "postinumero": "00600",
    "kaupunki": "Helsinki",
    "yhteyshenkilot": [
        {
            "yhtHloId": 4,
            "etunimi": "Etunimi",
            "sukunimi": "Sukunimi",
            "sahkoposti": "sahkoposti@sahkoposti.com",
            "puhelin": "09123456789",
            "lisatieto": "esim. titteli"
        },
        {
            "yhtHloId": 5,
            "etunimi": "Etunimi",
            "sukunimi": "Sukunimi",
            "sahkoposti": "sahkoposti@sahkoposti.com",
            "puhelin": "09123456789",
            "lisatieto": "esim. titteli"
        }
    ]
}
```

## Virhevastaukset

**Ehto**: Autentikointi epäonnistui

**Koodi**: `401 Unauthorized`

**Sisältö**:

### Tai

**Ehto**: Pyynnön runko on viallinen

**Koodi**: `400 Bad Request`

**Sisältö**:

```json
{
    "path": "/jarjestajat",
    "error": "Bad Request",
    "message": "Nimi voi olla 50 merkkiä pitkä",
    "timestamp": "2024-05-12T22:02:15.545947400+03:00",
    "status": 400
}
```

```json
{
    "path": "/jarjestajat",
    "error": "Bad Request",
    "message": "Anna y-tunnus muodossa 1234567-8",
    "timestamp": "2024-05-12T22:09:15.140944700+03:00",
    "status": 400
}
```

```json
{
    "path": "/jarjestajat",
    "error": "Bad Request",
    "message": "Osoite voi olla 100 merkkiä pitkä",
    "timestamp": "2024-05-12T22:06:02.930087200+03:00",
    "status": 400
}
```

## Huomautukset
Jos pyyntöön liitetään `jajrestajaId`, uutta järjestäjää ei tallenneta vaan päivitetään tieto id:n mukaisesti. 
Yhteyshenkilöiden lisääminen ei ole pakollista. 
