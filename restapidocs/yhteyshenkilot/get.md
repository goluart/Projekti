# Hae yhteyshenkilot
Tämä dokumentaatio kuvaa, miten yhteyshenkilon tiedot haetaan.

## API Endpoint


**URL**: /yhteyshenkilot

**Metodi**: `GET`

**Autentikointi vaaditaan**: Kyllä

**Käyttäjäroolit**: `myyja`, `hallinto`


## Onnistunut Vastaus

**Ehto**: 

**Koodi**: `200 OK`

**Sisällön esimerkki**
```json
{
        "yhtHloId": 1,
        "etunimi": "Matti",
        "sukunimi": "Meikäläinen",
        "sahkoposti": "matti@example.com",
        "puhelin": "0401234567",
        "lisatieto": "Markkinointipäällikkö",
        "jarjestajat": [
            {
                "jarjestajaId": 1,
                "jarjestajaNimi": "Musiikki Oy"
            }
        ],
        "tapahtumapaikka": null
}
```
## Huomautukset
