# Näytä tarkastettava lippu
Tämä dokumentaatio kuvaa, miten voit hakea tietoja tarkastettavista lipuista.

## API Endpoint
Hae tiedot tietyistä tai kaikista myyntitapahtumista.

**Kaikkien tarkastettujen lippujen tiedot**

**URL**: /tarkastukset

**Metodi**: `GET`

**Autentikointi vaaditaan**: Kyllä

**PreAuthorize**: `hasAuthority('lipuntarkastaja')`

## Pyyntö
Pyynnön runkoa ei vaadita, sillä tieto haetaan URL-parametrin avulla.

## Onnistunut Vastaus

**Ehto**: Jos tietokannassa on lippuja

**Koodi**: `200 OK`

**Sisällön esimerkki**
```json
[
    {
        "tarkastusId": null,
        "kayttoPvm": "2024-03-25T18:52:21.992137+02:00",
        "tarkistuskoodi": "c9495f53-a7ee-4ecd-8a3a-3cb5bb74f266",
        "tapahtumaNimi": "Rock Festivaali",
        "lipputyyppi": "Aikuinen",
        "paikkaNimi": "Kulttuuritalo"
    },
    {
        "tarkastusId": null,
        "kayttoPvm": "2024-03-25T18:52:21.993183+02:00",
        "tarkistuskoodi": "151a70b1-5bbf-415e-8e4d-14df8852a6a0",
        "tapahtumaNimi": "Rock Festivaali",
        "lipputyyppi": "Lapsi",
        "paikkaNimi": "Kulttuuritalo"
    }
]
```
## Virhevastaukset

**Ehto**: Jos autentikointi ja/tai auktorisointi epäonnistuu

**Koodi**: `401 Unauthorized`

**Sisältö**:

### Tai

**Ehto**: Jos myyntitapahtumaa ei löydy annetulla id:llä

**Koodi**: `404 Not Found`

**Sisältö**:
```json
{
    "timestamp": "2024-03-25T17:32:04.117+00:00",
    "status": 404,
    "error": "Not Found",
    "message": "No static resource tarkastukset/1.",
    "path": "/tarkastukset/1"
}
```

## Huomautukset
