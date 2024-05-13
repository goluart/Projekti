# Luo uusi lipputyyppi
Tämä dokumentaatio kuvaa, miten järjestelmään voi luoda uusia lipputyyppejä

## API Endpoint
Luo uusi lipputyyppi

**URL-polku**: /lipputyyppi

**Metodi**: `POST`

**Autentikointi vaaditaan**: Kyllä

**Käyttäjärooli**: `hallinto`

## Pyyntö

```json
{
    "nimi": "VIP Lippu",
    "hintakerroin": 0.7,
    "asiakasryhma": {
        "id": 1  // ID mikä on olemassa asiakasryhmässä (1-3)
    }
}
```

## Onnistunut vastaus

**Koodi**: `201 Created`

**Sisällön esimerkki**
```json
{
    "lipputyyppiId": 4,
    "nimi": "VIP Lippu",
    "hintakerroin": 0.7,
    "asiakasryhma": {
        "nimi": "Aikuinen",
        "kuvaus": "Yli 18-vuotiaat",
        "id": 1
    }
}
```
## Virhevastaukset

**Ehto**: Autentikointi epäonnistui

**Koodi**: `401 Unauthorized`

## Huomatukset
Varmista, että käytät lipputyypin luonnin yhteydessä oikeita attribuutien arvoja. Pidä huoli myös, että pyynnön runko on samanlainen kuin dokumentaatiossa.