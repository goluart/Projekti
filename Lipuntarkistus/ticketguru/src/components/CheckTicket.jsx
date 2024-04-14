import { useState } from "react";
import { Link, useParams } from "react-router-dom";

const CheckTicket = () => {

    let { accessToken } = useParams();
    const [ticketUUID, setTicketUUID] = useState('');
    const [err, setErr] = useState('');
    const [message, setMessage] = useState('');

    const handleChangeTicketUUID = (event) => {
        setTicketUUID(event.target.value);
    };

    const requestOptions = {
        method: 'PATCH',
        headers: {
            'Content-Type': 'application/json',
            'Authorization': `Bearer ${accessToken}`
        }
    };

    const patchTicket = async () => {
        try {
            const response = await fetch(`https://copypaste-ohjelmistoprojekti-copypaste-ticketguru.rahtiapp.fi/api/tickets/markAsUsed/byUuid?uuid=${ticketUUID}`, requestOptions)
        } catch (error) {
            setErr('Error: ', error.message) // tulee vastaus not found, pitäisi palauttaa vain http response 204
        }
    };
    // painike käynnistää doCheck tapahtuman
    const doCheck = (event) => {
        event.preventDefault();
        patchTicket(); // käynnistetään patch pyyntö
        if (err.length > 0) {  // jos err muuttujassa on tietoa, välitetään syy patchin epäonnistumisesta
            setMessage("Error checking ticket: " + err)
        } else {
            if (valid == true) {
                setMessage("Ticket OK") // viesti päivittyy sen mukaan, palautuuko true/false ja arvo välittyy message muuttujalla käyttäjän näkymään
            } if (valid == false) {
                setMessage("Ticket already used")
            }
        }
    };

    return (
        <div>
            <form>
                <label>Check ticket
                    <input type="text" onChange={handleChangeTicketUUID} name="ticketUUID" />
                </label>
                <input type="button" onClick={doCheck} value="Check" />
                <h1>{message}</h1>
            </form>
            <Link to={'/get/' + accessToken}>Get ticket</Link>
        </div>
    )
};

export default CheckTicket