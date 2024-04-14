import { useState } from "react";
import api from "./ApiToken";

const GetTicket = () => {

    const [ticket, setTicket] = useState('')
    const [ticketUUID, setTicketUUID] = useState('')
    const [err, setErr] = useState('')

    const fetchTicket = () => {
        api.get(`/tickets/byUuid?uuid=${ticketUUID}`)
            .then(response => response.json())
            .then(data => setTicket(data))
            .catch(error => {
                setErr(error);
            });
        if (ticket.length == null) {
            return (<p>Fetch failed: {err}</p>)
        } else {
            return (
                <div>
                    <p>Ticket type: {ticket.ticketType.name}</p>
                    <p>Ticket event: {ticket.event}</p>
                    <p>Ticket used: {ticket.used}</p>
                </div>
            )
        }
    }

    return (
        <div>
            <form>
                <label>Fetch ticket info
                    <input type='text' onChange={setTicketUUID} name='ticketUUID' placeholder="Write the code" /><br />
                </label>
                <input type='button' onClick={fetchTicket} value='Search' />
            </form>
        </div>)
}

export default GetTicket