# TicketGuru - Lipputoimiston lippujärjestelmä

Tiimi 4: Golubev Artur, Huovinen Mia, Tuomela Jouni, Varpanen Hilda-Maija. 

## Johdanto

Asiakkaanamme toimii lipputoimisto, joka haluaa uudistaa lippujärjestelmänsä vastaamaan nykypäivän vaatimuksia ja tarpeita. TicketGuru-järjestelmän tavoitteena on mahdollistaa lippujen myynti myyntipisteessä sekä myöhemmin myös verkkokaupassa. Lippujen myynti tapahtuu ensisijaisesti myyntipisteessä, jossa lipunmyyjä myy ja tulostaa liput asiakkaille. Kun ennakkomyynti päättyy, jäljellä jäävät liput tulostetaan myyntipisteen sijaan ovella myytäväksi. Jokaisessa lipussa on selkeästi tarkastettava koodi, joka mahdollistaa nopean ja vaivattoman pääsyn tapahtumaan.

Järjestelmä suunnitellaan ensisijaisesti käytettäväksi websovelluksena, joka on optimoitu käytettäväksi läppärillä tai pöytäkoneella.


## Järjestelmän määrittely

### Käyttäjäryhmät

Sovelluksen käyttäjäryhmät ovat lipunmyyjä, lipuntarkastaja ja palveluntarjoaja

### Käyttäjätarinat

- Lipuntarkastajana haluan pystyä varmistamaan lipun aitouden, jotta vain aidoilla lipuilla pääsee sisään

- Palveluntarjoajana haluan lisätä tapahtumia, jotta sidosryhmät voivat löytää tapahtumien tiedot

    - Palveluntarjoajana haluan tallennuspaikan tapahtumien ja lippujen tiedoille, jotta ne ovat tallessa

    - Palveluntarjoajana haluan saada tallennettua tapahtumatietoja, jotta niitä voidaan käyttää lipunmyynnissä

    - Palveluntarjoajana haluan pystyä hakemaan tapahtumatietoja, jotta voin nähdä tiedot

    - Palveluntarjoajana haluan pystyä muokkaamaan tallennettuja tietoja, jotta voin päivittää muutoksia tapahtumiin

- Palveluntarjoajana haluan saada tiedon myydyistä lipuista, jotta tiedän myytyjen lippujen määrän ja summan

- Palveluntarjoajana haluan saada tiedon koko kuukauden ja vuoden myytyjen lippujen tiedot, jotta voin seurata lipunmyyntiä pidemmällä aikavälillä

- Palveluntarjoajana haluan pystyä vertaamaan eri kuukausien myyntitietoja toisiinsa, jotta voin seurata myynnissä tapahtuvia muutoksia

- Palveluntarjoajana haluan käyttöliittymän, jonka kautta voin tehdä tapahtumatallennuksia

- Myyjänä haluan käyttöliittymän, jonka kautta voin myydä lippuja

- Myyjänä haluan tulostaa lipun, jotta asiakas saa lipun

- Asiakkaana haluan käyttöliittymän, jossa voin selata tapahtumia

### Käyttötapauskaavio

-   Käyttäjäroolit ja roolien tarvitsemat toiminnot, esim. käyttötapauskaaviona
    (use case diagram) tai käyttäjätarinoina.

    ![Käyttötapauskaavio](pictures/ticketguru_usecase_final.png)

#### Lyhyt kuvaus käyttötapauksista

-   Lyhyt kuvaus käyttötapauksista tai käyttäjätarinat

##### Tapahtuman vieminen järjestelmään

1. Tapahtumann järjestäjä ottaa yhteyttä lipputoimistoon ja sopii tapahtuman lipunmyynnistä.
2. Lipputoimiston vastaava tallentaa järjestelmään tapahtumaan nimen, paikan, ajankohdan, lippujen määrän sekä lipputyypit (eri asiakasryhmille) ja niiden hinnat.
3. Lipputoimiston vastaava tulostaa raportin lipunmyynnistä ja toimittaa sen tapahtumanjärjestäjälle tapahtuman jälkeen.

##### Lipunmyynti tapahtumaan

1. Asiakas valitsee tapahtuman, johon hän haluaa ostaa lippuja ja asioi lipunmyyntipisteessä.
2. Lipunmyyjä valitsee tapahtuman lipputyypit järjestelmästä asiakkaan mukaisesti, kirjaa ne myydyiksi ja tulostaa asiakkaalle liput. 
3. Asiakas osallistuu tapahtumaan ja antaa liput lipuntarkastajalle ovella.
4. Lipuntarkastaja merkitsee liput käytetyiksi järjestelmään.    

Kuvauksissa kannattaa harkita, mikä on toteuttajalle ja asiakkaalle oleellista
tietoa ja keskittyä siihen.

Määrittelyssä järjestelmää tarkastellaan käyttäjän näkökulmasta. Järjestelmän
toiminnot hahmotellaan käyttötapausten tai käyttäjätarinoiden kautta, ja kuvataan järjestelmän
käyttäjäryhmät.

-   Lyhyt kuvaus käyttäjäryhmistä (rooleista)

## Käyttöliittymä

Esitetään käyttöliittymän tärkeimmät (vain ne!) näkymät sekä niiden väliset siirtymät käyttöliittymäkaaviona. 

Jos näkymän tarkoitus ei ole itsestään selvä, se pitää kuvata lyhyesti.

## Tietokanta

Järjestelmään säilöttävä ja siinä käsiteltävät tiedot ja niiden väliset suhteet
kuvataan käsitekaaviolla. Käsitemalliin sisältyy myös taulujen välisten viiteyhteyksien ja avainten
määritykset. Tietokanta kuvataan käyttäen jotain kuvausmenetelmää, joko ER-kaaviota ja UML-luokkakaaviota.

Lisäksi kukin järjestelmän tietoelementti ja sen attribuutit kuvataan
tietohakemistossa. Tietohakemisto tarkoittaa yksinkertaisesti vain jokaisen elementin (taulun) ja niiden
attribuuttien (kentät/sarakkeet) listausta ja lyhyttä kuvausta esim. tähän tyyliin:

> ### _Tilit_
> _Tilit-taulu sisältää käyttäjätilit. Käyttäjällä voi olla monta tiliä. Tili kuuluu aina vain yhdelle käyttäjälle._
>
> Kenttä | Tyyppi | Kuvaus
> ------ | ------ | ------
> id | int PK | Tilin id
> nimimerkki | varchar(30) |  Tilin nimimerkki
> avatar | int FK | Tilin avatar, viittaus [avatar](#Avatar)-tauluun
> kayttaja | int FK | Viittaus käyttäjään [käyttäjä](#Kayttaja)-taulussa

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
