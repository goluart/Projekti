# Poista yhteyshenkilo
Tämä dokumentaatio kuvaa, miten yhteyshenkilon tiedot poistetaan tietokannasta.

## API Endpoint

**URL**: /yhteyshenkilot/{id}

**Metodi**: `DELETE`

**Autentikointi vaaditaan**: Kyllä

**Käyttäjäroolit**: `hallinto`

**URL-parametrit**: id=[integer], missä `id` on palvelimella olevan yhteyshenkilon yksilöllinen tunniste.

### Pyyntö
Pyynnön runkoa ei vaadita, sillä tieto haetaan URL-parametrin avulla.


### Onnistunut Vastaus

**Ehto**: Jos ID:n avulla löytyy yhteyshenkilö

**Koodi**: `204 No Content`

**Sisällön esimerkki**


### Epäonnistunut vastaus

**Ehto**: Jos yhteyshenkilöä ei löydy

**Koodi**: `404 Not Found`

**Sisällön esimerkki**: 
```json
{
    "timestamp": "2024-05-05T09:48:39.995+00:00",
    "status": 404,
    "error": "Not Found",
    "message": "Yhteyshenkilöä 9 ei löytynyt",
    "path": "/yhteyshenkilot/9"
}
```

## Huomautukset
Yhteyshenkilön tiedot voi poistaa, vaikka tieto olisi liitettynä järjestäjän tai tapahtumapaikan tietoihin. 
