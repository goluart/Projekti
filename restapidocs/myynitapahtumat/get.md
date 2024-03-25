# Näytä myyntitapahtumat
Tämä dokumentaatio kuvaa, miten voit hakea tietoja myyntitapahtumista.

## API Endpoint
Hae tiedot tietyistä tai kaikista myyntitapahtumista.

**Yksittäisen tapahtuman tiedot**

**URL**: /myyntitapahtumat/:myyntitapahtumaId

**URL-parametrit**: myyntitapahtumaId=[integer], missä `myyntitapahtymaId` on palvelimella olevan myyntitapahtuman yksilöllinen tunniste.

**Kaikkien tapahtumien tiedot**

**URL**: /myyntitapahtumat

**Metodi**: `GET`

**Autentikointi vaaditaan**: Kyllä

**PreAuthorize**: `hasAnyAuthority('myyja', 'hallinto')`

## Pyyntö
Pyynnön runkoa ei vaadita, sillä tieto haetaan URL-parametrin avulla.

## Onnistunut Vastaus
**Ehto**: Kaikki tapahtumat löytyvät tai löytyy yksi tapahtuma annetulla id:llä

**Koodi**: `200 OK`

**Sisällön esimerkki**
```json
[
    {
        "myyntitapahtumaId": 1,
        "myyntitapahtumaPvm": "2024-03-04T18:40:13.847079",
        "loppusumma": "135,00",
        "liputDto": [
            {
                "tapahtumaId": "1",
                "tapahtumanNimi": "Rock Festivaali",
                "tapahtumaAika": "2024-03-22T19:00+02:00",
                "tapahtumaPaikka": "Kulttuuritalo",
                "lipputyyppiId": "1",
                "lipputyyppi": "Aikuinen",
                "hinta": "60,00",
                "tarkistuskoodi": "a2810acf-009e-414f-aae5-4c05abc6f3f3"
            },
            {
                "tapahtumaId": "1",
                "tapahtumanNimi": "Rock Festivaali",
                "tapahtumaAika": "2024-03-22T19:00+02:00",
                "tapahtumaPaikka": "Kulttuuritalo",
                "lipputyyppiId": "2",
                "lipputyyppi": "Lapsi",
                "hinta": "30,00",
                "tarkistuskoodi": "0ba0d230-daf5-4557-b629-80c524d2f7ad"
            },
            {
                "tapahtumaId": "1",
                "tapahtumanNimi": "Rock Festivaali",
                "tapahtumaAika": "2024-03-22T19:00+02:00",
                "tapahtumaPaikka": "Kulttuuritalo",
                "lipputyyppiId": "3",
                "lipputyyppi": "Eläkeläinen",
                "hinta": "45,00",
                "tarkistuskoodi": "b7688adf-b789-46e3-b22f-c644c2a2471c"
            }
        ]
    },
    {
        "myyntitapahtumaId": 2,
        "myyntitapahtumaPvm": "2024-03-04T18:40:31.311085",
        "loppusumma": "87,50",
        "liputDto": [
            {
                "tapahtumaId": "3",
                "tapahtumanNimi": "Stand-up show",
                "tapahtumaAika": "2024-05-15T18:00+03:00",
                "tapahtumaPaikka": "Linnanmäki",
                "lipputyyppiId": "1",
                "lipputyyppi": "Aikuinen",
                "hinta": "35,00",
                "tarkistuskoodi": "c4bcd893-13ef-41b5-a6a7-90f29aee86c0"
            },
            {
                "tapahtumaId": "3",
                "tapahtumanNimi": "Stand-up show",
                "tapahtumaAika": "2024-05-15T18:00+03:00",
                "tapahtumaPaikka": "Linnanmäki",
                "lipputyyppiId": "2",
                "lipputyyppi": "Lapsi",
                "hinta": "17,50",
                "tarkistuskoodi": "68483b26-7948-488e-94d9-fd0e8b0071dc"
            },
            {
                "tapahtumaId": "3",
                "tapahtumanNimi": "Stand-up show",
                "tapahtumaAika": "2024-05-15T18:00+03:00",
                "tapahtumaPaikka": "Linnanmäki",
                "lipputyyppiId": "2",
                "lipputyyppi": "Lapsi",
                "hinta": "17,50",
                "tarkistuskoodi": "e6f11f8f-2c06-4080-8b64-e6a5ba6dc8ef"
            },
            {
                "tapahtumaId": "3",
                "tapahtumanNimi": "Stand-up show",
                "tapahtumaAika": "2024-05-15T18:00+03:00",
                "tapahtumaPaikka": "Linnanmäki",
                "lipputyyppiId": "2",
                "lipputyyppi": "Lapsi",
                "hinta": "17,50",
                "tarkistuskoodi": "82415c68-e0e3-4a08-ad57-c6204ee5c723"
            }
        ]
    }
]
```
## Virhevastaukset

**Ehto**: Autentikointi epäonnistui

**Koodi**: `401 Unauthorized`

**Sisältö**:


### Tai

**Ehto**: Autentikointi epäonnistui

**Koodi**: `403 Forbidden`

**Sisältö**:


### Tai

**Ehto**: Jos myyntitapahtumaa ei löydy annetulla id:llä

**Koodi**: `404 Not Found`

**Sisältö**:

### Tai
**Ehto**: Jos parametrin tyyppi on muu kuin ingeger

**Koodi**: `400 Bad Request`

**Sisältö**: 

## Huomautukset
Jos haet kaikki myyntitapahtumat, huomaa että myyntitapahtumat palautetaan listan muodossa. 
Varmista, että käytät oikeaa `myyntitapahtumaId`-arvoa halutun tapahtuman tietojen hakemiseen.
Autentikointi ja oikeudet tarkistetaan ennen tietojen palauttamista.