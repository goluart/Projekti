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
    "yhtHloId": 4,
    "etunimi": "Mia",
    "sukunimi": "Kääk6",
    "sahkoposti": "mia.huovinen@gmail.com",
    "puhelin": "0405550402",
    "lisatieto": "assari",
    "jarjestaja": null,
    "tapahtumapaikka": {
        "tapahtumapaikkaId": 1,
        "tapahtumapaikkaNimi": "Kulttuuritalo",
        "tapahtumapaikkaOsoite": "Sturenkatu 4, Helsinki",
        "tapahtumapaikkaKaupunki": "Helsinki"
    }
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
    "path": "/yhteyshenkilot",
    "error": "Bad Request",
    "message": "Anna etunimesi",
    "timestamp": "2024-05-12T23:54:40.057253500+03:00",
    "status": 400
}
```

```json
{
    "path": "/yhteyshenkilot",
    "error": "Bad Request",
    "message": "Etunimi voi olla 20 merkkiä pitkä",
    "timestamp": "2024-05-12T23:58:31.633677800+03:00",
    "status": 400
}
```

```json
{
    "path": "/yhteyshenkilot",
    "error": "Bad Request",
    "message": "Anna sukunimi",
    "timestamp": "2024-05-12T23:59:35.367311200+03:00",
    "status": 400
}
```

```json
{
    "path": "/yhteyshenkilot",
    "error": "Bad Request",
    "message": "Sukunimi voi olla 50 merkkiä pitkä",
    "timestamp": "2024-05-13T00:00:27.152055200+03:00",
    "status": 400
}
```

```json
{
    "path": "/yhteyshenkilot",
    "error": "Bad Request",
    "message": "Tarkista sähköpostiosoitten muoto",
    "timestamp": "2024-05-13T00:01:21.805220200+03:00",
    "status": 400
}
```

```json
{
    "path": "/yhteyshenkilot",
    "error": "Bad Request",
    "message": "Puhelinnumero voi olla 20 merkkiä pitkä, Anna puehlinnumero muodossa +358401234567 tai 0401234567",
    "timestamp": "2024-05-13T00:02:08.199969700+03:00",
    "status": 400
}
```

```json
{
    "path": "/yhteyshenkilot",
    "error": "Bad Request",
    "message": "Lisätiedon suurin sallittu merkkimäärä on 700",
    "timestamp": "2024-05-13T00:13:30.238464100+03:00",
    "status": 400
}
```

## Huomautukset
Jos pyyntöön liitetään `yhtHloId`, uutta henkilöä ei tallenneta vaan päivitetään tieto id:n mukaisesti. 
