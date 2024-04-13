import { useState, useEffect } from "react";
import { Form } from "react-router-dom";
import { useParams } from "react-router";

const GetTicket = () => {

    const [token, setToken] = useState('')
    const [message, setMessage] = useState('')
    const [ticketUUID, setTicketUUID] = useState('')

    const requestOptions = {
        method: 'GET',
        redirect: 'follow',
        headers: {
            Authorization: {
                token: token,
                type: 'bearer'
            }
        }
    }

    const fetchTicket = async () => {
        fetch(`http://copypaste-ohjelmistoprojekti-copypaste-ticketguru.rahtiapp.fi/api/tickets/${ticketUUID}`, requestOptions)
            .then(response => response.json())
            .then(data => setMessage(data))
            .catch(error => {
                alert('Error', error);
            });
    }

    return (
        <div>
            <form>
                <label>Fetch ticket info
                    <input type='text' onChange={ticketUUID} name='ticketId' placeholder="Write the code" /><br />
                </label>
                <input type='button' onClick={fetchTicket} value='Search' />
                <input type='hidden' value={token} />
            </form>
        </div>)
}

export default GetTicket