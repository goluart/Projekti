# TicketGuru - Lipputoimiston lippujärjestelmä

Tiimi 4: Golubev Artur, Huovinen Mia, Tuomela Jouni, Varpanen Hilda-Maija. 

## Johdanto

Asiakkaanamme toimii lipputoimisto, joka haluaa uudistaa lippujärjestelmänsä vastaamaan nykypäivän vaatimuksia ja tarpeita. TicketGuru-järjestelmän tavoitteena on mahdollistaa lippujen myynti myyntipisteessä sekä myöhemmin myös verkkokaupassa. Lippujen myynti tapahtuu ensisijaisesti myyntipisteessä, jossa lipunmyyjä myy ja tulostaa liput asiakkaille. Kun ennakkomyynti päättyy, jäljellä jäävät liput tulostetaan myyntipisteen sijaan ovella myytäväksi. Jokaisessa lipussa on selkeästi tarkastettava koodi, joka mahdollistaa nopean ja vaivattoman pääsyn tapahtumaan.

Järjestelmä suunnitellaan ensisijaisesti käytettäväksi websovelluksena, joka on optimoitu käytettäväksi läppärillä tai pöytäkoneella.


## Järjestelmän määrittely

### Käyttäjäryhmät

**Sovelluksen käyttäjäryhmät:**

1. **Lipunmyyjä:** Lipunmyyjä työskentelee lipputoimistossa ja vastaa lippujen myynnistä asiakkaille. Lipunmyyjät käyttävät järjestelmää lippujen myymiseen ja tulostamiseen.

2. **Lipuntarkastaja:** Lipuntarkastaja tarkistaa lipun aitouden tapahtuman sisäänkäynnillä. Lipuntarkastajat käyttävät järjestelmää lipun tarkistamiseen ja varmistavat, että vain oikeilla lipuilla henkilöt pääsevät tapahtumaan.

3. **Palveluntarjoaja:** Palveluntarjoaja käyttää järjestelmää tapahtumien lisäämiseen, hallinoimiseen ja seuraamiseen sekä lipunmyynnin tietojen tarkastelemiseen. Palveluntarjoaja saa toimeksiannot tapahtumien lisäämisestä ja myymisestä tapahtumajärjestäjiltä, keikkamyyjiltä sekä muilta organisaatioilta.

### Käyttötapauskaavio

-   Käyttäjäroolit ja roolien tarvitsemat toiminnot, esim. käyttötapauskaaviona
    (use case diagram) tai käyttäjätarinoina.

    ![Käyttötapauskaavio](pictures/ticketguru_usecase_final.png)

## Käyttöliittymä

Käyttöliittymä tarkoitus toteuttaa alustavasti Reactilla. Käyttöliittymäsivu aukeaa kirjautumissivulle, jonka kautta pääsee käyttäjän oikeuksien mukaiselle työpöydälle.

- Pääkäyttäjälle avautuu listaus tapahtumista nykyhetkestä eteenpäin ja valinnat mm. lisätä ja muokata tapahtumia.
- Myyjälle avautuu listaus tapahtumista nykyhetkestä eteenpäin ja mahdollisuus hakea ja myydä tapahtumia.
- Lipuntarkastajalle avautuu näkymä lippujen tarkastukseen ja myyntiin jo tulostetuille lipuille.

![Käyttöliittymäkaavio](pictures/kayttoliittymakaavio.png)

![Käyttöliittymän rautalankamalli](pictures/kayttoliittymaWireframe.png)

## Tietokanta

Kappaleessa kuvataan järjestelmässä käytettävän tietokannan rakennetta. Tietohkemisto-kuvaukset auttavat käytettävien attribuuttien ymmärtämisessä, sekä taulujen yhteyksien hahmottamisessa. Jokaisesta taulusta on annettu tarkat kuvaukset, jotka sisältävät taulun kentät, niiden tyypit ja niiden tarkoitukset. Tämä osio tarjoaa kattavan yleiskuvan tietokannan rakenteesta, tietokantakaaviosta ja toiminnallisuudesta.

![Tietokantakaavio](pictures/tietokantakaavio.png)

<img src ="pictures/tietokantakaavio_ssms.png" alt="Tietokantakaavio SQL Server Management Studiolla" width="90%" height="auto">


> ### _Jarjestaja_
> _Jarjestaja-taulu sisältää tiedot tapahtuman organisoivasta tahosta, eli tapahtuman järjestäjästä. Tapahtumalla on yksi järjestäjä, mutta järjestäjällä voi olla monta tapahtumaa. Järjestäjä liittyy Yhteyshenkilo-, Tapahtuma- ja Postitoimipaikka -tauluihin. Järjestäjällä voi olla monta yhteyhenkilöä ja vain yksi postitoimipaikka._
> 
> Kenttä | Tyyppi | Kuvaus
> ------ | ------ | ------
> jarjestaja_id | int PK | Järjestäjän yksilöivä tunniste
> nimi | varhcar(50) | Järjestäjän nimi
> ytunnus | varchar(9) | Järjestävän yrityksen y-tunnus
> osoite | varchar (100) | Järjestäjän osoite
> postinro | int | Osoitteen oikeaan alueeseen liittävä identifioiva tunnus
> yht_hlo_id | int FK |Järjestäjän yhteyshenkilö, viittaus [yhteyshenkilo](#Yhteyshenkilo)-tauluun
>
>
> ### _Kayttaja_
> _Kayttaja-taulu sisältää käyttäjien kirjautumistiedot ja yhdellä käyttäjällä voi olla vain yksi käyttäjä._
>
> Kenttä | Tyyppi | Kuvaus
> ------ | ------ | ------
> hlo_id | INT PK | Käyttäjän ID
> salasana | VARCHAR(700) | Käyttäjän salasana
> snimi | VARCHAR(50) | Käyttäjän sukunimi
> enimi | VARCHAR(20) | Käyttäjän etunimi
> lisatiedot | VARCHAR(700) | Mahdollisia lisätietoja käyttäjästä
> rooli_id | INT FK | Viittaus käyttäjän rooliin rooli-taulussa
>
>
> ### _Postitoimipaikka_
> _Postitoimipaikka-taulu, sisältää tiedot postinumerosta sekä kapungista, johon määrätty postinumero liittyy. Postinumeron avulla saman nimiset osoitteet erotetaan toisistaan ja sijoitetaan oikeisiin kuntiin tai kaupunkeihin. Postinumerolla voi olla monta osoitetta, mutta vain yksi kaupunki tai kunta. Postitoimipaikka liittyy Jarjestaja-tauluun ja Tapahtumapaikka-tauluun._
>
> Kenttä | Tyyppi | Kuvaus
> ------ | ------ | ------
> postinumeroId | int PK | Postitoimipaikan yksilöivä tunnus
> postinumero | int | Postitoimipaikan postinumero
> kaupunki | varchar (50) | Paikkakunta, johon postinumero liittää osoitteen
> 
> 
> ### _Rooli_
> _Rooli-taulu sisältää roolin, joka määrittää käyttäjän oikeudet käyttöliittymän kautta tehtäviin hakuihin ja muutoksiin_
> 
> Kenttä | Tyyppi | Kuvaus
> ------ | ------ | ------
> rooli_id | INT PK | Roolin ID
> rooli_nimi | VARCHAR(20) | Roolin nimi
>
>
> ### _Tapahtuma_
> _Tapahtuma-taulu sisältää tapahtumat. Tapahtumalla on yksi tapahtumapaikka ja yksi järjestäjä. Tapahtumapaikalla ja järjestäjällä voi olla monta tapahtumaa._
>
> Kenttä | Tyyppi | Kuvaus
> ------ | ------ | ------
> tapahtuma_id | int PK | Tapahtuman yksilöllinen tunniste
> tapahtuma_nimi | varchar(100) | Tapahtuman nimi
> luonti_pvm | timestamp with zone | Tapahtuman  UTC-luontipäivämäärä
> alkaa_pvm | timestamp with zone | UTC-tiedon sisältävä tapahtuman alkamispäivä ja kellonaika
> paattyy_pvm | timestamp with zone | UTC-tiedon sisältävä tapahtuman päättymispäivä ja kellonaika
> tapaikka_id | int FK | Tapahtuman järjestämispaikka, viittaus [tapahtumapaikka](#Tapahtumapaikka)-tauluun
> kuvaus | varchar(700) | Kuvaus tapahtumasta
> jarjestaja_id | int FK | Tapahtuman järjestäjä, viittaus [jarjestaja](#Jarjestaja)-tauluun
> perushinta | decimal | Tapahtumalipun perushinta, kiinteä liukuluku
> lippu_id | int FK | Tapahtuman lippu, viittaus [lippu](#lippu)-tauluun
>
>
> ### _Tapahtumapaikka_
> _Tapahtumapaikka-taulu sisältää tiedot paikasta, jossa tapahtuma järjestetään. Tapahtumalla on yksi tapahtumapaikka, tapahtumapaikalla voi olla monta tapahtumaa. Tapahtumalla on yksi postinumero ja yhteyshenkilö. Postinumerolla voi olla useita tapahtumapaikkoja. Yhteyshenkilöllä on vain yksi tapahtumapaikka._
>
> Kenttä | Tyyppi | Kuvaus
> ------ | ------ | ------
> tapaikka_id | int PK | Tapahtumapaikan yksillöllinen tunniste
> osoite | varchar(100) | Tapahtumapaikan osoite
> postinro | int FK | Tapahtumapaikan postitoimipaikka, viittaus [postitoimipaikka](#Postitoimipaikka)-tauluun
> kuvaus | varchar(700) | Kuvaus tapahtumapaikasta
> yht_hlo_id | int FK | Tapahtumapaikan yhteyshenkilö, viittaus [yhteyshenkilo](#Yhteyshenkilo)-tauluun
> ytunnus | char(9) | Tapahtumapaikan y-tunnus
> sposti | varchar(100) | Tapahtumapaikan sähköpostiosoite markkinointitarkoituksiin
> lisatiedot | varchar(700) | Lisätietoja tapahtumapaikasta
>
>
> ### _Yhteyshenkilo_
> _Yhteyshenkilo-taulu sisältää tiedot henkilöstä, joka edustaa tapahtumapaikkaa. Yhteyshenkilö on taho johon järjestäjä voi olla tarvittaessa yhteydessä. Yhteyshenkilöllä on vain yksi tapahtumapaikka. Yhteyshenkilö voi olla yhteydessä moneen järjestäjään_
>
> Kenttä | Tyyppi | Kuvaus
> ------ | ------ | ------
> yht_hlo_id | int PK | Yhteyshenkilön yksilöivä tunniste
> snimi | varchar (50) | Yhteyshenkilön sukunimi
> enimi | varchar (20) | Yhteyshenkilön etunimi
> sposti | varchar (100) | Yhteyshenkilön sähköpostiosoite
> puhelin | varchar (20) | Yhteyshenkilön puhelinnumero
> lisatieto | varchar (700) | Yleisiä muistiinpanoja liittyen yhteyshenkilöön
>
>
>### _Lippu_
>_Lippu-taulu tallentaa tiedot tapahtuman myydyistä lipuista. Jokaisella lipulla on oma yksilöinen tunniste ja se liittyy yhteen tapahtumaan ja asiakkaaseen. Lisäksi lipulla on lipputyyppi (esim. normaali, opiskelija, eläkeläinen) mikä määrittää sen hinnan ja ominaisuudet._
>
> Kenttä | Tyyppi | Kuvaus
> ------ | ------ | ------
> lippu_id | int PK | Lipun yksilöivä tunniste
> lipputyyppi_id | int FK | Lipputyypin tunniste, viittaus [lipputyyppi](#lipputyyppi)-tauluun
> osto_pvm | date | Lipun ostoajankohta
> alku_pvm | date | Lipun voimassaolon alkamispäivä
> loppu_pvm | date | Lipun voimassaolon päättymispäivä
> kaytto_pvm | date | Lipun käyttöpäivämäärä, kun se on käytetty
> tarkistuskoodi | int | Lipun tarkistuskoodi, onko lippu käytetty vai ei
>
>
>### _Lipputyyppi_
>_Lipputyyppi-taulu sisäkltää erilaisia lipputyyppejä, jotka voivat vaihdella esimerkiksi hinnoittelun, pääsyoikeuksien tai muiden ominasuuksien suhteen. Jokaisella lipputyypillä on oma yksilöllinen tunniste ja se määrittelee lipun hinnan ja erikoisoikeudet._
>
> Kenttä | Tyyppi | Kuvaus
> ------ | ------ | ------
> lipputyyppi_id | int PK | Lipputyypin yksilöivä tunniste
> asryh_id | int FK | Lipputyypin asiakasryhmä, viittaus [asiakasryhmä](#asiakasryhmä)-tauluun
> nimi | varchar (20) | Lipun ostoajankohta
> hintamuutos | decimal | Mahdollinen hintamuutos verrattuna perushintaan, esim. alennusprosentti
>
>
>### _Asiakasryhmä_
>_Asiakasryhmä-taulu sisältää erilaisia asiakasryhmiä, jotka voivat saada erikoishintoja tai muita etuja. Tämä mahdollistaa segmentoinnin asiakkaiden välillä ja erilaisten tarjousten tekemisen eri ryhmille._
>
> Kenttä | Tyyppi | Kuvaus
> ------ | ------ | ------
> asryh_id | int PK | Asiakasryhmän yksilöivä tunniste
> nimi | varchar (20) | Asiakasryhmän nimi
> kuvaus | varchar (100) | Lyhyt kuvaus asiakasryhmästä ja sen erityisoikeuksista
> tarkista | boolean | Kenttä, joka määrittää, onko asiakasryhmä tarkistettava
>
>
## Tekninen kuvaus

Teknisessä kuvauksessa esitetään järjestelmän toteutuksen suunnittelussa tehdyt tekniset
ratkaisut, esim.

-   Missä mikäkin järjestelmän komponentti ajetaan (tietokone, palvelinohjelma)
    ja komponenttien väliset yhteydet (vaikkapa tähän tyyliin:
    https://security.ufl.edu/it-workers/risk-assessment/creating-an-information-systemdata-flow-diagram/)
-   Palvelintoteutuksen yleiskuvaus: teknologiat, deployment-ratkaisut yms.
-   Keskeisten rajapintojen kuvaukset, esimerkit REST-rajapinta. Tarvittaessa voidaan rajapinnan käyttöä täsmentää
    UML-sekvenssikaavioilla.
-   Toteutuksen yleisiä ratkaisuja, esim. turvallisuus.

Tämän lisäksi

-   ohjelmakoodin tulee olla kommentoitua
-   luokkien, metodien ja muuttujien tulee olla kuvaavasti nimettyjä ja noudattaa
    johdonmukaisia nimeämiskäytäntöjä
-   ohjelmiston pitää olla organisoitu komponentteihin niin, että turhalta toistolta
    vältytään

## Testaus

Tässä kohdin selvitetään, miten ohjelmiston oikea toiminta varmistetaan
testaamalla projektin aikana: millaisia testauksia tehdään ja missä vaiheessa.
Testauksen tarkemmat sisällöt ja testisuoritusten tulosten raportit kirjataan
erillisiin dokumentteihin.

Tänne kirjataan myös lopuksi järjestelmän tunnetut ongelmat, joita ei ole korjattu.

## Asennustiedot

Järjestelmän asennus on syytä dokumentoida kahdesta näkökulmasta:

-   järjestelmän kehitysympäristö: miten järjestelmän kehitysympäristön saisi
    rakennettua johonkin toiseen koneeseen

-   järjestelmän asentaminen tuotantoympäristöön: miten järjestelmän saisi
    asennettua johonkin uuteen ympäristöön.

Asennusohjeesta tulisi ainakin käydä ilmi, miten käytettävä tietokanta ja
käyttäjät tulee ohjelmistoa asentaessa määritellä (käytettävä tietokanta,
käyttäjätunnus, salasana, tietokannan luonti yms.).

## Käynnistys- ja käyttöohje

Tyypillisesti tässä riittää kertoa ohjelman käynnistykseen tarvittava URL sekä
mahdolliset kirjautumiseen tarvittavat tunnukset. Jos järjestelmän
käynnistämiseen tai käyttöön liittyy joitain muita toimenpiteitä tai toimintajärjestykseen liittyviä asioita, nekin kerrotaan tässä yhteydessä.

Usko tai älä, tulet tarvitsemaan tätä itsekin, kun tauon jälkeen palaat
järjestelmän pariin !
