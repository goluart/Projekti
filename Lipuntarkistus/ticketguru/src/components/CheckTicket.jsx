import { useState } from "react";
import api from "./ApiToken";

const CheckTicket = () => {

    const [valid, setValid] = useState('')
    const [ticketUUID, setTicketUUID] = useState('')
    const [err, setErr] = useState('')
    const [message, setMessage] = useState('')

    // patch pyyntö välittää parametrina lipun tiedon ja saa onnistuessaan vastauksena true/false
    const patchTicket = () => {
        api.patch(`/tickets/markAsUsed/byUuid?uuid=${ticketUUID}`)
            .then(response => response.json())
            .then(data => setValid(data))
            .catch(error => {
                setErr(error.message);
            });
    }

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

    }

    return (
        <div>
            <form>
                <label>Check ticket
                    <input type="text" onChange={setTicketUUID} name="ticketUUID" />
                </label>
                <input type="button" onClick={doCheck} value="Check" />
                <h1>{message}</h1>
            </form>
        </div>
    )
}

export default CheckTicket