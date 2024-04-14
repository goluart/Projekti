import { useState, useEffect } from "react";
import { Form } from "react-router-dom";
import { useParams } from "react-router";

const CheckTicket = () => {

    const [token, setToken] = useState('')
    const [message, setMessage] = useState('')
    const [ticketUUID, setTicketUUID] = useState('')

    const requestOptions = {
        method: 'PATCH',
        redirect: 'follow',
        headers: {
            Authorization: {
                token: token,
                type: 'bearer'
            }
        }
    }

    const patchTicket = async () => {
        fetch(`http://copypaste-ohjelmistoprojekti-copypaste-ticketguru.rahtiapp.fi/api/tickets/markAsUsed/byUuid?uuid=${ticketUUID}`, requestOptions)
            .then(response => response.json())
            .then(data => setMessage(data))
            .catch(error => {
                alert('Error', error);
            });
    }

    const doCheck = () => {
        patchTicket();
        if (message == true) {
            setValid(true)
        } if (message == false) {
            setValid(false)
        }
    }

    return (
        <div>
            <form>
                <input type="text" onChange={setTicketUUID} />
                <button onClick={doCheck} title="Check" />
            </form>
        </div>
    )
}

export default CheckTicket