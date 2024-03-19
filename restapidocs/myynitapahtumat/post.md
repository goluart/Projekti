# Luo uusi tapahtumat
Tämä dokumentaatio kuvaa, miten järjestelmään voi luodaan myyntitapahtuma ja tapahtuman sisältämät liput

## API Endpoint
Luo uusi myyntitapahtuja ja tapahtumassa myydyt liput

**URL**: /myyntitapahtumat

**Metodi**: `POST`

**Autentikointi vaaditaan**: Ei

## Pyyntö
```json
{
  "tapahtumaId": 2,
  "lippuTyyppiMaarat": [
    {
      "lipputyyppiId": 1,
      "lippuMaara": 2
    },
    {
      "lipputyyppiId": 3,
      "lippuMaara": 1
    }
  ]
}
```
LippuTyyppiMaarat on lista objekteja.

## Onnistunut Vastaus
**Ehto**: Tapahtumaan on jäljellä haluttu määrä lippuja, `tapahtumaId` ja `lipputyyppiId` ovat olemassa

**Koodi**: `200 OK`

**Sisällön esimerkki**
```json
{
    "myyntitapahtumaPvm": "2024-03-03T21:36:29.4679581",
    "loppusumma": "108,00",
    "liputDto": [
        {
            "tapahtumaId": "2",
            "tapahtumanNimi": "Jazz-ilta",
            "tapahtumaAika": "2024-04-20T21:30+03:00",
            "tapahtumaPaikka": "Messukeskus",
            "lipputyyppiId": "1",
            "lipputyyppi": "Aikuinen",
            "hinta": "40,00",
            "tarkistuskoodi": "08c655f7-acdd-4177-b249-85c07a6100f3"
        },
        {
            "tapahtumaId": "2",
            "tapahtumanNimi": "Jazz-ilta",
            "tapahtumaAika": "2024-04-20T21:30+03:00",
            "tapahtumaPaikka": "Messukeskus",
            "lipputyyppiId": "1",
            "lipputyyppi": "Aikuinen",
            "hinta": "40,00",
            "tarkistuskoodi": "92ddd742-058f-40e4-a501-1cef46da1ef8"
        },
        {
            "tapahtumaId": "2",
            "tapahtumanNimi": "Jazz-ilta",
            "tapahtumaAika": "2024-04-20T21:30+03:00",
            "tapahtumaPaikka": "Messukeskus",
            "lipputyyppiId": "3",
            "lipputyyppi": "Eläkeläinen",
            "hinta": "28,00",
            "tarkistuskoodi": "59447f38-f1d8-41ad-ba12-2a686a570f1d"
        }
    ]
}
```

## Virhevastaukset
**Ehto**: Jos tapahtumaa ei löydy tietokannasta annetulla id:llä

**Koodi**: `404 Not Found`

**Sisältö**: 

```json
{
    "timestamp": "2024-03-11T14:41:50.743+00:00",
    "status": 404,
    "error": "Not Found",
    "message": "Tapahtumaa 10 ei löydy",
    "path": "/myyntitapahtumat"
}
```

### Tai

**Ehto**: Jos lipputyyppi on olemassa, mutta sitä ei ole liitetty tapahtumaan

**Koodi**: `400 Bad Request`

**Sisältö**: 
```json
{
    "timestamp": "2024-03-11T14:45:36.092+00:00",
    "status": 400,
    "error": "Bad Request",
    "message": "Lipputyypillä 2 ei voi myydä tapahtumaan lippuja",
    "path": "/myyntitapahtumat"
}
```
### Tai

**Ehto**: Jos lipputyyppiä ei ole olemassa
**Koodi**: `404 Not Found`

**Sisältö**: 
```json
{
    "timestamp": "2024-03-11T14:48:09.798+00:00",
    "status": 404,
    "error": "Not Found",
    "message": "Lipputyyppiä 1500 ei löytynyt",
    "path": "/myyntitapahtumat"
}
```
### Tai

**Ehto**: Jos lippuja on pyynnössä enemmän kuin niitä on jäljellä

**Koodi**: `400 Bad Request`

**Sisältö**: 
```json
{
    "timestamp": "2024-03-11T14:54:31.574+00:00",
    "status": 400,
    "error": "Bad Request",
    "message": "Lippujen määrä ylittää jäljellä olevien lippujen määrän (70)",
    "path": "/myyntitapahtumat"
}
```

## Huomautukset
Varmista, että käytät oikeita attribuuttien arvoja myyntitapahtuman ja lipputyypeissä.
Tämä rajapinta palauttaa myyntitapahtuman tiedot sekä myyntitapahtumassa myydyt liput. Lipuissa on tiedot tapahtumasta, lipputyypistä, lipun hinta sekä tarkistuskoodi. 
Huomioi, että onnistunut palautus on tekstimuodossa.