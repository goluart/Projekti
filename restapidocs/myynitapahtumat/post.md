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
**Ehto**: Jos pyynnössä tyyppivirhe

**Koodi**: `400 Bad Request`

**Sisältö**: 

```json
{
    "timestamp": "2024-03-03T20:19:38.978+00:00",
    "status": 400,
    "error": "Bad Request",
    "message": "JSON parse error: Cannot deserialize value of type `java.util.ArrayList<ohjelmistoprojekti.ticketguru.dto.LippuTyyppiMaaraDTO>` from Object value (token `JsonToken.START_OBJECT`)",
    "path": "/myyntitapahtuma"
}
```
LippuTyyppiMaarat on lista objekteja.

### Tai
**Ehto**: Jos lippuja myydään enemmän kuin niitä on jäljellä, tapahtumaa tai lipputyyppiä ei löydy

**Koodi**: `500 Internal Server Error`

**Sisältö**: 
```json

{
    "timestamp": "2024-03-03T19:50:27.006+00:00",
    "status": 500,
    "error": "Internal Server Error",
    "message": "Ei tarpeeksi lippuja jäljellä (67)",
    "path": "/myyntitapahtuma"
}
```

```json
{
    "timestamp": "2024-03-03T20:16:51.547+00:00",
    "status": 500,
    "error": "Internal Server Error",
    "message": "Lipputyyppiä ei löydy",
    "path": "/myyntitapahtuma"
}
```

## Huomautukset
Varmista, että käytät oikeita attribuuttien arvoja myyntitapahtuman ja lipputyypeissä.
Tämä rajapinta palauttaa myyntitapahtuman tiedot sekä myyntitapahtumassa myydyt liput. Lipuissa on tiedot tapahtumasta, lipputyypistä, lipun hinta sekä tarkistuskoodi. 
Huomioi, että onnistunut palautus on tekstimuodossa.